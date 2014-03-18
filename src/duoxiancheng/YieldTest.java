package duoxiancheng;

class MyYieldThread extends Thread
{
	public MyYieldThread()
	{ super(); }
	public MyYieldThread(String name)
	{
		super(name);
	}
	public void run()
	{
		for(int i=0;i<20;i++)
		{
			System.out.println(super.getName()+": "+i);
			yield();                      //调用让步方法
		}
	}
}

public class YieldTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyYieldThread thread1=new MyYieldThread("第一个线程");
		MyYieldThread thread2=new MyYieldThread("第二个线程");
		MyYieldThread thread3=new MyYieldThread("第三个线程");
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
