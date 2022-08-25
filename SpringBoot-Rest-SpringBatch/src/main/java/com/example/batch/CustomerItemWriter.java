package com.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.models.Customer;
import com.example.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerItemWriter implements ItemWriter<Customer>{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void write(List<? extends Customer> items) throws Exception {
		
		log.info("Customer :: Entry");
		
	   customerRepository.saveAll(items);
	   
	   log.info("Customer :: Exit");
	}  

}
