package com.capgemini.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.training.dao.ProductSpringDataDAO;
import com.capgemini.training.entity.Product;
import com.capgemini.training.exception.ProductException;

@Primary
@Service( value = "productServiceSpringData")
@Transactional
public class ProductServiceSpringDataImpl implements ProductService{
	@Autowired
	private ProductSpringDataDAO productSpringDataDaoImpl;
	
	@Override
	public Integer addProduct(Product product) throws ProductException {
			try {
				Product p= 
						productSpringDataDaoImpl.save(product);
				System.out.println(p);
				return p.getProductId();
			}catch(DataAccessException e) {
				throw new ProductException(e.getMessage(),e);
			}catch(Exception e) {
				throw new ProductException(e.getMessage(),e);
			}
	}

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		try {
			Optional<Product> optional= 
					productSpringDataDaoImpl.findById(productId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new ProductException(e.getMessage(),e);
		}catch(Exception e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteProduct(Integer productId) throws ProductException {
		try {
			productSpringDataDaoImpl.deleteById(productId);
			return productId;
		}catch(DataAccessException e) {
			throw new ProductException(e.getMessage(),e);
		}catch(Exception e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		try {
			List<Product> productList=
					productSpringDataDaoImpl.findAll();
			return productList;
		}catch(DataAccessException e) {
			throw new ProductException(e.getMessage(),e);
		}catch(Exception e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		try {
			Product p= 
					productSpringDataDaoImpl.save(product);
			return p;
		}catch(DataAccessException e) {
			throw new ProductException(e.getMessage(),e);
		}catch(Exception e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public List<Product> getProductsBetweenPrice(Double p1, Double p2) throws ProductException{
		try {
			List<Product> productList=
					productSpringDataDaoImpl.getProductsBetweenPrice(p1, p2);
			return productList;
		}catch(DataAccessException e) {
			throw new ProductException(e.getMessage(),e);
		}catch(Exception e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

}
