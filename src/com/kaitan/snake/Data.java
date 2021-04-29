package com.kaitan.snake;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL headerURL = Data.class.getResource("/statics/header.png"); //绝对路径 / 相当于当前的 项目
    public static URL downURL = Data.class.getResource("/statics/down.png"); //绝对路径 / 相当于当前的 项目
    public static URL upURL = Data.class.getResource("/statics/up.png"); //绝对路径 / 相当于当前的 项目
    public static URL rightURL = Data.class.getResource("/statics/right.png"); //绝对路径 / 相当于当前的 项目
    public static URL leftURL = Data.class.getResource("/statics/left.png"); //绝对路径 / 相当于当前的 项目
    public static URL foodURL = Data.class.getResource("/statics/food.png"); //绝对路径 / 相当于当前的 项目
    public static URL bodyURL = Data.class.getResource("/statics/body.png"); //绝对路径 / 相当于当前的 项目
    public static ImageIcon header = new ImageIcon(headerURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon right = new ImageIcon(rightURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon food = new ImageIcon(foodURL);
    public static ImageIcon body = new ImageIcon(bodyURL);
}
