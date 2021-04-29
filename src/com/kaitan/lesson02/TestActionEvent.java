package com.kaitan.lesson02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {
    public static void main(String[] args) {
        //按钮-触发事件
        Button b1= new Button("Button");
        Frame frame = new Frame();


        //因为需要一个ActionListener所以我们构造了一个ActionListener
        MyActionListener l1 = new MyActionListener();
        b1.addActionListener(l1);

        frame.add(b1,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        windowClose(frame);

    }

    //关闭 window 的 事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Touched Button");
    }
}