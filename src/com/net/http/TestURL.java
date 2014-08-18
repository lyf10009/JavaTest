package com.net.http;

import java.io.*;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) throws IOException {
        test4();
        test2();
    }
    /**
     * ��ȡURLָ������Դ��
     * 
     * @throws IOException
     */
    public static void test4() throws IOException {
        URL url =
                new URL(
                        "http://lavasoft.blog.51cto.com/attachment/200811/200811271227767778082.jpg");
        // ��ô� URL �����ݡ�
        Object obj = url.getContent();
        System.out.println(obj.getClass().getName());
    }
    /**
     * ��ȡURLָ������ҳ����
     * 
     * @throws IOException
     */
    public static void test2() throws IOException {
        URL url = new URL("http://baike.baidu.com/view/4066913.htm");
        // �򿪵��� URL �����Ӳ�����һ�����ڴӸ����Ӷ���� InputStream��
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()),"utf-8");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();
    }
}
