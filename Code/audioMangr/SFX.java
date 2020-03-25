package Code.audioMangr;
import Code.inputMangr.KeyInput;
import java.util.Random;

public class SFX {
    
    private static Random r = new Random();
    private static int a;
    private static int b;
    private static boolean intro=true;
    private static int counter=0;
    private static boolean state=true;
    private static boolean Mstate=true;
    private static boolean pause=false;
    private static boolean dead=false;
    
    public static void onOff() {
        if (state) {
            rainStop();
            state=false;
        } else if (state==false) {
                state=true;
                if (b==2)rainLoop();
        }
    }
    public static void mOnOff() {
        if (Mstate) {
            Mstate=false;
            AudioPlayer.getMusic("Intro").pause();
            AudioPlayer.getMusic("Zone1").pause();
            AudioPlayer.getMusic("Menu").pause();
            //AudioPlayer.getMusic("Game_Over").pause();
            //AudioPlayer.getMusic("Boss1").pause();
            //AudioPlayer.getMusic("Boss2").pause();
        }else if (Mstate==false) {
            Mstate=true;
            if (b==0) {
                AudioPlayer.getMusic("Boss2").resume();
            }
            if (b==1) {
                AudioPlayer.getMusic("Zone1").resume();
            }
            if (b==2) {
                AudioPlayer.getMusic("Menu").resume();
                if (intro){
                    AudioPlayer.getMusic("Menu").play();
                    intro=false;
                }
            }
            if (b==3) {
                AudioPlayer.getMusic("Game_Over").resume();
            }
            if (b==4) {
                AudioPlayer.getMusic("Boss1").resume();
            }
            if (b==5) {
                AudioPlayer.getMusic("Boss2").resume();
            }
        }
    }
    
    public static void tick() {
        if (intro) introLoop();
    }
    
    public static void introLoop() {
        counter++;
        if (counter > 2290 && KeyInput.State[1]==false) {
            menuTheme();
            intro=false;
        }
    }
    
    public static void introTheme() {
        b=2;
        AudioPlayer.getMusic("Intro").play();
        intro=true;
    }
    
    public static void zone1() {
        b=1;
        if (Mstate) {
            AudioPlayer.getMusic("Zone1").loop();
        }
    }
    
    public static  void menuTheme() {
        b=2;
        if (Mstate) {
            AudioPlayer.getMusic("Menu").loop();
        }
    }
    
    public static void gameOver() {
        b=3;
        if (Mstate) {
            //AudioPlayer.getMusic("Game_Over").play();
        }
    }
    
    public static void boss1() {
        b=4;
        if (Mstate) {
            //AudioPlayer.getMusic("Boss1").loop();
        }
    }
    
    public static void boss2() {
        b=5;
        if (Mstate) {
            //AudioPlayer.getMusic("Boss2").loop();
        }
    }
    
    public static void thunder(){
        if (state) {
            AudioPlayer.getSound("Thunder1").play();
            AudioPlayer.getSound("Thunder2").play();
        }
    }
    public static void rainLoop(){
        if (state) {
            AudioPlayer.getSound("RainLoop").loop(1,0.5f);
        }
    }
    public static void rainStop(){
        if (state) {
            AudioPlayer.getSound("RainLoop").stop();
        }
    }
    public static void pause() {
        if (state) {
            if (pause == false) {
                AudioPlayer.getSound("PauseOn").play();
                pause=true;
            }else
            if (pause) {
                AudioPlayer.getSound("PauseOff").play();
                pause = false;
            }
        }
    }
    public static void menu(){
        if (state) {
            AudioPlayer.getSound("Menu_Sound").play();
        }
    }
    public static void menuHover() {
        if (state) {
            //AudioPlayer.getSound("Menu_Hover");
        }
    }
    public static void ammo0() {
        if (state) {
            //AudioPlayer.getSound("Ammo0_1").play();
        }
    }
    public static void ammo1() {
        if (state) {
            //AudioPlayer.getSound("Ammo0_2").play();
        }
    }
    public static void ammo4() {
        if (state) {
            /*a = r.nextInt(3);
            if (a==0) {
                AudioPlayer.getSound("Ammo4_1").play();
            }
            if (a==1) {
                AudioPlayer.getSound("Ammo4_2").play();
            }
            if (a==2) {
                AudioPlayer.getSound("Ammo4_3").play();
            }*/
        }
    }
    public static void ballAmmo() {
        if (state) {
            /*a = r.nextInt(3);
            if (a==0) {
                AudioPlayer.getSound("BallAmmo1").play();
            }
            if (a==1) {
                AudioPlayer.getSound("BallAmmo2").play();
            }
            if (a==2) {
                AudioPlayer.getSound("BallAmmo3").play();
            }*/
        }
    }
    public static void charge() {
        if (state) {
            //AudioPlayer.getSound("Charge").play();
        }
    }
    public static void aim() {
        if (state) {
            /*AudioPlayer.getSound("Aim").play();
            AudioPlayer.getSound("Aim").play();
            AudioPlayer.getSound("Aim").play();
            AudioPlayer.getSound("Aim").play();*/
        }
    }
    public static void burst() {
        if (state) {
            /*a = r.nextInt(7);
            if (a==0) {
                AudioPlayer.getSound("Burst1").play();
            }
            if (a==1) {
                AudioPlayer.getSound("Burst2").play();
            }
            if (a==2) {
                AudioPlayer.getSound("Burst3").play();
            }
            if (a==3) {
                AudioPlayer.getSound("Burst4").play();
            }
            if (a==4) {
                AudioPlayer.getSound("Burst5").play();
            }
            if (a==5) {
                AudioPlayer.getSound("Burst6").play();
            }
            if (a==6) {
                AudioPlayer.getSound("Burst7").play();
            }*/
        }
    }
    public static void ammoGrab() {
        if (state) {
            /*AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();*/
        }
    }
    public static void healthUp() {
        if (state) {
            /*AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();*/
        }
    }
    public static void noAmmo() {
        if (state) {
            /*AudioPlayer.getSound("NoAmmo").play();
            AudioPlayer.getSound("NoAmmo").play();
            AudioPlayer.getSound("NoAmmo").play();
            AudioPlayer.getSound("NoAmmo").play();
            AudioPlayer.getSound("NoAmmo").play();
            AudioPlayer.getSound("NoAmmo").play();
            AudioPlayer.getSound("NoAmmo").play();
            AudioPlayer.getSound("NoAmmo").play();*/
        }
    }
    public static void lowHealth() {
        if (state) {
            /*AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();
            AudioPlayer.getSound("LowHealth").play();*/
        }
    }
    public static void rocket() {
        if (state) {
            //AudioPlayer.getSound("Rocket").play();
        }
    }
    public static void buzz() {
        if (state) {
            //AudioPlayer.getSound("Buzz").play();
        }
    }
    public static void explosion() {
        if (state) {
            /*a = r.nextInt(14);
            if (a==0) {
                AudioPlayer.getSound("Explosion1").play();
            }
            if (a==1) {
                AudioPlayer.getSound("Explosion2").play();
            }
            if (a==2) {
                AudioPlayer.getSound("Explosion3").play();
            }
            if (a==3) {
                AudioPlayer.getSound("Explosion4").play();
            }
            if (a==4) {
                AudioPlayer.getSound("Explosion5").play();
            }
            if (a==5) {
                AudioPlayer.getSound("Explosion6").play();
            }
            if (a==6) {
                AudioPlayer.getSound("Explosion7").play();
            }
            if (a==7) {
                AudioPlayer.getSound("Explosion8").play();
            }
            if (a==8) {
                AudioPlayer.getSound("Explosion9").play();
            }
            if (a==9) {
                AudioPlayer.getSound("Explosion10").play();
            }
            if (a==10) {
                AudioPlayer.getSound("Explosion11").play();
            }
            if (a==11) {
                AudioPlayer.getSound("Explosion12").play();
            }
            if (a==12) {
                AudioPlayer.getSound("Explosion13").play();
            }
            if (a==13) {
                AudioPlayer.getSound("Explosion14").play();
            }*/
        }
    }
    public static void burnt() {
        if (state) { 
            /*a = r.nextInt(2);
            if (a==0) {
                AudioPlayer.getSound("Burn1").play();
            }
            if (a==1) {
                AudioPlayer.getSound("Burn2").play();
            }*/
       }
    }
    public static void cry() {
        if (state) {
            /*a = r.nextInt(5);
            if (a==0) {
                AudioPlayer.getSound("Death1").play();
                AudioPlayer.getSound("Death1").play();
                AudioPlayer.getSound("Death1").play();
            }
            if (a==1) {
                AudioPlayer.getSound("Death2").play();
                AudioPlayer.getSound("Death2").play();
                AudioPlayer.getSound("Death2").play();
            }
            if (a==2) {
                AudioPlayer.getSound("Death3").play();
                AudioPlayer.getSound("Death3").play();
                AudioPlayer.getSound("Death3").play();
            }
            if (a==3) {
                AudioPlayer.getSound("Death4").play();
                AudioPlayer.getSound("Death4").play();
                AudioPlayer.getSound("Death4").play();
            }
            if (a==4) {
                AudioPlayer.getSound("Death0").play();
                AudioPlayer.getSound("Death0").play();
                AudioPlayer.getSound("Death0").play();
            }*/
        }
    }
}