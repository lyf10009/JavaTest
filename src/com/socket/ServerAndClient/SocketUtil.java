package com.socket.ServerAndClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketUtil {
    //�ͻ���
    public static void main(String[] args) {
        String str=null;
        Socket client=null;
        DataInputStream in = null;
        DataOutputStream out=null;
        try{
            client=new Socket("127.0.0.1", 4331);
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("��ã�����");
            while(true){
                str=in.readUTF();
                out.writeUTF(((int)(Math.random()*10)+1)+"");
                System.out.println("�ͻ����յ���"+str);
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
