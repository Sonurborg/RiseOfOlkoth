package Code;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    public static int type=0;
    public static int map=0;
    public static int Ulti=0;
    LinkedList<GameObject> object= new LinkedList<GameObject>();

    
    public void tick(){
        
        for (int i=0 ; i<object.size() ; i++) {
            //try {
                GameObject tempObject = object.get(i);
                tempObject.tick();
            //} catch (Exception ex) {
            //    System.out.println(ex.toString());}
        }
    }
    
    public void render(Graphics g) {
        for (int i=0 ; i<object.size() ; i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    } 
    public void setMap(int map) {
        this.map = map;
    }
    public int getMap() {
        return map;
    } 
}