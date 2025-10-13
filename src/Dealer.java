public class Dealer {

    int dealerHandValue = 0;
    boolean endTurn;

    Dealer() {
        this.endTurn = false;
    }

    public void DealerTurn(Deck deck, int playerHandValue) {
           //dealer draws cards until they reach 17
           while(dealerHandValue < 17) {
               //add a delay
               try {
                   Thread.sleep(1500);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }

               //script that draws card and does math
               Card drawnCard = deck.Draw();
               if (drawnCard == null) {
                   System.out.println("Dealer is out of cards");
                   break;
               }

               int cardValue = drawnCard.getCardValue();
               dealerHandValue = dealerHandValue + cardValue;
               System.out.println("Dealer draws: " + drawnCard);
               System.out.println("Dealer hand value is now: " + dealerHandValue);
           }

           // After reaching 17, dealer hits if they are losing to the player
           while(dealerHandValue < playerHandValue && playerHandValue <= 21) {
                //add a delay
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                Card drawnCard = deck.Draw();
                if (drawnCard == null) {
                    System.out.println("Dealer is out of cards");
                    break;
                }
                int cardValue = drawnCard.getCardValue();
                dealerHandValue = dealerHandValue + cardValue;
                System.out.println("Dealer draws: " + drawnCard);
                System.out.println("Dealer hand value is now: " + dealerHandValue);
           }

           //dealer will check if their above 17 and if they are winning, if so. stand
           System.out.println("The dealer stands.");
           this.endTurn = true;
    }
}
