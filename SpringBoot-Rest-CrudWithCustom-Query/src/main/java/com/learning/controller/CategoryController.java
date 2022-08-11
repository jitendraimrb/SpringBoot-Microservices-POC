package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
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
@RequestMapping("/product/category/v1")
public class CategoryController implements SwaggerInterface{

	@Autowired
	CategoryService categoryService;
	
	@PostMapping(value = "/saveCategory")
////	@ResponseStatus(code = HttpStatus.CREATED)
//	@Operation(summary = "Responsible for inesrting the new records")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "201", description = "Productd has been created successfully", 
//					content = @Content(mediaType = "application/json",
//					schema = @Schema(implementation = Product.class)) ),
//			@ApiResponse(responseCode = "401", description = "Unauthorized Access",content = @Content),
//			@ApiResponse(responseCode = "403", description = "Forbidden access",content = @Content)
//	})
	public ResponseEntity<String> saveCategoryRecords(@RequestBody Category category) {
		categoryService.saveCategoryRecords(category);
		
		return new ResponseEntity<String>("Productd has been created successfully", HttpStatus.CREATED);
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
	
	@PutMapping(value = "/updateCategory/{id}/{name}")
	public void updateCategoryNameRecordsByID(@PathVariable Integer id, @PathVariable String name) {
		System.out.println("-----------------------------------  ");
		categoryService.updateCategoryName(id, name);
	}
	
}
