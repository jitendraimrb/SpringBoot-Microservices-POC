package com.learning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Product;
import com.learning.exception.ProdutNotFoundException;
import com.learning.service.ProductService;

@RestController
@RequestMapping("/product/v1")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody @Valid Product product) {
		
		productService.saveProduct(product);
		
		return new ResponseEntity<String> ("Product is inserted successfully into the Database",HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public Iterable<Product> getProductDetails() {
		return productService.getCategoryRecords();
	}
	
	@DeleteMapping("/{productID}")
	public String deleteProductDetails(@PathVariable Integer productID) throws ProdutNotFoundException {
		productService.deleteProductRecords(productID);
		
		return "Records deleted successfully!";
	}
}
