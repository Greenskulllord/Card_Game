public class Card {
    //This class creates card objects

    //declare variables
    String suit;
    String name;
    int cardValue;

    //assigns each card object a suit and a name
    Card(String suit, String name){
        this.suit = suit;
        this.name = name;
        this.cardValue = setCardValue(name);
    }

    //method to allow other classes to access the value
    public int getCardValue() {
        return this.cardValue;
    }

    //assigns each name to a value
    private int setCardValue(String name) {
        //gives every single card a set value, Aces are more complicated
        switch (name) {
            case "A":
                cardValue = 11;
                break;
            case "J", "Q", "K", "10":
                cardValue = 10;
                break;
            case "2":
                cardValue = 2;
                break;
            case "3":
                cardValue = 3;
                break;
            case "4":
                cardValue = 4;
                break;
            case "5":
                cardValue = 5;
                break;
            case "6":
                cardValue = 6;
                break;
            case "7":
                cardValue = 7;
                break;
            case "8":
                cardValue = 8;
                break;
            case "9":
                cardValue = 9;
                break;
        }
        return cardValue;
    }

    @Override
    public String toString(){
        return name + " of " + suit;
    }

}