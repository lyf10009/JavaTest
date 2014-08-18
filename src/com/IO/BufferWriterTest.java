package com.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterTest {

    public static void main(String[] args) {
        String data="1234567894\r\n64asd6f as6\r\nd5f4aw6e5f46sa5d4f65asd6f564asdf";
        writer(data, "hehe.txt");
    }
    public static void writer(String data,String fileName){
        BufferedWriter writer=null;
        try {
            writer=new BufferedWriter(new FileWriter(fileName));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
