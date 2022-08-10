package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Category;
import com.learning.service.CategoryService;

@RestController
@RequestMapping("/v1/product/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping(value = "/saveCategory")
	public Category saveCategoryRecords(@RequestBody Category category) {
		return categoryService.saveCategoryRecords(category);
	}
	
	@GetMapping(value = "/getCategory")
	public Iterable<Category> getCategoryRecords() {
		return categoryService.getCategoryRecords();
	}
	
	@GetMapping(value = "/getCategory/{categoryID}")
	public Category getCategoryRecordsByID(@PathVariable Integer categoryID) {
		return categoryService.get(categoryID);
	}
	
	
	@DeleteMapping(value = "/deleteCategory/{categoryID}")
	public void deleteCategoryRecordsByID(@PathVariable Integer categoryID) {
		categoryService.deleteCategoryRecords(categoryID);
	}
	
	@PutMapping(value = "/updateCategory")
	public Category updateCategoryRecordsByID(@RequestBody Category category) {
		System.out.println("-----------------------------------  ");
		return categoryService.updateCategoryRecords(category);
	}
	
	@GetMapping(value = "/getCategoryByName/{name}")
	public Category getCategoryByName(@PathVariable String name) {
		System.out.println("-----------------------------------  ");
		return categoryService.getCategoryByName(name);
	}
	
}
