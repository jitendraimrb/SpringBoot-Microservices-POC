package com.learning.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Serializable>{

}
