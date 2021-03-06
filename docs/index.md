# GUI

狂神说Java系列-个人学习笔记

## GUI编程简介

- [ ]  [P1、GUI编程简介10:00](https://www.bilibili.com/video/BV1DJ411B75F?p=1)

### GUI

- 就是graphics user interface 图形界面
- 2个GUI核心开发基础：Swing AWT
- 需要JRE环境（比较大）
- 为啥要学？
    - 其为MVC基础，了解监听
    - 可以写出自己心中的 一些 小工具
    - 工作时候，可能要维护Swing界面

### GUI组件

- 窗口
- 弹窗（点击之后弹出来）
- 面板
- 文本框
- 按钮
- 图片
- 列表框
- 监听事件
- 鼠标
- 键盘事件
- 破解工具

## AWT

- [ ]  [P2、AWT介绍08:37](https://www.bilibili.com/video/BV1DJ411B75F?p=2)

### AWT介绍

- abstract windows tools 包含了很多的类和接口！
- 元素：窗口 按钮 文本框
- java包：java.awt

    如下，可以通过`jdk-jre-lib-rt.jar`中的 `java-awt`中查看所有的 awt 源码

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled.png)

### AWT核心类

1. 组件Components

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%201.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%201.png)

    - 直接用的：button, 文本TextArea, 标签Label
    - 容器Container: 存放基本组件
        - Window
            - Frame窗口
            - Diaglog 弹窗
        - 面板Panel
            - Applet（曾经流行）

## Frame窗口

- [ ]  [P3、第一个Frame窗口18:16](https://www.bilibili.com/video/BV1DJ411B75F?p=3)

### 看源码

- `new Frame();`之后 自动配合有加 `import java.awt.*;`包
- control+点击类Frame 查看源码（配合打开左边的Structure看 包 的 结构）

![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%202.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%202.png)

### 代码-实现一个frame

- 调用frame 类后
- 可以设置 可见性，大小，颜色等
- 注意 颜色可以用RGB 和 已经定义好的 Color类中 的（点击到Color（）中去看源码）
- 点击左边还可以自动调色

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%203.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%203.png)

- 计算机中 的 location：左上角 为(0,0)

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%204.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%204.png)

- 代码示例

    ```java
    package com.kaitan.lesson01;

    import java.awt.*;

    //GUI第一个界面
    public class TestFrame {
        public static void main(String[] args) {
            //Frame对象
            Frame frame = new Frame("My first Java GUi"); //name

            //frame现在在 内存中，不可见，现在 设置为可见
            frame.setVisible(true);

            //设置 window 大小
            frame.setSize(400,400);

            //设置 颜色
            frame.setBackground(Color.BLACK);
            frame.setBackground(new Color(16, 92, 165));

            //填出的 初始位置
            frame.setLocation(200,200);

            //设置 大小固定
            frame.setResizable(false);

        }
    }
    ```

    效果：（其中 没有 关闭功能）

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%205.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%205.png)

### 实现多个frame

- 这里思想很重要！
    - 上面定义了某一个frame, 这里 再定义一个MyFrame继承于 Frame就好
    - MyFrame除了Constructor外还有一个static id=0; 这个东西是 只运行一次，随后 new的 时候不再运行，只运行Constructor了（解释++id）
    - 注意，在MyFrame构造器中设置初始值
        - 创立 编号
        - 根据input 个性化创立frame
    - 因为继承了 父类，父类的方法直接使用，不需要加`frame.`了(不是特别懂)
- 代码

    ```java
    package com.kaitan.lesson01;

    import java.awt.*;

    public class TestFrame2 {
        public static void main(String[] args) {
            //display multiple windows
            new MyFrame(100,100,200,200,Color.blue);
            new MyFrame(300,100,200,200,Color.yellow);
            new MyFrame(100,300,200,200,Color.red);
            new MyFrame(300,300,200,200,Color.MAGENTA);
        }
    }

    class MyFrame extends Frame {
        static int id = 0;//可能多个窗口，所以需要计数器

        public MyFrame(int x, int y, int w, int h, Color color) throws HeadlessException {
            super("Myframe"+(++id)); //每次new 新建id +1

            setBounds(x,y,w,h);
            setVisible(true);
            setBackground(color);

        }
    }
    ```

![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%206.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%206.png)

## Panel面板

- [ ]  [P4、Panel面板讲解11:02](https://www.bilibili.com/video/BV1DJ411B75F?p=4)

### Panel面板

- 不能单独存在，要放在frame上
- 属于容器里面的（继承于 container类）可以看成一个空间
- Panel相当于 从frame中分出来的 一部分 区间

### 代码实现

- panel类 继承于 container类
- panel和frame属性操作类似，都可以添加 大小，颜色，注意其中的 位置 是相对于frame走的

    ```java
    package com.kaitan.lesson01;

    import java.awt.*;

    public class TestPanel {
        public static void main(String[] args) {
            Frame frame = new Frame();
            Panel panel = new Panel(); // 涉及Layout 的 概念

            frame.setLayout(null); //set Layout
            frame.setBounds(300,300,500,500);
            frame.setBackground(new Color(238, 250, 125));

            //set panel，相对于 frame
            panel.setBounds(50,50,400,400);
            panel.setBackground(new Color(215, 215, 215, 79));

            //把panel放到 frame上
            frame.add(panel);

            frame.setVisible(true);

        }
    }
    ```

- 通过`frame.add(panel);` 将panel放到frame中(panel继承于 container, 而这里要求intput container,所以可以)

![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%207.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%207.png)

### 监听事件添加

- 想要 实现关闭功能：需要添加frame层级的 Listener
- `frame.addWindowListener()` 中 要填入 `WindowListener`,但是这个对象涉及 一些列需要重写的 方法，如下

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%208.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%208.png)

- 上面 全部要重写 太麻烦，可以使用 适配器（`WindowAdapter`） 单独重写 某一个 方法

    如下，可以选择自己想重写的 方法

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%209.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%209.png)

- 如下，选择 `windowClosing`之后 自动出现 重写 模板

    ```java
    frame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                }
            })；
    ```

- 如下 改写 需要执行的内容：`System.exit(0);` 正常关闭（如果input status =1是 异常关闭）

    ```java
    frame.addWindowListener(new WindowAdapter(){
                //窗口点击 关闭 需要做的事情
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    ```

## 布局管理器

- [ ]  [P5、3种布局管理器15:56](https://www.bilibili.com/video/BV1DJ411B75F?p=5)

### 3种Layout布局

- FlowLayout流式 布局
- 东西南北中
- 表格

### FlowLayout

- `frame.setLayout(new FlowLayout());` //点进去，看到默认 this(CENTER, 5, 5);

    如下，frame上 自动 添加的3个button自动排列在中间

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2010.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2010.png)

    ```java
    package com.kaitan.lesson01;

    import java.awt.*;

    public class TestFlowLayout {
        public static void main(String[] args) {
            Frame frame = new Frame();

            //Component-按钮 button
            Button button1 = new Button("button1");
            Button button2 = new Button("button2");
            Button button3 = new Button("button3");

            frame.setLayout(new FlowLayout()); //点进去，看到默认 this(CENTER, 5, 5);
            frame.setSize(200,200);

            //添加 按钮 （panel也能添加）
            frame.add(button1);
            frame.add(button2);
            frame.add(button3);

            frame.setVisible(true);
        }
    }
    ```

- 可以移到左边

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2011.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2011.png)

### 东西南北中`BoarderLayout`

- 在Frame种添加内容时，可以规定 放在哪里，如`frame.add(east,BorderLayout.EAST);`

    ```java
    package com.kaitan.lesson01;
    import java.awt.*;

    public class TestBoarderLayout {
        public static void main(String[] args) {
            Frame frame = new Frame("TestBorderLayout");

            Button east = new Button("East");
            Button west = new Button("West");
            Button south = new Button("South");
            Button north = new Button("North");
            Button center = new Button("Center");

            frame.add(east,BorderLayout.EAST);
            frame.add(west,BorderLayout.WEST);
            frame.add(south,BorderLayout.SOUTH);
            frame.add(north,BorderLayout.NORTH);
            frame.add(center,BorderLayout.CENTER);

            frame.setSize(200,200);
            frame.setVisible(true);
        }
    }
    ```

- 比较丑，一般 在这个基础继续增加 layout结构

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2012.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2012.png)

### GridLayout

- 表格Layout
- `frame.pack();` java函数，自动选择好 布局
- `frame.setLayout(new GridLayout(3,2,1,1));`
参数为`GridLayout(int rows, int cols, int hgap, int vgap)`

    ```java
    package com.kaitan.lesson01;

    import java.awt.*;

    public class TestGridLayout {
        public static void main(String[] args) {
            Frame frame = new Frame("TestGridLayout");

            Button btn1 = new Button("btn1");
            Button btn2 = new Button("btn2");
            Button btn3 = new Button("btn3");
            Button btn4 = new Button("btn4");
            Button btn5 = new Button("btn5");
            Button btn6 = new Button("btn6");

            frame.setLayout(new GridLayout(3,2,1,1));

            frame.add(btn1);
            frame.add(btn2);
            frame.add(btn3);
            frame.add(btn4);
            frame.add(btn5);
            frame.add(btn6);
            frame.setSize(600,600);

            //frame.pack();//java函数，自动选择好的 布局
            frame.setVisible(true);

        }
    }
    ```

- 效果图

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2013.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2013.png)

## 练习-小结

- [ ]  [P6、课堂练习讲解及总结14:56](https://www.bilibili.com/video/BV1DJ411B75F?p=6)

### 作业题

- 题目

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2014.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2014.png)

- 思路： 上下 可以用2*1Grid，每个分别对应一个面板，上下两个面板可以用Boarder分为 west, center, east，中间 的块 又可以 使用 GridLayout的 Panel完成

### 我的 答案

- 架构是对的，但是 版式不太对

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2015.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2015.png)

    ```java
    package com.kaitan.lesson01;

    import java.awt.*;

    public class LayoutExercise {
        public static void main(String[] args) {
            Frame frame = new Frame();

            Button b1 = new Button("b1");
            Button b2 = new Button("b2");
            Button b3 = new Button("b3");
            Button b4 = new Button("b4");
            Button b5 = new Button("b5");
            Button b6 = new Button("b6");
            Button b7 = new Button("b7");
            Button b8 = new Button("b8");
            Button b9 = new Button("b9");
            Button b0 = new Button("b0");

            frame.setLayout(new GridLayout(2,1));

            Panel p1 = new Panel();
            Panel p2 = new Panel();
            Panel p3 = new Panel();
            Panel p4 = new Panel();

            p1.setLayout(new GridLayout(2,1));
            p1.add(b1);
            p1.add(b2);

            p2.add(b3,BorderLayout.EAST);
            p2.add(p1,BorderLayout.CENTER);
            p2.add(b4,BorderLayout.WEST);

            p3.setLayout(new GridLayout(2,2));
            p3.add(b5);
            p3.add(b6);
            p3.add(b7);
            p3.add(b8);

            p4.add(b9,BorderLayout.EAST);
            p4.add(p3,BorderLayout.CENTER);
            p4.add(b0,BorderLayout.WEST);

            frame.setSize(500,800);
            frame.add(p2);
            frame.add(p4);

            frame.pack();
            frame.setVisible(true);
        }
    }
    ```

### 标答

- 我的 错误只有一点: 在放入Border之前，
    - 要先setLayout:`Panel p2 = new Panel(new BorderLayout());`
    - 然后再放
    `p2.add(b3,BorderLayout.EAST);
    p2.add(p1,BorderLayout.CENTER);
    p2.add(b4,BorderLayout.WEST);`

        ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2016.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2016.png)

- 标答代码

    ```java
    package com.kaitan.lesson01;

    import java.awt.*;

    public class LayoutExercise {
        public static void main(String[] args) {
            Frame frame = new Frame();

            Button b1 = new Button("b1");
            Button b2 = new Button("b2");
            Button b3 = new Button("b3");
            Button b4 = new Button("b4");
            Button b5 = new Button("b5");
            Button b6 = new Button("b6");
            Button b7 = new Button("b7");
            Button b8 = new Button("b8");
            Button b9 = new Button("b9");
            Button b0 = new Button("b0");

            frame.setLayout(new GridLayout(2,1));

            Panel p1 = new Panel();
            Panel p2 = new Panel(new BorderLayout());
            Panel p3 = new Panel();
            Panel p4 = new Panel(new BorderLayout());

            p1.setLayout(new GridLayout(2,1));
            p1.add(b1);
            p1.add(b2);

            p2.add(b3,BorderLayout.EAST);
            p2.add(p1,BorderLayout.CENTER);
            p2.add(b4,BorderLayout.WEST);

            p3.setLayout(new GridLayout(2,2));
            p3.add(b5);
            p3.add(b6);
            p3.add(b7);
            p3.add(b8);

            p4.add(b9,BorderLayout.EAST);
            p4.add(p3,BorderLayout.CENTER);
            p4.add(b0,BorderLayout.WEST);

            frame.setSize(500,800);
            frame.add(p2);
            frame.add(p4);

            frame.pack();
            frame.setVisible(true);
        }
    }
    ```

## 事件监听

- [ ]  [P7、事件监听16:54](https://www.bilibili.com/video/BV1DJ411B75F?p=7)

### 事件监听

- 即 某件事情发生时，做什么

### Button的 监听事件-点击后会发生什么

- 使用`button.addActionListener()`时 发现 里面要填入`ActionListener`
- 第一个办法是 填 `AbstractAction`
    - 如果new `AbstractAction` 的话，还要填写具体方法

        如下

        ```java
        package com.kaitan.lesson02;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

        public class TestActionEvent {
            public static void main(String[] args) {
                //按钮-触发事件
                Button b1= new Button();
                Frame frame = new Frame();

                b1.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
            }
        }
        ```

- 第二种方法，可以自定义`ActionListener`

    从接口ActionListener承接 定义了 自己的 MyActionListener，并定义了点button之后触发的功能：

    ```java
    package com.kaitan.lesson02;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class TestActionEvent {
        public static void main(String[] args) {
            //按钮-触发事件
            Button b1= new Button("Button");
            Frame frame = new Frame();

            //因为需要一个ActionListener所以我们构造了一个ActionListener
            MyActionListener l1 = new MyActionListener();
            b1.addActionListener(l1);

            frame.add(b1,BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);

        }
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Touched Button");
        }
    }
    ```

- 可以定义一个用来设置 关闭window的 方法

    ```java
    private static void windowClose(Frame frame){
            frame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }
    ```

### 如果实现多个 button 同一个 ActionListener

- 如下，从ActionListener接口 承接的 MyMonitor可以用在 多个button（b1, b2）
- 原理就是，ActionListener 接口 定义的 input时 `ActionEvent e` 而从这个`e` 可以调出 对应的 睡事件command，
    - 如 button对应的 `e.getActionCommand()` 显示的 就是该button的 名字
    - 如果不想默认 值，可以设置command, 如`b2.setActionCommand("button2-stop");`
- 通过 读取`e.getActionCommand()` 返回值，可以知道目前是哪个button的action event，然后 用if else实现 多个button的 具体功能，这样就不用每个button都写一个ActionListener了

    ```java
    package com.kaitan.lesson02;

    import com.kaitan.lesson01.TestBoarderLayout;

    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class TestAction2 {
        public static void main(String[] args) {
            //连个button, 同一个监听
            Frame frame = new Frame("start-stop");
            frame.setVisible(true);
            Button b1 = new Button("start");
            Button b2 = new Button("stop");

            //b1.addActionListener(new ActionListener());
            //b2.setActionCommand("button2-stop");

            MyMonitor myMonitor = new MyMonitor();
            b1.addActionListener(myMonitor);
            b2.addActionListener(myMonitor);

            frame.add(b1, BorderLayout.NORTH);
            frame.add(b2,BorderLayout.SOUTH);
            frame.pack();
        }
    }

    class MyMonitor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("touched button: msg->"+e.getActionCommand());
            if(e.getActionCommand()=="start"){
                System.out.println("Just started");
            }
        }
    }
    ```

## 输入框 事件监听

- [ ]  [P8、输入框事件监听09:45](https://www.bilibili.com/video/BV1DJ411B75F?p=8)

### 书写规范

- 一般 公司要求，main里面只有 启动 的 代码
- 其他的 都定义在 下面的 class里
- 特殊注意，继承之后，方法 不需要在写前面的 `***.`了，因为 目前属于 class里（之所以需要Object.Fun是因为 不明现在是 哪类）

### 输入框

- 输入框是`TextField`
- 输入框通过enter来 触发 事件
- `textField.setEchoChar('*');` 可以设置 输入者 看到的 都是 *，但后台保留了 正确的数据（密码输入 的 应用）
- Listener中， 可以通过`TextField  field= (TextField) e.getSource();`  来 储存text
- Listener中， 可以通过`field.setText("");` 把 输入框 情况

```java
package com.kaitan.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText1 {
    public static void main(String[] args) {
        //一般 都只有 一行：启动
        new MyFrame();
    }

}

class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        //监听文本框输入的 文字
        MyActionListener2 l2=new MyActionListener2();
        //按下enter 触发 输入框的 事件
        textField.addActionListener(l2);

        //设置 替换编码
        textField.setEchoChar('*');

        setVisible(true);
        pack();
    }

}

class MyActionListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField  field= (TextField) e.getSource(); //获得source, 返回了一个对象Object, 可以转成任何 一类
        System.out.println(field.getText());
        field.setText("");
    }
}
```

## 计算器

- [ ]  [P9、简易计算器、回顾组合内部类21:10](https://www.bilibili.com/video/BV1DJ411B75F?p=9)

### 组合

- 组合优于 继承

    下面的就是组合（A里 也可以用B的东西）

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2017.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2017.png)

### 计算器

- main方法的 时候只要new就可以了
- new 就可以，是因为 Calculator类为Frame，而且 都是在contructor内执行了
- 构思计算器：[TextField1] + [TextField2] = [TextField3]
    - TextField1, TextField2，要传给 程序 （`Integer.parseInt(num1.getText());`）
    - +：是一个Label 标签（即 不变的 text, 提示用户用）
    - =：一个Button，用于 trigger event（计算，更新到 TextField3，清除TextField1，TextField2）
    - 顺序，所以是FlowLayout `setLayout(new FlowLayout());`
- 监听器Listener构造:
    - 操作对象是TextField1，TextField2，TextField3，所以可以 设置3个attribute对应他们3个，而且可以通过 有参构造器 传入 这3个 TextField
    - 重写`actionPerformed` ，作用在Button上，
        - 可以通过 `num1.getText()` 抓当前TextField里面的 text
        - 可以通过`num3.setText(""+(n1+n2))` 设置 trigger之后的 文字

    ```java
    package com.kaitan.lesson02;

    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    //简易计算器
    public class TestCal {
        public static void main(String[] args) {
            new Calculator();
        }
    }

    //计算器类（frame）
    class Calculator extends Frame{
        public Calculator(){
            //3个文本框
            TextField num1 = new TextField(10);
            TextField num2 = new TextField(10);
            TextField num3 = new TextField(20);

            //1个 button
            Button button = new Button("=");
            button.addActionListener(new MyCalListener(num1,num2,num3));

            //1个 标签label
            Label label = new Label("+");

            //label
            setLayout(new FlowLayout());

            add(num1);
            add(label);
            add(num2);
            add(button);
            add(num3);

            pack();
            setVisible(true);
        }
    }

    //监听器类
    class MyCalListener implements ActionListener {
        //获取 3 个 变量
        private TextField num1,num2,num3;
        public MyCalListener(TextField num1, TextField num2, TextField num3){
            this.num1 = num1;
            this.num2 = num2;
            this.num3= num3;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //获得 两个 加数
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

            // 做 加法
            num3.setText(""+(n1+n2));

            //清除 前两个框的 数
            num1.setText("");
            num2.setText("");

        }
    }
    ```

### 优化代码使更符合 面向对象

- 构造Calculator: `class Calculator2 extends Frame`
    - 注意，我没有写extends Frame, 而是 定义了自己的frame,明显不对
    - 书写规范：先定义attribute(一定要定义，要不无法调用),然后 定义一个 方法来构建frame
    - 这个方法：先写components，然后写组装部分
- 构造ActionListener:
    - 用组合的思想，直接传进来一个Calculator类 就好了！ 就不用 一个一个attribute导入了
    - 所以 定义一个Calculator的 attribute然后 传进来Calculator就好了
    - 然后 Overrite时，直接用Calculator的 attribute来处理就好了，比如

        `calculator.num1.getText()`

        `calculator.num1.setText()`

    ```java
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
    ```

- 注意 下面两个等价的：
    - method 1

        ```java
        Calculator2 c2 = new Calculator2();
        c2.loadFrame();
        ```

    - method 2

        ```java
        new Calculator2().loadFrame();
        ```

### 内部类-优化代码

- 注意，如果分别 写两个类Calculator, trigger,则还是需要把Calculator传给trigger,如果直接把trigger放在Calculator里面的话，trigger直接能访问到Calculator！（内部类）
    - 如下，直接调用`num1.setText("");`就行，不用再`calculator.num1.setText("");`了
    - trigger的 有参构造 也不需要了

    ```java
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
    ```

## 画笔

- [ ]  [P10、画笔paint09:45](https://www.bilibili.com/video/BV1DJ411B75F?p=10)

### 画笔paint方法

- Frame中有  对应的 paint 方法
- paint 方法可随Frame 出现而自动 运行，即可在无trigger时，Frame显示 的瞬间 已完成 绘图，如下

    ```java
    package com.kaitan.lesson03;

    import java.awt.*;

    public class TestPaint {
        public static void main(String[] args) {
            new MyPaint().loadFrame();
        }
    }

    class MyPaint extends Frame {

        public void loadFrame(){
            setBounds(200,200,600,500);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            //super.paint(g);
            g.setColor(Color.red);
            g.drawOval(100,100,100,100);
            g.fillOval(300,300,100,100);

            g.setColor(Color.GREEN);
            g.fillRect(150,200,100,50);

            // paint画完 要还原成最初的 颜色   
        }

    ```

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2018.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2018.png)

- paint画完 要还原成最初的 颜色

## 鼠标监听

- [ ]  [P11、鼠标监听事件、模拟画图工具20:42](https://www.bilibili.com/video/BV1DJ411B75F?p=11)

### 构建思路：鼠标画画（目标）

- 画板中 有Paint方法，进行绘制
- Frame上也添加了 mouse监听
- 重点，把每次 监听到的 mouse点 存到一个 集合里
- 一旦 mouse监听到 任何press变动，repaint 所有集合里的 点，（视觉上 只能看到 增加的 点）

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2019.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2019.png)

### 代码构思

- main方法：一行简单的执行
    - `new MyFrame("Drawing");`
- `MyFrame extends Frame{}`中
    - 所有方法都公用 的 一个attribute-点的集合: `ArrayList points;`
    - 构造方法：生成Frame，初始化点的 集合，添加MouseListener
    - 重写frame带的 paint 方法：将集合中的点 依次paint出来 （本身是 随frame生成时，自动执行，那个时候集合为空，所以不显示，之后 通过listener的repaint(）反复调用这一函数
    - addPoint函数：将某点 添加到 集合points里
    - MyMouseListener ：识别 当下鼠标press时的 点，然后把 点放到集合里，虽后 调用repaint 把 集合中的 所有点 重新再度输出

```java
package com.kaitan.lesson03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("Drawing");
    }
}

class MyFrame extends Frame{
    //画画 需要 画笔，需要监听鼠标现在的 位置，需要集合来 存储这个点

    //存 鼠标的 点: 集合attribute声明
    ArrayList points;

    //Constructor：具体 实施
    public MyFrame(String title) {
        super(title);
        setBounds(200,200,400,300);
        setVisible(true);

        //存鼠标的 点
        points = new ArrayList<>();

        //鼠标监听器 是针对这个 窗口的，而不是 像 button, FieldText
        this.addMouseListener(new MyMouseListener());

    }

    //重写 Painter
    @Override
    public void paint(Graphics g) {
        //监听鼠标的 事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.BLUE);
            g.fillOval(point.x,point.y,10,10); //画小圆
        }
    }

    //添加一个点(MyMouseListener识别出来的 点) 到界面（即上面的 points集合）
    public void addPoint(Point point){
        points.add(point);
    }

    // Mouse Monitor-对应 添加 到 Frame上的 addMouseListener
    private class MyMouseListener extends MouseAdapter {//MouseListener所有Abstract都要 写，所以改成Adapter
        //鼠标点击 (可以 有 按住不妨，)
        @Override
        public void mousePressed(MouseEvent e) {
            MyFrame frame = (MyFrame)e.getSource(); //这里 是用 frame来 addMouseListener,所以返回的 可以转成frame格式

            //这里点击时候，就会在 界面上产生一个点，所以这里要先获取 鼠标坐标点
            addPoint(new Point(e.getX(),e.getY()));

            //每次点击 都要重画一遍
            frame.repaint();
        }
    }

}
```

## 窗口监听

- [ ]  [P12、窗口监听事件09:59](https://www.bilibili.com/video/BV1DJ411B75F?p=12)

### 点关闭，就隐藏 的 例子：

```java
package com.kaitan.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        addWindowListener(new MyWindowListener());

    }

    class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false);//隐藏窗口，通过按钮，隐藏窗口
            //System.exit(0);//程序结束，正常退出（非正常，把0变成1）
        }
    }
}
```

### 优化之前的代码

- 直接在`addWindowListener`中`new WindowAdapter(){}` （匿名内部类）就好了，如下
- 注意 `WindowAdapter` 中 比较有用的 就是Activated，和 closing

```java
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

```

## 键盘监听

- [ ]  [P13、键盘监听事件08:05](https://www.bilibili.com/video/BV1DJ411B75F?p=13)

### 键盘监听

- 也是在Frame层面上， `addKeyListener(new KeyAdapter(){})` 就好
- 注意使用`int keyCode = e.getKeyCode()`提取按下的 按键
- java内部 对 每一个按键有 个 静态属性，如↑键为：`KeyEvent.VK_UP`

```java
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
```

## Swing-JFrame

- [ ]  [P14、Swing之JFrame窗体13:29](https://www.bilibili.com/video/BV1DJ411B75F?p=14)

### JFrame

- JFrame继承于Frame，所以 基础方法都是一样的
- JFrame 上面都要有 container，通过`Container container = jf.getContentPane();` 从JFrame中 建立出container
- 注意，操作container就行，有时直接操作JFrame没用（比如`jf.setBackground(Color.CYAN)`）
- JFrame有更多更优功能：
    - `jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);` 直接设置 关闭键（共有4种操作方式，`WindowConstants.EXIT_ON_CLOSE` 是其中一种）
    - label在Swing中是JLabel：`JLabel label = new JLabel("Welcome to the window");`
    - 可以设置 Label的 位置：`label.setHorizontalAlignment(SwingConstants.LEFT);`
- 更贴近production的 编程方式：
    - 写一个Init()函数
    - 然后main函数 调用init()函数

```java
package com.kaitan.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {

    //init 方法，初始化
    public void init(){

        //顶级窗口
        JFrame jf = new JFrame("This is a Jframe Window");
        jf.setVisible(true);
        jf.setBounds(100,100,200,200);
        //jf.setBackground(Color.CYAN);//not working
        //关闭 event
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置文字 JLabel
        JLabel label = new JLabel("Welcome to the window");
        label.setHorizontalAlignment(SwingConstants.LEFT);

        //所有东西放在 容器里面，容器需要实例化
        Container container = jf.getContentPane();
        container.setBackground(Color.YELLOW);
        container.setBounds(10,10,200,300);
        container.setVisible(true);
        container.add(label);
        

    }
    public static void main(String[] args) {
        //建立一个窗口
        new JFrameDemo().init();
    }
}
```

### AWT-Swing

- Swing画图更好看，功能更强大
- 之前都是AWT
- 从这里之后都是Swing

## JDialog

- [ ]  [P15、JDialog弹窗11:29](https://www.bilibili.com/video/BV1DJ411B75F?p=15)

### 弹窗

- JDialog跟 event绑定：
    - 如下，可以跟button绑定，用button触发弹窗
    - JDialog.getContentPane 可以绑定container,然后跟Frame的设置基本是一样的
    - 注意`setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);`没必要重复设定，否则会报错

```java
package com.kaitan.lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主窗口
public class DiaglogDemo extends JFrame {

    public DiaglogDemo(){
        setVisible(true);
        setSize(700,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //container
        Container container = getContentPane();
        container.setLayout(null); //绝对布局

        JButton button = new JButton("点击弹出一个对话框");
        button.setBounds(30,30,200,50);//绝对布局下，直接 相对 对话框 定位就行

        container.add(button);
        container.setVisible(true);

        //点击按钮的时候，需要弹出 另外一个弹窗，需要监听事件
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialogDemo();
            }
        });
    }

    public static void main(String[] args) {
        new DiaglogDemo();
    }
}

class MyDialogDemo extends JDialog{
    public MyDialogDemo(){
        setVisible(true);
        setBounds(100,100,500,500);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.add(new JLabel("Welcome to the new Window"));
    }
}
```

## Icon, ImageIcon

- [ ]  [P16、Icon、ImageIcon标签17:16](https://www.bilibili.com/video/BV1DJ411B75F?p=16)

### Label

`new JLabel("xxx");`

### 画一个Icon 放在label上：

- 既实现JFrame又实现 Icon接口:`public class IconDemo extends JFrame implements Icon`
- `implements Icon` 即需要填写 Icon相关指定 方法：手画时，指定画什么，在哪儿画
- 然后把 画好的 Icon放进Label：`JLabel label = new JLabel("icontest",iconDemo,SwingConstants.CENTER);`

```java
package com.kaitan.lesson04;

import javax.swing.*;
import java.awt.*;

//Icon是接口，需要实现类，Frame继承
public class IconDemo extends JFrame implements Icon {

    private int width;
    private int height;

    public IconDemo(){};

    public IconDemo(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void init(){
        IconDemo iconDemo = new IconDemo(15,15);

        //图标 可以放在 button/标签上
        JLabel label = new JLabel("icontest",iconDemo,SwingConstants.CENTER);
        Container container = getContentPane();
        container.add(label);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new IconDemo().init();
    }

		//Icon 方法
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
```

### 插入一个图片

- 使用`ImageIconDemo.class.getResource("example_jpg.jpg");` 找到 同class 地址下 的 jpg文件url
- 然后根据这个url 找到jpg并 放进label `ImageIcon imageIcon = new ImageIcon(url); label.setIcon(imageIcon);`

```java
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
```

## Jscroll

- [ ]  [P17、文本域JScroll面板10:21](https://www.bilibili.com/video/BV1DJ411B75F?p=17)

### JPanel

- JPanel和Panel基本一样
- JPanel添加到 Container里

    ```java
    package com.kaitan.lesson05;

    import javax.swing.*;
    import java.awt.*;

    public class JPanelDemo extends JFrame {

        public static void main(String[] args) {

            new JPanelDemo();
        }

        public JPanelDemo(){
            Container container = this.getContentPane();
            container.setLayout(new GridLayout(2,1,10,10));
            JPanel panel1 = new JPanel(new GridLayout(1,3));
            panel1.add(new JButton("1"));
            panel1.add(new JButton("1"));
            panel1.add(new JButton("1"));

            JPanel panel2 = new JPanel(new GridLayout(2,2));
            panel2.add(new JButton("4"));
            panel2.add(new JButton("3"));
            panel2.add(new JButton("2"));
            panel2.add(new JButton("1"));

            container.add(panel1);
            container.add(panel2);

            this.setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(500,500);

        }
    }
    ```

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2020.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2020.png)

### 把`TextArea`放到`JScrollPane` 实现滚动边框

- `JTextArea textArea = new JTextArea(20,50);` TextArea就是能输入的 文本框，20，50为能输入的 字符数
    - 将 出框的 JTextArea 放进JScrollPane：`JScrollPane scrollPane = new JScrollPane(textArea);`
    - 再把 JScrollPane添加到Container就好！

    ```java
    package com.kaitan.lesson05;

    import javax.swing.*;
    import java.awt.*;

    public class JScrollDemo extends JFrame {
        public JScrollDemo(){
            Container container = this.getContentPane();

            JTextArea textArea = new JTextArea(20,50);
            textArea.setText("Welcome to the text box");

            JScrollPane scrollPane = new JScrollPane(textArea);
            container.add(scrollPane);

            setBounds(100,100,300,350);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }

        public static void main(String[] args) {
            new JScrollDemo();
        }
    }

    ```

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2021.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2021.png)

## 图片按钮、单选框、多选框

- [ ]  [P18、图片按钮、单选框、多选框14:26](https://www.bilibili.com/video/BV1DJ411B75F?p=18)

### 图片按钮

- `button.setIcon(icon);`

```java
package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo01 extends JFrame {

    public JButtonDemo01(){
        Container container = getContentPane();
        URL url = JButtonDemo01.class.getResource("example_jpg.jpg");
        Icon icon = new ImageIcon(url);

        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("jpg button");

        container.add(button);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
```

### 单选框`JRadioButton`

- 每个button本身可以独立选中
- 但如果 想实现 多选1的 效果，需要添加分组，每组里选一个

    ```java
    package com.kaitan.lesson05;

    import javax.swing.*;
    import java.awt.*;
    import java.net.URL;

    public class JButtonDemo02 extends JFrame {

        public JButtonDemo02(){
            Container container = getContentPane();
            URL url = JButtonDemo01.class.getResource("example_jpg.jpg");
            Icon icon = new ImageIcon(url);

            JRadioButton radioB1 = new JRadioButton();
            JRadioButton radioB2 = new JRadioButton();
            JRadioButton radioB3 = new JRadioButton();

            //单选框，不能同时选择，一般分组，一组只能选1个
            ButtonGroup g1 = new ButtonGroup();
            g1.add(radioB1);
            g1.add(radioB2);
            g1.add(radioB3);

            container.add(radioB1,BorderLayout.NORTH);
            container.add(radioB2,BorderLayout.CENTER);
            container.add(radioB3,BorderLayout.SOUTH);
            setVisible(true);
            setSize(500,300);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        public static void main(String[] args) {
            new JButtonDemo02();
        }
    }
    ```

### 多选框-`JCheckBox()`

```java
package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo03 extends JFrame {

    public JButtonDemo03(){
        Container container = getContentPane();
        URL url = JButtonDemo01.class.getResource("example_jpg.jpg");
        Icon icon = new ImageIcon(url);

        JCheckBox check1 = new JCheckBox();
        JCheckBox check2 = new JCheckBox();
        JCheckBox check3 = new JCheckBox();

        container.add(check1,BorderLayout.NORTH);
        container.add(check2,BorderLayout.CENTER);
        container.add(check3,BorderLayout.SOUTH);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
```

## 下拉框，列表框

- [ ]  [P19、下拉框、列表框09:48](https://www.bilibili.com/video/BV1DJ411B75F?p=19)

### 下拉框 `JComboBox()`

- 直接在里面添加选项

    ```java
    JComboBox status = new JComboBox();
    status.addItem(null);
    status.addItem("To do");
    status.addItem("In progress");
    status.addItem("Completed");
    ```

    ```java
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
    ```

    ![%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2022.png](%E3%80%90%E7%8B%82%E3%80%91GUI%E7%AC%94%E8%AE%B0%20a1cd99f06d0040559a6228505c13c912/Untitled%2022.png)

### 通过数组 放列表 `JList`

- 将数组 放入`JList l1 = new JList(contents);`

```java
package com.kaitan.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestComboBoxDemo02 extends JFrame{
    public TestComboBoxDemo02(){

        Container container = getContentPane();

        //生成 列表的内容
        String[] contents = {"1","2","3"};
        //List中放内容
        JList l1 = new JList(contents);
        container.add(l1);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboBoxDemo02();
    }
}
```

### Vector放进 `JList`

- 注意：因为是引用对象，可以 先将vector 添加到 JList 然后再 添加vector的 content
`JList l1 = new JList(v1);
container.add(l1);
v1.add("kaitan");
v1.add("Jessy");`

    ```java
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
    ```

### 应用场景

- 选择 地区，或者 单个选项 时， 使用 列表
    - 如果只有两个选项 则优先 选择 单选按钮
- 列表，展示信息，动态扩容

## 文本框，密码框，文本域

- [ ]  [P20、文本框、密码框、文本域06:34](https://www.bilibili.com/video/BV1DJ411B75F?p=20)

### 文本框`JTextField`

- `JTextField t2 = new JTextField("world",20);` 20设定文本框长度

```java
package com.kaitan.lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){

        Container container = getContentPane();

        JTextField t1 = new JTextField("hello");
        JTextField t2 = new JTextField("world",20);

        container.add(t1,BorderLayout.NORTH);
        container.add(t2,BorderLayout.SOUTH);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
```

### 密码框`JPasswordField`

```java
package com.kaitan.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo03 extends JFrame {
    public TestTextDemo03(){

        Container container = getContentPane();

        JPasswordField p1 = new JPasswordField();
        p1.setEchoChar('*');
        container.add(p1);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo03();
    }
}
```

### 文本域`JTextArea`

- 配合`JScrollPane`使用

```java
package com.kaitan.lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        Container container = this.getContentPane();

        JTextArea textArea = new JTextArea(20,50);
        textArea.setText("Welcome to the text box");

        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);

        setBounds(100,100,300,350);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
```

### Java, C++

- Java是 B/S: Browser浏览器 + server
- C++是 C/S: Client客户端+server

## 贪吃蛇界面

- [ ]  [P21、贪吃蛇之界面绘制18:57](https://www.bilibili.com/video/BV1DJ411B75F?p=21)
- [ ]  [P22、绘制静态的小蛇15:27](https://www.bilibili.com/video/BV1DJ411B75F?p=22)
- [ ]  [P23、让小蛇动起来05:27](https://www.bilibili.com/video/BV1DJ411B75F?p=23)
- [ ]  [P24、键盘控制小蛇移动14:26](https://www.bilibili.com/video/BV1DJ411B75F?p=24)
- [ ]  [P25、小蛇吃食物长大04:46](https://www.bilibili.com/video/BV1DJ411B75F?p=25)
- [ ]  [P26、失败判定，积分系统14:03](https://www.bilibili.com/video/BV1DJ411B75F?p=26)

### 概念

- 小蛇动 是 动画，一秒可能24帧（动画），30帧，60帧

### 增加功能

- 定义数据
- 画上去
- 事件监听
    - 键盘
    - 事件

### 构思java架构

建立一个package, 包含以下 files:

- Data.java, 从satics加载ImageIcon
- StartGame.java, 执行启动游戏
- GamePanel.java,定义 游戏Panel,包含实际代码
- statics folder：里面含有 贪吃蛇 身体，头 等 图标

### Data.java

- 从satics加载ImageIcon
    - 绝对路径 / 相当于当前的 项目 的 root directory(src下)

```java
package com.kaitan.snake;

import javax.swing.*;
import java.net.URL;

public class Data {
		//绝对路径 / 相当于当前的 项目
    public static URL headerURL = Data.class.getResource("/statics/header.png"); 
    public static URL downURL = Data.class.getResource("/statics/down.png"); 
    public static URL upURL = Data.class.getResource("/statics/up.png");
    public static URL rightURL = Data.class.getResource("/statics/right.png"); 
    public static URL leftURL = Data.class.getResource("/statics/left.png"); 
    public static URL foodURL = Data.class.getResource("/statics/food.png"); 
    public static URL bodyURL = Data.class.getResource("/statics/body.png"); 

    public static ImageIcon header = new ImageIcon(headerURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon right = new ImageIcon(rightURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon food = new ImageIcon(foodURL);
    public static ImageIcon body = new ImageIcon(bodyURL);
}
```

### StartGame.Java

- 就是 新建JFrame，然后在上面new一个GamePanel(自己写好的)
- 设置JFrame，然后`frame.setVisible(true);` （注意，这个必须写在最后）

```java
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
```

### GamePanel.java

- 定义GamePanel （JPanel）,同时自身实现了接口KeyListener, ActionListener(定义了其方法)
- 组成要件
    - Attribute: 贪吃蛇 长度，蛇的位置序列snakeX, snakeY, 当前 朝向， 当前游戏是否进行状态，食物坐标，分数，随机数，timer(多久执行一次)
    - 构造器：执行了init()函数，和 只执行一次就好的：获得 游戏焦点，添加键盘Listener `addKeyListener(this);` ， `timer.start();`
    - init()函数 - 新开始游戏/游戏重玩 所执行的 代码：重新定位蛇的 位置，方向，初始化food位置，清零积分
    - 重写Paint函数，初始化时，和每次repaint时 绘制 `protected void paintComponent(Graphics g)`
        - 清屏
        - 静态面板：广告栏，游戏框界面，背景颜色
        - 根据 蛇头 位置，方向，画蛇头
        - 根据 蛇 身体位置 画身体
        - 根据现在 积分 画 分数
        - 根据现在 游戏 是否 进行中 画提示符"按下空格开始游戏"
        - 根据游戏是否失败，画提示符 "失败，按空格重新开始，得分："
        - 根据食物位置 画食物
    - KeyListener相关方法定义
        - space：如果在失败时 按 空格，则isFail重置，init（）初始化；如果在 游戏未失败时 按空格，可以通过 切换 isStart 状态（暂停）
        - 方向键：改变 蛇头方向参数
    - 事件监听ActionListener，即判断 发生了 什么情况，然后如何处理
        - 如果食物位置==蛇头位置，说明吃到了食物，此时 蛇身 增长一格，食物重新 随机 放到 下一个位置，分数+1
        - 如果 为失败，且 运行中，则蛇进行移动：
            - 蛇身体 后一格 移到 前一格位置
            - 头部：根据 所前进的 方向，前进一格，如果碰到边界，则设定位置到 墙的 另一侧
            - 如果 蛇头 等于 身体 任何一个位置（撞到自己），则判断始排（isFail）
            - repaint图
        - timer开始 `timer.start();` 目前理解：之前定义的是： `Timer timer = new Timer(100,this)` 每隔100毫秒（1/10秒）就执行一次this，直接直接影响ActionListener的 管控 间距，所以 是100毫秒 前进一格，可以控制蛇前进的速度

    ```java
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
    ```

## GUI回顾

- [ ]  [P27、GUI阶段回顾与总结05:58](https://www.bilibili.com/video/BV1DJ411B75F?p=27)

### GUI编程

1. GUI编程
2. AWT
    - 组件
    - 容器
    - 面板
    - 监听事件
        - Action
        - 文本框
        - 画图Paint
        - 鼠标
        - 窗口
        - 键盘
3. Swing
    - 容器
    - 面板-可以带滚动条
    - Label
        - 普通标签
        - 图片标签
        - 图像标签
    - 按钮
        - 普通按钮
        - 带图片的按钮
        - 单选
        - 多选
    - 列表
        - 下拉框
        - 列表框
    - 文本框
        - 文本域
        - 密码框
        - 普通文本
4. 贪吃蛇
