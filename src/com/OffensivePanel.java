package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 11/10/2014.
 */
public class OffensivePanel extends JPanel {

    private JButton one_point_button, two_point_button, three_point_button, assist_button,rebound_button, turnover_button;


    private enum ButtonType {
        OffensiveRebound,
        Score,
        Assist,
        Turnover
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

        assist_button = new JButton(Constants.ASSIST_BUTTON_LABEL);
        assist_button.addActionListener(new ButtonAction(ButtonType.Assist));

        rebound_button = new JButton(Constants.OFFENSIVE_REBOUND_BUTTON_LABEL);
        rebound_button.addActionListener(new ButtonAction(ButtonType.OffensiveRebound));

        turnover_button = new JButton(Constants.TURNOVER_BUTTON_LABEL);
        turnover_button.addActionListener(new ButtonAction(ButtonType.Turnover));

        this.add(one_point_button);
        this.add(two_point_button);
        this.add(three_point_button);
        this.add(assist_button);
        this.add(rebound_button);
        this.add(turnover_button);
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
                } else if (buttonType == ButtonType.Assist.toString()){
                    player = setPlayerAssist(player);
                } else if (buttonType == ButtonType.OffensiveRebound.toString()){
                    player = setPlayerOffensiveRebound(player);
                } else if (buttonType == ButtonType.Turnover.toString()){
                    player = setPlayerTurnover(player);
                }
            }
            Utility.SavePlayer(player);
        }

        private Player setPlayerPoints(Player player, int points){
            boolean shotMade;
            int response = JOptionPane.showConfirmDialog(null, "Was the shot Made?", "Shot Outcome", JOptionPane.YES_NO_CANCEL_OPTION);
            if( response == JOptionPane.YES_OPTION) {
                System.out.println("Yes option");
                shotMade = true;
            } else if ( response == JOptionPane.NO_OPTION) {
                System.out.println("No Option");
                shotMade = false;
            } else{
                shotMade = false;
            }
            return player;
        }

        private Player setPlayerAssist(Player player){
            player.setAssists(player.getAssists() + 1);
            return player;
        }

        private Player setPlayerOffensiveRebound(Player player){
            player.setOffensiveRebounds(player.getOffensiveRebounds() + 1);
            return player;
        }

        private Player setPlayerTurnover(Player player){
            player.setTurnovers(player.getTurnovers() + 1);
            return player;
        }
    }
}
