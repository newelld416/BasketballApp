package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 11/10/2014.
 */
public class OffensivePanel extends JPanel {

    public OffensivePanel(){
        int width = Constants.WIDTH / 2;
        int height = (int) (Constants.HEIGHT * .4);
        this.setPreferredSize(new Dimension(width, height));// hardCoded sizing
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
