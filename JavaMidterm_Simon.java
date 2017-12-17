package javamidterm_simon;

import java.util.Random;
import java.util.Scanner;

public class JavaMidterm_Simon {
    
    public static Random r = new Random();
    public static int a = r.nextInt(18) + 1;
    public static int b = r.nextInt(18) + 1;
    
    public static Player player = new Player(5, 5, 3);
    public static Enemy enemy = new Enemy(5,5);
    public static Trap trap = new Trap(r.nextInt(18) + 1 ,r.nextInt(18) + 1);
    
    public static Scanner sc = new Scanner(System.in);
    public static Map map = new Map(5, 5);
    public static int scan;
    public static String sca;

    public static void main(String[] args) {
        System.out.println("Welcome to Simon's game of mystery, there will be\n"
                + "several games to choose from, including:\n"
                + "\n[1]: Maze\n"
                + "[2]: Blackjack [Not Ready]\n");
        System.out.println("Please enter the corresponding number to start a game.");
        scanstart();
    }

    public static void scanstart() {
        scan = sc.nextInt();
        switch (scan) {
            case 1:
                maze();
                break;
            case 2:
                blackjack();
                break;
            default:
                System.out.println("Please try entering a number again!");
                scanstart();
                break;
        }
    }

    public static void maze() {
        int played;
        System.out.println("\nHave you played maze before? Skip instructions?"
                + "\n[1]: Yes"
                + "\n[2]: No");
        played = sc.nextInt();
        switch (played) {
            case 1:
                start();
                break;
            default:
                break;
        }
        System.out.println("\nWelcome to maze, my name is philip, your instructor.\n"
                + "there is a deep backstory for how you got here, and\n"
                + "I will be more than happy to tell you about that!\n");
        System.out.println("You see, you are an interesting character. For you\n"
                + "to make it here was not easy, yet it wasn't nearly as\n"
                + "difficult as it was for many others. If I'm going to\n"
                + "be 100% honest, you're very lucky, because winning\n"
                + "this game could be the start of a complete life,\n"
                + "something many others wish for!\n");
        System.out.println("Now the one thing I don't know is your name, and\n"
                + "I'm sure that you don't remember it either, so give\n"
                + "a good one!\n");
        sc.nextLine();
        player.name = sc.nextLine();
        System.out.println("\nNice to meet you, " + player.getName() + ", now let\n"
                + "me tell you where you are from.");
    }

    public static void start() {
        System.out.println("\nOkay, give me a x and y value to start from!");
        System.out.print("[X]: ");
        player.x = sc.nextInt();
        System.out.print("[Y]: ");
        player.y = sc.nextInt();
        System.out.println("Are you sure you want to start at " + player.getX() + "," + player.getY() + "?");
        sc.nextLine();
        sca = sc.nextLine();
        if (sca.contains("y")) {
            System.out.println("\nOkay, Here we go!");         
            enemy.x = a;
            enemy.y = b;
            map();
        }
    }

    public static void map() {
        char[][] map = new char[20][20];

        System.out.println("Health: " + player.health);
        
        map[trap.y][trap.x] = '*';
        map[player.y][player.x] = 'x';
        map[enemy.y][enemy.x] = 'e';

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
                    } else if (map[i][j] != 'x' && map[i][j] != 'e') { //map[i][j] != 'x'
                        System.out.print(" • ");
                    } else {
                        System.out.print(" " + map[i][j] + " ");
                    }
                } else if (i == 0) {
                    System.out.println("");
                } else if (i == 19) {
                    System.out.println("");
                } else if (j == 0) {
                    System.out.println("▐");
                } else if (j == 19) {
                    System.out.println("▐");
                } else if (map[i][j] != 'x' && map[i][j] != 'e') { //map[i][j] != 'x'
                    System.out.println(" • ");
                } else {
                    System.out.println(" " + map[i][j] + " ");
                }
            }
        }
        move();
        enemy();
    }

    public static void move() {
        String wasd;
        System.out.println("Type W,A,S,D to move. Ask for coordinates by typing \"coords\"!");
        wasd = sc.nextLine();
        wasd.toLowerCase();
        switch (wasd) {
            case "w":
                player.y -= 1;
                break;
            case "a":
                player.x -= 1;
                break;
            case "s":
                player.y += 1;
                break;
            case "d":
                player.x += 1;
                break;
            case "coords":
                System.out.println("You are currently at: " + player.getX() + "," + player.getY());
                System.out.println("The enemy is currently at: " + enemy.getX() + "," + enemy.getY());
                move();
                break;
            default:
                move();
                break;
        }
        if (player.x < 1) {
            player.x += 1;
        } else if (player.x > 18) {
            player.x -= 1;
        } else if (player.y < 1) {
            player.y += 1;
        } else if (player.y > 18) {
            player.y -= 1;
        }
    }
    
    public static void enemy() {
             //1
        if(player.x <= 9 && enemy.x >= 9) {
            enemy.x -= 1;
            //2
        } else if(player.x >= 9 && enemy.x <= 9) {
            enemy.x += 1;
            //3
        } else if(player.x <= 9 && enemy.x <= 9 && player.y >= 9 && enemy.y <= 9) {
            enemy.y += 1;
            //4
        } else if(player.x <= 9 && enemy.x <= 9 && player.y <= 9 && enemy.y >= 9) {
            enemy.y -= 1;
            //5
        } else if(player.x >= 9 && player.y >= 9 && enemy.x >= 9 && enemy.y <= 9) {
            enemy.y += 1;
            //6
        } else if(player.x >= 9 && player.y <= 9 && enemy.x >= 9 && enemy.y >= 9) {
            enemy.y -= 1;
            //7
        } else if(player.x >= 9 && player.y >= 9 && enemy.x >= 9 && enemy.y >= 9) {
            if(player.x > enemy.x) {
                enemy.x += 1;
            } else if (player.x == enemy.x && enemy.y < player.y) {
                enemy.y += 1;
            } else if (player.x == enemy.x && enemy.y > player.y) {
                enemy.y -= 1;
            } else {
                enemy.x -= 1;
            }
            //8
        } else if(player.x >= 9 && player.y <= 9 && enemy.x >= 9 && enemy.y <= 9) {
            if(player.x > enemy.x) {
                enemy.x += 1;
            } else if (player.x == enemy.x && enemy.y < player.y) {
                enemy.y += 1;
            } else if (player.x == enemy.x && enemy.y > player.y) {
                enemy.y -= 1;
            } else {
                enemy.x -= 1;
            }
            //9
        } else if(player.x <= 9 && player.y <= 9 && enemy.x <=9 && enemy.y <= 9) {
            if(player.x > enemy.x) {
                enemy.x += 1;
            } else if (player.x == enemy.x && enemy.y < player.y) {
                enemy.y += 1;
            } else if (player.x == enemy.x && enemy.y > player.y) {
                enemy.y -= 1;
            } else {
                enemy.x -= 1;
            }
            //10
        } else if(player.x <= 9 && player.y >=9 && enemy.x <= 9 && enemy.y >= 9) {
            if(player.x > enemy.x) {
                enemy.x += 1;
            } else if (player.x == enemy.x && enemy.y < player.y) {
                enemy.y += 1;
            } else if (player.x == enemy.x && enemy.y > player.y) {
                enemy.y -= 1;
            } else {
                enemy.x -= 1;
            }
        }
        int choice;
        if(player.x == enemy.x && player.y == enemy.y) {
            System.out.println("You have intersected with an enemy!"
                             + "\n[1]: Solve a math problem."
                             + "\n[2]: Lose a life!");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    math();
                    break;
                case 2:
                    player.health--;
                    if(player.health < 1) {
                    end();
                }
                    break;
                default:
                    break;
            }
        }
        map();
    }

    public static void math() {
        double a = r.nextInt(1000) + 1;
        double b = r.nextInt(1000) + 1;
        double c = r.nextInt(1000) + 1;
        double d = r.nextInt(1000) + 1;
        double e = r.nextInt(1000) + 1;
        double f = r.nextInt(1000) + 1;
        double g = r.nextInt(1000) + 1;
        double h = r.nextInt(1000) + 1;


        double p1 = a%b;
        double p2 = d*((e/f)*g);
        double p3 = h + p2;
        double p4 = p3 - p1;
        double p5 = p4/c;
        int ans;
        
        System.out.println("\nYou have chosen a math problem! It will not be easy!");
        System.out.println("Solve: (" + a + "/" + b + "+" + c + "x" + "-" + d + "(" + e + "/" + f + "*" + g + ")" + "=" + " " + h);
        System.out.print("Round to the nearest whole number and enter it: ");
        ans = sc.nextInt();
        if(ans == Math.round(p5)) {
            System.out.println("Correct! You keep a life!");
        } else {
            System.out.println("Incorrect, you lose one life!");
            player.health--;
            if(player.health < 1) {
                end();
            }
        }
        
    }
    
    public static void end() {
        System.out.println("Game over!");
    }
    
    public static void blackjack() {

    }

}
