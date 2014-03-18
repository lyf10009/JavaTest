package duoxiancheng;
class MyThread1 extends Thread
{
	public MyThread1()
	{ super(); }
	public MyThread1(String name)
	{
		super(name);
	}
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(super.getName()+": "+i);
			try
			{
				sleep(500);//让线程睡眠
			}catch(InterruptedException e)
			{
				System.out.println("线程被叫醒");
			}
		}
	}
}
public class SleepTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 thread1=new MyThread1("第一个线程");
		MyThread1 thread2=new MyThread1("第二个线程");
		thread1.start();
		thread2.start();


	}

}
