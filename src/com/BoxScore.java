package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Daniel on 11/17/2014.
 */
public class BoxScore  extends JPanel {

    private int width, height;
    private JButton gameOverButton;

    public BoxScore (){
        width = Constants.WIDTH;
        height = (int) (Constants.HEIGHT * .05);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        gameOverButton = new JButton(Constants.GAME_OVER_LABEL);
        gameOverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Container content;
                JFrame frame = new JFrame(Constants.BOX_SCORE_TITLE);
                Engine engine = Utility.getEngine();
                ArrayList<Player> homePlayers = engine.getHomePlayers();
                ArrayList<Player> awayPlayers = engine.getAwayPlayers();

                frame = addTitleRow(frame);
                for(Player play : homePlayers){
                    frame = addPlayerInfo(Utility.GetPlayer(play), frame);
                }
                frame = addTitleRow(frame);
                for(Player play : awayPlayers){
                    frame = addPlayerInfo(Utility.GetPlayer(play), frame);
                }

                frame.setTitle(Constants.TITLE);
                frame.setSize(1500, 1200);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                content = frame.getContentPane();
                content.setLayout(new GridLayout(homePlayers.size() + awayPlayers.size() + 2, 15));
                frame.setVisible(true);
            }

        });

        this.add(gameOverButton, BorderLayout.CENTER);
    }

    private JFrame addTitleRow(JFrame frame){
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        labels.add(new JLabel(Constants.PLAYER_NAME_LABEL));
        labels.add(new JLabel(Constants.NUMBER_LABEL));
        labels.add(new JLabel(Constants.FIELD_GOALS_LABEL));
        labels.add(new JLabel(Constants.THREE_POINTER_LABEL));
        labels.add(new JLabel(Constants.FREE_THROW_LABEL));
        labels.add(new JLabel(Constants.OFFENSIVE_REBOUND_LABEL));
        labels.add(new JLabel(Constants.DEFENSIVE_REBOUND_LABEL));
        labels.add(new JLabel(Constants.TOTAL_REBOUND_LABEL));
        labels.add(new JLabel(Constants.ASSIST_LABEL));
        labels.add(new JLabel(Constants.STEAL_LABEL));
        labels.add(new JLabel(Constants.BLOCK_LABEL));
        labels.add(new JLabel(Constants.TURN_OVER_LABEL));
        labels.add(new JLabel(Constants.PERSONAL_FOUL_LABEL));
        labels.add(new JLabel(Constants.CHARGE_TAKEN_LABEL));
        labels.add(new JLabel(Constants.POINTS_LABEL));

        for (JLabel label : labels){
            Font boldFont = new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize() + 4);
            label.setFont(boldFont.deriveFont(boldFont.getStyle() | Font.CENTER_BASELINE));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setToolTipText(getTootTipString(label.getText()));
            frame.add(label);
        }
        return frame;
    }

    private JFrame addPlayerInfo(Player player, JFrame frame){
        if (player != null){
            ArrayList<JLabel> labels = new ArrayList<JLabel>();
            labels.add(new JLabel(player.getFirstName() + " " + player.getLastName()));
            labels.add(new JLabel(player.getNumber() + ""));
            labels.add(new JLabel(player.getFieldGoalsMade() + " - " + player.getFieldGoalsAttempted()));
            labels.add(new JLabel(player.getThreePointersMade() + " - " + player.getThreePointersAttempted()));
            labels.add(new JLabel(player.getFreeThrowsMade() + " - " + player.getFreeThrowsAttempted()));
            labels.add(new JLabel(player.getOffensiveRebounds() + ""));
            labels.add(new JLabel(player.getDefensiveRebounds() + ""));
            labels.add(new JLabel((player.getOffensiveRebounds() + player.getDefensiveRebounds()) + ""));
            labels.add(new JLabel(player.getAssists() + ""));
            labels.add(new JLabel(player.getSteals() + ""));
            labels.add(new JLabel(player.getBlocks() + ""));
            labels.add(new JLabel(player.getTurnovers() + ""));
            labels.add(new JLabel(player.getPersonalFouls() + ""));
            labels.add(new JLabel(player.getChargesTaken() + ""));
            labels.add(new JLabel(player.getTotalPoints() + ""));

            for (JLabel label : labels){
                label.setHorizontalAlignment(SwingConstants.CENTER);
                if (label.getText().equals("0") || label.getText().equals("0 - 0")){
                    label.setText("-");
                }

                frame.add(label);
            }
        }
        return frame;
    }

    private String getTootTipString(String label){
        if (label.equals(Constants.PLAYER_NAME_LABEL)){
            return Constants.PLAYER_NAME_LABEL;
        } else if (label.equals(Constants.NUMBER_LABEL)){
            return Constants.NUMBER_TOOL_TIP;
        } else if (label.equals(Constants.FIELD_GOALS_LABEL)){
            return Constants.FIELD_GOALS_TOOL_TIP;
        } else if (label.equals(Constants.THREE_POINTER_LABEL)){
            return Constants.THREE_POINTER_TOOL_TIP;
        } else if (label.equals(Constants.FREE_THROW_LABEL)){
            return Constants.FREE_THROW_TOOL_TIP;
        } else if (label.equals(Constants.OFFENSIVE_REBOUND_LABEL)){
            return Constants.OFFENSIVE_REBOUND_TOOL_TIP;
        } else if (label.equals(Constants.DEFENSIVE_REBOUND_LABEL)){
            return Constants.DEFENSIVE_REBOUND_TOOL_TIP;
        } else if (label.equals(Constants.TOTAL_REBOUND_LABEL)){
            return Constants.TOTAL_REBOUND_TOOL_TIP;
        } else if (label.equals(Constants.ASSIST_LABEL)){
            return Constants.ASSIST_TOOL_TIP;
        } else if (label.equals(Constants.STEAL_LABEL)){
            return Constants.STEAL_TOOL_TIP;
        } else if (label.equals(Constants.BLOCK_LABEL)){
            return Constants.BLOCK_TOOL_TIP;
        } else if (label.equals(Constants.TURN_OVER_LABEL)){
            return Constants.TURN_OVER_TOOL_TIP;
        } else if (label.equals(Constants.PERSONAL_FOUL_LABEL)){
            return Constants.PERSONAL_FOUL_TOOL_TIP;
        } else if (label.equals(Constants.CHARGE_TAKEN_LABEL)){
            return Constants.CHARGE_TAKEN_TOOL_TIP;
        } else if (label.equals(Constants.POINTS_LABEL)){
            return Constants.POINTS_TOOL_TIP;
        }
        return "";
    }
}
