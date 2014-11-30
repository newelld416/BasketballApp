package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 11/10/2014.
 */
public class DefensivePanel extends JPanel {

    public DefensivePanel(){
        int width = Constants.WIDTH / 2;
        int height = (int) (Constants.HEIGHT * .3);
        this.setPreferredSize(new Dimension(width, height));// hardCoded sizing
        this.setMaximumSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
