package com.IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) {
//        File file = new File("E://EclipseWorkSpace//word.txt"); // �����ļ�����
//        if (file.exists()) {                                    // �жϸ��ļ��Ƿ����
//            String name = file.getName();                       // ��ȡ�ļ�����
//            String parent = file.getParent();                   // ��ȡ�ļ���·��
//            long leng = file.length();                          // ��ȡ�ļ�����
//            boolean bool = file.canWrite();                     // �жϸ��ļ��Ƿ�ɸ�д
//            long lastTime =file.lastModified();                 //����ļ�����޸�ʱ��
//            
//            System.out.println("�ļ�����Ϊ��" + name);           // �����Ϣ
//            System.out.println("�ļ�Ŀ¼Ϊ��" + parent);
//            System.out.println("�ļ���СΪ��" + leng + " bytes");
//            System.out.println("�Ƿ�Ϊ�ɸ�д�ļ���" + bool);
////            SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
////            //ǰ���lSysTime���������ȳ�1000�õ�����������תΪjava.util.Date����
////            java.util.Date dt = new Date(lastTime);  
////            String sDateTime = sdf.format(dt); 
////            System.out.println("�ļ�����޸�ʱ�䣺" + sDateTime);
//            System.out.println("�ļ�����޸�ʱ�䣺" + new Date(lastTime));
//            
//        }else{
//            System.out.println("word.txt�ļ������ڣ�������");
//        }
//        System.out.println();
        
        File dir = new File("E:/EclipseWorkSpace/bus/WebContent/WEB-INF/lib"); // ����ָ�����ļ�·���������ļ�����
        if (dir.isDirectory()) {                     // ������ļ�����ָ������һ��Ŀ¼
            System.out.println(dir.getName());
            File[] files = dir.listFiles();          // ��ȡ��Ŀ¼�µĳ���·��������
            for (int i = 0; i < files.length; i++) { // ѭ������������
                File fileTemp = files[i];               // ��ȡ�����е�Ԫ��
                System.out.print("lib/"+fileTemp.getName()+";");
            }
        }
        
    }
}
