package com.javacodegeeks.quartz;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class QuartzSchedulerPropertiesExample implements ILatch {
	private int repeatCount = 3;
	private CountDownLatch latch = new CountDownLatch(repeatCount + 1);

	public static void main(String[] args) throws Exception {
		QuartzSchedulerPropertiesExample quartzSchedulerExample = new QuartzSchedulerPropertiesExample();
		quartzSchedulerExample.fireJob();
	}

	public void fireJob() throws SchedulerException, InterruptedException {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		Scheduler scheduler = schedFact.getScheduler();
		System.out.println("Scheduler name is: " + scheduler.getSchedulerName());
		System.out.println("Scheduler instance ID is: " + scheduler.getSchedulerInstanceId());
		System.out.println(
				"Scheduler context's value for key QuartzTopic is " + scheduler.getContext().getString("QuartzTopic"));
		scheduler.start();

		// define the job and tie it to our HelloJob class
		JobBuilder jobBuilder = JobBuilder.newJob(MyJob.class);
		JobDataMap data = new JobDataMap();
		data.put("latch", this);

		JobDetail jobDetail = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerExample")
				.usingJobData(data).withIdentity("myJob", "group1").build();
		JobDetail jobDetail1 = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerExample")
				.usingJobData(data).withIdentity("myJob1", "group1").build();
		JobDetail jobDetail2 = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerExample")
				.usingJobData(data).withIdentity("myJob2", "group1").build();
		JobDetail jobDetail3 = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerExample")
				.usingJobData(data).withIdentity("myJob3", "group1").build();

		// Trigger the job to run now, and then every 3 seconds
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(1).withIntervalInSeconds(10))
				.withDescription("MyTrigger").build();

		// Trigger the job to run now, and then every 2 seconds
		Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("myTrigger1", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(1).withIntervalInSeconds(5))
				.withDescription("MyTrigger1").build();
		// Trigger the job to run now, and then every 2 seconds
		Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("myTrigger2", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(1).withIntervalInSeconds(5))
				.withDescription("MyTrigger2").build();
		// Trigger the job to run now, and then every 3 seconds
		Trigger trigger3 = TriggerBuilder.newTrigger().withIdentity("myTrigger3", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(1).withIntervalInSeconds(10))
				.withDescription("MyTrigger3").build();

		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(jobDetail, trigger);
		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(jobDetail1, trigger1);
		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(jobDetail2, trigger2);
		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(jobDetail3, trigger3);
		// latch.await();
		System.out.println("All triggers executed. Shutdown scheduler");
		// scheduler.shutdown();
	}

	public void countDown() {
		latch.countDown();
	}
}
