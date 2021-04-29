package com.kaitan.lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}

class KeyFrame extends Frame {
    public KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);

        addKeyListener(
                new KeyAdapter(){
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int keyCode = e.getKeyCode(); //当前pressed时哪一个key
                        System.out.println(keyCode);//不需要记这个 code,直接用静态属性VR_XXX（如KeyEvent.VK_UP）等就好


                        if(keyCode == KeyEvent.VK_UP){
                            System.out.println("Pressed Up");
                        }
                    }


                });
    }




}
