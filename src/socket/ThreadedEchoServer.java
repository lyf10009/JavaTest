package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoServer {
    public static void main(String[] args) {
        try{
            int i=1;
            //建立socket服务
            ServerSocket server = new ServerSocket(8888);
            
            while(true){
                //等待客户端连接
                Socket incoming = server.accept();
                System.out.println("Spawning "+i);
                Runnable run=new ThreadedEchoHandler(incoming,i);
                Thread thread=new Thread(run);
                thread.start();
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

/**
 * this class handles the client input for one server socket connection.
 * @author Administrator
 *
 */
class ThreadedEchoHandler implements Runnable{
    private Socket socket;
    private int counter;
    public ThreadedEchoHandler(Socket socket, int i){
        this.socket=socket;
        this.counter=i;
    }
    public void run(){
        try{
            try{
                InputStream inStream = socket.getInputStream();
                OutputStream outStream = socket.getOutputStream();
                Scanner in=new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream,true);
                
//                out.print("Hello! Enter BYE to exit.");
                System.out.println("Hello "+counter+"! \nEnter BYE to exit.");
                boolean done=false;
                while(!done && in.hasNextLine()){
                    String line=in.nextLine();
//                    out.print("Echo:"+line);
                    System.out.println("Echo"+counter+":"+line);
                    if(line.trim().equals("BYE")){
                        done=true;
                        System.out.println("bye");
                    }
                }
            } 
            finally{
                socket.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
