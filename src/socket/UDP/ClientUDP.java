package socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {

    public static void main(String[] args) {
        DatagramSocket client;
        try {
            client = new DatagramSocket();
            String sendStr = "��ã����ǿͻ��ˣ�";
            byte[] sendBuf=sendStr.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port=6000;
            DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length,address,port);
            client.send(sendPacket);
            
            byte[] recvBuf = new byte[100];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
            client.receive(recvPacket);
            String recvStr = new String(recvPacket.getData(),0,recvPacket.getLength());
            System.out.println("�յ���"+recvStr);
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
