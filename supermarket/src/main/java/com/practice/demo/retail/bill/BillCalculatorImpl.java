package com.practice.demo.retail.bill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.practice.demo.retail.exception.InvalidNumberofItemsException;
import com.practice.demo.retail.supermarket.Item;

/**
 * This is an implementation of Bill calculator interface
 *
 * @author Bhaskar thalwar
 *
 */
public class BillCalculatorImpl implements BillCalculator {

	/**
	 * this method returns the price of all the items available in the
	 * supermarket checks if an item has discount if there is a discount then
	 * uses the discount amount to calculate the price if not then it generates
	 * the actual cost of the item and it sums up for collection of all items
	 * 
	 */
	public double calculateNetPriceOfAll(List<Item> items) {

		double netPrice = 0;
		for (Item item : items) {
			netPrice = netPrice + (item.isHasDiscount()
					? (calculateActualPrice(item) * item.getDiscountAmount() * item.getTotalNumberOfItems())
					: (calculateActualPrice(item) * item.getTotalNumberOfItems()));
		}

		return netPrice;
	}

	/**
	 * This method just returns the actual price for an item this method is used
	 * in other methods
	 * 
	 */
	public double calculateActualPrice(Item item) {

		return (item.getItemPrice());
	}

	/**
	 * This method calculates the price of individual item takes in to account
	 * for how many items needs to calculate the price if the discount is
	 * applicable uses the discounted amount or else uses the actual price of
	 * the items to calculate the price for the items
	 * 
	 * 
	 */
	public double calculateIndividualPrice(Item item) throws NumberFormatException, IOException {

		BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter total number of items to be checked out");
		int numberOfItems = Integer.parseInt(bread.readLine());
		if (numberOfItems > item.getTotalNumberOfItems() || numberOfItems < 1)
			throw new InvalidNumberofItemsException(
					"Please enter valid number of items in the correct range between 1 and "
							+ item.getTotalNumberOfItems());
		if (numberOfItems >= item.getDiscountNumberOfItems() && item.isHasDiscount())
			return calculateActualPrice(item) * item.getDiscountAmount() * numberOfItems;
		else
			return calculateActualPrice(item) * numberOfItems;
	}

}
