import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventListener;

class Draw {

    Draw() {
        int cardIndex = 0;

        Deck deck = new Deck();
        ArrayList<Card> cardlist = deck.getDeck();

        //this is a error block starter
        try {
            System.out.println(cardlist.get(cardIndex));
            //every time a card is drawn/printed out, it adds one to the index so it goes through the whole deck in the Array
            cardIndex++;

        } catch (IndexOutOfBoundsException e) {
            //when out of all 51 cards, tells user/system there is no more cards
            System.out.println("no more cards.");
        }

    }

}


