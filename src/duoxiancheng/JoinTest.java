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

public class JoinTest {                   //�̼߳���

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyJoinThread thread=new MyJoinThread("��һ���߳�");
		thread.start();
		for(int i=0;i<20;i++)
		{
			System.out.println(Thread.currentThread().getName()+": "+i);
			if(i==10)
			{
				try
				{
					thread.join();              //������10��ʱ�򣬼����½��߳�
				}catch(InterruptedException e)
				{
					System.out.println("�̱߳��жϣ������̱߳�����");
				}
			}
		}

	}

}
