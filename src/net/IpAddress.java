package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        InetAddress ip;
        try{
        	ip =InetAddress.getLocalHost();
        	String localname=ip.getHostName();
        	String localip=ip.getHostAddress();
        	System.out.println("������������"+localname);
        	System.out.println("����IP��ַ��"+localip);
        }catch(UnknownHostException e){
        	e.printStackTrace();
        }
	}
}
