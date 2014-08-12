package IO;

import java.io.File;

public class FolderClear {

    /**
     * 清空文件夹
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("D://delete"); // 创建文件对象
        if(file.exists()){
            System.out.println("文件夹存在！！！");
            File[] files=file.listFiles();
            for(File tmp:files){
                deleteFile(tmp);
            }
            System.out.println("删除结束！！！");
        }else{
            System.out.println("文件夹不存在！！！");
            
        }
    }
    private static void deleteFile(File file){
        if(file.isDirectory()){
            File[] files=file.listFiles();
            for(File tmp:files){
                deleteFile(tmp);
            }
            file.delete();
        }else{
            file.delete();
        }
    }
}
