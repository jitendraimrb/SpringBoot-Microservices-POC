package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.collections.Product;

@Repository
public interface ProductRespository extends MongoRepository<Product, Integer>{

}
