package com.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Category;
import com.learning.entity.Product;
import com.learning.exception.CategoryNotFoundException;
import com.learning.exception.ProdutNotFoundException;
import com.learning.repository.CategoryRepository;
import com.learning.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;

	public void saveProduct(Product product) {

		Category inputCategory = product.getCategory();
		Category dbCategory = categoryService.get(inputCategory.getID());
		product.setCategory(dbCategory);
		productRepository.save(product);
	}
	
	public Iterable<Product> getCategoryRecords() {
		return productRepository.findAll();
	}
	
	public Product get(Integer id) throws ProdutNotFoundException {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product product = optional.get();
			return product;
		} else {
			log.info("Could not find any product with id {}", id);

			throw new ProdutNotFoundException("Could not find any product with id {}" + id);

		}
	}

	public Product updateProductRecords(Product product) throws ProdutNotFoundException {
		Product productObject = get(product.getID());
		productObject.setName(product.getName());
		return productRepository.save(productObject);

	}

	public void deleteProductRecords(Integer category) throws ProdutNotFoundException {

		Product productObject = get(category);
		productRepository.delete(productObject);
	}
	
	public List<Product> findByNameAndPrice(String name, Double price) {

		return productRepository.findByNameAndPrice(name, price);
	}

	
	public List<Product> findByNameContaining(String name) {

		return productRepository.findByNameContaining(name);
	}
	
//	public List<Product> findByPrice(Double price) {
//
//		return productRepository.findByPrice(price);
//	}

}
