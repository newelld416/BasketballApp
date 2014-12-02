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
    private int width, height;

    public TeamPanel(){
        width = Constants.WIDTH;
        height = (int) (Constants.HEIGHT * .5);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        createTeamPanel(Utility.getEngine().getHomePlayers(),BorderLayout.LINE_START, Constants.HOME_TEAM_LABEL);
        createTeamPanel(Utility.getEngine().getAwayPlayers(), BorderLayout.LINE_END, Constants.AWAY_TEAM_LABEL);

        JButton addPlayerButton = new JButton("Add Player");
        addPlayerButton.addActionListener(new AddPlayerButtonAction());
        addPlayerButton.setPreferredSize(new Dimension(width, (int) (Constants.HEIGHT * .05)));
        this.add(addPlayerButton, BorderLayout.PAGE_END);
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
            button.addActionListener(new ButtonAction(player));
            button.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(button);
            allPlayersButtonGroup.add(button);
            Utility.SavePlayer(player);
        }

        this.add(panel, placement);
    }

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

        private void setPlayer(Player player) {
            this.player = player;
        }
    }

    class AddPlayerButtonAction implements ActionListener {

        public AddPlayerButtonAction (){

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
