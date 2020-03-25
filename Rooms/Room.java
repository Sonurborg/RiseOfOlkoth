package Rooms;

import Code.game.Handler;
import Code.mapper.MapPlacer;
import Code.game.RoomID;
import java.awt.Point;

public abstract class Room {
    
    
    protected Handler handler;
    protected MapPlacer place;
    protected RoomID ID;
    protected Point point;
    
    public Room(Handler handler,boolean place){
        this.handler=handler;
    }
    
    public abstract Point getSavePoint();
    
    public abstract void tick();
    
    public abstract void Spawn();
    
    public abstract RoomID getId();
    
    public abstract void placeRoom();
}
