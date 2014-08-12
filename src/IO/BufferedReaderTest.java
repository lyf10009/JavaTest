package IO;

import java.io.*;
public class BufferedReaderTest{
    public static void main(String args[]){
        readLineByLine("all.txt");
        
    }
    
    /**
     * ���ж�ȡ�ļ�������
     * Ȼ���ӡÿ������
     */
    public static void readLineByLine(String fileName){
        BufferedReader in=null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String line;
            int i=0;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                i++;
            }
            System.out.println("�ļ���һ������"+i+"����");
        } catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        }
    }
}
