package com.kaitan.lesson03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("Drawing");
    }
}

class MyFrame extends Frame{
    //画画 需要 画笔，需要监听鼠标现在的 位置，需要集合来 存储这个点

    //存 鼠标的 点: 集合attribute声明
    ArrayList points;

    //Constructor：具体 实施
    public MyFrame(String title) {
        super(title);
        setBounds(200,200,400,300);
        setVisible(true);

        //存鼠标的 点
        points = new ArrayList<>();

        //鼠标监听器 是针对这个 窗口的，而不是 像 button, FieldText
        this.addMouseListener(new MyMouseListener());

    }


    //重写 Painter
    @Override
    public void paint(Graphics g) {
        //监听鼠标的 事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.BLUE);
            g.fillOval(point.x,point.y,10,10); //画小圆
        }
    }



    //添加一个点(MyMouseListener识别出来的 点) 到界面（即上面的 points集合）
    public void addPoint(Point point){
        points.add(point);
    }

    // Mouse Monitor-对应 添加 到 Frame上的 addMouseListener
    private class MyMouseListener extends MouseAdapter {//MouseListener所有Abstract都要 写，所以改成Adapter
        //鼠标点击 (可以 有 按住不妨，)
        @Override
        public void mousePressed(MouseEvent e) {
            MyFrame frame = (MyFrame)e.getSource(); //这里 是用 frame来 addMouseListener,所以返回的 可以转成frame格式

            //这里点击时候，就会在 界面上产生一个点，所以这里要先获取 鼠标坐标点
            addPoint(new Point(e.getX(),e.getY()));

            //每次点击 都要重画一遍
            frame.repaint();
        }
    }

}
