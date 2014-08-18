package com.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileInOutputStream {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try{
            File file = new File("E:\\EclipseWorkSpace//word.txt");     //文件名中的"//"和"\\"可以互换
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileOutputStream fos=new FileOutputStream(file,true);       //"true"表示将新写入的内容接在原来的内容的后面
            byte[] bytes="java编程词典软件，学java必备。".getBytes();
            fos.write(bytes);
            
            FileInputStream fis=new FileInputStream(file);
            int lenght;
            byte[] by=new byte[1024];
            System.out.println("从文件中读取出的数据是：");
            while((lenght=fis.read(by))!=-1){
                String str=new String(by,0,lenght);
                System.out.print(str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        try {
//            String path = "E:\\EclipseWorkSpace//word.txt";//文件保存路径、名字
//            File file = new File(path);
//            BufferedWriter ow = new BufferedWriter(new FileWriter(file));
//            String s = "内容";//写入内容
//            ow.write(s);
//            ow.close();
//           } catch (Exception e) {
//            e.printStackTrace();
//           }
    }

}
