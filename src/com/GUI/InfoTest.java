package com.GUI;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class InfoTest extends JFrame{
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel jl1,jl2,jl3,jl4;
    JButton jb1,jb2;
    JComboBox jComboBox;    //下拉框
    //一般列表框和滚动条一起使用
    JList jList;            //列表
    JScrollPane jScrollPane;//滚动条
    
    JCheckBox jcb1,jcb2,jcb3,jcb4;//多选框
    JRadioButton jrb1,jrb2;//单选框
    ButtonGroup buttonGroup;
    public InfoTest(){
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        jp5=new JPanel();
        jl1=new JLabel("兴趣");
        jl2=new JLabel("性别");
        jl3=new JLabel("籍贯");
        jl4=new JLabel("喜欢的地方");
        jcb1=new JCheckBox("篮球");
        jcb2=new JCheckBox("足球");
        jcb3=new JCheckBox("游泳");
        jcb4=new JCheckBox("乒乓球");
        
        //同一组单选按钮必须放到一个ButtonGroup里
        jrb1=new JRadioButton("男");
        jrb2=new JRadioButton("女");
        buttonGroup=new ButtonGroup();
        buttonGroup.add(jrb1);
        buttonGroup.add(jrb2);
        
        String[] address={"北京","上海","天津","重庆","湖北","湖南"};
        jComboBox=new JComboBox(address);
        
        jList=new JList(address);
        jList.setVisibleRowCount(3);//设置默认显示行数
        jScrollPane=new JScrollPane(jList);
        
        jb1=new JButton("确定");
        jb2=new JButton("取消");
        
        //设置布局管理
        this.setLayout(new GridLayout(5, 1));
        
        //添加组件
        jp1.add(jl1);
        jp1.add(jcb1);
        jp1.add(jcb2);
        jp1.add(jcb3);
        jp1.add(jcb4);
        
        jp2.add(jl2);
        jp2.add(jrb1);
        jp2.add(jrb2);
        
        jp3.add(jl3);
        jp3.add(jComboBox);
        
        jp4.add(jl4);
        jp4.add(jScrollPane);
        
        jp5.add(jb1);
        jp5.add(jb2);
        
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        
        this.setTitle("个人信息");
        this.setLocation(100, 200);
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InfoTest info=new InfoTest();
    }

}
