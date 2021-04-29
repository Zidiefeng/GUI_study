package com.kaitan.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {

    //init 方法，初始化
    public void init(){

        //顶级窗口
        JFrame jf = new JFrame("This is a Jframe Window");
        jf.setVisible(true);
        jf.setBounds(100,100,200,200);
        //jf.setBackground(Color.CYAN);//not working
        //关闭 event
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置文字 JLabel
        JLabel label = new JLabel("Welcome to the window");
        label.setHorizontalAlignment(SwingConstants.LEFT);

        //所有东西放在 容器里面，容器需要实例化
        Container container = jf.getContentPane();
        container.setBackground(Color.YELLOW);
        container.setBounds(10,10,200,300);
        container.setVisible(true);
        container.add(label);


    }
    public static void main(String[] args) {
        //建立一个窗口
        new JFrameDemo().init();
    }
}
