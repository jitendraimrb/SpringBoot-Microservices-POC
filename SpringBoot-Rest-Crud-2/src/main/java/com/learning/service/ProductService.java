package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Category;
import com.learning.entity.Product;
import com.learning.repository.CategoryRepository;
import com.learning.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService categoryService;

	public void saveProduct(Product product) {

		Category inputCategory = product.getCategory();
		Category dbCategory = categoryService.get(inputCategory.getID());
		product.setCategory(dbCategory);
		productRepository.save(product);
	}
	
	public Iterable<Category> getCategoryRecords() {
		return categoryRepository.findAll();
	}

}
