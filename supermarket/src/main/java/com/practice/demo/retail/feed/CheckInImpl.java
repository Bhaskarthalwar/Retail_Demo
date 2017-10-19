package com.practice.demo.retail.feed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.practice.demo.retail.exception.InvalidDiscountException;
import com.practice.demo.retail.exception.InvalidNumberofItemsException;
import com.practice.demo.retail.supermarket.Item;
import com.practice.demo.retail.supermarket.SuperMarket;

/**
 * This class reads an item code and populates all its attributes and returns
 * the item to the client which in turn puts the item to the supermarket
 * 
 * @author bhaskar thalwar
 *
 */
public class CheckInImpl implements CheckIn {

	/**
	 * This implementation stores the items with item code item price total
	 * number of items of this type if it has discount or not if it has discount
	 * the minimum number of items for which discount is availed the discount
	 * amount for each item in case of discount
	 * 
	 */

	public Item checkinItem() throws IOException {

		System.out.println("Please add an item to the retail");
		BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Item Code");
		Item it = new Item();
		it.setItemCode(bread.readLine());
		System.out.println("Enter Item Price");
		it.setItemPrice(Double.parseDouble(bread.readLine()));
		System.out.println("Enter the total number of items");
		it.setTotalNumberOfItems(Integer.parseInt(bread.readLine()));
		System.out.println("Enter if Item has an discount offer please enter yes/no");
		String discStr = bread.readLine();
		boolean hasDiscount = (discStr.equalsIgnoreCase("yes") ? true : false);
		it.setHasDiscount(hasDiscount);
		if (hasDiscount) {
			System.out.println("Enter number of Items for Discount");
			int numberOfItems = Integer.parseInt(bread.readLine());
			if (numberOfItems > it.getTotalNumberOfItems() || numberOfItems < 1)
				throw new InvalidNumberofItemsException(
						"Please enter valid number of items in the correct range between 1 and "
								+ it.getTotalNumberOfItems());
			it.setDiscountNumberOfItems(numberOfItems);
			System.out.println("Enter discounted amount for individual item in terms of percentage");
			double discountAmt = Double.parseDouble(bread.readLine());
			if (discountAmt > 100 || discountAmt < 1)
				throw new InvalidDiscountException("Please enter the discount amount between 1 and 100");
			it.setDiscountAmount((1 - (discountAmt * 0.01)));
			System.out.println("Successfully added item with code " + it.getItemCode());
		} else {
			it.setDiscountAmount(1);
			it.setDiscountNumberOfItems(0);
		}
		return it;
	}

}
