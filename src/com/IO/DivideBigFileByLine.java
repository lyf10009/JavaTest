package com.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class DivideBigFileByLine {

    public static void main(String[] args) {
        long time1=System.currentTimeMillis();
        start(3000,"all.txt","data");
        long time2=System.currentTimeMillis();
        System.out.println("�ָ��ļ���ʱ"+(time2-time1)+"����");
    }

    /**
     * ��������,ֱ�ӵ��þ�̬����start��ִ�в��� ����: 
     * rows Ϊ������һ���ļ� int ���� 
     * sourceFilePath ΪԴ�ļ�·�� String ����
     * targetDirectoryPath Ϊ�ļ��ָ���ŵ�Ŀ��Ŀ¼ String ����
     * ---�ָ����ļ���Ϊ������(��0��ʼ)��'_'��Դ�ļ���,����Դ�ļ���Ϊtest.txt,��ָ���ļ���Ϊ0_test.txt,�Դ�����
     */
    public static void start(int rows, String sourceFilePath, String targetDirectoryPath) {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetDirectoryPath);
        if (!sourceFile.exists() || rows <= 0 || sourceFile.isDirectory()) {
            System.out.println("Դ�ļ������ڻ��������˴��������");
            return;
        }
        if (targetFile.exists()) {
            if (!targetFile.isDirectory()) {
                System.out.println("Ŀ���ļ��д���,����һ���ļ���");
                return;
            }else{
                //���Ѵ��ڸ��ļ��У�����ո��ļ���
                targetFile.delete();
                targetFile.mkdirs();
            }
        } else {
            targetFile.mkdirs();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = null;
            StringBuilder str = new StringBuilder();
            String tempData = br.readLine();
            int i = 1, s = 0;
            while (tempData != null) {
                str.append(tempData).append("\r\n");
                if (i % rows == 0) {
                    bw = new BufferedWriter(new FileWriter(new File(targetFile.getAbsolutePath()
                         + "/" + s + "_" + sourceFile.getName())));
                    bw.write(str.toString());
                    bw.close();
                    str=new StringBuilder();
                    s += 1;
                }
                i++;
                tempData = br.readLine();
            }
            if ((i - 1) % rows != 0) {
                bw = new BufferedWriter(new FileWriter(new File(targetFile.getAbsolutePath()
                     + "/" + s + "_" + sourceFile.getName())));
                bw.write(str.toString());
                bw.close();
                br.close();
                s += 1;
            }
            System.out.println("�ļ��ָ����,���ָ����" + s + "���ļ�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
