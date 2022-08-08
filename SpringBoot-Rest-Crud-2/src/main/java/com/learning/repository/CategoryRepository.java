package com.learning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
