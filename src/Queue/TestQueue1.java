package Queue;

import java.rmi.server.LoaderHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestQueue1 {

  /**
   * @param args
   * @throws InterruptedException 
   */
  
  static BlockingQueue bqueue = new ArrayBlockingQueue(20);
  public static void load() throws InterruptedException
  {
    for(int i=0;i<30;i++){
      bqueue.put(i);
      System.out.println("添加的数据是："+i);
    }
  }
  public static void main(String[] args) throws InterruptedException {
    load();
    while(bqueue.peek()!=null)
    {
      System.out.println("元素为："+bqueue.remove());
    }
    System.out.println("程序到此运行结束，即将退出----");

  }

}
