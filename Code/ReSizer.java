package Code;

public class ReSizer {
    
    private static int width;
    private static int height;
    
    public static int getX(int a) {
        double transformer=width/397f;
        return (int)(a*transformer);
    }
    
    public static int getY(int b) {
        float transformer=height/224f;
        return (int)(b*transformer);
    }
    
    public static void setSize(int WIDTH,int HEIGHT) {
        width=WIDTH;
        height=HEIGHT;
    }
}
