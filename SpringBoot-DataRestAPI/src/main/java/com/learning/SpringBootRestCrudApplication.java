package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestCrudApplication.class, args);
	}

//	Hit the below URLs to get the records, just change the method type else urls would be same for all.
//	URls:- localhost:9999/products/4
}