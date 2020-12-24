package com.capgemini.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.training.entity.Product;

//Spring Data JPA

@Repository
public interface ProductSpringDataDAO 
				extends JpaRepository<Product,Integer>{
	
	@Query("From Product p where p.productPrice BETWEEN :p1 AND :p2")
	List<Product> getProductsBetweenPrice(@Param("p1") Double p1,
												@Param("p2") Double p2);
	
}
