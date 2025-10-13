public class Dealer {

    int dealerHandValue = 0;
    boolean endTurn;
    Utils utils = new Utils();
    Dealer() {
        this.endTurn = false;
    }
    boolean start = true;
    public void DealerTurn(Deck deck, int playerHandValue) {
           //dealer draws cards until they reach 17
           while(dealerHandValue < 17) {
               //add a delay
               utils.Wait(1000);

               //block of code that determines what the first cards the dealer has are. yes I copied and pasted.

               while(start) {
                   Card DealerCard = deck.Draw();
                   System.out.println("Dealer's card: " + DealerCard);
                   utils.Wait(1000);
                   Card DealerHoleCard = deck.Draw();
                   System.out.println("Dealers second card: " + DealerHoleCard);

                   //does a check if their aces and if they would become one.
                   if (DealerHoleCard.getCardValue() == 11 && dealerHandValue > 10) {
                       DealerHoleCard.cardValue = 1;
                   }
                   if (DealerCard.getCardValue() == 11 && dealerHandValue > 10) {
                       DealerCard.cardValue = 1;
                   }
                   dealerHandValue = DealerCard.getCardValue() + DealerHoleCard.getCardValue();
                   utils.Wait(1000);
                   System.out.println("Dealer's hand value is: " + dealerHandValue);
                   // this is so it loops only once
                   start = false;
               }

               //script that draws card and does math
               Card drawnCard = deck.Draw();
               if (drawnCard == null) {
                   System.out.println("Dealer is out of cards");
                   break;
               }
                //ace checker
               int cardValue = drawnCard.getCardValue();
               if (drawnCard.getCardValue() == 11 && dealerHandValue > 10) {
                   drawnCard.cardValue = 1;
               }

               dealerHandValue = dealerHandValue + cardValue;
               System.out.println("Dealer draws: " + drawnCard);
               utils.Wait(1000);
               System.out.println("Dealer hand value is now: " + dealerHandValue);


           }

           // After reaching 17, dealer hits if they are losing to the player
           while(dealerHandValue < playerHandValue && playerHandValue <= 21) {
                //add a delay
               utils.Wait(1000);

                Card drawnCard = deck.Draw();
                if (drawnCard == null) {
                    System.out.println("Dealer is out of cards");
                    break;
                }
                //ace checker
                int cardValue = drawnCard.getCardValue();
               if (drawnCard.getCardValue() == 11 && dealerHandValue > 10) {
                   drawnCard.cardValue = 1;
               }

                dealerHandValue = dealerHandValue + cardValue;
                System.out.println("Dealer draws: " + drawnCard);
               utils.Wait(1000);
                System.out.println("Dealer hand value is now: " + dealerHandValue);


           }

           //dealer will check if their above 17 and if they are winning, if so. stand
           System.out.println("The dealer stands.");
           this.endTurn = true;
    }
}
