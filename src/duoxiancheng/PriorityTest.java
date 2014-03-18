package duoxiancheng;

public class PriorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMoreThread thread1=new MyMoreThread("第一个线程");
		MyMoreThread thread2=new MyMoreThread("第二个线程");
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.start();

	}

}
