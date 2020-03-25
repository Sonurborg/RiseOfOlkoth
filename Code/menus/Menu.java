package Code.menus;
import Code.menus.functions.ButtonFunc;
import Code.Game;
import Code.imageLoader.SpriteSheet;
import Code.imageLoader.BufferedImageLoader;
import Code.displayMangr.ReSizer;
import Code.Game.STATE;
import Code.game.Handler;
import Code.inputMangr.MousePos;
import Code.audioMangr.SFX;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Menu{
    
    public static boolean Click[] = new boolean[20];
    public static boolean Hover[] = new boolean[20];
    public static Game game;
    private MousePos Mouse;
    public static int counter=0;
    private int kcounter=0;
    public static boolean save=false;
    public static boolean keyPressed=false;
    public static boolean optionSelected=false;
    private boolean CONF=false;
    private static String text;
    private static int func;
    private int death=250;
    private static Graphics g;
    private BufferedImage ButtonSpreadsheet;
    private BufferedImage SmallButtons;
    private BufferedImage ConfButtons;
    private BufferedImage confOver;
    public static BufferedImage menuOverlay;
    public static BufferedImageLoader loader = new BufferedImageLoader();
    public static SpriteSheet Buttons;
    public static SpriteSheet smallButtons;
    SpriteSheet confButtons;
    public static ButtonFunc button;
    
    public Menu(Game game,Handler handler,MousePos Mouse){
        this.Mouse=Mouse;
        this.game=game;
        button=new ButtonFunc(game,handler);
        
        button=new ButtonFunc(game,handler);
        
        confOver=loader.loadImage("/Res/Sprites/ConfOver.png");
        menuOverlay=loader.loadImage("/Res/Sprites/overlayMenu.png");
        ButtonSpreadsheet=loader.loadImage("/Res/Sprites/ButtonSpreadsheet.png");
        SmallButtons=loader.loadImage("/Res/Sprites/smallButtons.png");
        ConfButtons=loader.loadImage("/Res/Sprites/ConfButtons.png");
        Buttons = new SpriteSheet(ButtonSpreadsheet,3,6);
        smallButtons = new SpriteSheet(SmallButtons,3,14);
        confButtons = new SpriteSheet(ConfButtons,3,2);
        
    }
    
    private void mouseHover() {
        if (CONF) {
            Hover[17]=Mouse.getHover(ReSizer.getX(135),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31));
            Hover[18]=Mouse.getHover(ReSizer.getX(203),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31));
        }else{
        if  (game.gameState == STATE.Menu) {
        //Exit button
            Hover[10]=Mouse.getHover(ReSizer.getX(19),ReSizer.getY(19),ReSizer.getX(19),ReSizer.getY(19));
        //Start Button  
            Hover[0]=Mouse.getHover(ReSizer.getX(270),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40));
        //Help button
            Hover[1]=Mouse.getHover(ReSizer.getX(270),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40));
        //Options button
            Hover[2]=Mouse.getHover(ReSizer.getX(270),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40));
        }else
        if (game.gameState == STATE.Save) {
            if (save) {
                
            }else {
            //Back Button (SAVE)
                Hover[3]=Mouse.getHover(ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
            //Load button
                Hover[14]=Mouse.getHover(ReSizer.getX(80),ReSizer.getY(45),ReSizer.getX(19),ReSizer.getY(19));
            //Erase button
                Hover[15]=Mouse.getHover(ReSizer.getX(80),ReSizer.getY(94),ReSizer.getX(19),ReSizer.getY(19));
            //Copy Button
                Hover[16]=Mouse.getHover(ReSizer.getX(80),ReSizer.getY(143),ReSizer.getX(19),ReSizer.getY(19));
            //Start Button
                Hover[0]=Mouse.getHover(ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
            //Selected Save
                for (int i=0;i<4;i++){
                    
                }
            }
        } else 
        if  (game.gameState == STATE.Help) {
            //Back button (Help)
                Hover[3]=Mouse.getHover(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
        } else
        if (game.gameState == STATE.Options) {
            //Back Button (Options)
            if (OptionsMenu.mapper) {
                //back to options
                Hover[3]=Mouse.getHover(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
            }else {
                //back to menu
                Hover[3]=Mouse.getHover(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
                //volume Button
                Hover[8]=Mouse.getHover(ReSizer.getX(113),ReSizer.getY(35),ReSizer.getX(19),ReSizer.getY(19));
                //music on/off button
                Hover[9]=Mouse.getHover(ReSizer.getX(113),ReSizer.getY(63),ReSizer.getX(19),ReSizer.getY(19));
                //windowed/fullscreen button
                Hover[11]=Mouse.getHover(ReSizer.getX(113),ReSizer.getY(91),ReSizer.getX(19),ReSizer.getY(19));
                //load save button
                Hover[12]=Mouse.getHover(ReSizer.getX(113),ReSizer.getY(119),ReSizer.getX(19),ReSizer.getY(19));
                //Input mapper menu
                Hover[13]=Mouse.getHover(ReSizer.getX(113),ReSizer.getY(147),ReSizer.getX(19),ReSizer.getY(19));
            }
        
        }else
        if  (game.gameState == STATE.Dead) {
             //Menu Button (Game Over)
                Hover[4]=Mouse.getHover((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70);
        }else
        if  (game.gameState == STATE.Pause) {
            //Countnue Button
            Hover[5]=Mouse.getHover(ReSizer.getX(153),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40));
            //Main Menu Button (Pause Menu)
            Hover[6]=Mouse.getHover(ReSizer.getX(153),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40));
            // pause exit
            Hover[7]=Mouse.getHover(ReSizer.getX(153),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40));
        }
        }
    }
    
    private void mousePressed(){
        if (CONF) {
            Click[17]=Mouse.getClick(ReSizer.getX(135),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31));
            Click[18]=Mouse.getClick(ReSizer.getX(203),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31));
        }else{
        if  (game.gameState == STATE.Menu) {
        //Start button
            Click[0]=Mouse.getClick(ReSizer.getX(270),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40));
        //Help button
            Click[1]=Mouse.getClick(ReSizer.getX(270),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40));
        //Options button
            Click[2]=Mouse.getClick(ReSizer.getX(270),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40));
        //Exit button
            Click[10]=Mouse.getClick(ReSizer.getX(19),ReSizer.getY(19),ReSizer.getX(19),ReSizer.getY(19));
        } else 
        if (game.gameState==STATE.Save) {
            if (save) {
                
            }else {
            //Back button (Save)
                Click[3]=Mouse.getClick(ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
            //Load button
                Click[14]=Mouse.getClick(ReSizer.getX(80),ReSizer.getY(45),ReSizer.getX(19),ReSizer.getY(19));
            //Erase button
                Click[15]=Mouse.getClick(ReSizer.getX(80),ReSizer.getY(94),ReSizer.getX(19),ReSizer.getY(19));
            //Copy Button
                Click[16]=Mouse.getClick(ReSizer.getX(80),ReSizer.getY(143),ReSizer.getX(19),ReSizer.getY(19));
            //New Game Button
                Click[0]=Mouse.getClick(ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
            // Selected Save
                for (int i=0;i<4;i++){
                    
                }
            }
        }else
        if  (game.gameState == STATE.Help) {
            //Back button (Help)
                Click[3]=Mouse.getClick(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
        } else 
        if (game.gameState==STATE.Options) {
            //Back button (Options)
            if (OptionsMenu.mapper) {
                //back to options
                Click[3]=Mouse.getClick(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
            }else {
                //back button
                Click[3]=Mouse.getClick(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
                // volume buttons
                Click[8]=Mouse.getClick(ReSizer.getX(113),ReSizer.getY(35),ReSizer.getX(19),ReSizer.getY(19));
                //music on/off button
                Click[9]=Mouse.getClick(ReSizer.getX(113),ReSizer.getY(63),ReSizer.getX(19),ReSizer.getY(19));
                //windowed/fullscreen
                Click[11]=Mouse.getClick(ReSizer.getX(113),ReSizer.getY(91),ReSizer.getX(19),ReSizer.getY(19));
                //load save
                Click[12]=Mouse.getClick(ReSizer.getX(113),ReSizer.getY(119),ReSizer.getX(19),ReSizer.getY(19));
                //input menu
                Click[13]=Mouse.getClick(ReSizer.getX(113),ReSizer.getY(147),ReSizer.getX(19),ReSizer.getY(19));
            }
        }else
        if  (game.gameState == STATE.Dead) {
            //Menu Button (Game Over)
                Click[4]=Mouse.getClick((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70);
        }else
        if  (game.gameState == STATE.Pause) {
            //Countnue Button
            Click[5]=Mouse.getClick(ReSizer.getX(153),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40));
            //Main Menu Button (Pause Menu)
            Click[6]=Mouse.getClick(ReSizer.getX(153),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40));
            // pause Options
            Click[7]=Mouse.getClick(ReSizer.getX(153),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40));
        }
        }
    }
    
    private void mouseReleased() {
        if (CONF) {
            if(Mouse.getRel(ReSizer.getX(135),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31))){
                Click[17]=false;
                CONF=false;
            }
            if(Mouse.getRel(ReSizer.getX(203),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31))){
                Click[18]=false;
                CONF=false;
                button.relFunc(func);
            }
        }else{
        if  (game.gameState == STATE.Menu) {
            //Start Button
            if (Mouse.getRel(ReSizer.getX(270),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40))){
               button.relFunc(0);
                Click[0]=false;
            }
            //Help button
            if (Mouse.getRel(ReSizer.getX(270),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40))){
                SFX.menu();
                Click[1]=false;
                game.gameState = STATE.Help;
            }
            //Options button
            if (Mouse.getRel(ReSizer.getX(270),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40))){
                Click[2]=false;
                SFX.menu();
                button.relFunc(2);
            }
            //Exit button
            if (Mouse.getRel(ReSizer.getX(19),ReSizer.getY(19),ReSizer.getX(19),ReSizer.getY(19))) {
                Click[10]=false;
                text="Are you sure you want to exit?";
                func=7;
                CONF=true;
            }
        } else
        if  (game.gameState == STATE.Save) {
            //Back button (save)
            if (Mouse.getRel(ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40))){
                Click[3]=false;
               button.relFunc(3);
                return;
            }
            //Load button
            if (Mouse.getRel(ReSizer.getX(80),ReSizer.getY(45),ReSizer.getX(19),ReSizer.getY(19))){
                Click[14]=false;
               button.relFunc(14);
                return;
            }
            //Erase button
            if (Mouse.getRel(ReSizer.getX(80),ReSizer.getY(94),ReSizer.getX(19),ReSizer.getY(19))){
                Click[15]=false;
                text="Are you sure you want to permanently erase this file?";
                func=15;
                CONF=true;
                return;
            }
            //Copy Button
            if (Mouse.getRel(ReSizer.getX(80),ReSizer.getY(143),ReSizer.getX(19),ReSizer.getY(19))){
                Click[16]=false;
                button.relFunc(16);
                return;
            }
            //New Game Button
            if (Mouse.getRel(ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40))){
                Click[0]=false;
                button.relFunc(10);
                return;
            }
            //Selected Save
            for (int i=0;i<4;i++){
                    
            }
        } else            
        if  (game.gameState == STATE.Help) {
            //Back button (Help)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40))){
                Click[3]=false;
                button.relFunc(3);
                return;
            }
        } else 
        if  (game.gameState == STATE.Options) {
            if (OptionsMenu.mapper) {
                //Back button (Options)
                if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40))){
                    Click[3]=false;
                    button.relFunc(13);
                    return;
                }
            }else {
                //Back button (Options)
                if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40))){
                    Click[3]=false;
                    button.relFunc(3);
                    return;
                }
                //Volume Buttons
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(35),ReSizer.getX(19),ReSizer.getY(19))){
                    Click[8]=false;
                    button.relFunc(8);
                }
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(63),ReSizer.getX(19),ReSizer.getY(19))){
                    Click[9]=false;
                    button.relFunc(9);
                }
                //Windowed/Fullscreen button
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(91),ReSizer.getX(19),ReSizer.getY(19))) {
                    Click[11]=false;
                    button.relFunc(11);
                }
                //Load Save Button 
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(119),ReSizer.getX(19),ReSizer.getY(19))) {
                    Click[12]=false;
                    button.relFunc(0);
                }
                //Input Mapper Menu Button
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(147),ReSizer.getX(19),ReSizer.getY(19))) {
                    Click[13]=false;
                    button.relFunc(13);
                }
            }
            
        } else 
        if  (game.gameState == STATE.Dead) {
            //Menu Button (Game Over)
            if (Mouse.getRel((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70)){
                Click[4]=false;
                button.relFunc(4);
                return;
            }
        }else
        if  (game.gameState == STATE.Pause) {
            //Continue Button (Pause Menu)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40))){
                Click[5]=false;
               button.relFunc(5);
            }
            //Main Menu Button (Pause Menu)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40))){
                Click[6]=false;
                text="Are you sure you want to go back to the menu?, all progress will be lost.";
                func=6;
                CONF=true;
            }
            //Options button (Pause Menu)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40))){
                Click[7]=false;
               button.relFunc(2);
            }
        }
        }
    }

    public void tick(){ 
        hoverControl();
        mouseReleased();
        IntroDisplay.introA();
        if( game.gameState == STATE.Dead){
            counter++;
        }else {
            counter =0;
        }
    }
    
    private void hoverControl() {
        if (keyPressed==false) {
            mouseHover();
        }else {
            kcounter++;
            if (kcounter>300) {
                kcounter=0;
                keyPressed=false;
            }
        }
        if (optionSelected==false) {
            mousePressed();
        }
    }
    
    public static int click(int n){
        if (Click[n]) {
            return (2);
        } else if (Hover[n]) {
            return 1;
        }else return (0);
    }
    
    public void render(Graphics g){
        this.g=g;
        if(game.gameState == STATE.Intro) {
            IntroDisplay.introR();
        } else if (button.backRender()) {
            MainMenu.mainBackgr();
        }
        if(game.gameState == STATE.Menu){
            MainMenu.menuR();
        }
        if(game.gameState == STATE.Help){
            MainMenu.helpR();
        } 
        if( game.gameState == STATE.Dead){
            deadR();
        }
        if( game.gameState == STATE.Pause){
            pauseR();
        }
        if(game.gameState == STATE.Options) {
            OptionsMenu.optionsR();
        }
        if(game.gameState == STATE.Map) {
            mapR();
        }
        if (game.gameState==STATE.Save) {
            DataMenu.saveR();
        }
        if (game.gameState==STATE.Map) {
            mapR();
        }
        if (CONF) confirmate();
    }
    
    private void deadR() {
        if(counter < 50){
            int n=death-(counter*5);
            g.setColor(new Color(n,0,0));
            g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
        }
        g.setColor(Color.red);

        g.setFont(new Font("OwreKynge",1,Game.HEIGHT/7));
            
        g.drawString("Game Over",((Game.WIDTH)/2)-150,((Game.HEIGHT)/2)-100);
            
        //g.setColor(Click(Color.red,4));
        g.drawRect((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70);
        g.drawString("Menu", (Game.WIDTH/2)-55, ((Game.HEIGHT)/2)+245);
    }
    
    private void pauseR() {
        g.setFont(new Font("OwreKynge",1,Game.HEIGHT/7));
        g.setColor(new Color(177,16,16));
        g.drawString("PAUSE", Game.WIDTH/17, Game.HEIGHT/7);
        
        g.drawImage(Buttons.grabImage(click(5),3,92,40),ReSizer.getX(153),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40),null);
            
        g.drawImage(Buttons.grabImage(click(6),4,92,40),ReSizer.getX(153),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40),null);
            
        g.drawImage(Buttons.grabImage(click(7),1,92,40),ReSizer.getX(153),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40),null);
    }
    
    private void mapR() {
        g.setColor(Color.red);
        g.fillRect(0,0,50,50);
    }
    
    private void confirmate(){
        g.drawImage(confOver, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        g.setColor(Color.white);
        drawCenteredString(text,new Rectangle(ReSizer.getX(135),ReSizer.getY(70),ReSizer.getX(127),ReSizer.getY(78)),new Font("OwreKynge",1,Game.HEIGHT/15));
        
        g.drawImage(confButtons.grabImage(click(17),1, 59, 39),ReSizer.getX(135),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31),null);
        
        g.drawImage(confButtons.grabImage(click(18),0, 59, 39),ReSizer.getX(203),ReSizer.getY(145),ReSizer.getX(59),ReSizer.getY(31),null);
         
    }
    
    public static void drawCenteredString(String text, Rectangle rect, Font font) {
        FontMetrics fm = g.getFontMetrics(font);
        
        int lineHeight = fm.getHeight();

        int curX = rect.x;
        int curY = rect.y;

        String[] words = text.split(" ");
            
        for (String word : words){
            int wordWidth = fm.stringWidth(word + " ");

            if (curX + wordWidth >= rect.x + rect.width){
                curY += lineHeight;
                curX = rect.x;
            }
            
            g.setFont(font);
            g.drawString(word, curX,curY);

            curX += wordWidth;
        }
    }
}
