package Code.menus;

import Code.Game;
import Code.displayMangr.ReSizer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.image.BufferedImage;

public class OptionsMenu {
    
    private static Graphics g;
    public static boolean mapper=false;
    public static int noise[]=new int[3];
    private static BufferedImage InputMapper=Menu.loader.loadImage("/Res/Sprites/inputmapper.png");
    
    public static void optionsR() {
        g.drawImage(Menu.menuOverlay, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        if (mapper) {
            mapperR();
        }else frontR();
    }
    
    private static void frontR() {
        Font fnt0 = new Font("OwreKynge",1,Game.HEIGHT/7);
        g.setColor(new Color(177,16,16));
        g.setFont(fnt0);
        g.drawString("Options" , 75, (Game.HEIGHT/14)*2);
        
        Font fnt1 = new Font("OwreKynge",1,Game.HEIGHT/19);
        g.setColor(Color.white);
        
        g.setFont(fnt1);
        
        g.drawString("Sound ON/OFF", ReSizer.getX(133),ReSizer.getY(48));
        g.drawString("Music ON/OFF", ReSizer.getX(133),ReSizer.getY(76));
        g.drawString("Windowed/FullScreen", ReSizer.getX(133),ReSizer.getY(104));
        g.drawString("Load Save", ReSizer.getX(133),ReSizer.getY(132));
        g.drawString("Controller Inputs", ReSizer.getX(133),ReSizer.getY(160));
        
        
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(8),1+noise[0],19,19),ReSizer.getX(113),ReSizer.getY(35),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(9),3+noise[1],19,19),ReSizer.getX(113),ReSizer.getY(63),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(11),5+noise[2],19,19),ReSizer.getX(113),ReSizer.getY(91),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(12),8,19,19),ReSizer.getX(113),ReSizer.getY(119),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(13),13,19,19),ReSizer.getX(113),ReSizer.getY(147),ReSizer.getX(19),ReSizer.getY(19),null);
        
        g.drawImage(Menu.Buttons.grabImage(Menu.click(3),5,92,40),ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40),null);
   
    }
    
    private static void mapperR() {
        g.setColor(new Color(177,16,16));
        g.setFont(new Font("OwreKynge",1,Game.HEIGHT/21));
        g.drawImage(InputMapper, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        g.drawImage(Menu.Buttons.grabImage(Menu.click(3),5,92,40),ReSizer.getX(153),ReSizer.getY(173),ReSizer.getX(92),ReSizer.getY(40),null);
    }
}
