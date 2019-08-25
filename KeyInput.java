package Code;
import Code.Game.STATE;
import static Code.Menu.Click;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    
    private static Handler handler;
    private Game game;
    public static boolean State[] = new boolean[5];
    private static int n;
    private static int x=0;
    private static int y=0;
    private static boolean shut=false;
    private static int counter=0;
    private static int hold=0;
    public KeyInput(Handler handler,Game game) {
        this.handler = handler;
        this.game=game;
    }
    
    private int Where(int side){
        if (n==0) {
            if (side == 1) {
                n=1;
                if (Menu.Click[0]) {
                    Menu.Click[0]=false;
                }
                return n;
            }else {
                if (Menu.Click[0]) {
                    Menu.Click[0]=false;
                }
                n=2;
                return n;
            }
        }
        if (n==1) {
            if (side == 1) {
                n=2;
                if (Menu.Click[1]) {
                    Menu.Click[1]=false;
                }
                return n; 
            }else {
                if (Menu.Click[1]) {
                    Menu.Click[1]=false;
                }
                n=0;
                return n;
            }
            
        }else{
            if (side == 1) {
                n=0;
                if (Menu.Click[2]) {
                    Menu.Click[2]=false;
                }
                return n; 
            }else {
                if (Menu.Click[2]) {
                    Menu.Click[2]=false;
                }
                n=1;
                return n;
            }
        }
    }
    
    private int Whereas(int side){
        if (n==5) {
            if (side == 1) {
                n=6;
                if (Menu.Click[5]) {
                    Menu.Click[5]=false;
                }
                return n; 
            }else {
                if (Menu.Click[5]) {
                    Menu.Click[5]=false;
                }
                n=7;
                return n;
            }
        }
        if (n==6) {
            if (side == 1) {
                n=7;
                if (Menu.Click[6]) {
                    Menu.Click[6]=false;
                }
                return n; 
            }else {
                if (Menu.Click[6]) {
                    Menu.Click[6]=false;
                }
                n=5;
                return n;
            }
            
        }else{
            if (side == 1) {
                n=5;
                if (Menu.Click[7]) {
                    Menu.Click[7]=false;
                }
                return n; 
            }else {
                if (Menu.Click[7]) {
                    Menu.Click[7]=false;
                }
                n=6;
                return n;
            }
        }
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //kew event for menus
        if (State[0]) {
            if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP) Menu.Click[Where(0)]=true;
            if (key ==  KeyEvent.VK_S || key ==  KeyEvent.VK_DOWN) Menu.Click[Where(1)]=true;
        }
        if (State[4]) {
            if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP) Menu.Click[Whereas(0)]=true;
            if (key ==  KeyEvent.VK_S || key ==  KeyEvent.VK_DOWN) Menu.Click[Whereas(1)]=true;
        }
        if (State[3]) {
            if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_S) {
                Click[4]=true;
            }
        }
        
        for (int i=0; i< handler.object.size() ; i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (State[1]) {
                if (tempObject.getId()==ID.Player) {
                // key event for Player 1
                    x=tempObject.getX();
                    y=tempObject.getY();
                    if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP) tempObject.setVely(-10);
                    if (key ==  KeyEvent.VK_S || key ==  KeyEvent.VK_DOWN) tempObject.setVely(10);
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
                    Ammo(x,y);
                    counter=4;
                }else counter--;
            }else counter =0;
        }else shut=false;
    }
    
    public static void Ammo(int x,int y){
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
                 if (Menu.Click[0]) {
                    SFX.Menu();
                    game.gameState= STATE.Game;
                    handler.addObject(new Player((Game.WIDTH/2)-24,(Game.HEIGHT/2),ID.Player,handler));
                    Menu.Click[0]=false;
                 }else
                 if (Menu.Click[1]) {
                    SFX.Menu();
                    Click[1]=false;
                    Click[3]=true;
                    game.gameState = STATE.Help;
                 }else
                 if (Click[2]) {
                    Click[2]=false;
                    SFX.Menu();
                    System.exit(1);
                 }else Click[0]=true;
             }
        }
        
        if (State[2]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                if (Click[3]) {
                    SFX.Menu();
                    Click[3]=false;
                    Click[1]=true;
                    game.gameState= STATE.Menu;
                }else Click[3]=true;
            }
        }
        
        if (State[4]) {
            if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                 if (Menu.Click[5]) {
                    SFX.Pause();
                    Click[5]=false;
                    Game.pause=false;
                    Spawn.Render=true;
                 }else
                 if (Menu.Click[6]) {
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
                 }else
                 if (Click[7]) {
                    Click[7]=false;
                    SFX.Menu();
                    System.exit(1);
                 }else Click[5]=true;
             }
        }
        
        if (State[3]) {
            hold++;
            if (hold>2) {
                if (key ==  KeyEvent.VK_SPACE || key ==  KeyEvent.VK_ENTER) {
                    if (Menu.Click[4]) {
                        SFX.Menu();
                        HUD.HEALTH=1024;
                        Click[4]=false;
                        HUD.score=0;
                        HUD.SHIELD=0;
                        HUD.level=1;
                        Handler.type=0;
                        Handler.Ulti=0;
                        game.gameState= STATE.Menu;
                    }else Click[4]=true;
                }
            }
        }
        
        if (State[1]) {
            for (int i=0; i< handler.object.size() ; i++) {
                GameObject tempObject = handler.object.get(i);
            
                if (tempObject.getId()==ID.Player) {
                    // key event for Player 1
                    if (key ==  KeyEvent.VK_W || key ==  KeyEvent.VK_UP) tempObject.setVely(0);
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
                        SFX.Pause();
                        Game.pause=true;
                    }
                } else {
                    if (State[4]) {
                        Game.pause=false;
                        SFX.Pause();
                        Spawn.Render=true;
                    }
                }
            }
    }
}