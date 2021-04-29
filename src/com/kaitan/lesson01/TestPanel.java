package com.kaitan.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel(); // 涉及Layout 的 概念

        frame.setLayout(null); //set Layout
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(238, 250, 125));

        //set panel，相对于 frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(215, 215, 215, 79));

        //把panel放到 frame上
        frame.add(panel);

        frame.setVisible(true);
        
        frame.addWindowListener(new WindowAdapter(){
            //窗口点击 关闭 需要做的事情
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
