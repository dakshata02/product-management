package com.capgemini.training.exception;

public class ProductException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;

	public ProductException() {
		
	}

	public ProductException(String message) {
		super(message);
		this.message=message;
	}
	
	public ProductException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "ProductException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
	
}
