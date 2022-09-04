package com.example.model.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.model.Product;

@Service
public class ProductProducer {

	@Autowired
	KafkaTemplate<String, Product> kafkaTemplate;

	public String publishProducts() {
		Product product = null;
		Random rd = new Random(); // creating Random object
		for (int i = 0; i < 50; i++) {
			product = new Product();
			product.setProductId(rd.nextInt());
			product.setProductName("Mi__" + i);
			product.setCreatedDate(new Date());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			kafkaTemplate.send("flipkartProduct", product);
		}

		return "Product added to Kafka queue successfully";
	}

}
