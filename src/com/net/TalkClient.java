package com.net;

import java.io.*;
import java.net.*;

public class TalkClient {
	public static void main(String args[]) {
		try{
			Socket socket=new Socket("10.105.22.188",5002);
		
			ReadString read = new ReadString(socket);
			read.start();
			
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter os=new PrintWriter(socket.getOutputStream());
	
			String readline=sin.readLine();
			
			while(!readline.equals("bye")){
				os.println(readline);
				os.flush();
				System.out.println("Client:"+readline);
				
				readline=sin.readLine();
			}
			os.close();

			socket.close();
		}catch(Exception e) {
			System.out.println("Error"+e);
		}
	}
}

class ReadString extends Thread {

	private Socket socket;
	public ReadString(Socket socket){
		this.socket = socket;
	}
    public void run() {
		try {
			BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//循环接受服务端信息
			while(true)
			{
				String read = is.readLine();
				System.out.println("Server:"+read);
				if(read.equals("bye"))
				{
					break;
				}
			}
			is.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
