package Code;

public class MapPlacer {
    
    Handler handler;
    private int width;
    private int height;
    private RoomID room;
    private int colSize=45;
    private int rowSize=45;
    private int posX=0;
    private int posY=0;
    
    public MapPlacer(int width,int height,RoomID id,Handler handler) {
        this.room=id;
        this.width=width;
        this.height=height;
        this.handler=handler;
    }
    
    public void placeFloor(int x,int y,ID id) {
        handler.addObject(new MapFloor(x*ReSizer.getX(48),y*ReSizer.getY(48),id,room));
    }
    
    public void placeCorner(int x, int y,ID id) {
        //handler.addObject(new MapFloor(x*1,y*1,id));
    }
    
    public void placeWall(int x,int y,ID id) {
        handler.addObject(new MapWall(x*ReSizer.getX(48),y*ReSizer.getY(48),id,room));
    }
    
    public void placeCeiling(int x,int y,ID id){
        handler.addObject(new MapCeiling(x*ReSizer.getX(48),y*ReSizer.getY(48),id,room));
    }
    
    public void moveRoom(int x,int y) {
        posX+=x;
        posY+=y;
        for (int i=0; i< handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Map) {
                tempObject.setX(tempObject.getX()+x);
                tempObject.setY(tempObject.getY()+y);
            }
        }
    }
}
