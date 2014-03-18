package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        File source=new File("E://EclipseWorkSpace//word1.txt");
        File target=new File("E://EclipseWorkSpace//word1.zip");
        FileInputStream fis=null;
        FileOutputStream fos=null;
        ZipOutputStream zos=null;
        try{
            fis=new FileInputStream(source);
            fos=new FileOutputStream(target);
            zos=new ZipOutputStream(fos);
            
            byte[] buffer=new byte[1024];
            ZipEntry entry=new ZipEntry(source.getName());//利用文件的名字创建ZipEntry对象
            zos.putNextEntry(entry);                    //在压缩文件中添加一个ZipEntry对象
            int read=0;
            while((read=fis.read(buffer))!=-1){
                zos.write(buffer,0,read);              //将输入写入到压缩文件
            }
            zos.closeEntry();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(zos!=null){
                try{
                    zos.close();
                    System.out.println("文件压缩完成！！！");
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try{
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
