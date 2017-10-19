package com.assignment.ubs.testng.supermarket;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.*;
import org.testng.annotations.BeforeClass;

import com.practice.demo.retail.feed.CheckIn;
import com.practice.demo.retail.feed.CheckInImpl;
import com.practice.demo.retail.feed.Checkout;
import com.practice.demo.retail.feed.CheckoutImpl;
import com.practice.demo.retail.supermarket.SuperMarket;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a mvn testng class ,can be run on command line with proper mvn
 * command
 * 
 * mvn clean install should ideally run all the test cases defined with the
 * priority
 * 
 * It has 4 test cases
 * 
 * 1. checkin 2. single item type checkout 3. All items checkout 4. Display all
 * the items to the client
 * 
 * @author bhaskar thalwar
 *
 */
public class SuperMarketClient {

	static Logger logger = Logger.getLogger(SuperMarketClient.class.getName());

	/**
	 * testng client to test the checkin of the items . Need to enter E
	 * everytime the user finishes entering an item or else it would treat it as
	 * stopping of the checkin process.
	 * 
	 */
	@org.testng.annotations.Test(priority = 1)
	public void checkinItems() {
		try {
			CheckIn cin = new CheckInImpl();
			BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" Type E to add items to supermarket");
			String enter;
			while ((enter = bread.readLine()) != null) {
				if (enter.equalsIgnoreCase("E")) {
					SuperMarket.addItem(cin.checkinItem());
					System.out.println(" Type E to add items to supermarket else you would be taken out");
				} else
					break;

			}
			bread.close();
		} catch (NumberFormatException ne) {
			logger.log(Level.SEVERE, "Number Format Error" + ne);
		} catch (IOException io) {
			logger.log(Level.SEVERE, "IO Excpetion" + io);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error" + e);
		}
	}

	/**
	 * 
	 * testng client to test the checking out of an individual item type with
	 * fixed units.
	 * 
	 */

	@org.testng.annotations.Test(priority = 2)
	public void singleItemCheckout() {
		BufferedReader bread1 = null;
		try {
			Checkout cout = new CheckoutImpl();
			System.out.println("Please enter an item code to checkout");
			bread1 = new BufferedReader(new InputStreamReader(System.in));
			String itemCode = bread1.readLine();
			System.out.println(cout.checkoutItem(itemCode));
		} catch (NumberFormatException ne) {
			logger.log(Level.SEVERE, "Number Format Error" + ne);
		} catch (IOException io) {
			logger.log(Level.SEVERE, "IO Excpetion" + io);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error" + e);
		}
	}

	/**
	 * testng client to display the catalog of all the items with their prices.
	 * 
	 */
	@org.testng.annotations.Test(priority = 3)
	public void showCatalogOfItems() {
		Checkout cout = new CheckoutImpl();
		cout.showCatalog(SuperMarket.getItemList());
	}

	/**
	 * testng client to fetch the sum of all the items in the store inclusive of
	 * if the item has discount or not
	 *
	 */
	@org.testng.annotations.Test(priority = 4)
	public void allItemsCheckout() {
		Checkout cout = new CheckoutImpl();
		System.out.println(cout.checkoutAllItems(SuperMarket.getItemList()));
	}

}
