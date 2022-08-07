package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBannerApplication.class, args);
		System.out.println("This is just a custom banner");
	}

}
