package com.example.model;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventListener {
	
	
	@KafkaListener(topics = "flipkartProduct", groupId = "consumer_product_group",
			containerFactory = "kafkaListenerContainerFactory")
	public void consumerEvents(Product product) {
		log.info("Received Original Message as: {}",product);
		
	}

}
