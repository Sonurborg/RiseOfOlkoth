package Code;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    
    Handler handler;
    private int idleTime= 0;
    boolean IDLE=false;
    private BufferedImage Idles;
    BufferedImageLoader loader = new BufferedImageLoader();
    SpriteSheet Idle;
    private int jumpFrame=0;
    
    public Player(int x,int y,ID id, Handler handler) {
        super(x,y,id);
        this.handler = handler;
        
        Idles=loader.loadImage("/Res/Sprites/CharacterIdle.png");
        Idle = new SpriteSheet(Idles,3,1);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x,y,(int)(Game.WIDTH*0.08f),(int)(Game.HEIGHT*0.25f));
    } 
    
    public int idle(){ 
        if (idleTime>0 && idleTime<12) return 0;
        if (idleTime>12 && idleTime<18) return 1;
        if (idleTime>18 && idleTime<24) return 2;
        return 1;
    }
    
    public BufferedImage sprite() {
        if (IDLE) {
            return Idle.grabImage(idle(),0, 34, 70);
        }
        /*if (vely != 0) {
            return Jump.grabImage();
        }else*/ return Idles;
    }

    public void tick(){
        if (velx == 0 && vely == 0) {
            IDLE=true;
        }else IDLE=false;
        idleTime++;
        if (idleTime> 30) idleTime=0;
        
        x += velx;
        y+=10;
        
        if (KeyInput.jump) jump();
        
        x = Game.clamp(x,-16,Game.WIDTH-48);
        y = Game.clamp(y,0,Game.HEIGHT-(int)(Game.HEIGHT*0.25f));
        collision();
    }
    
    private void jump() {
        if (vely == 0 && jumpFrame== 0) vely=-30;
        jumpFrame++;
        y+=vely;
        vely++;
        if (vely > 10) {
            KeyInput.jump=false; 
            jumpFrame=0;
        }
    }
    
    private void collision() {
        for (int i=0; i< handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Ammo1) {
                if (getBounds().intersects(tempObject.getBounds())){
                    
                }
            }
        }
    }
    
    public void render(Graphics g){
        g.drawImage(sprite(),x,y,(int)(Game.WIDTH*0.08f),(int)(Game.HEIGHT*0.25f),null);
    }   
}