package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by morrisor17 on 10/15/2015.
 */
public class PigAdvComputerPlayer extends GameComputerPlayer{

    public PigAdvComputerPlayer(String name){
        super(name);
    }

    protected void receiveInfo(GameInfo info){
        PigGameState temp;
        if(info instanceof PigGameState) {
            temp = (PigGameState) info;

                if ((temp.getPlayer1Score() - temp.getPlayer2Score() + temp.getCurrentTotal()) >= 20) {
                    game.sendAction(new PigRollAction(this));

                } else if (temp.getCurrentTotal() >= 11) {
                    game.sendAction(new PigHoldAction(this));

                } else if ((temp.getPlayer2Score() + temp.getCurrentTotal()) <= temp.getPlayer1Score()) {
                    game.sendAction(new PigRollAction(this));

                } else if ((temp.getPlayer2Score() + temp.getCurrentTotal()) > temp.getPlayer1Score()) {
                    game.sendAction(new PigHoldAction(this));
                }

        }
    }
}
