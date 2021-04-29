package com.kaitan.lesson02;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCal {
    public static void main(String[] args) {
        new Calculator();
    }
}

//计算器类（frame）
class Calculator extends Frame{
    public Calculator(){
        //3个文本框
        TextField num1 = new TextField(10);
        TextField num2 = new TextField(10);
        TextField num3 = new TextField(20);

        //1个 button
        Button button = new Button("=");
        button.addActionListener(new MyCalListener(num1,num2,num3));

        //1个 标签label
        Label label = new Label("+");

        //label
        setLayout(new FlowLayout());

        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);
    }
}

//监听器类
class MyCalListener implements ActionListener {
    //获取 3 个 变量
    private TextField num1,num2,num3;
    public MyCalListener(TextField num1, TextField num2, TextField num3){
        this.num1 = num1;
        this.num2 = num2;
        this.num3= num3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获得 两个 加数
        int n1 = Integer.parseInt(num1.getText());
        int n2 = Integer.parseInt(num2.getText());


        // 做 加法
        num3.setText(""+(n1+n2));

        //清除 前两个框的 数
        num1.setText("");
        num2.setText("");

    }
}