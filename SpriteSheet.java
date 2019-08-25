package Code;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    
    private BufferedImage sprite;
    private int rows,cols;
    
    public SpriteSheet(BufferedImage ss,int rows, int cols) {
        this.sprite = ss;
        this.rows=rows;
        this.cols=cols;
    }
    
    public BufferedImage grabImage(int row,int col,int width,int height) {
        BufferedImage img = sprite.getSubimage((sprite.getWidth()/rows)*row,(sprite.getHeight()/cols)*col,width,height) ;
        return img;
    }
}
