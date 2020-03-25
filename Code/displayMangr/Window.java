package Code.displayMangr;
import Code.Game;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window extends Canvas{

    public static ReSizer ReSizer;
    private static JFrame frame;
    private static final long serialVersionUID = 318126280877336490L;

    public Window(String title, Game game) {
        this.frame = new JFrame(title);
        
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        Game.WIDTH=frame.getWidth();
        Game.HEIGHT=frame.getHeight();
        frame.setUndecorated(true);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        
        frame.setMaximumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
        
        game.start();
        ReSizer.setSize(frame.getWidth(),frame.getHeight());
    }
    
    public static JFrame GetFrame() {
        return frame;
    }
    
    public static void fullscreen() {
        frame.setVisible(false);
        frame.dispose();     
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        Game.WIDTH=frame.getWidth();
        Game.HEIGHT=frame.getHeight();
        frame.setLocationRelativeTo(frame);
        frame.setUndecorated(true);
        frame.setVisible(true);
        ReSizer.setSize(frame.getWidth(),frame.getHeight());
    }
    
    public static void windowed() {
        frame.setVisible(false);
        frame.dispose();  
        frame.setUndecorated(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1191,672+(frame.getInsets().top)); 
        Game.WIDTH=frame.getWidth();
        Game.HEIGHT=frame.getHeight();
        ReSizer.setSize(1191,672);
    }
}