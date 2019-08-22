package Code;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    
    protected int x,y;
    protected ID id;
    protected  int velx,vely;
    protected int iden;
    
    public  GameObject(int x,int y,ID id){
        this.x=x;
        this.y=y;
        this.id=id;
    }
    
    public  GameObject(int x,int y,ID id,int iden){
        this.x=x;
        this.y=y;
        this.id=id;
        this.iden=iden;
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
    public void setId(ID id) {
        this.id = id;
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
    public int getIden() {
        return iden;
    }
    public void setIden(int iden) {
        this.iden = iden;
    }
}
 