package com.practice.demo.retail.exception;

/**
 * This exception is used when the item which needs to be checked out is not in
 * the store , as in when the admin enters an invalid item code this exception
 * would be invoked
 * 
 * @author bhaskar thalwar
 *
 */
public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(String message) {
		super(message);
	}

	public ItemNotFoundException(Throwable cause) {
		super(cause);
	}

	public ItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
