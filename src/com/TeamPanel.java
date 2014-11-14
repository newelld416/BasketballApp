package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Daniel on 11/10/2014.
 */
public class TeamPanel extends JPanel {

    private ButtonGroup allPlayersButtonGroup = new ButtonGroup();
    private ArrayList<Player> homeTeamPlayers, awayTeamPlayers;
    private int width, height;
    private Player selectedPlayer;

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

    private void createTeamPanel(ArrayList<Player> players, String placement, String teamLabel){
        JPanel panel = new JPanel();
        JLabel team = new JLabel(teamLabel);
        team.setHorizontalAlignment(SwingConstants.CENTER);
        team.setFont(new Font("Verdana", Font.BOLD, 24));
        panel.add(team);
        panel.setPreferredSize(new Dimension(width / 2, height));
        panel.setLayout(new GridLayout(players.size() + 3,1));

        //Add players to buttons
        for (Player player : players){
            String buttonLabel = "#" + player.getNumber() + " - " + player.getFirstName() + " " + player.getLastName();
            JRadioButton button = new JRadioButton(buttonLabel);
            button.addActionListener(new ButtonAction());
            button.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(button);
            allPlayersButtonGroup.add(button);
        }

        this.add(panel, placement);
    }

    public Player getSelectedPlayer(){
        if (selectedPlayer == null){
            JOptionPane.showMessageDialog(null, "No player selected.", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        return selectedPlayer;
    }

    class ButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton button = (JRadioButton) e.getSource();
            String[] ary = button.getText().split(" ");
            String firstName = ary[2];
            String lastName = ary[3];

            for(Player player: homeTeamPlayers){
                if (firstName.equals(player.getFirstName()) && lastName.equals(player.getLastName())){
                    selectedPlayer = player;
                    return;
                }
            }

            for(Player player: awayTeamPlayers){
                if (firstName.equals(player.getFirstName()) && lastName.equals(player.getLastName())){
                    selectedPlayer = player;
                    return;
                }
            }
        }
    }
}
