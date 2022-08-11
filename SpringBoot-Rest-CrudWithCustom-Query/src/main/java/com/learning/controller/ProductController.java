package com.learning.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product) {
		
		productService.saveProduct(product);
		
		return "Product is inserted successfully into the Database";
		
	}
	
	@GetMapping("/getProductDetails")
	public Iterable<Product> getProductDetails() {
		return productService.getCategoryRecords();
	}
	
	@GetMapping("/getproductInDesc")
	public List<Product> fetchProductDetailInDescendingOrder() {
		List<Product> list = (List<Product>) productService.getCategoryRecords();
		return list.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
	}
	
	@GetMapping("/getproductInAscc")
	public List<Product> fetchProductDetailInAscendingOrder() {
		List<Product> list = (List<Product>) productService.getCategoryRecords();
		return list.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
	}
	
	@GetMapping("/getproductInAscc/{productID}")
	public Product fetchProductDetailByID(@PathVariable Integer productID) throws ProdutNotFoundException {
		return productService.get(productID);
	}
	
	
	@PutMapping("/updateProductDetails")
	public Product updateProductDetails(@RequestBody Product product) throws ProdutNotFoundException {
		return productService.updateProductRecords(product);
	}
	
	@GetMapping("/findByName/{name}")
	public List<Product> findByNameContaining(@PathVariable String name) throws ProdutNotFoundException {
		return productService.findByNameContaining(name);
	}
	
	
//	@GetMapping("/findByName/{name}/{price}")
//	public List<Product> findByNameAndPrice(@PathVariable String name, Double price) throws ProdutNotFoundException {
//		return productService.findByNameAndPrice(name, price);
//	}
//	
//	@GetMapping("/findByPrice/{price}")
//	public List<Product> findByPrice(@PathVariable double price) throws ProdutNotFoundException {
//		return productService.findByPrice(price);
//	}
	
	@DeleteMapping("/deleteProductDetails/{productID}")
	public String deleteProductDetails(@PathVariable Integer productID) throws ProdutNotFoundException {
		productService.deleteProductRecords(productID);
		
		return "Records deleted successfully!";
	}
}
