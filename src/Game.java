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
        * class to hold all images(NOT STARTED)
        * Display cards as a visual display(NOT STARTED)
     */

    public static void main(String[] args) {
        Boolean gameEnd = false;
        Utils utils = new Utils();
        while (!gameEnd) {
            //variables that keep track of all game data
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
            while (!EVENTS.GAME_END.equals(currentEvent)) {
                switch (currentEvent) {
                    case GAME_START:
                        //new GameWindow();
                        //for playing in the console
                        //im doing this so i have can split the project of learning Jpanels
                        //   and also having something done for midterm
                        //this is because, j panels are hella complicated to learn
                        //   and i wouldn't have time to implement it anyway

                        System.out.println("press Enter to Start");
                        scanner.nextLine();
                        //declare players card
                        Card playerCard = deck.Draw();
                        System.out.println("Your card: " + playerCard);
                        Card playerHoleCard = deck.Draw();
                        System.out.println("Your second card: " + playerHoleCard);
                        //adds your starter cards to your hand
                        playerHandValue = playerCard.getCardValue() + playerHoleCard.getCardValue();
                        currentEvent = EVENTS.PLAYER_TURN;

                        //check if player auto wins
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
                        //idle is a state where it waits for player input
                        PLAYER_ACTIONS currentAction = PLAYER_ACTIONS.IDLE;

                        //thrown into a while loop so it keeps going with the players turn until they end it themselves
                        while (!endturn) {
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
                                    //if player gets blackjack during drawing sequence, they will immediately win
                                    if (playerHandValue == 21) {
                                        System.out.println("Blackjack! You win!");
                                        currentEvent = EVENTS.GAME_END;
                                    }
                                    break;
                            }
                        }
                        break;
                    //when its dealer's turn, it runs the dealer AI class
                    case DEALER_TURN:
                        System.out.println("--------Dealer's turn----------");

                        //gives the dealer the information of the current board
                        dealer.DealerTurn(deck, playerHandValue);
                        //if dealer has a 21, insta-win
                        if (dealer.dealerHandValue == 21) {
                            System.out.println("Dealer has Blackjack! You lose.");
                        }
                        //once dealer's turn is over, end game and calculate everything to decide who wins
                        currentEvent = EVENTS.GAME_END;
                        break;
                }
            }

            //what to do at game end
            if (currentEvent.equals(EVENTS.GAME_END)) {
                //ends game after win/lose condition is met
                //add delay for readability
                utils.Wait(1000);

                if (dealer.dealerHandValue > 21) {
                    System.out.println("the dealer busts");
                    utils.Wait(1000);
                    System.out.println("the player wins.");
                } else if (dealer.dealerHandValue >= playerHandValue) {
                    System.out.println("the dealer wins");
                    utils.Wait(1000);
                    System.out.println("the player loses.");
                } else if (dealer.dealerHandValue < playerHandValue){
                    System.out.println("the player wins.");
                }

                //this adds replayability and delays because I like them
                System.out.println("Play Again?");
                String playAgain = scanner.nextLine();
                if (playAgain.equalsIgnoreCase(utils.StringYesInputs())) {
                    System.out.println("Resetting game");
                    utils.Wait(1000);
                    gameEnd = false;
                } else if (playAgain.equalsIgnoreCase(utils.StringNoInputs())) {
                    System.out.println("---------thanks for playing---------");
                    gameEnd = true;
                } else {
                    System.out.println("that's close enough to a 'no'...");
                    utils.Wait(1000);
                    System.out.println("---------thanks for playing---------");
                    gameEnd = true;
                }

            }
        }
    }
}