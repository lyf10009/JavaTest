package IO;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        delete("E://EclipseWorkSpace//word1.txt");
    }
    public static void delete(String name){
        File file=new File(name);
        if(file.delete()){
            System.out.println(name+"���ļ�ɾ���ɹ���");
        }else{
            System.out.println(name+"���ļ�ɾ��ʧ�ܣ�");
        }  
        
    }
    public static void changeName() {
        File dir = new File("F:\\��˳ƽ��Ƶ�̳�"); // ����ָ�����ļ�·���������ļ�����
        String absolute ="F:/��˳ƽ��Ƶ�̳�";
        if (dir.isDirectory()) {                     // ������ļ�����ָ������һ��Ŀ¼
            File[] files = dir.listFiles();          // ��ȡ��Ŀ¼�µĳ���·��������
            for (int i = 0; i < files.length; i++) { // ѭ������������
                File fileTemp = files[i];               // ��ȡ�����е�Ԫ��
                String name=fileTemp.getName().replaceAll("��˳ƽ-","");
                fileTemp.renameTo(new File(absolute+File.separator+name));
            }
        }
    }
}
