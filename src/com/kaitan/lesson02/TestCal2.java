package com.kaitan.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCal2 {
    public static void main(String[] args) {
        Calculator2 c2 = new Calculator2();
        c2.loadFrame();
    }
}

class Calculator2 extends Frame{
    TextField num1;
    TextField num2;
    TextField num3;


    public void loadFrame(){
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(20);
        Button button = new Button("=");
        button.addActionListener(new Trigger(this));
        Label label = new Label("+");


        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        setVisible(true);
    }
}

class Trigger implements ActionListener{
    Calculator2 calculator = null;

    public Trigger(Calculator2 calculator){//add public
        this.calculator = calculator;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int n1 = Integer.parseInt(calculator.num1.getText());
        int n2 = Integer.parseInt(calculator.num2.getText());
        calculator.num3.setText(""+(n1+n2));
        calculator.num1.setText("");
        calculator.num2.setText("");
    }
}