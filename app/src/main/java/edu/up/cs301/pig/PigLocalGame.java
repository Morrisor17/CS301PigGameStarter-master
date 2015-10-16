package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigLocalGame extends LocalGame {
    PigGameState gameState;

    /**
     * This ctor creates a new game state
     */


    public PigLocalGame(PigGameState gameState) {
        this.gameState=gameState;

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    public boolean canMove(int playerIdx) {
        return playerIdx == gameState.getCurrentPlayer();
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    public boolean makeMove(GameAction action) {
        if(!canMove(getPlayerIdx(action.getPlayer())))
        {
            return false;
        }
        if(action instanceof PigHoldAction)
        {
            gameState.hold();
        }
        else
        {
            gameState.roll();
        }
        return true;
    }

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copy = new PigGameState(gameState);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    public String checkIfGameOver() {
        String temp = null;
        if(gameState.getPlayer1Score() >= 50)
        {
            temp = "Player 1 WINS!";
        }
        else if(gameState.getPlayer2Score() >= 50)
        {
            temp = "Player 2 WINS!";
        }
        return temp;
    }

}// class PigLocalGame
