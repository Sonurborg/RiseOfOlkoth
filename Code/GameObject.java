package Code;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    
    protected int x,y;
    protected ID id;
    protected  int velx,vely;
    protected RoomID RoomId;
    
    public  GameObject(int x,int y,ID id){
        this.x=x;
        this.y=y;
        this.id=id;
    }
    
    public  GameObject(int x,int y,ID id,RoomID RoomId){
        this.x=x;
        this.y=y;
        this.id=id;
        this.RoomId=RoomId;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public void setX(int x){
        this.x=x;
    }  
    public void setY(int y){
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public ID getId() {
        return id;
    }
    public int getVelx() {
        return velx;
    }
    public void setVelx(int velx) {
        this.velx = velx;
    }
    public int getVely() {
        return vely;
    }
    public void setVely(int vely) {
        this.vely = vely;
    }
    public RoomID getRoomId() {
        return RoomId;
    }
    public void setRoomId(RoomID RoomId) {
        this.RoomId = RoomId;
    }
}
 