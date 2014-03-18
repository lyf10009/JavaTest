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
        	System.out.println("本地主机名："+localname);
        	System.out.println("本地IP地址："+localip);
        }catch(UnknownHostException e){
        	e.printStackTrace();
        }
	}
}
