package com.kaitan.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){

        Container container = getContentPane();

        JTextField t1 = new JTextField("hello");
        JTextField t2 = new JTextField("world",20);

        container.add(t1,BorderLayout.NORTH);
        container.add(t2,BorderLayout.SOUTH);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
