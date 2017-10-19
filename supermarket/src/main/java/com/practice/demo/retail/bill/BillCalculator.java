package com.practice.demo.retail.bill;

import java.io.IOException;
import java.util.List;

import com.practice.demo.retail.supermarket.Item;

/**
 * Interface for calculating the price of individual items based on discount
 * amount on items if there is a discount on a number of items
 *
 * 
 * @author bhaskar thalwar
 * 
 *
 */
public interface BillCalculator {
	/**
	 * 
	 * @param items
	 * @return price of all the items
	 */
	public double calculateNetPriceOfAll(List<Item> items);

	/**
	 * 
	 * @param item
	 * @return items price inclusive of discount amount if any
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public double calculateIndividualPrice(Item item) throws NumberFormatException, IOException;

	/**
	 * 
	 * @param item
	 * @return actual price for an item
	 */
	public double calculateActualPrice(Item item);

}
