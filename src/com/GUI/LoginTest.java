package com.GUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginTest extends JFrame{
    JPanel jp1,jp2,jp3;
    JLabel jl1,jl2;
    JTextField jtf;
    JPasswordField jpf;
    JButton jb1,jb2;
    public LoginTest(){
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jl1=new JLabel("用户名");
        jtf=new JTextField(10);
        jl2=new JLabel("密     码");
        jpf=new JPasswordField(10);
        jb1=new JButton("确定");
        jb2=new JButton("取消");
        
        //设置布局管理
        this.setLayout(new GridLayout(3, 1));
        
        jp1.add(jl1);
        jp1.add(jtf);
        jp2.add(jl2);
        jp2.add(jpf);
        jp3.add(jb1);
        jp3.add(jb2);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        
        this.setTitle("登陆");
        this.setLocation(100, 200);
        this.setSize(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LoginTest loginTest= new LoginTest();
    }
}
