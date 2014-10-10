package com.ts.salestaxcalculator.receipt;


/**
 * A class that represents receipt items
 * 
 * @author Mehdi Bennani
 * @see Receipt
 */
public class ReceiptEntry {

	private int quantity;
	private double taxPrice;
	private String description;

	/**
	 * 
	 * @param quantity
	 * @param description
	 * @param taxPrice
	 */
	public ReceiptEntry(int quantity, String description, double taxPrice)
	{
		this.quantity = quantity;
		this.description = description;
		this.taxPrice = taxPrice;
	}

	/**
	 * 
	 * @return the receipt item quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @return the receipt item tax price
	 */
	public double getTaxPrice() {
		return taxPrice;
	}

	/**
	 * 
	 * @return the receipt item description 
	 */
	public String getDescription() {
		return description;
	}

}
