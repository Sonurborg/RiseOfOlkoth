package Code.menus;

import Code.Game;
import Code.audioMangr.SFX;
import Code.imageLoader.BufferedImageLoader;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class IntroDisplay {
    
    private static Graphics g;
    private static int scounter=0;
    private static float alpha=1;
    private static BufferedImageLoader loader = new BufferedImageLoader();
    private static BufferedImage companyLogo=loader.loadImage("/Res/Sprites/Clogo.png");
    
    public static void introR() {
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
    
    public static void introA() {
        if( Menu.game.gameState == Game.STATE.Intro){
            scounter++;
            if (scounter > 300) {
                Menu.game.gameState=Game.STATE.Menu;
                Menu.counter = 0;
                MainMenu.thunder();
                SFX.rainLoop();
            }
            
            if  (alpha > 0.1f && scounter < 75) {
                alpha -= (0.01333333f);
            } else if (alpha < 1 && scounter > 224) alpha += (0.013333333f);
        }
    }
    
    private static AlphaComposite makeTransparent(float alpha) {
        int type  = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }
}
