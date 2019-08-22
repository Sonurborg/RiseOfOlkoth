package Code;
import java.util.Random;

public class SFX {
    
    private static Random r = new Random();
    private static int a;
    private static int b;
    private  static boolean state=true;
    private  static boolean Mstate=true;
    private static boolean pause=false;
    private static boolean dead=false;
    
    public static void OnOff() {
        if (state) {
            state=false;
        } else {
            if (state==false) 
                state=true;
        }
    }
    public static void MOnOff() {
        /*if (Mstate) {
            Mstate=false;
        }else {
        if (Mstate==false) 
            Mstate=true;
        }
        if (Mstate) {
            if (b==0) {
                AudioPlayer.getMusic("Battle_Music").loop();
            }
            if (b==1) {
                AudioPlayer.getMusic("Menu_Theme").loop();
            }
            if (b==2) {
                AudioPlayer.getMusic("Game_Over").play();
            }
            if (b==3) {
                AudioPlayer.getMusic("Boss1").loop();
            }
            if (b==4) {
                AudioPlayer.getMusic("Boss2").loop();
            }
        }
        if (Mstate==false) {
            AudioPlayer.getMusic("Battle_Music").stop();
            AudioPlayer.getMusic("Menu_Theme").stop();
            AudioPlayer.getMusic("Game_Over").stop();
            AudioPlayer.getMusic("Boss1").stop();
            AudioPlayer.getMusic("Boss2").stop();
        }*/
    }
    
    public static void Battle_Theme() {
        b=0;
        if (Mstate) {
            //AudioPlayer.getMusic("Battle_Music").loop();
        }
    }
    
    public static  void Menu_Theme() {
        b=1;
        if (Mstate) {
            //AudioPlayer.getMusic("Menu_Theme").loop();
        }
    }
    
    public static void Game_Over() {
        b=2;
        if (Mstate) {
            //AudioPlayer.getMusic("Game_Over").play();
        }
    }
    
    public static void Boss1() {
        b=3;
        if (Mstate) {
            //AudioPlayer.getMusic("Boss1").loop();
        }
    }
    
    public static void Boss2() {
        b=4;
        if (Mstate) {
            //AudioPlayer.getMusic("Boss2").loop();
        }
    }
    
    public static void Pause() {
        if (state) {
            /*if (pause == false) {
                AudioPlayer.getSound("PauseOn").play();
                pause=true;
            }else
            if (pause) {
                AudioPlayer.getSound("PauseOff").play();
                pause = false;
            }*/
        }
    }
    public static void Menu(){
        if (state) {
            //AudioPlayer.getSound("Menu_Sound").play();
        }
    }
    public static void MenuHover() {
        if (state) {
            //AudioPlayer.getSound("Menu_Hover");
        }
    }
    public static void Ammo0() {
        if (state) {
            //AudioPlayer.getSound("Ammo0_1").play();
        }
    }
    public static void Ammo1() {
        if (state) {
            //AudioPlayer.getSound("Ammo0_2").play();
        }
    }
    public static void Ammo4() {
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
    public static void BallAmmo() {
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
    public static void Charge() {
        if (state) {
            //AudioPlayer.getSound("Charge").play();
        }
    }
    public static void Aim() {
        if (state) {
            /*AudioPlayer.getSound("Aim").play();
            AudioPlayer.getSound("Aim").play();
            AudioPlayer.getSound("Aim").play();
            AudioPlayer.getSound("Aim").play();*/
        }
    }
    public static void Burst() {
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
    public static void AmmoGrab() {
        if (state) {
            /*AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();
            AudioPlayer.getSound("AmmoGrab").play();*/
        }
    }
    public static void HealthUp() {
        if (state) {
            /*AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();
            AudioPlayer.getSound("HealthUp").play();*/
        }
    }
    public static void NoAmmo() {
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
    public static void LowHealth() {
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
    public static void Rocket() {
        if (state) {
            //AudioPlayer.getSound("Rocket").play();
        }
    }
    public static void Buzz() {
        if (state) {
            //AudioPlayer.getSound("Buzz").play();
        }
    }
    public static void Explosion() {
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
    public static void Burnt() {
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
    public static void Cry() {
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