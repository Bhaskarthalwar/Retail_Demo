package com.practice.demo.retail.exception;

/**
 * This Custom exception is for discount value if it exceeds the limit of 100 or
 * subceeds by 1 
 * @author thalwar
 *
 */
public class InvalidDiscountException extends RuntimeException {

	public InvalidDiscountException(String message) {
		super(message);
	}

	public InvalidDiscountException(Throwable cause) {
		super(cause);
	}

	public InvalidDiscountException(String message, Throwable cause) {
		super(message, cause);
	}

}
