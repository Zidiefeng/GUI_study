package com.kaitan.lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestComboBoxDemo02 extends JFrame{
    public TestComboBoxDemo02(){

        Container container = getContentPane();

        //生成 列表的内容
        //String[] contents = {"1","2","3"};

        Vector v1 = new Vector();

        //List中放内容
        JList l1 = new JList(v1);
        container.add(l1);

        v1.add("kaitan");
        v1.add("Jessy");

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboBoxDemo02();
    }
}
