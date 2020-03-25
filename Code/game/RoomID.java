package Code.game;


import Rooms.Room;
import Rooms.Room1;

public enum RoomID {
    
    Room1(),
    ;
    
    
    public static Room getRoom(RoomID id,Handler handler,boolean place){
        if (id.equals(Room1)) return new Room1(handler,place);
        else return null;
    }
}
