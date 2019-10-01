package Rooms;

import Code.ReSizer;
import Code.MapPlacer;
import Code.Handler;
import Code.ID;
import Code.RoomID;

public class Room1 {
    
    static Handler handler;
    static MapPlacer place;
    
    public Room1(Handler handler){
        this.handler=handler;
        place=new MapPlacer(30,30,RoomID.Room1,handler);
        Spawn();
    }
    
    public static void tick(){
        place.moveRoom(0, 0);
    }
    
    private static void Spawn() {
        place.placeFloor(0, 4, ID.Floor);
        place.placeFloor(1, 4, ID.Floor);
        place.placeFloor(2, 4, ID.Floor);
    }
}
