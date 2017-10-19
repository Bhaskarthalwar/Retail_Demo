package com.assignment.ubs.standalone.supermarket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.*;
import org.testng.annotations.BeforeClass;
import com.practice.demo.retail.feed.CheckIn;
import com.practice.demo.retail.feed.CheckInImpl;
import com.practice.demo.retail.feed.Checkout;
import com.practice.demo.retail.feed.CheckoutImpl;
import com.practice.demo.retail.supermarket.SuperMarket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a stand alone test class ,can be run on JVM by issuing a simple
 * java command .
 * 
 * It has 4 test cases
 * 
 * 1. checkin 2. single item type checkout 3. All items checkout with sum 4.
 * Display all the items to the client
 * 
 * @author bhaskar thalwar
 *
 */
public class SuperMarketClient {

	static Logger logger = Logger.getLogger(SuperMarketClient.class.getName());

	public static void main(String[] args) {

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
			Checkout cout = new CheckoutImpl();
			System.out.println("Please enter an item code to checkout");
			System.out.println(cout.checkoutItem(bread.readLine()));
			System.out.println("show the catalog with all the items with price");
			cout.showCatalog(SuperMarket.getItemList());
			System.out.println("The grand summation of all the items in the market");
			System.out.println(cout.checkoutAllItems(SuperMarket.getItemList()));
		} catch (NumberFormatException ne) {
			logger.log(Level.SEVERE, "Number Format Error" + ne);
		} catch (IOException io) {
			logger.log(Level.SEVERE, "IO Excpetion" + io);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error" + e);
		}
	}

}
