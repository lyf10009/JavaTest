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
		MyMoreThread thread1=new MyMoreThread("��һ���߳�");
		MyMoreThread thread2=new MyMoreThread("�ڶ����߳�");
		thread1.start();
		thread2.start();
	}
}
