package com.learning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Category;
import com.learning.exception.CategoryNotFoundException;
import com.learning.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public Category saveCategoryRecords(Category category) {
		return categoryRepository.save(category);
	}

	public Iterable<Category> getCategoryRecords() {
		return categoryRepository.findAll();
	}

	public Category get(Integer id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isPresent()) {
			Category category = optional.get();
			return category;
		} else {
			log.info("Could not find any product with id {}", id);

			throw new CategoryNotFoundException("Could not find any product with id {}" + id);

		}
	}

	public Category updateCategoryRecords(Category category) {
		Category categoryObject = get(category.getID());
		categoryObject.setName(category.getName());
		return categoryRepository.save(categoryObject);

	}

	public void deleteCategoryRecords(Integer category) {

		Category categoryObject = get(category);
		categoryRepository.delete(categoryObject);
	}

}
