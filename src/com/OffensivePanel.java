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
    private JButton steal_button;
    private JButton rebound_button;

    private enum ButtonType {
        OffensiveRebound,
        Score,
        Steal
    }

    public OffensivePanel(){
        int width = Constants.WIDTH / 2;
        int height = (int) (Constants.HEIGHT * .3);
        this.setPreferredSize(new Dimension(width, height));// hardCoded sizing
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new GridLayout(2,3));

        one_point_button = new JButton(Constants.ONE_POINT_LABEL);
        one_point_button.addActionListener(new ButtonAction(1, ButtonType.Score));

        two_point_button = new JButton(Constants.TWO_POINT_LABEL);
        two_point_button.addActionListener(new ButtonAction(2, ButtonType.Score));

        three_point_button = new JButton(Constants.THREE_POINT_LABEL);
        three_point_button.addActionListener(new ButtonAction(3, ButtonType.Score));

        steal_button = new JButton(Constants.STEAL_BUTTON_LABEL);
        steal_button.addActionListener(new ButtonAction(ButtonType.Steal));

        rebound_button = new JButton(Constants.REBOUND_BUTTON_LABEL);
        rebound_button.addActionListener(new ButtonAction(ButtonType.OffensiveRebound));

        this.add(one_point_button);
        this.add(two_point_button);
        this.add(three_point_button);
        this.add(steal_button);
        this.add(rebound_button);
    }

    class ButtonAction implements ActionListener{
        private int points;
        private String buttonType;

        public ButtonAction(ButtonType pButtonType){
            buttonType = pButtonType.toString();
        }

        public ButtonAction(int pPoints, ButtonType pButtonType){
            points = pPoints;
            buttonType = pButtonType.toString();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Player player = Utility.GetPlayer(Utility.getEngine().getSelectedPlayer());
            if (player != null){
                if (buttonType == ButtonType.Score.toString()){
                    player = setPlayerPoints(player, points);
                } else if (buttonType == ButtonType.Steal.toString()){
                    player = setPlayerSteal(player);
                } else if (buttonType == ButtonType.OffensiveRebound.toString()){
                    player = setPlayerOffensiveRebound(player);
                }
            }
            Utility.SavePlayer(player);
        }

        private Player setPlayerPoints(Player player, int points){
            player.setTotalPoints(player.getTotalPoints() + points);
            return player;
        }

        private Player setPlayerSteal(Player player){
            player.setSteals(player.getSteals() + 1);
            return player;
        }

        private Player setPlayerOffensiveRebound(Player player){
            player.setOffensiveRebounds(player.getOffensiveRebounds() + 1);
            return player;
        }
    }
}
