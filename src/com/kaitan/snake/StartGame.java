package com.kaitan.snake;

import javax.swing.*;

public class StartGame {
    //游戏主 启动类
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBounds(900,350,900,720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //真正的 游戏 界面 都应该游戏面板上
        frame.add(new GamePanel()); //定义在 GamePanel 中的Panel
        frame.setVisible(true);
    }

}
