package javasolitaire_simon;

public class JavaSolitaire_Simon {
    
    public static void main(String[] args) {
       
//        Card ace = new Card("Diamonds", "Ace", 1);
//        Card two = new Card("Spades", "Two", 2);
//        Card three = new Card("Hearts", "Three", 3);
//        
//        System.out.println(ace.declare());
//        System.out.println(two.declare());
//        System.out.println(three.declare());
//        
        String[] ranks = {"A", "1", "2", "3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        int[] values = {11,1,2,3,4,5,6,7,8,9,10,10,10,10};
        Deck d = new Deck(ranks, suits, values);
        System.out.println(d);
        System.out.println(d.deal());
        System.out.println(d.deal());
        System.out.println(d.deal());
        System.out.println(d);
    }
    
}