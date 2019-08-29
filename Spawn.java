package Code;
import java.util.Random;

public class Spawn {
    
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    private int counter=0;
    public static int scoreKeep = 0;
    public static int levelScore=150; 
    private float n=1;
    public static boolean Render = false;
    private static int a=1;
    public static int play=1;
    
    public   Spawn (Handler handler,HUD  hud) {
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick() {
        scoreKeep++;
        
        if (hud.getLevel() == 1){
            levelScore=150;
        }
        if (HUD.HEALTH==0){
            SFX.gameOver();
            scoreKeep=0;
            play=1;
            return;
        }
        
        
        if (scoreKeep >= levelScore) {
            scoreKeep=0;
            hud.setLevel(hud.getLevel()+1);
            levelScore *=1.5;
        }
        
        if (scoreKeep==1 ) {
            if (hud.getLevel()== play) {
               
                /*--level 11 test--
                hud.level=11;
                levelScore=5700;
                -- -- -- -- -- --*/
                
                /*--level 11 test--
                hud.level=13;
                levelScore=12825;
                handler.setType(6);
                -- -- -- -- -- --*/
                play+=10;
            }
        }
    }   

}