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
    JComboBox jComboBox;    //������
    //һ���б��͹�����һ��ʹ��
    JList jList;            //�б�
    JScrollPane jScrollPane;//������
    
    JCheckBox jcb1,jcb2,jcb3,jcb4;//��ѡ��
    JRadioButton jrb1,jrb2;//��ѡ��
    ButtonGroup buttonGroup;
    public InfoTest(){
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        jp5=new JPanel();
        jl1=new JLabel("��Ȥ");
        jl2=new JLabel("�Ա�");
        jl3=new JLabel("����");
        jl4=new JLabel("ϲ���ĵط�");
        jcb1=new JCheckBox("����");
        jcb2=new JCheckBox("����");
        jcb3=new JCheckBox("��Ӿ");
        jcb4=new JCheckBox("ƹ����");
        
        //ͬһ�鵥ѡ��ť����ŵ�һ��ButtonGroup��
        jrb1=new JRadioButton("��");
        jrb2=new JRadioButton("Ů");
        buttonGroup=new ButtonGroup();
        buttonGroup.add(jrb1);
        buttonGroup.add(jrb2);
        
        String[] address={"����","�Ϻ�","���","����","����","����"};
        jComboBox=new JComboBox(address);
        
        jList=new JList(address);
        jList.setVisibleRowCount(3);//����Ĭ����ʾ����
        jScrollPane=new JScrollPane(jList);
        
        jb1=new JButton("ȷ��");
        jb2=new JButton("ȡ��");
        
        //���ò��ֹ���
        this.setLayout(new GridLayout(5, 1));
        
        //������
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
        
        this.setTitle("������Ϣ");
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
