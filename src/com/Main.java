package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{

    private Container content;

    public Main (){
        //Necessary initialization code
        setTitle(Constants.TITLE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        content = getContentPane();
        content.setLayout(new BorderLayout());

        content.add(new TeamPanel(getHomePlayers(), getAwayPlayers()), BorderLayout.PAGE_START);
        content.add(new OffensivePanel(), BorderLayout.LINE_START);
        content.add(new DefensivePanel(), BorderLayout.LINE_END);

        setVisible(true);
    }

    private ArrayList<Player> getHomePlayers(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Daniel", "Newell", 12, "Home Team"));
        players.add(new Player("Vince", "Newell", 11, "Home Team"));
        players.add(new Player("Kevin", "Newell", 43, "Home Team"));
        players.add(new Player("Gina", "Newell", 5, "Home Team"));
        return players;
    }

    private ArrayList<Player> getAwayPlayers(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Jessie", "Smith", 12, "Away Team"));
        players.add(new Player("Kelsey", "Smith", 11, "Away Team"));
        players.add(new Player("Steve", "Smith", 5, "Away Team"));
        return players;
    }

    public static void main(String[] args) {
        Main gui = new Main();
    }
}
