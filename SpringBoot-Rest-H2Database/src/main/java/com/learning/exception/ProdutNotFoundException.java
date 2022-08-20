package com.learning.exception;

public class ProdutNotFoundException extends Exception {
	
	public ProdutNotFoundException(String message) {
		
		super(message);
	}
	
	public ProdutNotFoundException(String message, Throwable cause) {
		
		super(message, cause);
	}

}
