package com.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InOutputStreamTest {

    /**
     * 标准输入输出流InputStream、OutputStream
     * 从控制台获得用户输入并在控制台上输出
     * @param args
     */
    public static void main(String[] args) {
        InputStream is = System.in;                 // 定义InputStream对象
        OutputStream out = System.out;              //实例化OutputStream类
        byte[] bytes = new byte[1024];
        try {
            System.out.println("请输入字符串：");    // 提示用户输入字符串
            is.read(bytes);                         // 将输入的字符串保存在数组中
            System.out.println("您输入的字符串："); 
            out.write(bytes);                       //向流中写数据
//            String input = new String(bytes);       // 将数组中的内容转换成字符串
//            System.out.println(input.trim());// 输出字符串
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();// 释放资源
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
