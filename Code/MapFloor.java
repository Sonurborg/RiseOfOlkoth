package Code;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class MapFloor extends GameObject{
    
    Handler handler;
    private BufferedImageLoader loader=new BufferedImageLoader();
    private BufferedImage sprite=loader.loadImage("/Res/Sprites/living_tileset.png");
    private SpriteSheet sheet=new SpriteSheet(sprite,17,12);
    
    public MapFloor(int x,int y,ID id,RoomID RoomId) {
        super(x,y,id,RoomId);
    }

    public void tick() {
        collision();
    }
    
    public void collision() {
    }

    public void render(Graphics g) {
        g.drawImage(sheet.grabImage(4, 8, 16, 16), x, y,ReSizer.getX(24),ReSizer.getY(24), null);
        g.drawImage(sheet.grabImage(5, 8, 16, 16), x+ReSizer.getX(24), y,ReSizer.getX(24),ReSizer.getY(24),null);
        g.drawImage(sheet.grabImage(4, 9, 16, 16), x, y+ReSizer.getY(24),ReSizer.getX(24),ReSizer.getY(24), null);
        g.drawImage(sheet.grabImage(5, 9, 16, 16), x+ReSizer.getX(24), y+ReSizer.getY(24),ReSizer.getX(24),ReSizer.getY(24), null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y+ReSizer.getY(12),ReSizer.getX(48),ReSizer.getY(36));
    }
}
