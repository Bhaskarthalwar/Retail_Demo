package com.practice.demo.retail.supermarket;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a base repository for storing all the items for the super market
 * 
 * @author thalwar
 *
 */
public class SuperMarket {

	private static List<Item> items = new ArrayList<Item>();

	public static List<Item> getItemList() {
		return items;
	}

	public static void addItem(Item it) {
		items.add(it);
	}

}
