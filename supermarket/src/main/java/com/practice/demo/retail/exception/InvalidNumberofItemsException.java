package com.practice.demo.retail.exception;

/**
 * This exception is used if the number of items entered exceeds the total
 * number of items for a particular item code while calculating price of an item
 * set of a particular item code
 * 
 * This exception is also used during checkin when the minimum number of items
 * required for discount exceeds the total number of items of the item code
 * 
 * @author bhaskar thalwar
 *
 */
public class InvalidNumberofItemsException extends RuntimeException {

	public InvalidNumberofItemsException(String message) {
		super(message);
	}

	public InvalidNumberofItemsException(Throwable cause) {
		super(cause);
	}

	public InvalidNumberofItemsException(String message, Throwable cause) {
		super(message, cause);
	}

}
