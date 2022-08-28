package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Order Management Operations",
version = "1.0", description = "Product APIS",contact=@Contact ))
public class SpringBootRestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestCrudApplication.class, args);
	}

}