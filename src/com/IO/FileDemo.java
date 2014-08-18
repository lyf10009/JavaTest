package com.IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) {
//        File file = new File("E://EclipseWorkSpace//word.txt"); // 创建文件对象
//        if (file.exists()) {                                    // 判断该文件是否存在
//            String name = file.getName();                       // 获取文件名称
//            String parent = file.getParent();                   // 获取文件父路径
//            long leng = file.length();                          // 获取文件长度
//            boolean bool = file.canWrite();                     // 判断该文件是否可改写
//            long lastTime =file.lastModified();                 //获得文件最后修改时间
//            
//            System.out.println("文件名称为：" + name);           // 输出信息
//            System.out.println("文件目录为：" + parent);
//            System.out.println("文件大小为：" + leng + " bytes");
//            System.out.println("是否为可改写文件：" + bool);
////            SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
////            //前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
////            java.util.Date dt = new Date(lastTime);  
////            String sDateTime = sdf.format(dt); 
////            System.out.println("文件最后修改时间：" + sDateTime);
//            System.out.println("文件最后修改时间：" + new Date(lastTime));
//            
//        }else{
//            System.out.println("word.txt文件不存在！！！！");
//        }
//        System.out.println();
        
        File dir = new File("E:/EclipseWorkSpace/bus/WebContent/WEB-INF/lib"); // 根据指定的文件路径，创建文件对象
        if (dir.isDirectory()) {                     // 如果该文件对象指定的是一个目录
            System.out.println(dir.getName());
            File[] files = dir.listFiles();          // 获取该目录下的抽象路径名数组
            for (int i = 0; i < files.length; i++) { // 循环遍历该数组
                File fileTemp = files[i];               // 获取数据中的元素
                System.out.print("lib/"+fileTemp.getName()+";");
            }
        }
        
    }
}
