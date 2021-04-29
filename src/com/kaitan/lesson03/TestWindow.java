package com.kaitan.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame(){
        setBackground(Color.BLUE);
        setBounds(100,100,200,200);
        setVisible(true);

        addWindowListener(
                new WindowAdapter(){
                    @Override
                    public void windowClosing(WindowEvent e) {
                        setVisible(false);
                        System.exit(0);
                    }

                    @Override
                    public void windowOpened(WindowEvent e) {
                        System.out.println("Opened");
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.out.println("Closed");
                    }

                    //激活窗口
                    @Override
                    public void windowActivated(WindowEvent e) {
                        WindowFrame source = (WindowFrame) e.getSource();
                        source.setTitle("Activated");
                        System.out.println("Activated");
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        System.out.println("De-Activated");
                    }


                }
                );

    }
}

