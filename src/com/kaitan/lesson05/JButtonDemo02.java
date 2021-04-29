package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02 extends JFrame {

    public JButtonDemo02(){
        Container container = getContentPane();
        URL url = JButtonDemo01.class.getResource("example_jpg.jpg");
        Icon icon = new ImageIcon(url);

        JRadioButton radioB1 = new JRadioButton();
        JRadioButton radioB2 = new JRadioButton();
        JRadioButton radioB3 = new JRadioButton();

        //单选框，不能同时选择，一般分组，一组只能选1个
        ButtonGroup g1 = new ButtonGroup();
        g1.add(radioB1);
        g1.add(radioB2);
        g1.add(radioB3);

        container.add(radioB1,BorderLayout.NORTH);
        container.add(radioB2,BorderLayout.CENTER);
        container.add(radioB3,BorderLayout.SOUTH);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
