package Code;
import Code.Game.STATE;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Menu{
    
    public static boolean Click[] = new boolean[20];
    public static boolean Hover[] = new boolean[20];
    private Game game;
    private Handler  handler;
    private MousePos Mouse;
    private int counter=0;
    private int scounter=0;
    private int kcounter=0;
    private boolean save=false;
    private boolean mapper=false;
    public static boolean keyPressed=false;
    public static boolean optionSelected=false;
    private boolean running=false;
    private static STATE last=STATE.Menu;
    private float alpha=1;
    private int death=250;
    public static int noise[]=new int[3];
    private BufferedImage LOGO;
    private BufferedImage companyLogo;
    private BufferedImage ButtonSpreadsheet;
    private BufferedImage SmallButtons;
    private BufferedImage InputMapper;
    private BufferedImage menuOverlay;
    BufferedImageLoader loader = new BufferedImageLoader();
    SpriteSheet Buttons;
    SpriteSheet smallButtons;
    
    public Menu(Game game,Handler handler,MousePos Mouse){
        this.Mouse=Mouse;
        this.game=game;
        this.handler=handler;
        
        LOGO=loader.loadImage("/Res/Sprites/Logo.png");
        menuOverlay=loader.loadImage("/Res/Sprites/overlayMenu.png");
        ButtonSpreadsheet=loader.loadImage("/Res/Sprites/ButtonSpreadsheet.png");
        SmallButtons=loader.loadImage("/Res/Sprites/smallButtons.png");
        InputMapper=loader.loadImage("/Res/Sprites/inputmapper.png");
        Buttons = new SpriteSheet(ButtonSpreadsheet,3,6);
        smallButtons = new SpriteSheet(SmallButtons,3,14);
        
        companyLogo=loader.loadImage("/Res/Sprites/Clogo.png");
        
    }
    
    public void mouseHover() {
        //Exit button
        if  (game.gameState == STATE.Menu) {
            Hover[10]=Mouse.getHover(ReSizer.getX(19),ReSizer.getY(19),ReSizer.getX(19),ReSizer.getY(19));
        //Start Button  
            Hover[0]=Mouse.getHover(ReSizer.getX(270),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40));
        //Help button
            Hover[1]=Mouse.getHover(ReSizer.getX(270),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40));
        //Options button
            Hover[2]=Mouse.getHover(ReSizer.getX(270),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40));
        }else
        if (game.gameState == STATE.Save) {
            //Back Button (SAVE)
            Hover[3]=Mouse.getHover(ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
            //Load button
            //Erase button
            //Copy Button
            //New Game Button
            Hover[0]=Mouse.getHover(ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
            
        } else 
        if  (game.gameState == STATE.Help) {
            //Back button (Help)
                Hover[3]=Mouse.getHover(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
        } else //Menu Button (Game Over)
        if (game.gameState == STATE.Options) {
            //Back Button (Options)
            if (mapper) {
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
    
    public void mousePressed(){
        
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
            //Back button (Save)
                Click[3]=Mouse.getClick(ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
            //Load button
            //Erase button
            //Copy Button
            //New Game Button
                Click[0]=Mouse.getClick(ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40));
        }else
        if  (game.gameState == STATE.Help) {
            //Back button (Help)
                Click[3]=Mouse.getClick(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40));
        } else 
        if (game.gameState==STATE.Options) {
            //Back button (Options)
            if (mapper) {
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
    
    public void mouseReleased() {
        if  (game.gameState == STATE.Menu) {
            //Start Button
            if (Mouse.getRel(ReSizer.getX(270),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40))){
                relFunc(0);
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
                relFunc(2);
            }
            //Exit button
            if (Mouse.getRel(ReSizer.getX(19),ReSizer.getY(19),ReSizer.getX(19),ReSizer.getY(19))) {
                Click[10]=false;
                relFunc(7);
            }
        } else
        if  (game.gameState == STATE.Save) {
            //Back button (save)
            if (Mouse.getRel(ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40))){
                Click[3]=false;
                relFunc(3);
                return;
            }
            //Load button
            //Erase button
            //Copy Button
            //New Game Button
            
            if (Mouse.getRel(ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40))){
                Click[0]=false;
                relFunc(10);
                return;
            }
        } else            
        if  (game.gameState == STATE.Help) {
            //Back button (Help)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40))){
                Click[3]=false;
                relFunc(3);
                return;
            }
        } else 
        if  (game.gameState == STATE.Options) {
            if (mapper) {
                //Back button (Options)
                if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40))){
                    Click[3]=false;
                    relFunc(13);
                    return;
                }
            }else {
                //Back button (Options)
                if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40))){
                    Click[3]=false;
                    relFunc(3);
                    return;
                }
                //Volume Buttons
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(35),ReSizer.getX(19),ReSizer.getY(19))){
                    Click[8]=false;
                    relFunc(8);
                }
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(63),ReSizer.getX(19),ReSizer.getY(19))){
                    Click[9]=false;
                    relFunc(9);
                }
                //Windowed/Fullscreen button
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(91),ReSizer.getX(19),ReSizer.getY(19))) {
                    Click[11]=false;
                    relFunc(11);
                }
                //Load Save Button 
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(119),ReSizer.getX(19),ReSizer.getY(19))) {
                    Click[12]=false;
                    relFunc(0);
                }
                //Input Mapper Menu Button
                if (Mouse.getRel(ReSizer.getX(113),ReSizer.getY(147),ReSizer.getX(19),ReSizer.getY(19))) {
                    Click[13]=false;
                    relFunc(13);
                }
            }
            
        } else 
        if  (game.gameState == STATE.Dead) {
            //Menu Button (Game Over)
            if (Mouse.getRel((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70)){
                Click[4]=false;
                relFunc(4);
                return;
            }
        }else
        if  (game.gameState == STATE.Pause) {
            //Continue Button (Pause Menu)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40))){
                Click[5]=false;
                relFunc(5);
            }
            //Main Menu Button (Pause Menu)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40))){
                Click[6]=false;
                relFunc(6);
            }
            //Options button (Pause Menu)
            if (Mouse.getRel(ReSizer.getX(153),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40))){
                Click[7]=false;
                relFunc(2);
            }
        }
    }
    
    public void relFunc(int n) {
        if (n==0) {
            SFX.menu();
            last=game.gameState;
            save=false;
            game.gameState= STATE.Save;
        }
        if (n==1) {
            SFX.menu();
            last=game.gameState;
            game.gameState = STATE.Help;
        }
        if (n==2) {
            SFX.menu();
            last=game.gameState;
            game.gameState = STATE.Options;
        }
        if (n==3) {
            SFX.menu();
            if (last==game.gameState) {
                if (running) {
                    game.gameState=STATE.Pause;
                }else game.gameState= STATE.Menu;
            }else if (last==STATE.Pause) {
                game.gameState = STATE.Pause;
            }else if (last==STATE.Menu) {
                game.gameState= STATE.Menu;
            }else if (last==STATE.Options) {
                game.gameState=STATE.Options;
            }else if (last==STATE.Game) {
                game.gameState=STATE.Game;
            }
            last=game.gameState;
        }
        if (n==4) {
            SFX.menu();
            HUD.HEALTH=1024;
            Handler.type=0;
            Handler.Ulti=0;
            game.gameState= STATE.Menu;
        }
        if (n==5) {
            SFX.pause();
            Game.pause=false;
        }
        if (n==6) {
            SFX.menu();
            SFX.menuTheme();
            Game.pause=false;
            for (int j=0;j<5;j++) {
                for (int i=0; i< handler.object.size();i++){
                    GameObject tempObject = handler.object.get(i);
                    /*if(tempObject.getId() != ID.Background && tempObject.getId() != ID.Backplate) {
                        handler.removeObject(tempObject);
                    }*/
                }
            }
            HUD.HEALTH=1024;
            Handler.type=0;
            Handler.Ulti=0;
            game.gameState = STATE.Menu;
        }
        if (n==7) {
            SFX.menu();
            System.exit(1);
        }
        if (n==8) {
            SFX.menu();
            if (noise[0]==0) {
                noise[0]=1;
            } else noise[0]=0;
            SFX.onOff();
        }
        if (n==9) {
            SFX.menu();
            if (noise[1]==0) {
                noise[1]=1;
            } else noise[1]=0;
            SFX.mOnOff();
        }
        if (n==10) {
            running=true;
            game.gameState= STATE.Game;
            handler.addObject(new Player((Game.WIDTH/2)-24,(Game.HEIGHT/2),ID.Player,handler));
            SFX.menu();
        }
        if (n==11) {
            if (noise[2]==0) {
                Window.windowed();
                noise[2]=1;
            } else {
                Window.fullscreen();
                noise[2]=0;
            }
            SFX.menu();
        }
        if (n==12) {
            SFX.menu();
            save=true;
            game.gameState= STATE.Save;
        }
        if (n==13) {
            SFX.menu();
            if (mapper) {
                mapper=false;
            }else mapper=true;
        }
    }

    public void tick(){ 
        if (game.gameState==STATE.Menu) running=false;
        
        hoverControl();
        mouseReleased();
        
        introA();
        if( game.gameState == STATE.Dead){
            counter++;
        }else {
            counter =0;
        }
    }
    
    public void hoverControl() {
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
    
    public int click(int n){
        if (Click[n]) {
            return (2);
        } else if (Hover[n]) {
            return 1;
        }else return (0);
    }
    
    public void render(Graphics g){
        if(game.gameState == STATE.Intro) {
            introR(g);
        }
        if(game.gameState == STATE.Menu){
            menuR(g);
        }
        if(game.gameState == STATE.Help){
            helpR(g);
        } 
        if( game.gameState == STATE.Dead){
            deadR(g);
        }
        if( game.gameState == STATE.Pause){
            pauseR(g);
        }
        if(game.gameState == STATE.Options) {
            optionsR(g);
        }
        if(game.gameState == STATE.Map) {
            mapR(g);
        }
        if (game.gameState==STATE.Save) {
            saveR(g);
        }
    }
    
    public void introR(Graphics g) {
        g.drawImage(companyLogo,0,0,Game.WIDTH,Game.HEIGHT,null);
        
        if  (scounter< 75) {
            Graphics2D g2d =  (Graphics2D) g;
            g2d.setComposite(makeTransparent(alpha));
            g.setColor(Color.BLACK);
            g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
            g2d.setComposite(makeTransparent(1));
        }
        
        if  (scounter > 225) {
            Graphics2D g2d =  (Graphics2D) g;
            g2d.setComposite(makeTransparent(alpha));
            g.setColor(Color.BLACK);
            g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
            g2d.setComposite(makeTransparent(1));
        }
    }
    
    public void introA() {
        if( game.gameState == STATE.Intro){
            scounter++;
            if (scounter > 300) {
                game.gameState=STATE.Menu;
                counter = 0;
            }
            
            if  (alpha > 0.1f && scounter < 75) {
                alpha -= (0.01333333f);
            } else if (alpha < 1 && scounter > 224) alpha += (0.013333333f);
        }
    }
    
    private AlphaComposite makeTransparent(float alpha) {
        int type  = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }
    
    public void menuR(Graphics g) {
        //put logo
        g.drawImage(LOGO, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
            
        //red = new Color(156,48,15);
        
        // Menu buttons
        
        g.drawImage(smallButtons.grabImage(click(10),0,19,19),ReSizer.getX(19),ReSizer.getY(19),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Buttons.grabImage(click(0),0,92,40),ReSizer.getX(270),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40),null);
        
        g.drawImage(Buttons.grabImage(click(1),2,92,40),ReSizer.getX(270),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40),null);
        
        g.drawImage(Buttons.grabImage(click(2),1,92,40),ReSizer.getX(270),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40),null);
            
    }
    
    public void helpR(Graphics g) {
        Font fnt3 = new Font("OwreKynge",1,Game.HEIGHT/21);
        g.setColor(new Color(177,16,16));
        
        g.setFont(fnt3);
        g.drawString("Use WASD or the arrow keys to move around ,dodge enemies and proyectiles" , Game.WIDTH/100, (Game.HEIGHT/14)*5);
        g.drawString(", and press the spacebar to shoot your ammo.", Game.WIDTH/85, (Game.HEIGHT/14)*6);
        g.drawString("There are several types of powerups that your enemies can drop, choose", Game.WIDTH/100, (Game.HEIGHT/14)*7);
        g.drawString("your favourite ammo and blaze through  the galaxy to your destination.", Game.WIDTH/85, (Game.HEIGHT/14)*8);
        g.drawString("Grab the flickering bomb boxes to gain Ultimate ammo, use it pressing the", Game.WIDTH/100, (Game.HEIGHT/14)*9);
        g.drawString("F or ALT key to launch a set of 20 grenades and obliterate all your enemies.", Game.WIDTH/85, (Game.HEIGHT/14)*10);
            
        g.drawImage(Buttons.grabImage(click(3),5,92,40),ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40),null);
    }
    
    public void deadR(Graphics g) {
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
    
    public void pauseR(Graphics g) {
        g.setFont(new Font("OwreKynge",1,Game.HEIGHT/7));
        g.setColor(new Color(177,16,16));
        g.drawString("PAUSE", Game.WIDTH/17, Game.HEIGHT/7);
        
        g.drawImage(Buttons.grabImage(click(5),3,92,40),ReSizer.getX(153),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40),null);
            
        g.drawImage(Buttons.grabImage(click(6),4,92,40),ReSizer.getX(153),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40),null);
            
        g.drawImage(Buttons.grabImage(click(7),1,92,40),ReSizer.getX(153),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40),null);
    }
    
    public void optionsR(Graphics g) {
        g.drawImage(menuOverlay, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        if (mapper) {
            mapperR(g);
        }else frontR(g);
    }
    
    private void frontR(Graphics g) {
        Font fnt0 = new Font("OwreKynge",1,Game.HEIGHT/7);
        g.setColor(new Color(177,16,16));
        g.setFont(fnt0);
        g.drawString("Options" , 75, (Game.HEIGHT/14)*2);
        
        Font fnt1 = new Font("OwreKynge",1,Game.HEIGHT/19);
        g.setColor(new Color(177,16,16));
        
        g.setFont(fnt1);
        
        g.drawString("Sound ON/OFF", ReSizer.getX(133),ReSizer.getY(48));
        g.drawString("Music ON/OFF", ReSizer.getX(133),ReSizer.getY(76));
        g.drawString("Windowed/FullScreen", ReSizer.getX(133),ReSizer.getY(104));
        g.drawString("Load Save", ReSizer.getX(133),ReSizer.getY(132));
        g.drawString("Controller Inputs", ReSizer.getX(133),ReSizer.getY(160));
        
        
        g.drawImage(smallButtons.grabImage(click(8),1+noise[0],19,19),ReSizer.getX(113),ReSizer.getY(35),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(smallButtons.grabImage(click(9),3+noise[1],19,19),ReSizer.getX(113),ReSizer.getY(63),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(smallButtons.grabImage(click(11),5+noise[2],19,19),ReSizer.getX(113),ReSizer.getY(91),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(smallButtons.grabImage(click(12),8,19,19),ReSizer.getX(113),ReSizer.getY(119),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(smallButtons.grabImage(click(13),13,19,19),ReSizer.getX(113),ReSizer.getY(147),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Buttons.grabImage(click(3),5,92,40),ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40),null);
   
    }
    
    private void mapperR(Graphics g) {
        g.setColor(new Color(177,16,16));
        g.setFont(new Font("OwreKynge",1,Game.HEIGHT/21));
        g.drawImage(InputMapper, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        g.drawImage(Buttons.grabImage(click(3),5,92,40),ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40),null);
    }
    
    public void mapR(Graphics g) {
        
    }
    
    public void saveR(Graphics g) {
        g.drawImage(menuOverlay, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        if (save) {
            saveMenuR(g);
        }else loadMenuR(g);
    }
    
    public void loadMenuR(Graphics g) {
        g.setColor(new Color(156,48,15));
        g.setFont(new Font("OwreKynge",1,Game.HEIGHT/19));
        
        g.drawString("Saved Files" , 75, 250);
        g.drawString("Load File", 50, 280);
        g.drawString("Erase File", 75, 310);
        g.drawString("Create new File", 50, 340);
        g.drawString("If you wish to load a save file at any time you can acces the saved files", 75, 370);
        g.drawString("from the Options Menu on the Pouse screen", 50, 400);
        
        
        //put all sound, music, screen and input setting buttons.
        g.drawImage(Buttons.grabImage(click(0),0,92,40),ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40),null);
        
        g.drawImage(Buttons.grabImage(click(3),5,92,40),ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40),null);
   
    }
    
    public void saveMenuR(Graphics g) {
        
    }
}
