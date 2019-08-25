package Code;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window extends Canvas{

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
        game.start();
    }
    
    public static JFrame GetFrame() {
        return frame;
    }
    
    public static void Fullscreen() {
        frame.setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    
    public static void Windowed() {
        frame.setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
        frame.setMaximumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
        frame.setMinimumSize(new Dimension(397,224));
        frame.setResizable(true);
    }
}