package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 11/17/2014.
 */
public class BoxScore  extends JPanel {

    private int width, height;
    private JButton gameOverButton;

    public BoxScore (){
        width = Constants.WIDTH;
        height = (int) (Constants.HEIGHT * .1);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        gameOverButton = new JButton(Constants.GAME_OVER_LABEL);
        gameOverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Container content;
                JFrame frame = new JFrame(Constants.BOX_SCORE_TITLE);

                Engine engine = Utility.getEngine();
                for(Player play : engine.getHomePlayers()){
                    Player player = Utility.GetPlayer(play);
                    StringBuilder playerString = new StringBuilder();
                    playerString.append(player.getFirstName() + " ");
                    playerString.append(player.getTotalPoints());
                    frame.add(new JLabel(playerString.toString()));
                }

                for(Player play : engine.getAwayPlayers()){
                    Player player = Utility.GetPlayer(play);
                    StringBuilder playerString = new StringBuilder();
                    playerString.append(player.getFirstName() + " ");
                    playerString.append(player.getTotalPoints());
                    frame.add(new JLabel(playerString.toString()));
                }

                frame.setTitle(Constants.TITLE);
                frame.setSize(Constants.WIDTH, Constants.HEIGHT);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                content = frame.getContentPane();
                content.setLayout(new GridLayout(8, 1));
                frame.setVisible(true);
            }

        });

        this.add(gameOverButton, BorderLayout.CENTER);
    }
}
