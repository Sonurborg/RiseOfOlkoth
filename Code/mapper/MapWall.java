package Code.mapper;

import Code.game.GameObject;
import Code.game.ID;
import Code.game.RoomID;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MapWall extends GameObject{
    
    public MapWall(int x,int y,ID id,RoomID RoomId) {
        super(x,y,id,RoomId);
    }

    public void tick() {
        
    }

    public void render(Graphics g) {
        
    }

    public Rectangle getBounds() {
        return null;
    }
}
