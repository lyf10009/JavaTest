package com.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 每一个被调度的任务都会由线程池中一个线程去执行，因此任务是并发执行的，
 * 相互之间不会受到干扰。需 要注意的是，只有当任务的执行时间到来时，
 * ScheduedExecutor 才会真正启动一个线程，其余时间 ScheduledExecutor
 * 都是在轮询任务的状态。
 * @author fluo
 */
public class ScheduledExecutorTest implements Runnable {
	private String jobName="";
	public ScheduledExecutorTest(String jobName){
		super();
		this.jobName = jobName;
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		 
        long initialDelay1 = 1;
        long period1 = 1;
        // 从现在开始1秒钟之后，每隔1秒钟执行一次job1
        service.scheduleAtFixedRate(
                new ScheduledExecutorTest("job1"), initialDelay1,
                period1, TimeUnit.SECONDS);

        long initialDelay2 = 2;
        long delay2 = 2;
        // 从现在开始2秒钟之后，每隔2秒钟执行一次job2
        service.scheduleWithFixedDelay(
                new ScheduledExecutorTest("job2"), initialDelay2,
                delay2, TimeUnit.SECONDS);

	}

	@Override
	public void run() {
		System.out.println("execute "+jobName);
	}

}
