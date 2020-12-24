package com.capgemini.training.dao;


import java.util.List;

import javax.persistence.PersistenceException;

import com.capgemini.training.entity.Product;

public interface ProductDAO {
	public Integer addProduct(Product product) throws PersistenceException;
	public Product getProductById(Integer productId) throws PersistenceException;
	public Integer deleteProduct(Integer productId) throws PersistenceException;
	public List<Product> getAllProducts() throws PersistenceException;
	public Product updateProduct(Product product) throws PersistenceException;
	
}
