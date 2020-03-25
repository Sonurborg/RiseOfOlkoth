package Code.game;
import Code.Game;
import Code.audioMangr.SFX;
import Code.inputMangr.MousePos;
import Code.imageLoader.SpriteSheet;
import Code.imageLoader.BufferedImageLoader;
import Code.displayMangr.ReSizer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class HUD {
    MousePos Mouse;
    public static int HEALTH = 5;
    BufferedImageLoader loader = new BufferedImageLoader();
    private BufferedImage SmallButtons;
    SpriteSheet smallButtons;
    private static boolean Hover[]= new boolean[2];
    private static boolean Press[]= new boolean[2];
    private static int click[]= new int[2];
    
    public void setMouse(MousePos mouse){
        SmallButtons=loader.loadImage("/Res/Sprites/smallButtons.png");
        smallButtons = new SpriteSheet(SmallButtons,3,14);
        this.Mouse=mouse;
    }
    
    public void tick(){
        buttons();
    }
    
    private void buttons(){
        try{
        pauseButton();
        mapButton();
        }catch (Exception ex){
        }
        buttonClick();
    }
    
    private void pauseButton() throws Exception{
        Hover[0]=Mouse.getHover(ReSizer.getX(373),ReSizer.getY(5),ReSizer.getX(19),ReSizer.getY(19));
        Press[0]=Mouse.getClick(ReSizer.getX(373),ReSizer.getY(5),ReSizer.getX(19),ReSizer.getY(19));
        if (Mouse.getRel(ReSizer.getX(373),ReSizer.getY(5),ReSizer.getX(19),ReSizer.getY(19))) {
            Press[0]=false;
            SFX.pause();
            Game.pause=true;
        }
    }
    
    private void mapButton() throws Exception{
        Hover[1]=Mouse.getHover(ReSizer.getX(373),ReSizer.getY(29),ReSizer.getX(19),ReSizer.getY(19));
        Press[1]=Mouse.getClick(ReSizer.getX(373),ReSizer.getY(29),ReSizer.getX(19),ReSizer.getY(19));
        if (Mouse.getRel(ReSizer.getX(373),ReSizer.getY(29),ReSizer.getX(19),ReSizer.getY(19))) {
            Press[1]=false;
            Game.map=true;
        }
    }
    
    private void buttonClick(){
        if (Press[0]) {
            click[0]=2;
        } else if (Hover[0]) {
            click[0]=1;
        }else click[0]=0;
        
        if (Press[1]) {
            click[1]=2;
        } else if (Hover[1]) {
            click[1]=1;
        }else click[1]=0;
    }
    
    public void render(Graphics g){
        lifeBarR(g);
        buttonR(g);
    }
    
    private void lifeBarR(Graphics g){
        g.setColor(Color.white);
        g.fillRect(15,15,202,7);
        g.setColor(Color.RED);
        g.fillRect(16,16,(int)(HEALTH/5.12f),5);
    }
    
    private void buttonR(Graphics g){
        g.drawImage(smallButtons.grabImage(click[0],12,19,19),ReSizer.getX(373),ReSizer.getY(5),ReSizer.getX(19),ReSizer.getY(19),null);
        g.drawImage(smallButtons.grabImage(click[1],7,19,19),ReSizer.getX(373),ReSizer.getY(29),ReSizer.getX(19),ReSizer.getY(19),null);
    }
}