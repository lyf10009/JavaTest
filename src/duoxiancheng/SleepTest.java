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
				sleep(500);//���߳�˯��
			}catch(InterruptedException e)
			{
				System.out.println("�̱߳�����");
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
		MyThread1 thread1=new MyThread1("��һ���߳�");
		MyThread1 thread2=new MyThread1("�ڶ����߳�");
		thread1.start();
		thread2.start();


	}

}
