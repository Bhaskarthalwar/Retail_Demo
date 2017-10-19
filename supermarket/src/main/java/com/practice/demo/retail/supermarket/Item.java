package com.practice.demo.retail.supermarket;

/**
 * This class is a basic element of store it has item code,item price,discount
 * amount ,minimum number reqd for discount , total number of units ,whether it
 * has discount
 * 
 * @author bhaskar thalwar
 *
 */
public class Item {

	private String itemCode;

	private double itemPrice;

	private double discountAmount;

	private int discountNumberOfItems;

	private boolean hasDiscount;

	private int totalNumberOfItems;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getDiscountNumberOfItems() {
		return discountNumberOfItems;
	}

	public void setDiscountNumberOfItems(int discountNumberOfItems) {
		this.discountNumberOfItems = discountNumberOfItems;
	}

	public boolean isHasDiscount() {
		return hasDiscount;
	}

	public void setHasDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	public void setTotalNumberOfItems(int totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}

}
