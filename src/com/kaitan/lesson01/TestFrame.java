package com.kaitan.lesson01;

import java.awt.*;

//GUI第一个界面
public class TestFrame {
    public static void main(String[] args) {
        //Frame对象
        Frame frame = new Frame("My first Java GUi"); //name

        //frame现在在 内存中，不可见，现在 设置为可见
        frame.setVisible(true);

        //设置 window 大小
        frame.setSize(400,400);

        //设置 颜色
        frame.setBackground(Color.BLACK);
        frame.setBackground(new Color(16, 92, 165));

        //填出的 初始位置
        frame.setLocation(200,200);

        //设置 大小固定
        frame.setResizable(false);


    }
}
