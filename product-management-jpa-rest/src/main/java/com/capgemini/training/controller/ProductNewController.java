package com.capgemini.training.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.training.entity.Product;
import com.capgemini.training.exception.ProductException;
import com.capgemini.training.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@Api
@RestController
@RequestMapping("/api-new/products")
@Slf4j
public class ProductNewController {
	//Autowired byName
	//	@Resource(name = "productServiceSpringData")
	@Autowired(required = false)
	@Qualifier(value = "productServiceSpringData")
	private ProductService productService;

	//get product by Id
	//http://localhost:8081/api-new/products/1
	@ApiOperation(value = "Get product by Id",
			response = Product.class,
			tags = "get-product",
			consumes = "productId",
			httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id){
		try {
			Product product= productService.getProductById(id);
			log.info("Product added"+ product);
			return new ResponseEntity<>(product,HttpStatus.OK);
		}catch(ProductException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//get all products
	//http://localhost:8081/api-new/products/
	@ApiOperation(value = "Get All products",
			response = Product.class,
			tags = "get-product",
			httpMethod = "GET")
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts(){
		try {
			List<Product> productList = productService.getAllProducts();
			log.info("Returning all product details");
			return new ResponseEntity<>(productList,HttpStatus.OK);
		}catch(ProductException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api-new/products/
	//add product
	@ApiOperation(value = "Add product",
			response = String.class,
			consumes = "receives product object as Request body",
			httpMethod = "POST")
	@PostMapping("/")
	public String addProduct(@RequestBody Product product) {
		try {
			Integer status= productService.addProduct(product);
			if(status ==1) {
				log.info("product:"+product.getProductName()+" added to database");
				return "product:"+product.getProductName()+" added to database";
			}else {
				log.debug("Unable to add product");
				return "Unable to add product to database";
			}

		}catch(ProductException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api-new/products/1
	//delete product
	@ApiOperation(value = "Delete product",
			response = Product.class,
			tags = "delete-product",
			consumes = "productId",
			httpMethod = "DELETE")
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		try {
			Integer status= productService.deleteProduct(id);
			if(status ==1) {
				log.info("product: "+id+" deleted from database");
				return "product: "+id+" deleted from database";
			}else {
				log.debug("Unable to delete product from database");
				return "Unable to delete product from database";
			}

		}catch(ProductException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api-new/products/
	//update product
	@ApiOperation(value = "Update product",
			response = Product.class,
			tags = "put-productId",
			consumes = "productId",
			httpMethod = "PUT")
	@PutMapping("/")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		try {
			Product updatedProduct= productService.updateProduct(product);
			log.info("Product: "+ product.getProductId()+ " updated");
			return new ResponseEntity<>(updatedProduct,HttpStatus.OK);

		}catch(ProductException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}


	//get all products between given two prices
	//http://localhost:8081/api-new/products/15000/80000
	@GetMapping("/{p1}/{p2}")
	public ResponseEntity<List<Product>> 
		getProductsBetweenPrice(@PathVariable("p1") Double p1, 
							@PathVariable("p2") Double p2){
		try {
			List<Product> productList= 
					productService.getProductsBetweenPrice(p1, p2);
			return new ResponseEntity<>(productList,HttpStatus.OK);
		}catch(ProductException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
