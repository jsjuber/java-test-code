package com.javacodegeeks.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListener implements JobListener {
	
	private String someProp;		

	public String getSomeProp() {
		return someProp;
	}

	public void setSomeProp(String someProp) {
		this.someProp = someProp;
	}

	public String getName() {
		return "MyJobListener: " + someProp;
	}

	public void jobToBeExecuted(JobExecutionContext context) {
//		System.out.println("Job to be exected: " + context.getFireInstanceId() + ", job listener: " + getName());
	}

	public void jobExecutionVetoed(JobExecutionContext context) {
	}

	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		System.out.println("Job was exected: " + context.getFireInstanceId() + ", job listener: " + getName());
	}

}
