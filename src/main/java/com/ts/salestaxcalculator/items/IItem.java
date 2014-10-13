package com.ts.salestaxcalculator.items;

/**
 * Interface to be implemented by all the Shopping Cart Items
 *
 * @author Mehdi Bennani
 */
public interface IItem {
	
	/**
	 * 
	 * @return the name of the item
	 */
	String getName(); 
	
	/**
	 * 
	 * @return the quantity of the item in the cart
	 */
	int getQuantity(); 
	
	/**
	 * 
	 * @return the item shelfprice
	 */
	double getShelfPrice(); 

	/**
	 * 
	 * @return the item tax rate
	 */
	double getTaxRate();
	
	/**
	 * 
	 * @return a more verbose description of the item
	 */
	String getDescription();
}
