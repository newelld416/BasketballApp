package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 11/10/2014.
 */
public class DefensivePanel extends JPanel {

    private JButton steal_button, block_button, rebound_button, charge_taken_button, personal_foul_button;

    private enum ButtonType {
        Steal,
        Block,
        DefensiveRebound,
        ChargeTaken,
        PersonalFoul
    }

    public DefensivePanel(){
        int width = Constants.WIDTH / 2;
        int height = (int) (Constants.HEIGHT * .1);
        this.setPreferredSize(new Dimension(width, height));// hardCoded sizing
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new GridLayout(2,3));

        steal_button = new JButton(Constants.STEAL_BUTTON_LABEL);
        steal_button.addActionListener(new ButtonAction(ButtonType.Steal));

        block_button = new JButton(Constants.BLOCK__BUTTON_LABEL);
        block_button.addActionListener(new ButtonAction(ButtonType.Block));

        rebound_button = new JButton(Constants.DEFENSIVE_REBOUND_BUTTON_LABEL);
        rebound_button.addActionListener(new ButtonAction(ButtonType.DefensiveRebound));

        charge_taken_button = new JButton(Constants.CHARGE_TAKEN_BUTTON_LABEL);
        charge_taken_button.addActionListener(new ButtonAction(ButtonType.ChargeTaken));

        personal_foul_button = new JButton(Constants.PERSONAL_FOUL_BUTTON_LABEL);
        personal_foul_button.addActionListener(new ButtonAction(ButtonType.PersonalFoul));

        this.add(steal_button);
        this.add(block_button);
        this.add(rebound_button);
        this.add(charge_taken_button);
        this.add(personal_foul_button);
    }

    class ButtonAction implements ActionListener {
        private String buttonType;

        public ButtonAction(ButtonType pButtonType) {
            buttonType = pButtonType.toString();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Player player = Utility.GetPlayer(Utility.getEngine().getSelectedPlayer());
            if (player != null) {
                if (buttonType == ButtonType.Steal.toString()) {
                    player.setSteals(player.getSteals() + 1);
                } else if (buttonType == ButtonType.Block.toString()) {
                    player.setBlocks(player.getBlocks() + 1);
                } else if (buttonType == ButtonType.DefensiveRebound.toString()) {
                    player.setDefensiveRebounds(player.getDefensiveRebounds() + 1);
                } else if (buttonType == ButtonType.ChargeTaken.toString()) {
                    player.setChargesTaken(player.getChargesTaken() + 1);
                } else if (buttonType == ButtonType.PersonalFoul.toString()) {
                    player.setPersonalFouls(player.getPersonalFouls() + 1);
                }
                Utility.SavePlayer(player);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a player.", "Player Selection", JOptionPane.OK_OPTION);
            }
        }
    }
}
