package duoxiancheng;

public class PriorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMoreThread thread1=new MyMoreThread("��һ���߳�");
		MyMoreThread thread2=new MyMoreThread("�ڶ����߳�");
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.start();

	}

}
