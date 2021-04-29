package com.kaitan.lesson03;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame {

    public void loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.red);
        g.drawOval(100,100,100,100);
        g.fillOval(300,300,100,100);

        g.setColor(Color.GREEN);
        g.fillRect(150,200,100,50);

        // paint画完 要还原成最初的 颜色

    }
}