package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by morrisor17 on 10/15/2015.
 */
public class PigGameState extends GameState {

    int currentPlayer;
    int player1Score;
    int player2Score;
    int currentTotal;
    int currentRoll;

    public PigGameState(){
        currentPlayer=0;
        player1Score=0;
        player2Score=0;
        currentTotal=0;
        currentRoll=1;
    }

    public PigGameState(PigGameState copy){
        this.currentPlayer=copy.getCurrentPlayer();
        this.player1Score=copy.getPlayer1Score();
        this.player2Score=copy.getPlayer2Score();
        this.currentTotal=copy.getCurrentTotal();
        this.currentRoll=copy.getCurrentRoll();
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public int getPlayer1Score(){
        return player1Score;
    }

    public int getPlayer2Score(){
        return player2Score;
    }

    public int getCurrentTotal(){
        return currentTotal;
    }

    public int getCurrentRoll(){
        return currentRoll;
    }

    public void hold(){
        if(currentPlayer==0){
            player1Score+=currentTotal;
            currentTotal=0;
            currentPlayer=1;
        }
        else{
            player2Score+=currentTotal;
            currentTotal=0;
            currentPlayer=0;
        }
    }

    public void roll(){
        Random rand = new Random();
        currentRoll = rand.nextInt(6)+1;
        if(currentRoll==1){
            currentTotal=0;
            if(currentPlayer==0){
                currentPlayer=1;
            }
            else{
                currentPlayer=0;
            }
        }else currentTotal+=currentRoll;
    }
}
