package Code;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
    
    Handler handler;
    
    
    public Player(int x,int y,ID id, Handler handler) {
        super(x,y,id);
        this.handler = handler;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x,y,48,48);
    } 
    
    public void tick(){
        
        x += velx;
        y += vely;
        x = Game.clamp(x,-16,Game.WIDTH-48);
        y = Game.clamp(y,0,Game.HEIGHT-68);
        collision();
    }
    
    private void collision() {
        for (int i=0; i< handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Ammo1) {
                if (getBounds().intersects(tempObject.getBounds())){
                    
                }
            }
        }
    }
    
    public void render(Graphics g){
    }   
}