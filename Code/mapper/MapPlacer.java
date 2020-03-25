package Code.mapper;

import Code.game.GameObject;
import Code.game.Handler;
import Code.game.ID;
import Code.game.RoomID;
import Code.displayMangr.ReSizer;
import Rooms.Room;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MapPlacer {
    
    Handler handler;
    public static List<Room> room=new ArrayList<>();
    private int width;
    private int height;
    private int colSize=45;
    private int rowSize=45;
    private int posX=0;
    private int posY=0;
    
    public MapPlacer(int width,int height,Handler handler,Room newroom) {
        this.width=width;
        this.height=height;
        this.handler=handler;
        room.add(newroom);
    }
    
    public void placeFloor(int x,int y,ID id) {
        handler.addObject(new MapFloor(x*ReSizer.getX(48),y*ReSizer.getY(48),id,room.get(0).getId()));
    }
    
    public void placeCorner(int x, int y,ID id) {
        //handler.addObject(new MapFloor(x*1,y*1,id));
    }
    
    public void placeWall(int x,int y,ID id) {
        handler.addObject(new MapWall(x*ReSizer.getX(48),y*ReSizer.getY(48),id,room.get(0).getId()));
    }
    
    public void placeCeiling(int x,int y,ID id){
        handler.addObject(new MapCeiling(x*ReSizer.getX(48),y*ReSizer.getY(48),id,room.get(0).getId()));
    }
    
    public void changeRoom(Room chg){
        room.remove(room.get(0));
        room.add(chg);
        room.get(0).placeRoom();
    }
    
    public void moveRoom(int x,int y) {
        posX+=x;
        posY+=y;
        /*for (int i=0; i< handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Map) {
                tempObject.setX(tempObject.getX()+x);
                tempObject.setY(tempObject.getY()+y);
            }
        }*/
    }

    public static RoomID getRoomId() {
        return room.get(0).getId();
    }
    
    public static Point getSavePoint() {
        return room.get(0).getSavePoint();
    }
    
    public static int getRoom(RoomID id){
        for (int i=0;i<room.size();i++) {
            if (room.get(i).getId().equals(id))return i;
        }
         return 0;
    }
}
