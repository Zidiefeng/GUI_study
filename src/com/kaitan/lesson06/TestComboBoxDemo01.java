package com.kaitan.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestComboBoxDemo01 extends JFrame{
    public TestComboBoxDemo01(){

        Container container = getContentPane();

        JComboBox status = new JComboBox();
        status.addItem(null);
        status.addItem("To do");
        status.addItem("In progress");
        status.addItem("Completed");

        container.add(status);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboBoxDemo01();
    }
}
