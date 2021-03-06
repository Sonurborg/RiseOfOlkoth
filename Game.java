package Code;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{
  
    private static final long serialVersionUID = -7360988675525082953L;
    public static boolean pause=false;
   
    public static final int WIDTH =1080, HEIGHT = (WIDTH /12*9);
    static PopupMenu Game;
    private Thread thread;
    private boolean running = false;
    private int counter=0;
    
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    
    public static enum STATE {
        Intro,
        Menu,
        Pause,
        Help,
        Game,
        Dead,
    };
    
    public STATE gameState = STATE.Menu;
    public static BufferedImage MapSprite,Cloud;
            
    public Game(){
        handler = new Handler();
        menu=new Menu(this,handler);
        this.addKeyListener(new KeyInput(handler,this));
        this.addMouseListener(menu);
        
        AudioPlayer.load();
        
        SFX.Menu_Theme();
        
        new Window(WIDTH, HEIGHT, "Game",this);
        BufferedImageLoader loader = new BufferedImageLoader();
        
        hud = new HUD();
        spawner = new Spawn(handler,hud);  
        
    }
    
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop(){
        try {
            thread.join();
            running =false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1) {
                tick();
                delta--;
            }
            if(running)
                render();
                frames++;
                            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println("FPS: "+ frames);
                frames = 0;
            }
        } stop();
    }
    
    private void InputState() {
        /*if (gameState == STATE.Menu) {
            KeyInput.State[0]=true;
        }else KeyInput.State[0]=false;
        if (gameState == STATE.Game) {
            KeyInput.State[1]=true;
        }else KeyInput.State[1]=false;
        if (gameState == STATE.Help) {
            KeyInput.State[2]=true;
        }else KeyInput.State[2]=false;
        if (gameState == STATE.Dead) {
            KeyInput.State[3]=true;
        }else KeyInput.State[3]=false;
        if (gameState == STATE.Pause) {
            KeyInput.State[4]=true;
        }else KeyInput.State[4]=false;*/
    }
    
    private void tick() {        
        
        InputState();
        KeyInput.tick();
        
        if (gameState==STATE.Game) {
            if (pause==false) {
                handler.tick();
                hud.tick();
                spawner.tick();
            }
        }
        if (gameState==STATE.Pause) {
            if (pause==false) {
                gameState = STATE.Game;
                handler.tick();
                hud.tick();
                spawner.tick();
            }
        }
        
        if (gameState == STATE.Game) {
            if (pause){
                gameState = STATE.Pause;
            }else pause=false;
        }
        
        if (HUD.HEALTH == 0) {
            gameState = STATE.Dead;
        }
        
        if(gameState==STATE.Menu || gameState == STATE.Help){
            handler.tick();
            menu.tick();
        }else if(gameState==STATE.Dead){
            menu.tick();
        }
        
    }
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if  (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        if (gameState == STATE.Game){
            hud.render(g);
        }else if(gameState==STATE.Menu || gameState==STATE.Help || gameState==gameState.Dead || gameState==gameState.Pause){
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }
    
    public static int clamp(int var,int min,int max){
        if(var >= max) {
            return var = max;
        }else if (var <= min) {
            return var = min;
        } else
            return var;
    }
    
    public static void main(String[] args) {
        new Game();
    }  

}