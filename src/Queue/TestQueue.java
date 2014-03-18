package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Queue<String> queue = new LinkedList<String>();  
    queue.offer("Hello");  
    queue.offer("World!");  
    queue.offer("��ã�");  
    System.out.println(queue.size());  
    String str;  
    while((str=queue.poll())!=null){  
        System.out.print(str);  
    }  
    System.out.println();  
    System.out.println(queue.size()); 
  }

}
