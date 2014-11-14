package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 11/10/2014.
 */
public class OffensivePanel extends JPanel {

    private JButton one_point_button;
    private JButton two_point_button;
    private JButton three_point_button;

    private TeamPanel teamPanel;
    public OffensivePanel(TeamPanel pTeamPanel){
        teamPanel = pTeamPanel;
        int width = Constants.WIDTH / 2;
        int height = (int) (Constants.HEIGHT * .4);
        this.setPreferredSize(new Dimension(width, height));// hardCoded sizing
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new GridLayout(2,3));

        one_point_button = new JButton(Constants.ONE_POINT_LABEL);
        one_point_button.addActionListener(new AddPointsButtonAction(1));

        two_point_button = new JButton(Constants.TWO_POINT_LABEL);
        two_point_button.addActionListener(new AddPointsButtonAction(2));

        three_point_button = new JButton(Constants.THREE_POINT_LABEL);
        three_point_button.addActionListener(new AddPointsButtonAction(3));

        three_point_button = new JButton(Constants.THREE_POINT_LABEL);
        three_point_button.addActionListener(new AddPointsButtonAction(3));

        three_point_button = new JButton(Constants.THREE_POINT_LABEL);
        three_point_button.addActionListener(new AddPointsButtonAction(3));

        three_point_button = new JButton(Constants.THREE_POINT_LABEL);
        three_point_button.addActionListener(new AddPointsButtonAction(3));

        this.add(one_point_button);
        this.add(two_point_button);
        this.add(three_point_button);
    }

    class AddPointsButtonAction implements ActionListener{
        private int points;

        public AddPointsButtonAction(int pPoints){
            points = pPoints;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Player player = teamPanel.getSelectedPlayer();
            player.setTotalPoints(player.getTotalPoints() + points);
        }
    }
}
