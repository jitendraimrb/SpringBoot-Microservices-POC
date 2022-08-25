package com.example.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collation = "product")
@Data
public class Product {
	
	@Id
	private String id;

	@Field(name = "product_name")
	private String name;
	private String desc;
	private boolean active;
	private float price;
}
