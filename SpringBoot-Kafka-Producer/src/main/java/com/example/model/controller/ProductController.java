package com.example.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductProducer productProducer;
	
	@GetMapping("/publish")
	public String publishProduct()
	{
	return 	productProducer.publishProducts();
	}
}
