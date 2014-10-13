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
	long computeSalesTax(IItem item);
	
	/**
	 * Compute the item price after tax
	 * 
	 * @param item to compute
	 * @return the price of this item after tax
	 */
	long computeTaxedPrice(IItem item);
	
	/**
	 * Convert back the price from its long representation to its double value
	 * 
	 * @param value to format
	 * @return formatted value as double 
	 */
	double toDoublePrice(long value);
	
}
