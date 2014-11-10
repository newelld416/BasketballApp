package com;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    private Container content;

    public Main (){
        //Necessary initialization code
        setTitle(Constants.TITLE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        content = getContentPane();
        content.setLayout(new BorderLayout());
        setVisible(true);
    }


    public static void main(String[] args) {
        Main gui = new Main();
    }
}
