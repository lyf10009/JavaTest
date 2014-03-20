package duoxiancheng;

class MyMoreThread extends Thread
{
	public MyMoreThread()
	{ super(); }
	public MyMoreThread(String name)
	{
		super(name);
	}
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(super.getName()+": "+i);
		}
	}
}

public class ThreadExtendsThread {
    public static void main(String[] args) {
		MyMoreThread thread1=new MyMoreThread("第一个线程");
		MyMoreThread thread2=new MyMoreThread("第二个线程");
		MyMoreThread thread3=new MyMoreThread("第三个线程");
		
		thread1.start();
		try {
            thread1.join();//先执行完当前线程，在执行其他的
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		thread3.start();
		thread2.start();
		
	}
}
