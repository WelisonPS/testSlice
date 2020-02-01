package br.com.sparktest.sparkTest;

import org.quartz.CronScheduleBuilder;


import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


/**
 * Definições do Job
 * Execução
 * Tempo de execução
 * @author Welison Paixão
 *
 */
public class main {

	public static void main(String[] args) {
		try {

			SchedulerFactory schedFact = new StdSchedulerFactory();
			Scheduler sched = schedFact.getScheduler();
			sched.start();
			//Definição para que o Job rode a cada 10 secundos - Cron Expression
			JobDetail job = JobBuilder.newJob(JobSpark.class).withIdentity("jobSpark", "jobSpark").build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("gatilho", "jobspark")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();
			sched.scheduleJob(job, trigger);

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
