import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventListener;

class Draw {

    Draw() {
        int cardIndex = 0;

        Deck deck = new Deck();
        ArrayList<Card> cardlist = deck.getDeck();
        int hi = 1;
        //this is an error block starter
        try {
            Card drawncard = cardlist.get(cardIndex);
            System.out.println(drawncard);
            System.out.println(drawncard.getCardValue());
            cardIndex++;
        } catch (IndexOutOfBoundsException e) {
            //when out of all 51 cards, tells user/system there is no more cards
            System.out.println("no more cards.");
        }

    }

}


