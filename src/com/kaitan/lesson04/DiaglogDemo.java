package com.kaitan.lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主窗口
public class DiaglogDemo extends JFrame {

    public DiaglogDemo(){
        setVisible(true);
        setSize(700,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //container
        Container container = getContentPane();
        container.setLayout(null); //绝对布局

        JButton button = new JButton("点击弹出一个对话框");
        button.setBounds(30,30,200,50);//绝对布局下，直接 相对 对话框 定位就行

        container.add(button);
        container.setVisible(true);

        //点击按钮的时候，需要弹出 另外一个弹窗，需要监听事件
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialogDemo();
            }
        });

    }

    public static void main(String[] args) {
        new DiaglogDemo();
    }
}

class MyDialogDemo extends JDialog{
    public MyDialogDemo(){
        setVisible(true);
        setBounds(100,100,500,500);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.add(new JLabel("Welcome to the new Window"));
    }

}

//弹窗的 窗口