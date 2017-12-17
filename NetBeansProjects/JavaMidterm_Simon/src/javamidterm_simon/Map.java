
package javamidterm_simon;

import static java.awt.Color.CYAN;
import static java.awt.Color.WHITE;

public class Map {
    
    public static int x;
    char[][] map = new char[x][x];
    
    public Map(int a, int b) {
        
        x = a;
        
    }
    
    public char Map() {
                for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (j < map[1].length - 1) {
                    if (i == 0) {
                        System.out.print("▬▬▬");
                    } else if (i == 19) {

                        System.out.print("▬▬▬");
                    } else if (j == 0) {
                        System.out.print("▐");
                    } else if (j == 19) {
                        System.out.print("▐");
                    } else if (map[i][j] != 'x') { //map[i][j] != 'x'
                        System.out.print(WHITE + " • ");
                    } else {
                        System.out.print (CYAN + " " + map[i][j] + CYAN + " ");
                    }
                } else if (i == 0) {
                    System.out.println("");
                } else if (i == 19) {
                    System.out.println("");
                } else if (j == 0) {
                    System.out.println("▐");
                } else if (j == 19) {
                    System.out.println("▐");
                } else if (map[i][j] != 'x') { //map[i][j] != 'x'
                    System.out.println(" • ");
                } else {
                    System.out.println(" " + map[i][j] + " ");
                }
            }
}
                return 'x';
    }
    
}
