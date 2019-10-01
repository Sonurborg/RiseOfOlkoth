package Code;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class HUD {
    public static int HEALTH = 1024;
    public static int status=0;
    
    private int flick=0;
    private int greenValue = 255;
    private int a=0;
    private int danger=0;
    
    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 1024);
        greenValue = Game.clamp(greenValue,0,255);
        
        if (HEALTH<400) {
            danger ++;
            if (danger > 30) {
                SFX.lowHealth();
                danger = 0;
            }
        }
        
        
        greenValue = HEALTH/7;
        
        if  (a != 0){
            greenValue *= 999/7;
        }
    }
    
    public void render(Graphics g){
        
        g.setColor(Color.white);
        g.fillRect(15,15,202,7);
        g.setColor(new Color(75,greenValue,0));
        g.fillRect(16,16,(int)(HEALTH/5.12f),5);
        
        Font fnt = new Font("OwreKynge",1,20);
        g.setFont(fnt);
        g.setColor(new Color(0,200,255));
        
        
        if  (Handler.Ulti> 0) {
            flick++;
            int x=250;
            int y=15;
            int U=Handler.Ulti;
            g.setColor(Color.white);
            g.fillRect( x,y, 20, 20);

            if(flick > 0 && flick < 250) {
                g.setColor(Color.red);
            }else {
                g.setColor(Color.orange);
                if (flick > 500) {
                    flick =0;
                }
            }
            
            g.fillRect( x+1,y+1, 18, 18);
        
            g.setColor(Color.black);
            g.fillOval(x+4, y+6, 12, 11);
            g.fillRect(x+7, y+5, 6, 2);
            g.fillRect(x+9, y+2, 2, 1);
            
            g.setColor(Color.WHITE);
            g.drawString(""+U,x+1,y+18);
            
            g.setColor(Color.BLACK);
            fnt = new Font("OwreKynge",1,18);
            g.setFont(fnt);
            g.drawString(""+U,x+1,y+19);
        }

    }
    
}