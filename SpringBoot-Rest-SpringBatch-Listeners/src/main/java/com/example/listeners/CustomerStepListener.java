package com.example.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import com.example.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class CustomerStepListener implements StepExecutionListener{
	
	private CustomerRepository customerRepository;
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		
		ExecutionContext executionContext= stepExecution.getExecutionContext();
		executionContext.put("recordCount", customerRepository.count());
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		ExecutionContext executionContext= stepExecution.getExecutionContext();
		
		long countBeforeStep = executionContext.getLong("recordCount");
		long countAfterStep = customerRepository.count();
		long updateCount = countBeforeStep - countAfterStep;
		
		log.info("Total Records Inserted in DB :: {}",updateCount);
		log.info("Total Records Processed :: {}", stepExecution.getWriteCount());
		log.info("Status :: {}", stepExecution.getExitStatus().getExitCode());
		
		// TODO Auto-generated method stub
		return null;
	}

}
