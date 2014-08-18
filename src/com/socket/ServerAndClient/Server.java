package com.socket.ServerAndClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        String line=null;
        DataOutputStream out = null;
        DataInputStream in = null;
        try{
            server = new ServerSocket(4331);
            socket = server.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            while(true){
                line= in.readUTF();
                out.writeUTF("hello,我是服务器");
                out.writeUTF(line);
                System.out.println("服务器收到："+line);
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
