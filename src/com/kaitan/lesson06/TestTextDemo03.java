package com.kaitan.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo03 extends JFrame {
    public TestTextDemo03(){

        Container container = getContentPane();

        JPasswordField p1 = new JPasswordField();
        p1.setEchoChar('*');
        container.add(p1);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo03();
    }
}
