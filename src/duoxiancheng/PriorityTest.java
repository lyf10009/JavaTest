package duoxiancheng;

public class PriorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyMoreThread thread1=new MyMoreThread("第一个线程");
		MyMoreThread thread2=new MyMoreThread("第二个线程");
		MyMoreThread thread3=new MyMoreThread("第三个线程");
		MyMoreThread thread4=new MyMoreThread("第四个线程");
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
