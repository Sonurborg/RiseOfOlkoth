package Code;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class HUD {
    public static boolean BhDisplay=false;
    public static int BH=1000;
    public static int HEALTH = 1024;
    public static int SHIELD = 0;
    public static int score = 0;
    public static int level = 1;
    public static int status=0;
    
    private int flick=0;
    private int greenValue = 255;
    private int blueValue =255;
    private int a=0;
    private int box;
    private int danger=0;
    
    public void tick(){
        SHIELD = Game.clamp(SHIELD, 0, 500);
        HEALTH = Game.clamp(HEALTH, 0, 1024);
        BH=Game.clamp(BH, 0, 1000);
        if (level != 10) {
            if (score<1) {
                BH=1000;
                BhDisplay=false;
            }
        }
        if (BH==0) {
            BhDisplay=false;
        }
        greenValue = Game.clamp(greenValue,0,255);
        blueValue = Game.clamp(greenValue,0,255);
        
        if (HEALTH<400) {
            danger ++;
            if (danger > 30) {
                SFX.lowHealth();
                danger = 0;
            }
        }
        
        
        blueValue = SHIELD/2;
        greenValue = HEALTH/7;
        if (level != 10 ) {
            score +=level;
        }else score+=1;
        
        if  (a != 0){
            greenValue *= 999/7;
        }
        if (Handler.type != box) {
            renderBox();
        }
        box =Handler.type;
    }
    
    private void renderBox() {
        Spawn.Render=true;
    }
        
    public void render(Graphics g){
        if (BhDisplay) {
            g.setColor(Color.white);
            g.fillRect(331,15,402,14);
            g.setColor(Color.red);
            g.fillRect(332,16,(int)(BH*0.4f),12);
        }
        
        g.setColor(Color.white);
        g.fillRect(15,15,202,7);
        g.setColor(new Color(75,greenValue,0));
        g.fillRect(16,16,(int)(HEALTH/5.12f),5);
        if (SHIELD > 0) {
            g.setColor(Color.white);
            g.fillRect(15,25,202,7);
            g.setColor(new Color(blueValue/3,blueValue/3,blueValue));
            g.fillRect(16,26,((SHIELD/5)*2),5);
        }
        
        Font fnt = new Font("OwreKynge",1,20);
        g.setFont(fnt);
        g.setColor(new Color(0,200,255));
        
        g.drawString("Score: "+score,10,55);
        g.drawString("Level "+level,10,68);
        
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
    
    public void score(int score){
        this.score=score;
    }
    public int getScore(){
        return score;
    }  
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level=level;
    }
    
}