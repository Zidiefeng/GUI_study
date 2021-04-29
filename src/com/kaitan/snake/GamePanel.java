package com.kaitan.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    // 定义 蛇的 长度
    int length; //蛇的 长度
    int[] snakeX = new int[600]; //蛇X坐标25*25（一节25）
    int[] snakeY = new int[500]; //蛇Y坐标25*25
    String direction;
    //游戏 当前status
    boolean isStart = false;
    // new Timer()
    Timer timer = new Timer(100,this); //毫秒单位: 100毫秒执行一次
    //食物坐标
    int foodX;
    int foodY;
    Random random = new Random();
    //是否失败
    boolean isFail=false;
    //积分展示
    int score;



    // 构造器
    public GamePanel() {
        init();
        setFocusable(true);//获得焦点事件 -光标
        addKeyListener(this);//because of implements
        timer.start();//游戏一开始 就启动
    }

    //初始条件
    public void init(){
        length = 3;
        snakeX[0]=100;snakeY[0]=100; //头 坐标
        snakeX[1]=75;snakeY[1]=100; //第一个身体
        snakeX[2]=50;snakeY[2]=100; //第二节 身体
        direction = "R";
        foodX=25+25*random.nextInt(34);
        foodY=75+25*random.nextInt(24);
        score=0;
    }

    //绘制 面板, 游戏中的所有东西，都由这个画笔来画
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //清屏

        //绘制 静态 面板
        this.setBackground(Color.WHITE);
        Data.header.paintIcon(this,g,25,11);//头部 广告栏
        g.fillRect(25,75,850,600);//默认游戏界面




        if(direction.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }


        //snake
        for (int i=1; i<length; i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //游戏状态
        if(isStart==false){

            g.setColor(Color.WHITE);
            //设置 字体
            g.setFont(new Font("Microsoft YaHei", Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,400);
        }


        //食物
        Data.food.paintIcon(this, g,foodX,foodY);

        if(isFail){
            g.setColor(Color.RED);
            //设置 字体
            g.setFont(new Font("Microsoft YaHei", Font.BOLD,40));
            g.drawString("失败，按空格重新开始，得分："+length,150,400);
        }

        //画分数
        g.setColor(Color.WHITE);
        g.setFont(new Font("Microsoft YaHei", Font.BOLD,10));
        g.drawString("得分："+score,750,30);

    }




    //KeyListener--------------------------------------------

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode= e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE){
            if(isFail){
                //重新开始
                isFail=false;
                init();
            }else{
                if (!isStart) isStart = true;
                else isStart = false;
                repaint();
            }

        }

        //snake move
        if (keyCode == KeyEvent.VK_UP){
            direction="U";
        }else if(keyCode == KeyEvent.VK_DOWN){
            direction="D";
        }else if(keyCode == KeyEvent.VK_RIGHT){
            direction="R";
        }else if(keyCode == KeyEvent.VK_LEFT){
            direction="L";
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //Action Listener -----------------------------------------
    //需要通过 固定的 时间 刷新
    @Override
    public void actionPerformed(ActionEvent e) {

        if (snakeX[0]==foodX && snakeY[0]==foodY){
            length++;
            foodX=25+25*random.nextInt(34);
            foodY=75+25*random.nextInt(24);
            score +=1;
        }

        if (isStart && (!isFail)){
            //如果开始，就让小蛇 动起来

            //右 移
            for(int i = length-1;i>0;i--){
                snakeX[i] = snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            if (direction.equals("R")){
                snakeX[0]=snakeX[0]+25;
                if (snakeX[0]>850){
                    snakeX[0] = 25;
                }
            }else if(direction.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if (snakeX[0]<25){
                    snakeX[0] = 850;
                }
            }else if(direction.equals("U")){
                snakeY[0]=snakeY[0]-25;
                if (snakeY[0]<75){
                    snakeY[0] = 650;
                }
            }else if(direction.equals("D")){
                snakeY[0]=snakeY[0]+25;
                if (snakeY[0]>650){
                    snakeY[0] = 75;
                }
            }
            
            //撞到自己，就是失败
            for (int i = 1; i < length; i++) {
                if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    isFail=true;
                }
            }
            
            repaint();
        }
        timer.start();

    }
}


//Listener: Keyboards