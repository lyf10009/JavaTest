package com.net.http;

import java.io.*;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) throws IOException {
        test4();
        test2();
    }
    /**
     * 获取URL指定的资源。
     * 
     * @throws IOException
     */
    public static void test4() throws IOException {
        URL url =
                new URL(
                        "http://lavasoft.blog.51cto.com/attachment/200811/200811271227767778082.jpg");
        // 获得此 URL 的内容。
        Object obj = url.getContent();
        System.out.println(obj.getClass().getName());
    }
    /**
     * 读取URL指定的网页内容
     * 
     * @throws IOException
     */
    public static void test2() throws IOException {
        URL url = new URL("http://baike.baidu.com/view/4066913.htm");
        // 打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream。
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()),"utf-8");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();
    }
}
