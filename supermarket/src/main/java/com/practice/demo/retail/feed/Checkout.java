package com.practice.demo.retail.feed;

import java.io.IOException;
import java.util.List;

import com.practice.demo.retail.supermarket.Item;

/**
 * This interface is used to checkout an item with a particular item code Also
 * used for checking out all the items by calculating their cumulative sum Also
 * used for displaying the entire catalogue
 * 
 * @author bhaskar thalwar
 *
 */

public interface Checkout {

	/**
	 * 
	 * @param itemCode
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public double checkoutItem(String itemCode) throws NumberFormatException, IOException;

	/**
	 * 
	 * @param items
	 * @return
	 */
	public double checkoutAllItems(List<Item> items);

	/**
	 * 
	 * @param items
	 */
	public void showCatalog(List<Item> items);

}
