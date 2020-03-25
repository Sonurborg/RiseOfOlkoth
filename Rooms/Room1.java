package Rooms;

import Code.displayMangr.ReSizer;
import Code.mapper.MapPlacer;
import Code.game.Handler;
import Code.game.RoomID;
import java.awt.Point;

public class Room1 extends Room{
    
    public Room1(Handler handler,boolean place){
       super(handler,place);
       ID=RoomID.Room1;
       point=new Point(0,0);
       if(place)placeRoom();
    }
    
    public void placeRoom(){
        place=new MapPlacer(30,30,handler,this);
        Code.audioMangr.SFX.zone1();
        Spawn();
    }
    
    public Point getSavePoint(){
        return point;
    }
    
    public void tick(){
        place.moveRoom(0, 0);
    }
    
    public void Spawn() {
        place.placeFloor(0, 4, Code.game.ID.Floor);
        place.placeFloor(1, 4, Code.game.ID.Floor);
        place.placeFloor(2, 4, Code.game.ID.Floor);
    }
    
    public RoomID getId(){
        return ID;
    }
}
