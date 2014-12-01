package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{

    private Container content;

    public Main (){
        setTitle(Constants.TITLE);
        setSize((int) (Constants.WIDTH * 1.1) , Constants.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(new TeamPanel(), BorderLayout.PAGE_START);
        content.add(new OffensivePanel(), BorderLayout.LINE_START);
        content.add(new DefensivePanel(), BorderLayout.LINE_END);
        content.add(new BoxScore(), BorderLayout.PAGE_END);

        setVisible(true);
    }

    public static void main(String[] args) {
        ArrayList<Player> homePlayers = new ArrayList<Player>();
        ArrayList<Player> awayPlayers = new ArrayList<Player>();
        homePlayers.add(new Player("Daniel", "Newell", 12, "Home"));
        homePlayers.add(new Player("Vince", "Newell", 11, "Home"));
        homePlayers.add(new Player("Kevin", "Newell", 43, "Home"));
        homePlayers.add(new Player("Gina", "Newell", 5, "Home"));


        awayPlayers.add(new Player("Jessie", "Smith", 12, "Away"));
        awayPlayers.add(new Player("Kelsey", "Smith", 11, "Away"));
        awayPlayers.add(new Player("Steve", "Smith", 5, "Away"));
        awayPlayers.add(new Player("tyrone", "Smith", 6, "Away"));

        Engine engine = new Engine(homePlayers,awayPlayers);
        Utility.saveEngine(engine);
        Main gui = new Main();
    }
}
