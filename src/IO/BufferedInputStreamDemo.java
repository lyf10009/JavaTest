package IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        try {
            File file = new File("E://EclipseWorkSpace//word.txt"); // �����ļ�����
            FileInputStream fis = new FileInputStream(file); // ����FileInputStream����
            BufferedInputStream bip = new BufferedInputStream(fis); // ����BufferedInputStream����
            int count = 0;
            bip.mark(50); // ���������ж�����λ��
            for (int i = 0; i < 10; i++) { // ��ѭ���ж�ȡ�ļ�����
                count++;
                int read = bip.read(); // ��ȡ�ļ�����
                if (count % 5 == 0)
                    bip.reset(); // ������λ�����һ�ε���mark()�����µ�λ��
                System.out.println((char) read); // ����ȡ���������
            }
            bip.close(); // �ر���
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
