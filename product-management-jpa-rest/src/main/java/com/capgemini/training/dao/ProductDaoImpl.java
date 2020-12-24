package com.capgemini.training.dao;


import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.training.entity.Product;

//Spring JPA

@Repository
public class ProductDaoImpl implements ProductDAO{
	@PersistenceContext
	private EntityManager entityManager;
			
	
	public Integer addProduct(Product product) throws PersistenceException {
		
		try {			
			
			entityManager.persist(product);
			entityManager.flush();
			
			return 1;
		}catch(PersistenceException e) {
			
			throw e;
		}catch(Exception e) {
			throw e;
		}	
		
		
	}

	public Product getProductById(Integer productId) throws PersistenceException {
		
		try {

			Product product =
					entityManager.find(Product.class, productId);			

			return product;
		}catch(PersistenceException e) {

			throw e;
		}catch(Exception e) {
			throw e;
		}	
		
	}

	
	public Integer deleteProduct(Integer productId) throws PersistenceException {
		
		try {
			
			Product product= 
					entityManager.find(Product.class, productId);
			entityManager.remove(product);
//			entityManager.flush();
			
			return product.getProductId();
		}catch(PersistenceException e) {
			
			throw e;
		}catch(Exception e) {
			throw e;
		}	
	}

	public List<Product> getAllProducts() throws PersistenceException {
		
		//		String jql="select p from Product p";
		String jql= "From Product p";
		try {			
			
//			Query q= entityManager.createQuery(jql);
			TypedQuery<Product> query=
					entityManager.createQuery(jql, Product.class);
			List<Product> productList=query.getResultList();
						
			return productList;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();		
			
			throw e;
		}catch(Exception e) {
			throw e;
		}
	}

	public Product updateProduct(Product product) throws PersistenceException {
		
		try {
			
			Product updatedProduct= 
					entityManager.merge(product);			
			entityManager.flush();
				
			return updatedProduct;
		}catch(PersistenceException e) {
			
			throw e;
		}catch(Exception e) {
			throw e;
		}	
	}

}
