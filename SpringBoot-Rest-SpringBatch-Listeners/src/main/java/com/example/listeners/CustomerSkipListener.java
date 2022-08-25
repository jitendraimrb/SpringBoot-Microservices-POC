package com.example.listeners;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

import com.example.models.Customer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerSkipListener implements SkipListener<Customer, Customer>{

	@Override
	public void onSkipInRead(Throwable t) {
		
		log.info("CustomerSkipListener :: onSkipInRead:: {}",t.getMessage());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSkipInWrite(Customer item, Throwable t) {
		
		log.info("CustomerSkipListener :: onSkipInWrite :: {}",t.getMessage());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSkipInProcess(Customer item, Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
