package GUI;

import javax.swing.*;
import java.awt.Container;
import java.net.URL;

public class ThreadTest extends JFrame {
    private JLabel jl = new JLabel();//����JLabel����
    private int count = 0; //������������
    private static Thread t; //�����̶߳���
    private Container container = getContentPane();//��������

    public ThreadTest() {
        setBounds(300, 200, 850, 600); //���Զ�λ����λ�úʹ�С
        container.setLayout(null); //ʹ���岻ʹ���κβ���
        URL url = ThreadTest.class.getResource("./1.gif");//��ȡͼƬURL,"./1.gif"��"\\1.gif"
        Icon icon = new ImageIcon(url); //ʵ����һ��Icon
        jl.setIcon(icon); //��ͼ����ڱ�ǩ��
        jl.setHorizontalAlignment(SwingConstants.LEFT);//����ͼƬ�ڱ�ǩ������
        jl.setBounds(10, 10, 220, 220); //���ñ�ǩ��λ�����С
        jl.setOpaque(true);
        t = new Thread(new Runnable() { //���������ڲ��࣬����ʵ��Runnable�ӿ�
                    public void run() { //��дrun��������
                        while (count <= 200) { //����ѭ������
                            jl.setBounds(count, 10, 200, 250); //����ǩ�ĺ������ñ�����ʾ
                            try {
                                Thread.sleep(1000); //ʹ�߳�����1000����
                            }catch (Exception e) {
                                e.printStackTrace();
                            }
                            count += 10; //ʹ������ÿ������10
                            if (count == 200) {
                                //��ͼ��ﵽ��ǩ�����ұߣ�ʹ��ص���ǩ�����
                                count = 10;
                            }
                        }
                    }
                });
        t.start(); //�����߳�
        container.add(jl); //����ǩ��ӵ�������
        setVisible(true); //ʹ�������
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ThreadTest(); //ʵ����һ��ThreadTest����
    }
}
