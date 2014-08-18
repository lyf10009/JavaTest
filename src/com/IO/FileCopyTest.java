package com.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCopyTest {

    /**
     * �ļ�����
     */
    public static void main(String[] args) throws IOException {
        File file1= new File("E://EclipseWorkSpace//word.txt");
        File file2= new File("E://EclipseWorkSpace//word1.txt");
        if(!file2.exists()){
            file2.createNewFile();
        }
        FileInputStream fis=new FileInputStream(file1);
        FileOutputStream fos=new FileOutputStream(file2,true);  //"true"��ʾ����д������ݽ���ԭ�������ݵĺ���
        StringBuilder sBuilder=new StringBuilder("\r\n");       //���� windows�µ�
        int lenght=0;
        fos.write("\r\n".getBytes());                           //���� windows�µ�
        byte[] by1=new byte[1024];
        while((lenght=fis.read(by1))!=-1){
            String str=new String(by1,0,lenght);
            sBuilder.append(str);
            fos.write(by1,0,lenght);
        }
        System.out.println("Copy��ɣ���������");
    }
}
