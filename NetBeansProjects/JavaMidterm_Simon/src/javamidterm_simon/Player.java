package javamidterm_simon;

public class Player {
    
    public static int x;
    public static int y;
    public static int health;
    public static String name;
    
    public Player(int a, int b, int c) {
        
        x = a;
        y = b;
        health = c;
        
    }
    
    public Player(String nam) {
        
        name = nam;
        
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    
}
