package com.capgemini.training.service;


import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.training.dao.ProductDAO;
import com.capgemini.training.dao.ProductDaoImpl;
import com.capgemini.training.entity.Product;
import com.capgemini.training.exception.ProductException;

@Service(value = "productServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDao;

	@Override
	public Integer addProduct(Product product) throws ProductException {
		try {
			//validate product
			return productDao.addProduct(product);			
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}

	}

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		try {			
			Product product= productDao.getProductById(productId);
			return product;
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteProduct(Integer productId) throws ProductException {
		try {			
			Integer id= productDao.deleteProduct(productId);
			return id;
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		try {			
			List<Product> productList= 
					productDao.getAllProducts();
			return productList;
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		try {			
			Product updatedProduct= 
					productDao.updateProduct(product);
			return updatedProduct;
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public List<Product> getProductsBetweenPrice(Double p1, Double p2) throws ProductException{
		// TODO Auto-generated method stub
		return null;
	}

}
