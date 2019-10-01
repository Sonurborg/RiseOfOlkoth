package Code;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    
    Handler handler;
    private int idleTime= 0;
    boolean IDLE=false;
    BufferedImageLoader loader = new BufferedImageLoader();
    private BufferedImage Idles;
    private BufferedImage jump;
    SpriteSheet Idle;
    SpriteSheet Jump;
    private int jumpFrame=0;
    
    public Player(int x,int y,ID id, Handler handler) {
        super(x,y,id);
        this.handler = handler;
        
        jump=loader.loadImage("/Res/Sprites/JumpSpritesheet.png");
        Idles=loader.loadImage("/Res/Sprites/CharacterIdle.png");
        Idle = new SpriteSheet(Idles,3,1);
        Jump=new SpriteSheet(jump,12,2);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x,y,ReSizer.getX(34),ReSizer.getY(70));
    } 
    
    public int idle(){ 
        if (idleTime>0 && idleTime<12) return 0;
        if (idleTime>12 && idleTime<18) return 1;
        if (idleTime>18 && idleTime<24) return 2;
        return 1;
    }
    
    public int jumpSprite(boolean isRow) {
        if (isRow) {
            if (vely>-25 && vely<=-24) return 0;
            if (vely>-24 && vely<=-23) return 1;
            if (vely>-23 && vely<=-21) return 2;
            if (vely>-21 && vely<=-19) return 3;
            if (vely>-19 && vely<=-15) return 4;
            if (vely>-15 && vely<=-13) return 5;
            if (vely>-13 && vely<=-11) return 6;
            if (vely>-11 && vely<= -9) return 7;
            if (vely> -9 && vely<= -7) return 8;
            if (vely> -7 && vely<= -5) return 9;
            if (vely> -5 && vely<= -3) return 10;
            if (vely> -3 && vely<=  0) return 11;
            if (vely>  0 && vely<=  4) return 0;
            if (vely>  4 && vely<=  7) return 1;
            if (vely>  7 && vely<=  9) return 2;
            if (vely>  9 && vely<= 11) return 3;
            if (vely> 11 && vely<= 15) return 4;
            if (vely> 15 && vely<= 17) return 5;
            if (vely> 17 && vely<= 20) return 6;
            if (vely> 20 && vely<= 23) return 7;
            if (vely> 23 && vely<= 24) return 8;
            if (vely> 24 && vely<= 25) return 9;
            if (vely==0) {
                return 10;
            }
        }else if (vely >= 0) {
            return 1;
        } return 0;
    }
    
    public BufferedImage sprite() {
        if (IDLE) {
            return Idle.grabImage(idle(),0, 34, 70);
        }
        if (vely != 0 || KeyInput.jump) {
            return Jump.grabImage(jumpSprite(true),jumpSprite(false),40,74);
        }else return Idles;
    }

    public void tick(){
        if (velx == 0 && vely == 0 && KeyInput.jump==false) {
            IDLE=true;
        }else IDLE=false;
        idleTime++;
        if (idleTime> 30) idleTime=0;

        x += velx;
        
        jump();
        
        x = Game.clamp(x,-16,ReSizer.getX(363));
        y = Game.clamp(y,0,Game.HEIGHT-ReSizer.getY(70));
        collision();
    }
    
    private void jump() {
        if (vely == 0 && jumpFrame== 0 && KeyInput.jump) vely=-25;
        jumpFrame++;
        y+=vely;
        if (vely<25)vely++;
        if (vely > 15) {
            KeyInput.jump=false; 
            jumpFrame=0;
        }
    }
    
    private void collision() {
        for (int i=0; i< handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Floor) {
                if (getBounds().intersects(tempObject.getBounds())){
                    vely=0;
                    jumpFrame=0;
                }
            }
        }
    }
    
    public void render(Graphics g){
        g.drawImage(sprite(),x,y,ReSizer.getX(34),ReSizer.getY(70),null);
    }   
}