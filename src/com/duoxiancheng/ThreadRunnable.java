package com.duoxiancheng;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyRunnable extends Observable implements Runnable {       //实现Runnable接口
	private int route;
	public MyRunnable(int route){
	    this.route=route;
	}
    public void run()              //定义线程运行方法
	{
	    for(int i=0;i<30;i++){
	      setChanged();
	      notifyObservers(i);
	    }
//		System.out.println("通过实现Runnable接口方式创建线程");
	}
}

class MyObservers implements Observer{
  private BlockingQueue bqueue = new ArrayBlockingQueue(20);
  @Override
  public void update(Observable arg0, Object arg1) {
    try {
      bqueue.put(arg1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    insert();
  }
  public void insert(){
    while(bqueue.peek()!=null)
    {
      System.out.println("元素为："+bqueue.remove());
    }
  }
}
public class ThreadRunnable {
	public static void main(String[] args) {
	    int route=3;
		MyRunnable mr= new MyRunnable(route);                 //创建实现接口对象
		Thread thread=new Thread(mr);                   //创建线程对象
		thread.start();                                 //启动线程

	}
}

