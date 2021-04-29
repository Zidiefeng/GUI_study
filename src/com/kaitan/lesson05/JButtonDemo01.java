package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo01 extends JFrame {

    public JButtonDemo01(){
        Container container = getContentPane();
        URL url = JButtonDemo01.class.getResource("example_jpg.jpg");
        Icon icon = new ImageIcon(url);

        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("jpg button");

        container.add(button);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
