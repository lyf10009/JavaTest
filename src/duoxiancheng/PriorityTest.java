package duoxiancheng;

public class PriorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyMoreThread thread1=new MyMoreThread("��һ���߳�");
		MyMoreThread thread2=new MyMoreThread("�ڶ����߳�");
		MyMoreThread thread3=new MyMoreThread("�������߳�");
		MyMoreThread thread4=new MyMoreThread("���ĸ��߳�");
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MIN_PRIORITY);
		thread3.setPriority(Thread.MAX_PRIORITY);
		thread4.setPriority(Thread.MIN_PRIORITY);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}

}
