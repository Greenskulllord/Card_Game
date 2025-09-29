public class Card {
    String suit;
    String name;

    Card(String suit, String name){
        this.suit = suit;
        this.name = name;
    }

    @Override
    public String toString(){
        return name + " of " + suit;
    }

}
