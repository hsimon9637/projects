package javamidterm_simon;

public class Trap {
    
    public static int x;
    public static int y;
    public static boolean present;
    
    public Trap (int a, int b) {
        
        x = a;
        y = b;
        
    }
    
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public static boolean isPresent() {
        return present;
    }
}


