package IO;

import java.io.File;

public class FolderClear {

    /**
     * ����ļ���
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("D://delete"); // �����ļ�����
        if(file.exists()){
            System.out.println("�ļ��д��ڣ�����");
            File[] files=file.listFiles();
            for(File tmp:files){
                deleteFile(tmp);
            }
            System.out.println("ɾ������������");
        }else{
            System.out.println("�ļ��в����ڣ�����");
            
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
