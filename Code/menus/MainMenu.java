package Code.menus;

import Code.Game;
import Code.audioMangr.SFX;
import Code.displayMangr.ReSizer;
import Code.imageLoader.BufferedImageLoader;
import static Code.menus.Menu.loader;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class MainMenu {
    
    private static int  frame=0;
    private static int blodtime=0;
    private static int backtime=0;
    public static BufferedImage menuOverlay;
    public static BufferedImageLoader loader = new BufferedImageLoader();
    private static BufferedImage LOGO=loader.loadImage("/Res/Sprites/Logo.png");
    private static BufferedImage back=loader.loadImage("/Res/Sprites/titleBackground.png");
    private static BufferedImage front=loader.loadImage("/Res/Sprites/titleFronground.png");
    private static BufferedImage blood1=loader.loadImage("/Res/Sprites/BloodRain1.png");
    private static BufferedImage blood2=loader.loadImage("/Res/Sprites/BloodRain2.png");
    private static BufferedImage blood3=loader.loadImage("/Res/Sprites/BloodRain3.png");
    private static BufferedImage blood4=loader.loadImage("/Res/Sprites/BloodRain4.png");
    private static Graphics g;
    
    public static void thunder(){
        SFX.thunder();
        g.setColor(Color.WHITE);
        g.drawRect(0,0, ReSizer.getX(397), ReSizer.getY(224));
    }
    
    public static void mainBackgr(){
        Random r=new Random();
        if (r.nextInt(5000)==0)thunder();
        if (frame==3) {
            backtime++;
            frame=0;
        }else frame++;
        blodtime++;
        
        if (blodtime> ReSizer.getY(224))blodtime=0; 
        
        g.drawImage(back, xPosBack(back),0,ReSizer.getX(1746),ReSizer.getY(224), null);
        
        g.drawImage(blood4,(xyPosBlod(blood4)),-ReSizer.getY(500)+(-xyPosBlod(blood4)),ReSizer.getX(1000),ReSizer.getY(1000), null);
        g.drawImage(blood3,(int)(xyPosBlod(blood3)*1.5),-ReSizer.getY(500)+(int)(-xyPosBlod(blood3)*1.5),ReSizer.getX(1000),ReSizer.getY(1000), null);
        
        g.drawImage(front, xPosBack(front),0,ReSizer.getX(1746),ReSizer.getY(224), null);
        
        g.drawImage(blood2,(int)(xyPosBlod(blood2)*2),-ReSizer.getY(500)+(int)(-xyPosBlod(blood2)*2),ReSizer.getX(1000),ReSizer.getY(1000), null);
        g.drawImage(blood1,(int)(xyPosBlod(blood1)*2.5),-ReSizer.getY(500)+(int)(-xyPosBlod(blood1)*2.5),ReSizer.getX(1000),ReSizer.getY(1000), null);
    }
    
    private static int xPosBack(BufferedImage img){
        if (backtime<ReSizer.getX(1349)){
            return -backtime;
        }else if (backtime<ReSizer.getX(1746)){
            g.drawImage(img,ReSizer.getX(1746)-backtime,0,ReSizer.getX(1746),ReSizer.getY(224), null);
            return -backtime;
        }else
            backtime=0;
            return 0;
    }
    
    private static int xyPosBlod(BufferedImage img){
        if (blodtime < ReSizer.getY(112)) {
            return -blodtime;
        }else if(blodtime < ReSizer.getY(224)){
            g.drawImage(img, blodtime+(img.getWidth()/2),(img.getHeight()/2)+blodtime,ReSizer.getX(1000),ReSizer.getY(1000), null);
            return -blodtime;
        }else return 0;
            
    }
    
    public static void menuR() {
        //put logo
        g.drawImage(LOGO, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        // Menu buttons
        
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(10),0,19,19),ReSizer.getX(19),ReSizer.getY(19),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Menu.Buttons.grabImage(Menu.click(0),0,92,40),ReSizer.getX(270),ReSizer.getY(72),ReSizer.getX(92),ReSizer.getY(40),null);
        
        g.drawImage(Menu.Buttons.grabImage(Menu.click(1),2,92,40),ReSizer.getX(270),ReSizer.getY(123),ReSizer.getX(92),ReSizer.getY(40),null);
        
        g.drawImage(Menu.Buttons.grabImage(Menu.click(2),1,92,40),ReSizer.getX(270),ReSizer.getY(174),ReSizer.getX(92),ReSizer.getY(40),null);
            
    }
    
    public static void helpR() {
        g.drawImage(menuOverlay, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        Font fnt3 = new Font("OwreKynge",1,Game.HEIGHT/21);
        g.setColor(Color.white);
         
        String help=("Use WASD or the arrow keys to move around ,dodge "
                + "enemies and proyectiles, and press the spacebar to shoot your ammo."
                + "There are several types of powerups that your enemies can drop, choose"
                + "your favourite ammo and blaze through  the galaxy to your destination."
                + "Grab the flickering bomb boxes to gain Ultimate ammo, use it pressing the"
                + "F or ALT key to launch a set of 20 grenades and obliterate all your enemies.");
        
        Menu.drawCenteredString(help,new Rectangle(ReSizer.getX(78),ReSizer.getY(30),ReSizer.getX(250),ReSizer.getY(250)),new Font("OwreKynge",1,Game.HEIGHT/17));
            
        g.drawImage(Menu.Buttons.grabImage(Menu.click(3),5,92,40),ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40),null);
    }
}
