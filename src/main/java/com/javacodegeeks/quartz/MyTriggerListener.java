package com.javacodegeeks.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {
	private String someProp;

	public String getName() {
		return "MyTrigger: " + someProp;
	}

	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		System.out.println("Trigger fired: " + trigger.getDescription());
	}

	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		return false;
	}

	public void triggerMisfired(Trigger trigger) {
	}

	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
		System.out.println("Trigger completed: " + trigger.getDescription());
	}

	public String getSomeProp() {
		return someProp;
	}

	public void setSomeProp(String someProp) {
		this.someProp = someProp;
	}	
}
