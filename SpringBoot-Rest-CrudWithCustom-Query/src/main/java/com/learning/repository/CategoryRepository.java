package com.learning.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	
	
//	select * from category where name="Mobile";
	Category findByName(String name);
	
	@Query("update Product p SET p.name=?2 where p.id=?1")
	public void updateCategoryName(Integer id, String name);

}
