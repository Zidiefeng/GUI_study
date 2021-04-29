package com.kaitan.lesson01;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
        //display multiple windows
        new MyFrame(100,100,200,200,Color.blue);
        new MyFrame(300,100,200,200,Color.yellow);
        new MyFrame(100,300,200,200,Color.red);
        new MyFrame(300,300,200,200,Color.MAGENTA);
    }
}

class MyFrame extends Frame {
    static int id = 0;//可能多个窗口，所以需要计数器

    public MyFrame(int x, int y, int w, int h, Color color) throws HeadlessException {
        super("Myframe"+(++id)); //每次new 新建id +1

        setBounds(x,y,w,h);
        setVisible(true);
        setBackground(color);


    }
}

