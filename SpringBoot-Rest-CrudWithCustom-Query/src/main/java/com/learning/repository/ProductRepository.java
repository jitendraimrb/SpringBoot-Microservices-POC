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
	
	
	/* Here below there are few examples for HQL query */
	
//	@Query("select p from Product p")
//	List<Product> fetchAllProduct();
//	
//	@Query("select p.name from Product where p.id=:id")
//	public String fetchProductNameById(Integer id);
//	
//	@Query("select p.name from Product where p.id=?1")
//	public String fetchProductNameById1(Integer id);
//	
//	
//	@Query("select p from Product where p.id=?1 and p.name=?2")
//	public Product fetchProductByNameAndId(Integer id, String pName);
//	
//	@Query("select p from Product where p.name LIKE %?1%")
//	public List<Product> fetchProduct(String keyword);
	
}
