package com.kaitan.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCal3 {
    public static void main(String[] args) {
        new Calculator3().loadFrame();
    }
}

class Calculator3 extends Frame{
    TextField num1;
    TextField num2;
    TextField num3;


    public void loadFrame(){
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(20);
        Button button = new Button("=");
        button.addActionListener(new Trigger3());
        Label label = new Label("+");


        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        setVisible(true);
    }

    class Trigger3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText(""+(n1+n2));
            num1.setText("");
            num2.setText("");
        }
    }

}

