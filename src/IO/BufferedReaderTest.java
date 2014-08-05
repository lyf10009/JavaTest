package IO;

import java.io.*;
public class BufferedReaderTest{
    public static void main(String args[]){
        BufferedReader in=null;
        try {
            in = new BufferedReader(new FileReader("word.txt"));
            String line;
            int num = 0, fileNum;
            while ((line = in.readLine()) != null) {
                try {
                    fileNum = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    continue;
                }
                System.out.println(fileNum);
                num += fileNum;
            }
            System.out.println(num);
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
