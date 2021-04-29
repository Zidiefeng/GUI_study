package com.kaitan.lesson01;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //Component-按钮 button
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

        frame.setLayout(new FlowLayout(FlowLayout.LEFT)); //点进去，看到默认 this(CENTER, 5, 5);
        frame.setSize(200,200);

        //添加 按钮 （panel也能添加）
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);
    }
}
