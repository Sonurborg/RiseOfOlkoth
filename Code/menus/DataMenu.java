package Code.menus;

import Code.Game;
import Code.displayMangr.ReSizer;
import Code.menus.functions.ButtonFunc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DataMenu {
    
    private static Graphics g;
    
    public static void saveR() {
        g.drawImage(Menu.menuOverlay, 0,0,ReSizer.getX(397),ReSizer.getY(224), null);
        if (Menu.save) {
            saveMenuR();
        }else loadMenuR();
    }
    
    private static void loadMenuR() {
        g.setColor(new Color(156,48,15));
        g.setFont(new Font("OwreKynge",1,Game.HEIGHT/19));
        
        /*g.drawString("Saved Files" , 75, 250);
        g.drawString("Load File", 50, 280);
        g.drawString("Erase File", 75, 310);
        g.drawString("Create new File", 50, 340);
        g.drawString("If you wish to load a save file at any time you can acces the saved files", 75, 370);
        g.drawString("from the Options Menu on the Pouse screen", 50, 400);*/
        
        for (int i=0;i<4;i++){
            showSave(i);
        }
        
        //load
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(14),8,19,19),ReSizer.getX(80),ReSizer.getY(45),ReSizer.getX(19),ReSizer.getY(19),null);
        //erase
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(15),10,19,19),ReSizer.getX(80),ReSizer.getY(94),ReSizer.getX(19),ReSizer.getY(19),null);
        //copy
        g.drawImage(Menu.smallButtons.grabImage(Menu.click(16),11,19,19),ReSizer.getX(80),ReSizer.getY(143),ReSizer.getX(19),ReSizer.getY(19),null);
        
        //start
        g.drawImage(Menu.Buttons.grabImage(Menu.click(0),0,92,40),ReSizer.getX(237),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40),null);
        //back
        g.drawImage(Menu.Buttons.grabImage(Menu.click(3),5,92,40),ReSizer.getX(69),ReSizer.getY(179),ReSizer.getX(92),ReSizer.getY(40),null);
   
    }
    
    private static void showSave(int save){
        //g.setColor(/*Hover/Click*/);
        g.setFont(new Font("Arial",0/*style*/,ReSizer.getY(9)/*size*/));
        g.setColor(selectedSave(save));
        g.fillRect(ReSizer.getX(115),ReSizer.getY(10)*(3+save),ReSizer.getX(200),ReSizer.getY(10));
        g.setColor(Color.gray.brighter());
        g.drawRect(ReSizer.getX(115),ReSizer.getY(10)*(3+save),ReSizer.getX(200),ReSizer.getY(10));
        g.setColor(Color.WHITE);
        try {
            g.drawString(ButtonFunc.saves[save].getDataString(), ReSizer.getX(120), (ReSizer.getY(10)*(4+save))-ReSizer.getY(2));
        }catch (Exception ex) {
            g.drawString("New Game", ReSizer.getX(120), (ReSizer.getY(10)*(4+save))-ReSizer.getY(2));
        }
    }
    
    private static Color selectedSave(int check){
        if (check == ButtonFunc.selected) {
            return Color.BLACK;
        }else return Color.gray.darker();
    }
    
    private static void saveMenuR() {
        
    }
}
