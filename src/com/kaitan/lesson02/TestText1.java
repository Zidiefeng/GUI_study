package com.kaitan.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText1 {
    public static void main(String[] args) {
        //一般 都只有 一行：启动
        new MyFrame();
    }

}

class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        //监听文本框输入的 文字
        MyActionListener2 l2=new MyActionListener2();
        //按下enter 触发 输入框的 事件
        textField.addActionListener(l2);

        //设置 替换编码
        textField.setEchoChar('*');

        setVisible(true);
        pack();
    }

}

class MyActionListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField  field= (TextField) e.getSource(); //获得source, 返回了一个对象Object, 可以转成任何 一类
        System.out.println(field.getText());
        field.setText("");
    }
}
