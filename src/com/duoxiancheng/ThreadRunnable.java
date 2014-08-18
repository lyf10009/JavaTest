package com.duoxiancheng;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyRunnable extends Observable implements Runnable {       //ʵ��Runnable�ӿ�
	private int route;
	public MyRunnable(int route){
	    this.route=route;
	}
    public void run()              //�����߳����з���
	{
	    for(int i=0;i<30;i++){
	      setChanged();
	      notifyObservers(i);
	    }
//		System.out.println("ͨ��ʵ��Runnable�ӿڷ�ʽ�����߳�");
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
      System.out.println("Ԫ��Ϊ��"+bqueue.remove());
    }
  }
}
public class ThreadRunnable {
	public static void main(String[] args) {
	    int route=3;
		MyRunnable mr= new MyRunnable(route);                 //����ʵ�ֽӿڶ���
		Thread thread=new Thread(mr);                   //�����̶߳���
		thread.start();                                 //�����߳�

	}
}

