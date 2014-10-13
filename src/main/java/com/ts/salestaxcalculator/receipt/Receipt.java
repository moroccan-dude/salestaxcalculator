package com.ts.salestaxcalculator.receipt;

import java.util.List;

/**
 * Represents the Receipt bean
 * 
 * @author Mehdi Bennani
 * @see ReceiptEntry
 */
public class Receipt 
{
	
	private double totalSalesTax = 0;
	private double totalCost = 0;
	
	/**
	 * List of receipt entries making up the receipt
	 */
	private List<ReceiptEntry> entries = null;
	
	public Receipt(List<ReceiptEntry> entries, double totalSalesTax, double totalCost)
	{	
		this.entries = entries;
		this.totalSalesTax = totalSalesTax;
		this.totalCost = totalCost;
	}
	
	/**
	 * @return the list of receipt entries in this receipt
	 */
	public List<ReceiptEntry> getEntries()
	{
		return entries;
	}

	/**
	 * 
	 * @return the total cost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * 
	 * @return the total sales tax amount
	 */
	public double getTotalSalesTax() {
		return totalSalesTax;
	}
}
