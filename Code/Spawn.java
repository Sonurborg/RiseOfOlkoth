package Code;
import java.util.Random;
import Rooms.Room1;

public class Spawn {
    
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    private float n=0;
    
    public   Spawn (Handler handler,HUD  hud) {
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick() {
        if (HUD.HEALTH==0){
            SFX.gameOver();
            return;
        }
        SpawnRoom();
    }
    
    public void SpawnRoom(){
        for (int i=0; i< handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getRoomId() != RoomID.Room1) {
                if (n==0) {
                    new Room1(handler);
                }n++;
            }
        }
    }

}