package com.socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {

    public static void main(String[] args) {
        DatagramSocket server = null;
        try {
            server = new DatagramSocket(6000);
            byte[] recvBuf = new byte[100];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
            server.receive(recvPacket);
            String recvStr = new String(recvPacket.getData(),0,recvPacket.getLength());
            System.out.println("Hello!"+recvStr);
            
            int port = recvPacket.getPort();
            InetAddress address = recvPacket.getAddress();
            String sendStr = "服务器发送的消息";
            byte[] sendBuf = sendStr.getBytes();
            DatagramPacket sendPacket= new DatagramPacket(sendBuf, sendBuf.length,address,port);
            server.send(sendPacket);
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
