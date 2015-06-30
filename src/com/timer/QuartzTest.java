package com.timer;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest implements Job {

	public static void main(String[] args) {
		try {
			// ����һ��Scheduler
			SchedulerFactory schedFact = new StdSchedulerFactory();
			Scheduler sched = schedFact.getScheduler();
			sched.start();

			// ����һ��JobDetail��ָ��name��groupname���Լ������Job������
			// ��Job��������Ҫִ������
			JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class)
					.withIdentity("myJob", "myJobGroup").build();
			jobDetail.getJobDataMap().put("type", "FULL");

			// ����һ��ÿ�ܴ�����Trigger��ָ�����ڼ����㼸��ִ��
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
					.weeklyOnDayAndHourAndMinute(3, 15, 37);
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("myTrigger", "myTriggerGroup")
					.withSchedule(scheduleBuilder).build();

			// ��scheduler��JobDetail��Trigger������һ�𣬿�ʼ��������
			sched.scheduleJob(jobDetail, trigger);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	// ʵ����Ҫִ�е�����
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Generating report - "
				+ context.getJobDetail().getDescription() + ", type ="
				+ context.getJobDetail().getJobDataMap().get("type"));
		System.out.println(new Date().toString());

	}

}
