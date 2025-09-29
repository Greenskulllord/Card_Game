import java.util.ArrayList;
import java.util.Collections;

class Deck {
    static String[] suitname = {"spades", "hearts", "diamonds", "clubs"};
    static String[] cardname = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    Deck() {
        boolean loop = true;
        int cardIndex = 0;

        //card creation
        ArrayList<Card> deck = getCards();
        //shuffles the array list "desk"
        Collections.shuffle(deck);

        //this is a error block started
        try {
            while (loop) {

                System.out.println(deck.get(cardIndex));
                //every time a card is drawn/printed out, it adds one to the index so it goes through the whole deck in the Array
                cardIndex++;

            }
        } catch (IndexOutOfBoundsException e) {
            //when out of all 51 cards, tells user/system there is no more cards
            System.out.println("no more cards.");
        }

        //stops printing cards when there are no more cards left to print
        if (cardIndex == 51) {
            loop = false;
        }

    }

    //block of code that creates the deck itself, not needing changes
    private static ArrayList<Card> getCards() {
        ArrayList<Card> deck = new ArrayList<>();

        //adds a suit class first for the first set of cards in one class
        for (String suit : suitname) {
            //once it gets a suit, the first suit will be spades, then it will get a card and add the suit class to that card
            for (String name : cardname) {
                //adds the suit class and card name together
                Card card = new Card(suit, name);
                //adds card to the array list called "deck"
                deck.add(card);
            }
        }
        return deck;
    }
}


