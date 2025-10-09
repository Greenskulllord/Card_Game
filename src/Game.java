import java.util.ArrayList;

public class Game extends GameWindow{

    /*TODO
        #-----------stuff to do within the terminal for now -------------
        * create a game function to draw a single card(DONE)
        * create a main menu for the game(NOT STARTED)
        * create a dealer so the player starts with one card(STARTED)
        * create a opponent that also draws cards(NOT STARTED)
        * create a win/lose condition(NOT STARTED)
        #-------------stuff to do within the actual game window like display cards and stats------------
        *


     */

    public static void main(String[] args) {
        //variables that keep track of all game data
        Boolean playerTurn = false;
        Boolean opponentTurn = false;
        Boolean gameEnd = false;


        //events for the game to know what to do
        enum EVENTS {
            GAME_START,
            GAME_END,
            PLAYER_TURN,
            DEALER_TURN;
        }

        EVENTS currentEvent = EVENTS.GAME_START;

        switch (currentEvent) {
            case GAME_START:
                new GameWindow();
                new Dealer();

                //declare the players starter card when the game starts
                Deck deck = new Deck();
                ArrayList<Card> starterCard = deck.getDeck();

                //declare the opponents card


                break;

            case PLAYER_TURN:
                    boolean actionEnded = false;

                    enum PLAYER_ACTIONS {
                        IDLE,
                        DRAW,
                        STAND;
                    }
                   //idle is the action it will be on at the start of players turn
                    PLAYER_ACTIONS currentAction = PLAYER_ACTIONS.IDLE;



                break;

            case DEALER_TURN:
                int hi = 1;


                break;

            case GAME_END:

                break;
        }


    }
}