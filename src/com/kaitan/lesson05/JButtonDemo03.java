package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo03 extends JFrame {

    public JButtonDemo03(){
        Container container = getContentPane();
        URL url = JButtonDemo01.class.getResource("example_jpg.jpg");
        Icon icon = new ImageIcon(url);

        JCheckBox check1 = new JCheckBox();
        JCheckBox check2 = new JCheckBox();
        JCheckBox check3 = new JCheckBox();


        container.add(check1,BorderLayout.NORTH);
        container.add(check2,BorderLayout.CENTER);
        container.add(check3,BorderLayout.SOUTH);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
