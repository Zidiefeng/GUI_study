package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        Container container = this.getContentPane();

        JTextArea textArea = new JTextArea(20,50);
        textArea.setText("Welcome to the text box");

        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);

        setBounds(100,100,300,350);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
