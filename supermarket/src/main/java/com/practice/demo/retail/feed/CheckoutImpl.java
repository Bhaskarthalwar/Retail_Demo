package com.practice.demo.retail.feed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.practice.demo.retail.bill.BillCalculator;
import com.practice.demo.retail.bill.BillCalculatorImpl;
import com.practice.demo.retail.exception.ItemNotFoundException;
import com.practice.demo.retail.supermarket.Item;
import com.practice.demo.retail.supermarket.SuperMarket;

/**
 * This class is used to checkout individual items with a particular item code
 * and its price also used for checking out all the items of the store also used
 * for showing the whole catalog of the store to the client
 * 
 * This class has a relationship with BillCalculator
 * 
 * @author bhaskar thalwar
 *
 */
public class CheckoutImpl implements Checkout {

	BillCalculator bc;

	/**
	 * This method is to checkout an individual item with a number of units and
	 * its price inclusive of discount if any
	 */
	public double checkoutItem(String itemCode) throws NumberFormatException, IOException {

		bc = new BillCalculatorImpl();
		Item it = checkForValidItem(itemCode);
		if (it != null)
			return bc.calculateIndividualPrice(it);
		else {
			throw new ItemNotFoundException("Please enter a valid item which is in the store");
		}
	}

	/**
	 * 
	 * @param itemCode
	 * @return
	 */
	private Item checkForValidItem(String itemCode) {

		List<Item> items = SuperMarket.getItemList();
		for (Item item : items) {
			if (item.getItemCode().equals(itemCode))
				return item;
		}

		return null;

	}

	/**
	 * Check out all the items and their cumulative price inclusive of discount
	 */
	public double checkoutAllItems(List<Item> items) {

		bc = new BillCalculatorImpl();
		return bc.calculateNetPriceOfAll(items);
	}

	/**
	 * This method is to display the whole items catalog to the client
	 * 
	 */
	public void showCatalog(List<Item> items) {

		BillCalculator bc = new BillCalculatorImpl();
		System.out.println("Displaying all the items in the catalog");
		for (Item item : items) {
			List<Item> itemPrice = new ArrayList<Item>();
			System.out.println("Item Code : " + item.getItemCode());
			System.out.println("Item price : " + item.getItemPrice());
			System.out.println("Total number of items : " + item.getTotalNumberOfItems());
			System.out.println("If Item has discount amount : " + item.isHasDiscount());
			if (item.isHasDiscount()) {
				System.out.println("Amount for individual item after discount: " + item.getDiscountAmount() * item.getItemPrice());
				System.out.println("Minimum number of items required for discount : " + item.getDiscountNumberOfItems());
			} else {
				System.out.println("Discount amount for individual item : " + 0);
				System.out.println("Minimum number of items required for discount : none");
			}
			itemPrice.add(item);
			System.out.println("Total amount of all the items with code " + item.getItemCode() + " is : "
					+ bc.calculateNetPriceOfAll(itemPrice));
			itemPrice = null;
		}
	}

}
