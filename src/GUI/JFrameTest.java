package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest extends JFrame{
    JButton jb1;
    public JFrameTest(){
        //���������ñ���
        this.setTitle("Hello World");
        //���ô����ʼλ��
        this.setLocation(100, 200);
        //���������ô�С,��λ����
        this.setSize(200, 200);
        //����Button��ť
        jb1=new JButton("��ʼ");
        //���JButton���
        this.add(jb1);
        
        
        //��ʾ����
        this.setVisible(true);
        //���ùرմ����ͬʱҲ��������
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrameTest jt = new JFrameTest();
    }
}
