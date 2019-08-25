package Code;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MousePos extends MouseAdapter{
    
    private static boolean rClick;
    private static boolean lClick;
    private static boolean rClickRel;
    private static boolean lClickRel;
    private static int x;
    private static int y;
    private JFrame frame;
    
    public MousePos(JFrame frame) {
        this.frame=frame;
    }
    
    public static int GetXPos() {
        return x;
    }
    
    public static int GetYPos() {
        return y;
    }

    public static boolean GetHover(int X,int Y,int width,int height) {
        return isMouse(X,Y,width,height);
    }

    public static boolean GetClick(int X,int Y,int width,int height) {
        return (isMouse(X,Y,width,height));
    }
    
    public static boolean GetRel(int X,int Y,int width,int height) {
        if (isMouse(X,Y,width,height) && lClickRel) {
            return true;
        }else return false;
    }
    
    /*
     *isMouse recibe los datos de posicion del puntero y las de una zona y devuelve un 
     *boolean de acuerdo si esta o no el puntero ene sa posicion
    **/
    
    private static boolean isMouse(int X, int Y, int width, int height){
        if(x > X && x < X+ width){
            if (y > Y && y < Y + height) {
                return true;
            }else return false;
        }else return false;
    }
    
    public void mousePressed(MouseEvent e){
        this.x = e.getX();
        this.y = e.getY(); 
        if (e.getButton()==1) {
            lClick=true;
            lClickRel=false;
        }else lClick=false;
        if (e.getButton()==3) {
            rClick=true;
            rClickRel=false;
        }else rClick=false;
    }
    
    public void mouseReleased(MouseEvent e){
        this.x = e.getX();
        this.y = e.getY(); 
        if (e.getButton()==1) {
            lClickRel=true;
            lClick=false;
        }else lClickRel=false;
        if (e.getButton()==0) {
            rClickRel=true;
            rClick=false;
        }else rClickRel=false;
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("lClickRel: " +lClickRel + "x: "+x +" y: "+y );
        Point p = MouseInfo.getPointerInfo().getLocation();
        p = new Point(p.x - frame.getLocation().x, p.y - frame.getLocation().y);
        this.x=p.x;
        this.y=p.y;
    }
    
}