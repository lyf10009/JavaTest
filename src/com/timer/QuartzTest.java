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
			// 创建一个Scheduler
			SchedulerFactory schedFact = new StdSchedulerFactory();
			Scheduler sched = schedFact.getScheduler();
			sched.start();

			// 创建一个JobDetail，指明name，groupname，以及具体的Job类名，
			// 该Job负责定义需要执行任务
			JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class)
					.withIdentity("myJob", "myJobGroup").build();
			jobDetail.getJobDataMap().put("type", "FULL");

			// 创建一个每周触发的Trigger，指明星期几几点几分执行
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
					.weeklyOnDayAndHourAndMinute(3, 15, 37);
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("myTrigger", "myTriggerGroup")
					.withSchedule(scheduleBuilder).build();

			// 用scheduler将JobDetail与Trigger关联在一起，开始调度任务
			sched.scheduleJob(jobDetail, trigger);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	// 实现需要执行的任务
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Generating report - "
				+ context.getJobDetail().getDescription() + ", type ="
				+ context.getJobDetail().getJobDataMap().get("type"));
		System.out.println(new Date().toString());

	}

}
