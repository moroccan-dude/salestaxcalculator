package com.ts.salestaxcalculator.items;

/**
 * Interface to be implemented by all the Shopping Cart Items
 *
 * @author Mehdi Bennani
 */
public interface IItem {
	
	/**
	 * internal multiplier used to convert price dollar values into cents
	 */
	public final static int CENTS_MULTIPLIER = 100;
	
	/**
	 * 
	 * @return the name of the item
	 */
	public String getName(); 
	
	/**
	 * 
	 * @return the quantity of the item in the cart
	 */
	public int getQuantity(); 
	
	/**
	 * 
	 * @return the item shelfprice
	 */
	public long getShelfPrice(); 

	/**
	 * 
	 * @return the item tax rate
	 */
	public double getTaxRate();
	
	/**
	 * 
	 * @return a more verbose description of the item
	 */
	public String getDescription();
}
