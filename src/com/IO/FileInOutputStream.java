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
            File file = new File("E:\\EclipseWorkSpace//word.txt");     //�ļ����е�"//"��"\\"���Ի���
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileOutputStream fos=new FileOutputStream(file,true);       //"true"��ʾ����д������ݽ���ԭ�������ݵĺ���
            byte[] bytes="java��̴ʵ������ѧjava�ر���".getBytes();
            fos.write(bytes);
            
            FileInputStream fis=new FileInputStream(file);
            int lenght;
            byte[] by=new byte[1024];
            System.out.println("���ļ��ж�ȡ���������ǣ�");
            while((lenght=fis.read(by))!=-1){
                String str=new String(by,0,lenght);
                System.out.print(str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        try {
//            String path = "E:\\EclipseWorkSpace//word.txt";//�ļ�����·��������
//            File file = new File(path);
//            BufferedWriter ow = new BufferedWriter(new FileWriter(file));
//            String s = "����";//д������
//            ow.write(s);
//            ow.close();
//           } catch (Exception e) {
//            e.printStackTrace();
//           }
    }

}
