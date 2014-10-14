package com.ts.salestaxcalculator;

import com.ts.salestaxcalculator.ShoppingCart;
import com.ts.salestaxcalculator.items.BasicItem;
import com.ts.salestaxcalculator.items.Imported;
import com.ts.salestaxcalculator.items.TaxExempted;

/**
 * Basic Driver
 * @author Mehdi Bennani
 *
 */
public class Driver {

	public static void main(String[] args) {

		// 1 book at 12.49
		// 1 music CD at 14.99
		// 1 chocolate bar at 0.85
		System.out.println("Output1");
		ShoppingCart cart1 = new ShoppingCart();
		cart1.addItem(new TaxExempted(new BasicItem("book",12.49)));
		cart1.addItem(new BasicItem("music CD",14.99));
		cart1.addItem(new TaxExempted(new BasicItem("chocolate bar",0.85)));
		cart1.checkout();
		cart1.printReceipt();

		//1 imported box of chocolates at 10.00
		// 1 imported bottle of perfume at 47.50
		System.out.println("\nOutput2");
		ShoppingCart cart2 = new ShoppingCart();
		cart2.addItem(new Imported(new TaxExempted(new BasicItem("box of chocolates",10.00))));
		cart2.addItem(new Imported(new BasicItem("bottle of perfume",47.50)));
		cart2.checkout();
		cart2.printReceipt();

		// 1 imported bottle of perfume at 27.99
		// 1 bottle of perfume at 18.99
		// 1 packet of headache pills at 9.75
		// 1 box of imported chocolates at 11.25
		System.out.println("\nOutput3");
		ShoppingCart cart3 = new ShoppingCart();
		cart3.addItem(new Imported(new BasicItem("bottle of perfume",27.99)));
		cart3.addItem(new BasicItem("bottle of perfume",18.99));
		cart3.addItem(new TaxExempted(new BasicItem("headache pills",9.75)));
		cart3.addItem(new Imported(new TaxExempted(new BasicItem("box of chocolates",11.25))));
		cart3.checkout();
		cart3.printReceipt();

		System.out.println("\nOther Tests");
		ShoppingCart cart4 = new ShoppingCart();
		cart4.addItem(new TaxExempted(new BasicItem("book",12.49,5)));
		cart4.addItem(new BasicItem("music CD",14.99,5));
		cart4.addItem(new Imported(new TaxExempted(new BasicItem("box of chocolates",10.00,5))));
		cart4.addItem(new Imported(new BasicItem("bottle of perfume",47.50,2)));
		cart4.checkout();
		cart4.printReceipt();
		
		System.out.println("\nLow prices");
		ShoppingCart cart5 = new ShoppingCart();
		cart5.addItem(new BasicItem("music CD",0.09));
		cart5.checkout();
		cart5.printReceipt();
		
		System.out.println("\nHigh prices");
		ShoppingCart cart6 = new ShoppingCart();
		cart6.addItem(new BasicItem("music CD",1000000000.42));
		cart6.checkout();
		cart6.printReceipt();
	}

}
