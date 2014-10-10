package com.ts.salestaxcalculator.calculator;

import com.ts.salestaxcalculator.items.IItem;

/**
 * Interface to be implemented by Price Calculators
 *
 * @author Mehdi Bennani
 */
public interface IPriceCalculator {

	/**
	 * Compute the sale tax 
	 * 
	 * @param item to compute
	 * @return the Sale tax applicable to this item
	 */
	public long computeSalesTax(IItem item);
	
	/**
	 * Compute the item price after tax
	 * 
	 * @param item to compute
	 * @return the price of this item after tax
	 */
	public long computeTaxedPrice(IItem item);
	
	/**
	 * Convert from a long value into a double value
	 * 
	 * @param value to format
	 * @return formatted value as double 
	 */
	public double format(long value);
	
}
