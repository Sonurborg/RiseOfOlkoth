package Code.menus.functions;
import Code.Game;
import Code.menus.OptionsMenu;
import Code.menus.Menu;
import Code.dataMangr.SaveMangr;
import Code.displayMangr.Window;
import Code.Game.STATE;
import Code.game.GameObject;
import Code.game.HUD;
import Code.game.Handler;
import Code.game.ID;
import Code.game.Player;
import Code.audioMangr.SFX;


public class ButtonFunc {
    
    public static SaveMangr[] saves = new SaveMangr[4];
    private static STATE last=STATE.Menu;
    private static boolean acc;
    public static int selected=0;
    private Game game;
    private Handler handler;
    private boolean running=false;
    
    public ButtonFunc(Game game,Handler handler){
        this.game=game;
        this.handler=handler;
    }
    
    public void relFunc(int n) {
        if (n==0) func00();
        if (n==1) func01();
        if (n==2) func02();
        if (n==3) func03();
        if (n==4) func04();
        if (n==5) func05();
        if (n==6) func06();
        if (n==7) func07();
        if (n==8) func08();
        if (n==9) func09();
        if (n==10) func10();
        if (n==11) func11();
        if (n==12) func12();
        if (n==13) func13();
        if (n==14) func14();
        if (n==15) func15();
        if (n==16) func16();
        if (n==17) func17();
    }
    
    private void func00(){
        SFX.menu();
        last=game.gameState;
        Menu.save=false;
        game.gameState= STATE.Save;
    }
    
    private void func01(){
        SFX.menu();
        last=game.gameState;
        game.gameState = STATE.Help;
    }
    
    private void func02(){
        SFX.menu();
            last=game.gameState;
            game.gameState = STATE.Options;
    }

    private void func03(){
        SFX.menu();
        if (last==game.gameState) {
            if (running) {
                game.gameState=STATE.Pause;
            }else game.gameState= STATE.Menu;
        }else if (last==STATE.Pause) {
            game.gameState = STATE.Pause;
        }else if (last==STATE.Menu) {
            game.gameState= STATE.Menu;
        }else if (last==STATE.Options) {
            game.gameState=STATE.Options;
        }else if (last==STATE.Game) {
            game.gameState=STATE.Game;
        }
        last=game.gameState;
    }
    
    private void func04(){
        SFX.menu();
        HUD.HEALTH=1024;
        game.gameState= STATE.Menu;
    }
    
    private void func05(){
        SFX.pause();
        Game.pause=false;
    }
    
    private void func06(){
        SFX.menu();
        SFX.menuTheme();
        SFX.rainLoop();
        running=false;
        Game.pause=false;
        for (int j=0;j<5;j++) {
            for (int i=0; i< handler.object.size();i++){
                GameObject tempObject = handler.object.get(i);
                handler.removeObject(tempObject);
                /*if(tempObject.getId() != ID.Background && tempObject.getId() != ID.Backplate) {
                    handler.removeObject(tempObject);
                }*/
            }
        }
        HUD.HEALTH=1024;
        game.gameState = STATE.Menu;
    }
    
    private void func07(){
        SFX.menu();
        System.exit(1);
    }
    
    private void func08(){
        SFX.menu();
        if (OptionsMenu.noise[0]==0) {
            OptionsMenu.noise[0]=1;
        } else OptionsMenu.noise[0]=0;
        SFX.onOff();
    }
    
    private void func09(){
        SFX.menu();
            if (OptionsMenu.noise[1]==0) {
                OptionsMenu.noise[1]=1;
            } else OptionsMenu.noise[1]=0;
            SFX.mOnOff();
    }
    
    //START GAME OPTION
    private void func10(){
        SFX.menu();
        SFX.rainStop();
        if (true) {
            startNewGame();
        }
    }
    
    private void func11(){
        if (OptionsMenu.noise[2]==0) {
                Window.windowed();
                OptionsMenu.noise[2]=1;
            } else {
                Window.fullscreen();
                OptionsMenu.noise[2]=0;
            }
            SFX.menu();
    }
    
    private void func12(){
        SFX.menu();
        Menu.save=true;
        game.gameState= STATE.Save;
    }
    
    private void func13(){
        SFX.menu();
        if (OptionsMenu.mapper) {
           OptionsMenu.mapper=false;
        }else OptionsMenu.mapper=true;
    }
    
    //load
    private void func14(){
        if (getSave()!=null)SaveMangr.loadGame(getSave());
    }
    
    //save
    private void func15(){
        SaveMangr.saveGame();
    }
    
    //erase
    private void func16(){
        if (getSave()!=null)SaveMangr.eraseGame(getSave());
    }
    
    //copy
    private void func17(){
        if (getSave()!=null)SaveMangr.copyGame(getSave(),getSlot());
    }
    
    private int getSlot(){
        /*ASK TO SELECT SLOT TO COPY THE SHIT*/
        /*MAKE AN ARE YOU SURE WINDOW */
        return 0;
    }
    
    private void startNewGame(){
        running=true;
        game.gameState= STATE.Game;
        handler.addObject(new Player((Game.WIDTH/2)-24,(Game.HEIGHT/2),ID.Player,handler));
        SaveMangr.newGame(selected);
    }
    
    public SaveMangr getSave(){
        return selectedSave();
    }
    
    private SaveMangr selectedSave(){
        return saves[selected];
    }
    
    public boolean backRender(){
        if (game.gameState == STATE.Options){
            if (last== STATE.Menu) acc=true;
            else if (last==STATE.Pause)acc=false;
        }
        if (game.gameState == STATE.Menu) {
            return true;
        }else if (running) {
            return false;
        }else if (last==STATE.Pause) {
            acc=false;
            return false;
        }else if (last==STATE.Menu) {
            return true;
        }else if (last==STATE.Options && acc) {
            return true;
        }else if (last==STATE.Game) {
            return false;
        }else return false;
    }
    
}
