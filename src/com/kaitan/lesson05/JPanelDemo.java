package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {

    public static void main(String[] args) {

        new JPanelDemo();
    }



    public JPanelDemo(){
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1,10,10));
        JPanel panel1 = new JPanel(new GridLayout(1,3));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));

        JPanel panel2 = new JPanel(new GridLayout(2,2));
        panel2.add(new JButton("4"));
        panel2.add(new JButton("3"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("1"));

        container.add(panel1);
        container.add(panel2);


        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);

    }
}
