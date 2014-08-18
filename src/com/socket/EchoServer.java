package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    /**
     * 单客户
     * 在CMD中输入 telnet 127.0.0.1 8888 连接服务端
     */
    public static void main(String[] args) {
        try{
            //建立socket服务
            ServerSocket server = new ServerSocket(8888);
            //等待客户端连接
            Socket incoming = server.accept();
            try{
                InputStream inStream = incoming.getInputStream();
//                OutputStream outStream = incoming.getOutputStream();
                Scanner in=new Scanner(inStream);
//                PrintWriter out = new PrintWriter(outStream,true);
                
//                out.print("Hello! Enter BYE to exit.");
                System.out.println("Hello! Enter BYE to exit.");
                boolean done=false;
                while(!done && in.hasNextLine()){
                    String line=in.nextLine();
//                    out.print("Echo:"+line);
                    System.out.println("Echo:"+line);
                    if(line.trim().equals("BYE")){
                        done=true;
                        System.out.println("bye");
                    }
                }
            }
            finally{
                incoming.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
