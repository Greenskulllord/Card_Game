import java.util.Scanner;

public class Game extends GameWindow {

    /*TODO
        #-----------stuff to do within the terminal for now -------------
        * create a game function to draw a single card(DONE)
        * create a main menu for the game(NOT STARTED)
        * create the game within a JPanel(NOT STARTED)
        * create a dealer so the player starts with one card(DONE)
        * create a opponent that also draws cards(DONE)
        * create a win/lose condition(DONE)
        #-------------stuff to do within the actual game window like display cards and stats------------
        *


     */

    public static void main(String[] args) {
        //variables that keep track of all game data
        Boolean gameEnd = false;
        Scanner scanner = new Scanner(System.in);
        int playerHandValue = 0;
        Dealer dealer = new Dealer();
        Deck deck = new Deck();

        //events for the game to know what to do
        enum EVENTS {
            GAME_START,
            GAME_END,
            PLAYER_TURN,
            DEALER_TURN;
        }

        EVENTS currentEvent = EVENTS.GAME_START;
        while(!EVENTS.GAME_END.equals(currentEvent)) {
            switch (currentEvent) {
                case GAME_START:
                    //new GameWindow();
                    //for playing in the console
                    //im doing this so i have can split the project of learning Jpanels and also having something done for midterm
                    //this is because, j panels are hella complicated to learn and i wouldn't have time to implement it anyway

                    System.out.println("press Enter to Start");
                    scanner.nextLine();
                    //declare players card
                    Card playerCard = deck.Draw();
                    System.out.println("Your card: " + playerCard);
                    Card playerHoleCard = deck.Draw();
                    System.out.println("Your second card: " + playerHoleCard);
                    //adds your starter cards to your hand
                    playerHandValue = playerHandValue + playerCard.getCardValue() + playerHoleCard.getCardValue();
                    currentEvent = EVENTS.PLAYER_TURN;

                    //check if player auto wins or dealer auto wins
                    if (playerHandValue == 21) {
                        System.out.println("Blackjack! You win!");
                        currentEvent = EVENTS.GAME_END;
                    }

                    break;

                case PLAYER_TURN:
                    //for playing in the console
                    boolean endturn = false;

                    //create the list of player actions
                    enum PLAYER_ACTIONS {
                        IDLE,
                        DRAW,
                        STAND;
                    }

                    PLAYER_ACTIONS currentAction = PLAYER_ACTIONS.IDLE;

                    while(!endturn) {
                        switch (currentAction) {
                            case DRAW:
                                //draws a player card
                                Card drawnCard = deck.Draw();
                                //turns aces into a one whenever the hand is bigger than 10
                                if (drawnCard.getCardValue() == 11 && playerHandValue > 10) {
                                    drawnCard.cardValue = 1;
                                }
                                //prints out results and does math
                                System.out.println("Your card: " + drawnCard);
                                playerHandValue = playerHandValue + drawnCard.getCardValue();
                                System.out.println("current hand value: " + playerHandValue);
                                currentAction = PLAYER_ACTIONS.IDLE;
                                break;
                            case STAND:
                                //ends turn on stand and nothing else
                                endturn = true;
                                currentEvent = EVENTS.DEALER_TURN;
                                break;
                            case IDLE:
                                System.out.println("Current hand: " + playerHandValue);
                                if (playerHandValue > 21) {
                                    System.out.println("you bust");
                                    System.out.println("Dealer wins");
                                    currentEvent = EVENTS.GAME_END;
                                    endturn = true;
                                    break;
                                }
                                System.out.println("hit or stand?");
                                String action = scanner.nextLine();

                                if (action.equalsIgnoreCase("hit")) {
                                    currentAction = PLAYER_ACTIONS.DRAW;
                                } else if (action.equalsIgnoreCase("stand")) {
                                    currentAction = PLAYER_ACTIONS.STAND;
                                } else {
                                    System.out.println("invalid input, try 'hit' or stand'");
                                }
                                break;
                        }
                    }
                    break;

                case DEALER_TURN:
                    System.out.println("--------Dealer's turn----------");

                    //gives the dealer the information of the current board
                    dealer.DealerTurn(deck, playerHandValue);
                   //if dealer has a 21, insta-win
                    if (dealer.dealerHandValue == 21) {
                        System.out.println("Dealer has Blackjack! You lose.");
                        scanner.close();
                    }

                    currentEvent = EVENTS.GAME_END;
                    break;
            }
        }

        //what to do at game end
        if (currentEvent.equals(EVENTS.GAME_END)) {
            //ends game after win/lose condition is met
            //add delay for readability
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (dealer.dealerHandValue > 21) {
                System.out.println("the dealer busts");
                System.out.println("the player wins.");
            } else if (dealer.dealerHandValue >= playerHandValue) {
                System.out.println("the dealer wins");
                System.out.println("the player loses.");
            } else {
                System.out.println("the player wins.");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("---------thanks for playing---------");
        }
    }
}