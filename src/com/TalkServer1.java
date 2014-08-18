package com;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TalkServer1 {
    public static void main(String[] args) throws Exception {
        new MultiServer().service();
    }
}
class MultiServer{
    int port=8888;//port
    ServerSocket serverSocket=null;
    ExecutorService executorService=null;
    final int POOL_SIZE=10;
    int i=0;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public MultiServer() throws Exception{
        serverSocket=new ServerSocket(port);
        executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
    }
    public void service() throws Exception {
        while(true)
        {
            Socket socket=serverSocket.accept();
            
            System.out.println("Success!!!"+"time="+df.format(new Date())+"  i="+i++); 

            executorService.execute(new hander(socket));

        }
    }
}
class hander implements Runnable{
    Socket socket=null;
    Thread thread;
    public hander(Socket socket) {

        this.socket=socket;

        thread=new Thread();

        thread.run();

    }
    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(socket.getOutputStream(),false,"GBK");  
            
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
         
            String str =  buf.readLine();  
            System.out.println("OK:"+str);
           
            out.println("echo pandongfei:" + str);  
            
            out.close();  
            buf.close();  
            socket.close(); 

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
