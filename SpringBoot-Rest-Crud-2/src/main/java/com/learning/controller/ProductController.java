package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Category;
import com.learning.entity.Product;
import com.learning.service.ProductService;

@RestController
@RequestMapping("v1/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product) {
		
		productService.saveProduct(product);
		
		return "Product is inserted successfully into the Database";
		
	}
	
	@GetMapping("/getProductDetails")
	public Iterable<Category> getProductDetails() {
		return productService.getCategoryRecords();
		
		
	}
}
