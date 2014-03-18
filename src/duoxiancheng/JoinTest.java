package duoxiancheng;

class MyJoinThread extends Thread
{
	public MyJoinThread()
	{ super(); }
	public MyJoinThread(String name)
	{
		super(name);
	}
	public void run()
	{
		for(int i=0;i<20;i++)
		{
			System.out.println(super.getName()+": "+i);
		}
	}
}

public class JoinTest {                   //线程加入

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyJoinThread thread=new MyJoinThread("第一个线程");
		thread.start();
		for(int i=0;i<20;i++)
		{
			System.out.println(Thread.currentThread().getName()+": "+i);
			if(i==10)
			{
				try
				{
					thread.join();              //当等于10的时候，加入新建线程
				}catch(InterruptedException e)
				{
					System.out.println("线程被中断，其余线程被叫醒");
				}
			}
		}

	}

}
