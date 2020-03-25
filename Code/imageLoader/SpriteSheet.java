package Code.imageLoader;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    
    private BufferedImage sprite;
    private int rows,cols;
    
    public SpriteSheet(BufferedImage ss,int cols, int rows) {
        this.sprite = ss;
        this.rows=rows;
        this.cols=cols;
    }
    
    public BufferedImage grabImage(int col,int row,int width,int height) {
        BufferedImage img = sprite.getSubimage((sprite.getWidth()/cols)*col,(sprite.getHeight()/rows)*row,width,height) ;
        return img;
    }
}
