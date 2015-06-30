package com.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ʹ�� Timer ʵ��������ȵĺ������� Timer �� TimerTask������ Timer �����趨 TimerTask ����ʼ����ִ��ʱ�䡣
 * ʹ����ֻ��Ҫ����һ�� TimerTask �ļ̳��࣬ʵ���Լ��� run ������Ȼ���䶪�� Timer ȥִ�м��ɡ�
 * Timer ����ƺ�����һ�� TaskList ��һ�� TaskThread��
 * Timer �����յ������񶪵��Լ��� TaskList �У�TaskList ���� Task �����ִ��ʱ���������
 * TimerThread �ڴ��� Timer ʱ��������Ϊһ���ػ��̡߳�����̻߳���ѯ���������ҵ�һ�����Ҫִ�е�����
 * Ȼ�����ߣ����������Ҫִ������Ŀ�ʼʱ��㣬TimerThread �����Ѳ�ִ�и�����
 * ֮�� TimerThread �������һ��Ҫִ�е����񣬼������ߡ�
 * Timer ���ŵ����ڼ����ã�������������������ͬһ���߳������ȣ�
 * ������������Ǵ���ִ�еģ�ͬһʱ��ֻ����һ��������ִ�У�ǰһ��������ӳٻ��쳣������Ӱ�쵽֮�������
 * @author fluo
 *
 */
public class TimerTest extends TimerTask{
	private String jobName = "";
	public TimerTest(String jobName){
		super();
		this.jobName = jobName;
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		//�����ڿ�ʼ1���Ӻ�ÿ��1��ִ��һ��
		long delay1 = 1*1000;
		long period1= 1000;
		timer.schedule(new TimerTest("job1"), delay1,period1);
		
		//�����ڿ�ʼ2���Ӻ�ÿ��2��ִ��һ��
		long delay2 = 2*1000;
		long period2= 2000;
		timer.schedule(new TimerTest("job2"), delay2,period2);

	}

	@Override
	public void run() {
		System.out.println("execute "+jobName);
	}

}
