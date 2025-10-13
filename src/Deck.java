import java.util.ArrayList;
import java.util.Collections;

class Deck {
    //this class creates deck objects filled with card objects

    //declare variabless
    static String[] suitname = {"spades", "hearts", "diamonds", "clubs"};
    static String[] cardname = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    ArrayList<Card> deck = new ArrayList<>();
    private int cardIndex;


    Deck() {
        //card creation
        deck = getCards();
        //shuffles the array list "desk"
        Collections.shuffle(deck);
    }
    //turns the list into a function so the deck can be used in different classes
    public ArrayList<Card> getDeck() {
        return deck;
    }

    //block of code that creates the deck itself, not needing changes
    private static ArrayList<Card> getCards() {
        ArrayList<Card> Newdeck = new ArrayList<>();

        //adds a suit class first for the first set of cards in one class
        for (String suit : suitname) {
            //once it gets a suit, the first suit will be spades, then it will get a card and add the suit class to that card
            for (String name : cardname) {
                //adds the suit class and card name together
                Card card = new Card(suit, name);
                //adds card to the array list called "deck"
                Newdeck.add(card);
            }
        }
        return Newdeck;
    }

    public Card Draw() {
        //this is an error block starter
        if (cardIndex >= deck.size()) {
            System.out.println("no more cards.");
            return null;
        }
        Card cardDrawn = this.deck.get(cardIndex);
        cardIndex++;
        return cardDrawn;
    }
}