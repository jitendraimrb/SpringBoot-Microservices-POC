package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.collections.Product;
import com.example.repository.ProductRespository;

@RestController
@RequestMapping("/product/api/v1")
public class ProductController {

	@Autowired
	private ProductRespository productRespository;
	
	@PostMapping("/insertRecords")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		
		return productRespository.insert(product);
	}
	
	@GetMapping("/getRecords")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Product> getProducts(){
		
		return productRespository.findAll();
	}
}
