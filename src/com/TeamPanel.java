package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Daniel on 11/10/2014.
 */
public class TeamPanel extends JPanel {

    private JPanel homeTeamPanel, awayTeamPanel;
    private ButtonGroup allPlayersButtonGroup = new ButtonGroup();
    private JLabel awayTeamLabel, homeTeamLabel;
    private ArrayList<Player> homeTeamPlayers, awayTeamPlayers;
    private int width, height;

    public TeamPanel(ArrayList<Player> pHomeTeamPlayers, ArrayList<Player> pAwayTeamPlayers){
        homeTeamPlayers = pHomeTeamPlayers;
        awayTeamPlayers = pAwayTeamPlayers;

        width = Constants.WIDTH;
        height = (int) (Constants.HEIGHT * .6);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        createTeamPanel(homeTeamPlayers,BorderLayout.LINE_START, Constants.HOME_TEAM_LABEL);
        createTeamPanel(awayTeamPlayers, BorderLayout.LINE_END, Constants.AWAY_TEAM_LABEL);
    }

    private void createTeamPanel(ArrayList<Player> players, String placement, String teamlabel){
        JPanel panel = new JPanel();
        JLabel team = new JLabel(teamlabel);
        team.setHorizontalAlignment(SwingConstants.CENTER);
        team.setFont(new Font("Verdana", Font.BOLD, 24));
        panel.add(team);
        panel.setPreferredSize(new Dimension(width / 2, height));
        panel.setLayout(new GridLayout(players.size() + 3,1));

        for (Player player : players){
            String buttonLabel = "#" + player.getNumber() + " - " + player.getFirstName() + " " + player.getLastName();
            JRadioButton button = new JRadioButton(buttonLabel);
            button.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(button);
            allPlayersButtonGroup.add(button);
        }

        this.add(panel, placement);
    }
}
