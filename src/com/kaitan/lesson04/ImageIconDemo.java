package com.kaitan.lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public static void main(String[] args) {
        new ImageIconDemo();
    }

    public ImageIconDemo(){
        JLabel label = new JLabel("ImageIcon");
        //获取图片地址: 当前这个class队医的 上级 地址，然后给一个 file name，直接获取
        URL url = ImageIconDemo.class.getResource("example_jpg.jpg");

        ImageIcon imageIcon = new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,400,400);
    }
}
