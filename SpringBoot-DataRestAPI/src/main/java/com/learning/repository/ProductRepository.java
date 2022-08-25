package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}