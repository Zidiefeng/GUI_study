package com.kaitan.lesson01;

import java.awt.*;

public class LayoutExercise {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        Button b6 = new Button("b6");
        Button b7 = new Button("b7");
        Button b8 = new Button("b8");
        Button b9 = new Button("b9");
        Button b0 = new Button("b0");

        frame.setLayout(new GridLayout(2,1));

        Panel p1 = new Panel();
        Panel p2 = new Panel(new BorderLayout());
        Panel p3 = new Panel();
        Panel p4 = new Panel(new BorderLayout());

        p1.setLayout(new GridLayout(2,1));
        p1.add(b1);
        p1.add(b2);

        p2.add(b3,BorderLayout.EAST);
        p2.add(p1,BorderLayout.CENTER);
        p2.add(b4,BorderLayout.WEST);

        p3.setLayout(new GridLayout(2,2));
        p3.add(b5);
        p3.add(b6);
        p3.add(b7);
        p3.add(b8);

        p4.add(b9,BorderLayout.EAST);
        p4.add(p3,BorderLayout.CENTER);
        p4.add(b0,BorderLayout.WEST);

        frame.setSize(500,800);
        frame.add(p2);
        frame.add(p4);

        frame.pack();
        frame.setVisible(true);
    }
}
