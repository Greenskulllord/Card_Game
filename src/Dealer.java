import java.util.ArrayList;

public class Dealer {

    int handValue = 0;
    boolean endTurn;

    void DealerAction() {
        boolean turnStatus = false;
        endTurn = turnStatus;
    }
    int hi = 1;

    Dealer() {
        boolean draw;
        boolean stand;
        int cardValue;

        //declare the opponents deck
        Deck dealerDeck = new Deck();
        ArrayList<Card> cardList = dealerDeck.getDeck();

        //keep drawing when under 17
        while(handValue < 17) {
           draw = true;
            if (draw) {
                //randomize what card the opponent pulls
                int randomIndex = (int) (Math.random() * 53);
                Card drawnCard = cardList.get(randomIndex);
                cardValue = drawnCard.getCardValue();
                cardList.remove(randomIndex);

                //this is an error block starter
                try {
                    System.out.println("Dealer's card: " + drawnCard);
                    handValue = handValue + cardValue;

                } catch (IndexOutOfBoundsException e) {
                    //if for some reason there is a bug and there isn't cards, default to a stand action
                    endTurn = true;
                }

                endTurn = true;
            }
            //break loop when endTurn is true
            if (endTurn) {
                break;
            }
        }

        //always stand when opponent is at 16 and above
        while (handValue > 17) {
            stand = true;

            if (stand) {
                //do nothing
                System.out.println("stand");
                endTurn = true;
            }
            //break loop when endTurn is true
            if (endTurn) {
                break;
            }
        }

    }
}


