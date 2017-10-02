package javasolitaire_simon;

    public class Card {
        String suits;
        String ranks;
        int values;
    
    public Card(String xsuits, String xranks, int xvalues) {
        suits = xsuits;
        ranks = xranks;
        values = xvalues;
    }
    public String suits() {
        return suits;
    }
    public String ranks() {
       return ranks; 
    }
    public int values() {
        return values;
    }
    public boolean checkEquals(Card newCard) {
        return this.values == newCard.values && this.ranks.equals(newCard.ranks) && this.suits.equals(newCard.suits);
    }
    public String declare() {
        return suits + " " + ranks + " Point Value: " + values;
    }
    
}