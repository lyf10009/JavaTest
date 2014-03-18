package IO;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        delete("E://EclipseWorkSpace//word1.txt");
    }
    public static void delete(String name){
        File file=new File(name);
        if(file.delete()){
            System.out.println(name+"，文件删除成功！");
        }else{
            System.out.println(name+"，文件删除失败！");
        }  
        
    }
    public static void changeName() {
        File dir = new File("F:\\韩顺平视频教程"); // 根据指定的文件路径，创建文件对象
        String absolute ="F:/韩顺平视频教程";
        if (dir.isDirectory()) {                     // 如果该文件对象指定的是一个目录
            File[] files = dir.listFiles();          // 获取该目录下的抽象路径名数组
            for (int i = 0; i < files.length; i++) { // 循环遍历该数组
                File fileTemp = files[i];               // 获取数据中的元素
                String name=fileTemp.getName().replaceAll("韩顺平-","");
                fileTemp.renameTo(new File(absolute+File.separator+name));
            }
        }
    }
}
