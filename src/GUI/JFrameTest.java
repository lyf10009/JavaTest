package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest extends JFrame{
    JButton jb1;
    public JFrameTest(){
        //给窗体设置标题
        this.setTitle("Hello World");
        //设置窗体初始位置
        this.setLocation(100, 200);
        //给窗体设置大小,单位像素
        this.setSize(200, 200);
        //创建Button按钮
        jb1=new JButton("开始");
        //添加JButton组件
        this.add(jb1);
        
        
        //显示窗体
        this.setVisible(true);
        //设置关闭窗体的同时也结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrameTest jt = new JFrameTest();
    }
}
