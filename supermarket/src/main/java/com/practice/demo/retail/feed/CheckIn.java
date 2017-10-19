package com.practice.demo.retail.feed;

import java.io.IOException;
import java.util.List;

import com.practice.demo.retail.supermarket.Item;

/**
 * 
 * This is an interface for feeding all the items with different item codes to
 * the supermarket store
 * 
 * @author bhaskar thalwar
 *
 */
public interface CheckIn {

	/**
	 * This is to return the item to the client which is checked into the store
	 * with various attributes related to Item object
	 * 
	 * @return Item
	 * @throws IOException
	 */
	public Item checkinItem() throws IOException;

}
