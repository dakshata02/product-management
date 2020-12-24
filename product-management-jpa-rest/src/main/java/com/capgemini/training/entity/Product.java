package com.capgemini.training.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_cg_jpa")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "product_name",nullable = false)
	private String productName;
	@Column(name = "product_catagory")
	private String productCategory;
	@Column(name = "manufacture_date")
	private LocalDate manufactureDate;
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	@Column(name = "product_price")
	private Double productPrice;
	
	public Product() {
		
	}

	public Product(Integer productId, String productName, String productCategory, LocalDate manufactureDate,
			LocalDate expiryDate, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.productPrice = productPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
				+ ", productPrice=" + productPrice + "]";
	}
	
	
	
}
