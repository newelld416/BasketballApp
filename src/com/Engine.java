package com;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/30/2014.
 */
public class Engine {

    private ArrayList<Player> homePlayers;
    private ArrayList<Player> awayPlayers;
    private Player selectedPlayer;

    public Engine (){

    }

    public Engine (ArrayList<Player> homePlayers, ArrayList<Player> awayPlayers){
        this.homePlayers = homePlayers;
        this.awayPlayers = awayPlayers;
    }

    public ArrayList<Player> getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(ArrayList<Player> homePlayers) {
        this.homePlayers = homePlayers;
    }

    public ArrayList<Player> getAwayPlayers() {
        return awayPlayers;
    }

    public void setAwayPlayers(ArrayList<Player> awayPlayers) {
        this.awayPlayers = awayPlayers;
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }
}
