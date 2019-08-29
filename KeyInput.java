package Code;
import Code.Game.STATE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    
    private static Handler handler;
    private Game game;
    public static boolean State[] = new boolean[8];
    private static int n;
    private static boolean lastMenu=false;
    private static int x=0;
    private static int y=0;
    private static boolean shut=false;
    private static int counter=0;
    private static int hold=0;
    public static boolean crouch= false;
    public static boolean jump=false;
            
    public KeyInput(Handler handler,Game game) {
        this.handler = handler;
        this.game=game;
    }
    
    private int where(int side){
        if (n==0) {
            if (side == 1) {
                n=1;
                if (Menu.Hover[0]) {
                    Menu.Hover[0]=false;
                }
                return n;
            }else {
                if (Menu.Hover[0]) {
                    Menu.Hover[0]=false;
                }
                n=2;
                return n;
            }
        }
        if (n==1) {
            if (side == 1) {
                n=2;
                if (Menu.Hover[1]) {
                    Menu.Hover[1]=false;
                }
                return n; 
            }else {
                if (Menu.Hover[1]) {
                    Menu.Hover[1]=false;
                }
                n=0;
                return n;
            }
            
        }else{
            if (side == 1) {
                n=0;
                if (Menu.Hover[2]) {
                    Menu.Hover[2]=false;
                }
                return n; 
            }else {
                if (Menu.Hover[2]) {
                    Menu.Hover[2]=false;
                }
                n=1;
                return n;
            }
        }
    }
    
    private int whereas(int side){
        if (n==5) {
            if (side == 1) {
                n=6;
                if (Menu.Hover[5]) {
                    Menu.Hover[5]=false;
                }
                return n; 
            }else {
                if (Menu.Hover[5]) {
                    Menu.Hover[5]=false;
                }
                n=7;
                return n;
            }
        }
        if (n==6) {
            if (side == 1) {
                n=7;
                if (Menu.Hover[6]) {
                    Menu.Hover[6]=false;
                }
                return n; 
            }else {
                if (Menu.Hover[6]) {
                    Menu.Hover[6]=false;
                }
                n=5;
                return n;
            }
            
        }else{
            if (side == 1) {
                n=5;
                if (Menu.Hover[7]) {
                    Menu.Hover[7]=false;
                }
                return n; 
            }else {
                if (Menu.Hover[7]) {
                    Menu.Hover[7]=false;
                }
                n=6;
                return n;
            }
        }
    }
    
    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        if (key != KeyEvent.VK_ESCAPE) {
            Menu.keyPressed=true;
        }
        if (key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE) {
            Menu.optionSelected=true;
        }else Menu.optionSelected=false;
        
        //kew event for menus
        if (State[0]) {
            if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP) Menu.Hover[where(0)]=true;
            if (key ==  KeyEvent.VK_S || key ==  KeyEvent.VK_DOWN) Menu.Hover[where(1)]=true;
        }
        if (State[4]) {
            if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP) Menu.Hover[whereas(0)]=true;
            if (key ==  KeyEvent.VK_S || key ==  KeyEvent.VK_DOWN) Menu.Hover[whereas(1)]=true;
        }
        if (State[3]) {
            if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_S) {
                Menu.Hover[4]=true;
            }
        }
        
        if (State[0]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[0]) {
                    Menu.Click[0]=true;
                }else
                if (Menu.Hover[1]) {
                    Menu.Click[1]=true;
                }else
                if (Menu.Hover[2]) {
                    Menu.Click[2]=true;
                }
            }
        }
        
        if (State[2]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[3]) {
                        Menu.Click[3]=true;
                }
            }
        }
        
        if (State[5]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[3]) {
                        Menu.Click[3]=true;
                }
            }
        }
        
        if (State[4]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[5]){
                    Menu.Click[5]=true;
                }else
                if (Menu.Hover[6]) {
                    Menu.Click[6]=true;
                }else
                if (Menu.Hover[7]) {
                    Menu.Click[7]=true;
                }
            }
        }
        
        if (State[3]) {
            hold++;
            if (hold>2) {
                if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                    if (Menu.Hover[4]) {
                        Menu.Click[4]=true;
                    }
                }
            }
        }
        
        for (int i=0; i< handler.object.size() ; i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (State[1]) {
                if (tempObject.getId()==ID.Player) {
                // key event for Player 1
                    x=tempObject.getX();
                    y=tempObject.getY();
                    if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP) jump=true;
                    if (key ==  KeyEvent.VK_S || key ==  KeyEvent.VK_DOWN) crouch=true;
                    if (key ==  KeyEvent.VK_A || key ==  KeyEvent.VK_LEFT) tempObject.setVelx(-10);
                    if (key ==  KeyEvent.VK_D || key ==  KeyEvent.VK_RIGHT) tempObject.setVelx(10);
                    if (key ==  KeyEvent.VK_SPACE) {
                        shut=true;
                    }
                }
            }
        }
    }
    
    public static void tick() {
        for (int i=0; i< handler.object.size() ; i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (State[1]) {
                if (tempObject.getId()==ID.Player) {
                    x=tempObject.getX();
                    y=tempObject.getY();
                }
            }
        }
        if (State[1]) {
            if (shut) {
                if (counter <1) {
                    ammo(x,y);
                    counter=4;
                }else counter--;
            }else counter =0;
        }else shut=false;
    }
    
    public static void ammo(int x,int y){
            /*if (handler.getType()==0){
                handler.addObject(new Ammo0(x+24,y,ID.Ammo0,handler));
            }
            if (handler.getType()==2){
                handler.addObject(new Ammo0(x+12,y+15,ID.Ammo0,handler));
                handler.addObject(new Ammo0(x+36,y+15,ID.Ammo0,handler));
            }
            if (handler.getType()==3){
                handler.addObject(new Ammo2(x+21,y,ID.Ammo2,handler));
            }
            if (handler.getType()==4){
                handler.addObject(new Ammo4(x+22,y,ID.Ammo4,handler));
            }
            if (handler.getType()==5){
                handler.addObject(new Ammo4(x+8,y+15,ID.Ammo4,handler));
                handler.addObject(new Ammo4(x+36,y+15,ID.Ammo4,handler));
            }
            if (handler.getType()==6){
                handler.addObject(new Ammo11(x+24,y,ID.Ammo11,handler,0));
                handler.addObject(new Ammo11(x+6,y+15,ID.Ammo11,handler,1));
                handler.addObject(new Ammo11(x+37,y+15,ID.Ammo11,handler,2));
            }
            if (handler.getType()==7){
                handler.addObject(new Ammo14(x+24,y,ID.Ammo14,handler,0));
                handler.addObject(new Ammo14(x+12,y+15,ID.Ammo14,handler,2));
                handler.addObject(new Ammo14(x+36,y+15,ID.Ammo14,handler,-2));
            }*/
    }
    
    public  void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (State[0]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[0]) {
                    Menu.Click[0]=true;
                    relFunc(0);
                    Menu.Hover[0]=false;
                }else
                if (Menu.Hover[1]) {
                    Menu.Click[1]=true;
                    relFunc(1);
                    Menu.Hover[1]=false;
                    Menu.Hover[3]=true;
                }else
                if (Menu.Hover[2]) {
                    Menu.Click[2]=true;
                    relFunc(2);
                    Menu.Hover[2]=false;
                }else Menu.Hover[0]=true;
            }
        }
        
        if (State[2]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[3]) {
                    relFunc(3);
                    Menu.Hover[3]=false;
                    Menu.Hover[1]=true;
                }else Menu.Hover[3]=true;
            }
        }
        
        if (State[5]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[3]) {
                    relFunc(3);
                    Menu.Hover[3]=false;
                    Menu.Hover[1]=true;
                }else Menu.Hover[3]=true;
            }
        }
        
        if (State[4]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Menu.Hover[5]){
                    relFunc(5);
                    Menu.Hover[5]=false;
                    Spawn.Render=true;
                }else
                if (Menu.Hover[6]) {
                    Menu.Hover[6]=false;
                    relFunc(6);
                }else
                if (Menu.Hover[7]) {
                    Menu.Hover[7]=false;
                    lastMenu=true;
                    relFunc(2);
                    Menu.Hover[3]=true;
                }else Menu.Hover[5]=true;
            }
        }
        
        if (State[3]) {
            hold++;
            if (hold>2) {
                if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                    if (Menu.Hover[4]) {
                        relFunc(4);
                        Menu.Click[4]=true;
                    }else Menu.Hover[4]=true;
                }
            }
        }
        
        if (State[1]) {
            for (int i=0; i< handler.object.size() ; i++) {
                GameObject tempObject = handler.object.get(i);
            
                if (tempObject.getId()==ID.Player) {
                    // key event for Player 1
                    if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP);
                    if (key ==  KeyEvent.VK_S || key ==  KeyEvent.VK_DOWN) tempObject.setVely(0);
                    if (key ==  KeyEvent.VK_A || key ==  KeyEvent.VK_LEFT) tempObject.setVelx(0);
                    if (key ==  KeyEvent.VK_D || key ==  KeyEvent.VK_RIGHT) tempObject.setVelx(0);
                }
            }
            if (key ==  KeyEvent.VK_SPACE)shut=false;
        }
            if (key == KeyEvent.VK_ESCAPE) {
                if (Game.pause==false) {
                    if (State[1]) {
                        SFX.pause();
                        Game.pause=true;
                    }
                } else {
                    if (State[4]) {
                        Game.pause=false;
                        SFX.pause();
                        Spawn.Render=true;
                    }
                }
            }
    }
    
    public void relFunc(int n) {
        if (n==0) {
            game.gameState= STATE.Game;
            handler.addObject(new Player((Game.WIDTH/2)-24,(Game.HEIGHT/2),ID.Player,handler));
            SFX.menu();
        }
        if (n==1) {
            SFX.menu();
            game.gameState = STATE.Help;
        }
        if (n==2) {
            SFX.menu();
            game.gameState = STATE.Options;
        }
        if (n==3) {
            SFX.menu();
            if (lastMenu) {
                lastMenu=false;
                game.gameState = STATE.Pause;
            }else {
                game.gameState= STATE.Menu;
            }
        }
        if (n==4) {
            SFX.menu();
            HUD.HEALTH=1024;
            HUD.SHIELD=0;
            HUD.score=0;
            HUD.level=1;
            Handler.type=0;
            Handler.Ulti=0;
            game.gameState= STATE.Menu;
        }
        if (n==5) {
            SFX.pause();
            Game.pause=false;
            Spawn.Render=true;
        }
        if (n==6) {
            SFX.menu();
            Spawn.play=1;
            Spawn.scoreKeep=0;
            SFX.menuTheme();
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
        }
        /*if (n==8) {
            if (noise[0]==0) {
                noise[0]=1;
            } else noise[0]=0;
            SFX.onOff();
        }
        if (n==9) {
            if (noise[1]==0) {
                noise[1]=1;
            } else noise[1]=0;
            SFX.mOnOff();
        }*/
    }
}