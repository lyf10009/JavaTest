package GUI;

import javax.swing.*;
import java.awt.Container;
import java.net.URL;

public class ThreadTest extends JFrame {
    private JLabel jl = new JLabel();//声明JLabel对象
    private int count = 0; //声明计数变量
    private static Thread t; //声明线程对象
    private Container container = getContentPane();//声明容器

    public ThreadTest() {
        setBounds(300, 200, 850, 600); //绝对定位窗体位置和大小
        container.setLayout(null); //使窗体不使用任何布局
        URL url = ThreadTest.class.getResource("./1.gif");//获取图片URL,"./1.gif"或"\\1.gif"
        Icon icon = new ImageIcon(url); //实例化一个Icon
        jl.setIcon(icon); //将图标放在标签中
        jl.setHorizontalAlignment(SwingConstants.LEFT);//设置图片在标签的最左方
        jl.setBounds(10, 10, 220, 220); //设置标签的位置与大小
        jl.setOpaque(true);
        t = new Thread(new Runnable() { //定义匿名内部类，该类实现Runnable接口
                    public void run() { //重写run（）方法
                        while (count <= 200) { //设置循环条件
                            jl.setBounds(count, 10, 200, 250); //将标签的横坐标用变量表示
                            try {
                                Thread.sleep(1000); //使线程休眠1000毫秒
                            }catch (Exception e) {
                                e.printStackTrace();
                            }
                            count += 10; //使横坐标每次增加10
                            if (count == 200) {
                                //当图标达到标签的最右边，使其回到标签最左边
                                count = 10;
                            }
                        }
                    }
                });
        t.start(); //启动线程
        container.add(jl); //将标签添加到容器中
        setVisible(true); //使窗体可视
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ThreadTest(); //实例化一个ThreadTest对象
    }
}
