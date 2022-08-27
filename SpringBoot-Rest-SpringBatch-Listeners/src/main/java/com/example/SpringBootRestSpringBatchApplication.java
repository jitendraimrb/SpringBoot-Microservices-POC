package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringBootRestSpringBatchApplication {
	
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestSpringBatchApplication.class, args);
	}
	
//	@Scheduled(initialDelay = 3000, fixedDelayString = "30000")
	@Scheduled(cron = "*/10 * * * * *")
	public void perform() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameter = new JobParametersBuilder()
				.addString("jobId", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, jobParameter);
	}

}
