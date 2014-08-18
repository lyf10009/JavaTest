package com.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InOutputStreamTest {

    /**
     * ��׼���������InputStream��OutputStream
     * �ӿ���̨����û����벢�ڿ���̨�����
     * @param args
     */
    public static void main(String[] args) {
        InputStream is = System.in;                 // ����InputStream����
        OutputStream out = System.out;              //ʵ����OutputStream��
        byte[] bytes = new byte[1024];
        try {
            System.out.println("�������ַ�����");    // ��ʾ�û������ַ���
            is.read(bytes);                         // ��������ַ���������������
            System.out.println("��������ַ�����"); 
            out.write(bytes);                       //������д����
//            String input = new String(bytes);       // �������е�����ת�����ַ���
//            System.out.println(input.trim());// ����ַ���
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();// �ͷ���Դ
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
