package IO;

import java.io.*;
public class BufferedReaderTest{
    public static void main(String args[]){
        readLineByLine("all.txt");
        
    }
    
    /**
     * 按行读取文件中数据
     * 然后打印每行数据
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
            System.out.println("文件中一共有行"+i+"数据");
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
