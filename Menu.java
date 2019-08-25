package Code;
import Code.Game.STATE;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Menu{
    
    
    public static boolean Click[] = new boolean[10];
    public static boolean Hover[] = new boolean[10];
    private Game game;
    private Handler  handler;
    private MousePos Mouse;
    private int counter=0;
    private int scounter=0;
    private int lcounter=0;
    private float alpha=1;
    private int death=250;
    private int fcx[]=new int[4];
    private int fcy[]=new int[4];
    private int scx[]=new int[4];
    private int scy[]=new int[4];
    private int mx[]=new int[20];
    private int my[]=new int[20];
    private int sx[]=new int[10];
    private int sy[]=new int[10];
    private int noise[]=new int[2];
    private BufferedImage LOGO;
    private BufferedImage companyLogo;
    private BufferedImage ButtonSpreadsheet;
    BufferedImageLoader loader = new BufferedImageLoader();
    SpriteSheet Buttons;
    
    public Menu(Game  game,Handler handler){
        this.game=game;
        this.handler=handler;
        
        ButtonSpreadsheet=loader.loadImage("/Res/Sprites/ButtonSpreadsheet.png");
        Buttons = new SpriteSheet(ButtonSpreadsheet,3,6);
        
        companyLogo=loader.loadImage("/Res/Sprites/Clogo.png");
        
    }
    
    public void mousePressed(){
        //Start button
        if  (game.gameState == STATE.Menu) {
            Click[0]=Mouse.GetClick((Game.WIDTH/10)*7,5*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7));
        //Exit button
        if (Mouse.GetClick((Game.WIDTH/10)*7,11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
            Click[2]=true;
        }
        
        //Help button
        if (Mouse.GetClick((Game.WIDTH/10)*7,8*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
            Click[1]=true;
        }
        
        if (Mouse.GetClick(1004,(Game.HEIGHT)-100,30,30)){
            Click[8]=true;
        }
        
        if (Mouse.GetClick(959,(Game.HEIGHT)-100,30,30)){
            Click[9]=true;
        }
        
        //Back button (Help)
        } else if  (game.gameState == STATE.Help) {
            if (Mouse.GetClick(2*(Game.WIDTH/5),11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                Click[3]=true;
            }
        } else //Menu Button (Game Over)
        if  (game.gameState == STATE.Dead) {
            if (Mouse.GetClick((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70)){
                Click[4]=true;
            }
        }else //Continue Button (Pause Menu)
        if  (game.gameState == STATE.Pause) {
            if (Mouse.GetClick((Game.WIDTH/5)*2,5*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                Click[5]=true;
            } //Main Menu Button (Pause Menu)
            if (Mouse.GetClick((Game.WIDTH/5)*2,8*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                Click[6]=true;
            }// pause exit
            if (Mouse.GetClick((Game.WIDTH/5)*2,11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                Click[7]=true;
            }
            if (Mouse.GetClick(1004,(Game.HEIGHT)-100,30,30)){
                Click[8]=true;
            }
        
            if (Mouse.GetClick(959,(Game.HEIGHT)-100,30,30)){
                Click[9]=true;
            }
        }
    }
    
    public void mouseReleased() {
        //Start button
        if  (game.gameState == STATE.Menu) {
            if (Mouse.GetRel((Game.WIDTH/10)*7,5*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                game.gameState= STATE.Game;
                handler.addObject(new Player((Game.WIDTH/2)-24,(Game.HEIGHT/2),ID.Player,handler));
                Click[0]=false;
            
                SFX.Menu();
            }else Click[0]=false;
        //Exit button
            if (Mouse.GetRel((Game.WIDTH/10)*7,11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                Click[2]=false;
                SFX.Menu();
                System.exit(1);
            }else Click[2]=false;
        
        //Help button
            if (Mouse.GetRel((Game.WIDTH/10)*7,8*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                SFX.Menu();
                Click[1]=false;
                game.gameState = STATE.Help;
            }else Click[1]=false;
            
            if (Mouse.GetRel(1004,(Game.HEIGHT)-100,30,30)){
                Click[8]=false;
                if (noise[0]==0) {
                    noise[0]=1;
                } else noise[0]=0;
                SFX.OnOff();
            }else Click[8]=false;
            
            if (Mouse.GetRel(959,(Game.HEIGHT)-100,30,30)){
                Click[9]=false;
                if (noise[1]==0) {
                    noise[1]=1;
                } else noise[1]=0;
                SFX.MOnOff();
            }else Click[9]=false;
            
        //Back button (Help)
        } else if  (game.gameState == STATE.Help) {
            if (Mouse.GetRel(2*(Game.WIDTH/5),11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                SFX.Menu();
                Click[3]=false;
                game.gameState= STATE.Menu;
                return;
            }else Click[3]=false;
        } else //Menu Button (Game Over)
        if  (game.gameState == STATE.Dead) {
            if (Mouse.GetRel((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70)){
                SFX.Menu();
                HUD.HEALTH=1024;
                HUD.SHIELD=0;
                Click[4]=false;
                HUD.score=0;
                HUD.level=1;
                Handler.type=0;
                Handler.Ulti=0;
                game.gameState= STATE.Menu;
                return;
            }else Click[4]=false;
        }else //Continue Button (Pause Menu)
        if  (game.gameState == STATE.Pause) {
            if (Mouse.GetRel((Game.WIDTH/5)*2,5*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                SFX.Pause();
                Click[5]=false;
                Game.pause=false;
                Spawn.Render=true;
            }else Click[5]=false;
            //Main Menu Button (Pause Menu)
            if (Mouse.GetRel((Game.WIDTH/5)*2,8*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                SFX.Menu();
                Spawn.play=1;
                Spawn.scoreKeep=0;
                SFX.Menu_Theme();
                Click[6]=false;
                Game.pause=false;
                for (int j=0;j<5;j++) {
                    for (int i=0; i< handler.object.size();i++){
                        GameObject tempObject = handler.object.get(i);
                        if(tempObject.getId() != ID.Background && tempObject.getId() != ID.Backplate) {
                            handler.removeObject(tempObject);
                        }
                    }
                }
                HUD.HEALTH=1024;
                HUD.SHIELD=0;
                HUD.score=0;
                HUD.level=1;
                Handler.type=0;
                Handler.Ulti=0;
                game.gameState = STATE.Menu;
            }else Click[6]=false;
            if (Mouse.GetRel((Game.WIDTH/5)*2,11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7))){
                Click[7]=false;
                System.exit(1);
            }else Click[7]=false;
            if (Mouse.GetRel(1004,(Game.HEIGHT)-100,30,30)){
                Click[8]=false;
                if (noise[0]==0) {
                    noise[0]=1;
                } else noise[0]=0;
                SFX.OnOff();
            }else Click[8]=false;
            
            if (Mouse.GetRel(959,(Game.HEIGHT)-100,30,30)){
                Click[9]=false;
                if (noise[1]==0) {
                    noise[1]=1;
                } else noise[1]=0;
                SFX.MOnOff();
            }else Click[9]=false;
        }
    }
    
    private void sprite() {
        int x=1004;
        int y=game.HEIGHT-100;
            
        sx[0]=x+4;
        sx[1]=x+4;
        sx[2]=x+11;
        sx[3]=x+11;
        sx[4]=x+13;
        sx[5]=x+13;
        sx[6]=x+25;
        sx[7]=x+25;
        sx[8]=x+13;
        sx[9]=x+11;
            
        sy[0]=y+8;
        sy[1]=y+22;
        sy[2]=y+22;
        sy[3]=y+8;
        sy[4]=y+8;
        sy[5]=y+22;
        sy[6]=y+28;
        sy[7]=y+2;
        sy[8]=y+8;
        sy[9]=y+8;
        
        x=959;
        
        mx[0]=x+10;
        mx[1]=x+10;
        mx[2]=x+6;
        mx[3]=x+3;
        mx[4]=x+3;
        mx[5]=x+5;
        mx[6]=x+8;
        mx[7]=x+11;
        mx[8]=x+12;
        mx[9]=x+12;
        mx[10]=x+24;
        mx[11]=x+24;
        mx[12]=x+20;
        mx[13]=x+17;
        mx[14]=x+17;
        mx[15]=x+19;
        mx[16]=x+22;
        mx[17]=x+25;
        mx[18]=x+26;
        mx[19]=x+26;
            
        my[0]=y+7;
        my[1]=y+21;
        my[2]=y+21;
        my[3]=y+24;
        my[4]=y+26;
        my[5]=y+28;
        my[6]=y+28;
        my[7]=y+26;
        my[8]=y+24;
        my[9]=y+13;
        my[10]=y+9;
        my[11]=y+18;
        my[12]=y+18;
        my[13]=y+20;
        my[14]=y+23;
        my[15]=y+25;
        my[16]=y+25;
        my[17]=y+23;
        my[18]=y+21;
        my[19]=y+2;
        
        if (noise[0]==1) {
            x=1004;
            
            fcx[0]=x+2;
            fcx[1]=x+24;
            fcx[2]=x+27;
            fcx[3]=x+5;
            fcy[0]=y+6;
            fcy[1]=y+28;
            fcy[2]=y+25;
            fcy[3]=y+3;
        }
        if (noise[1]==1) {
            x=959;
            
            scx[0]=x+2;
            scx[1]=x+24;
            scx[2]=x+27;
            scx[3]=x+5;
            scy[0]=y+6;
            scy[1]=y+28;
            scy[2]=y+25;
            scy[3]=y+3;
        }
    }

    public void tick(){
        mousePressed();
        mouseReleased();
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
        if( game.gameState == STATE.Dead){
            counter++;
        }else {
            counter =0;
        }
    }
    
    public int Click(int n){
        if (Click[n]) {
            return (2);
        } else if (Hover[n]) {
            return 1;
        }else return (0);
    }
    
    public void render(Graphics g){
        sprite();
        if(game.gameState == STATE.Intro) {
            IntroR(g);
        }
        if(game.gameState == STATE.Menu){
            MenuR(g);
        }else if(game.gameState == STATE.Help){
            HelpR(g);
        } 
        if( game.gameState == STATE.Dead){
            DeadR(g);
        }
        if( game.gameState == STATE.Pause){
            PauseR(g);
        }
    }
    
    public void IntroR(Graphics g) {
        lcounter++;
        
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
    
    private AlphaComposite makeTransparent(float alpha) {
        int type  = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }
    
    public void MenuR(Graphics g) {
            //put logo
        g.drawImage(LOGO, 0,100,game.WIDTH,240, null);
            
        Color red = new Color(156,48,15);
        
        // Menu buttons
        
        g.drawImage(Buttons.grabImage(Click(0),0,92,40),(Game.WIDTH/10)*7,5*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7),null);
            
        g.drawImage(Buttons.grabImage(Click(1),1,92,40),(Game.WIDTH/10)*7,8*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7),null);
            
        g.drawImage(Buttons.grabImage(Click(2),2,92,40),(Game.WIDTH/10)*7,11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7),null);
            
            //Volume Buttons


        /*g.setColor(Click(red,8));
        g.drawRect(1004,game.HEIGHT-100, 30, 30);
        g.drawPolygon(sx, sy, 10);
            
        g.setColor(Click(red,9));
        g.drawRect(959,game.HEIGHT-100, 30, 30);
        g.drawPolygon(mx, my, 20);
            
        if (noise[0]==1) {
            g.setColor(Color.black);
            g.fillPolygon(fcx, fcy, 4);
            g.setColor(Click(new Color(0,100,160),8));
            g.drawPolygon(fcx, fcy, 4);
        }
        if (noise[1]==1) {
            g.setColor(Color.black);
            g.fillPolygon(scx, scy, 4);
            g.setColor(Click(new Color(0,100,160),9));
            g.drawPolygon(scx, scy, 4);
        }*/
    }
    
    public void HelpR(Graphics g) {
        Font fnt3 = new Font("OwreKynge",1,25);
            
        g.setFont(fnt3);
        g.drawString("Use WASD or the arrow keys to move around ,dodge enemies and proyectiles" , 75, 250);
        g.drawString(", and press the spacebar to shoot your ammo.", 50, 280);
        g.drawString("There are several types of powerups that your enemies can drop, choose", 75, 310);
        g.drawString("your favourite ammo and blaze through  the galaxy to your destination.", 50, 340);
        g.drawString("Grab the flickering bomb boxes to gain Ultimate ammo, use it pressing the", 75, 370);
        g.drawString("F or ALT key to launch a set of 20 grenades and obliterate all your enemies.", 50, 400);
            
        //g.setColor(Click(new Color(0,100,160),3));
        g.drawImage(Buttons.grabImage(Click(3),5,92,40),2*(Game.WIDTH/5),11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7),null);
    }
    
    public void DeadR(Graphics g) {
        if(counter < 50){
            int n=death-(counter*5);
            g.setColor(new Color(n,0,0));
            g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
        }
        g.setColor(Color.red);
            
        Font fnt = new Font("OwreKynge",1,50);
        g.setFont(fnt);
            
        g.drawString("Game Over",((Game.WIDTH)/2)-150,((Game.HEIGHT)/2)-100);
        g.drawString("Score: "+HUD.score,((Game.WIDTH)/2)-150,((Game.HEIGHT)/2)-50);
            
        //g.setColor(Click(Color.red,4));
        g.drawRect((Game.WIDTH/2)-100,((Game.HEIGHT)/2)+200,200,70);
        g.drawString("Menu", (Game.WIDTH/2)-55, ((Game.HEIGHT)/2)+245);
    }
    
    public void PauseR(Graphics g) {
        Font fnt = new Font("OwreKynge",1,100);
        Font fnt2 = new Font("OwreKynge",1,45);
            
        g.setFont(fnt);
        g.setColor(new Color(0,100,160));
        g.drawString("Pause", 100, 150);
            
        g.setFont(fnt2);
            
        
        g.drawImage(Buttons.grabImage(Click(5),3,92,40),(Game.WIDTH/5)*2,5*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7),null);
            
        g.drawImage(Buttons.grabImage(Click(6),4,92,40),(Game.WIDTH/5)*2,8*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7),null);
            
        g.drawImage(Buttons.grabImage(Click(7),1,92,40),(Game.WIDTH/5)*2,11*(Game.HEIGHT/14),(Game.WIDTH/379)*85,(Game.HEIGHT/7),null);
        
            
        if (noise[0]==1) {
            g.setColor(Color.black);
            g.fillPolygon(fcx, fcy, 4);
            //g.setColor(Click(new Color(0,100,160),8));
            g.drawPolygon(fcx, fcy, 4);
        }
        if (noise[1]==1) {
            g.setColor(Color.black);
            g.fillPolygon(scx, scy, 4);
            //g.setColor(Click(new Color(0,100,160),9));
            g.drawPolygon(scx, scy, 4);
        }
    }
    
}
