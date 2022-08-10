package com.learning.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Serializable>{

	
	List<Product> findByNameAndPrice(String name, double price);
	
	List<Product> findByNameContaining(String name);
	
//	List<Product> findByPrice(Double price);
}
