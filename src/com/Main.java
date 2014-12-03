package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame{

    private Container content;
    private static String homeTeamName = "Select a Player";
    private static String awayTeamName = "Select a Player";

    /**
     * Main Constructor
     */
    public Main (){
        setTitle(Constants.TITLE);
        setSize((int) (Constants.WIDTH * 1.02) , Constants.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(new TeamPanel(homeTeamName, awayTeamName), BorderLayout.PAGE_START);
        content.add(new OffensivePanel(), BorderLayout.LINE_START);
        content.add(new DefensivePanel(), BorderLayout.LINE_END);
        content.add(new BoxScore(), BorderLayout.PAGE_END);

        setVisible(true);
    }

    /**
     * This method drives the creation of the initial GUI as well as selecting the teams
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Player> homePlayers = new ArrayList<Player>();
        ArrayList<Player> awayPlayers = new ArrayList<Player>();

        String[] choices = Utility.getTeamInfo();
        homeTeamName = (String) JOptionPane.showInputDialog(
                null,
                "Team Selection",
                "Please Select the Home Team",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                choices[0]);

        awayTeamName = (String) JOptionPane.showInputDialog(
                null,
                "Team Selection",
                "Please Select the Away Team",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                choices[0]);

        List<String> homeInfo = Utility.getTeamPlayerInfo(homeTeamName);
        for (String playerInfo : homeInfo){
            String[] playerDetails = playerInfo.split(",");
            homePlayers.add(new Player(playerDetails[0],playerDetails[1], Integer.parseInt(playerDetails[2]), "home"));
        }

        List<String> awayInfo = Utility.getTeamPlayerInfo(awayTeamName);
        for (String playerInfo : awayInfo){
            String[] playerDetails = playerInfo.split(",");
            awayPlayers.add(new Player(playerDetails[0],playerDetails[1], Integer.parseInt(playerDetails[2]), "away"));
        }

        Engine engine = new Engine(homePlayers,awayPlayers);
        Utility.saveEngine(engine);
        Main gui = new Main();
    }
}
