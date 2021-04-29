package com.kaitan.lesson02;

import com.kaitan.lesson01.TestBoarderLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestAction2 {
    public static void main(String[] args) {
        //连个button, 同一个监听
        Frame frame = new Frame("start-stop");
        frame.setVisible(true);
        Button b1 = new Button("start");
        Button b2 = new Button("stop");

        //b1.addActionListener(new ActionListener());
        //b2.setActionCommand("button2-stop");

        MyMonitor myMonitor = new MyMonitor();
        b1.addActionListener(myMonitor);
        b2.addActionListener(myMonitor);

        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);
        frame.pack();
    }
}

class MyMonitor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("touched button: msg->"+e.getActionCommand());
        if(e.getActionCommand()=="start"){
            System.out.println("Just started");
        }
    }
}