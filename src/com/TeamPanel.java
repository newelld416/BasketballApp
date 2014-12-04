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
    private String homeTeamName, awayTeamName;

    public TeamPanel(String homeTeam, String awayTeam){
        homeTeamName = homeTeam;
        awayTeamName = awayTeam;
        this.setPreferredSize(new Dimension(Constants.WIDTH, ((int) (Constants.HEIGHT * .5))));
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        createTeamPanel(Utility.getEngine().getHomePlayers(),BorderLayout.LINE_START, homeTeamName);
        createTeamPanel(Utility.getEngine().getAwayPlayers(), BorderLayout.LINE_END, awayTeamName);
    }

    /**
     * Creates an individual team panel for either the home or away team
     * @param players
     * @param placement
     * @param teamLabel
     */
    private void createTeamPanel(ArrayList<Player> players, String placement, String teamLabel){
        JPanel panel = new JPanel();
        JLabel team = new JLabel(teamLabel);
        team.setHorizontalAlignment(SwingConstants.CENTER);
        team.setFont(new Font("Verdana", Font.BOLD, 24));
        panel.add(team);
        panel.setPreferredSize(new Dimension(Constants.WIDTH / 2, ((int) (Constants.HEIGHT * .5))));
        panel.setLayout(new GridLayout(players.size() + 3,1));

        //Add players to buttons
        for (Player player : players){
            String buttonLabel = "#" + player.getNumber() + " - " + player.getFirstName() + " " + player.getLastName();
            JRadioButton button = new JRadioButton(buttonLabel);
            button.addActionListener(new ButtonAction(player));
            button.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(button);
            allPlayersButtonGroup.add(button);
            Utility.savePlayer(player);
        }

        this.add(panel, placement);
    }

    /**
     * This is the Button action used
     */
    class ButtonAction implements ActionListener {
        private Player player;

        public ButtonAction (Player pPlayer){
            this.player = pPlayer;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Engine engine = Utility.getEngine();
            engine.setSelectedPlayer(getPlayer());
            Utility.saveEngine(engine);
        }

        private Player getPlayer() {
            return player;
        }
    }
}
