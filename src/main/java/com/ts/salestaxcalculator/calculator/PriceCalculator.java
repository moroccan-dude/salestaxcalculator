package com.ts.salestaxcalculator.calculator;

import com.ts.salestaxcalculator.items.IItem;

/**
 * A {@link IPriceCalculator} that computes the item sales tax and its price after tax using a RoundingStrategy
 * 
 * @author Mehdi Bennani
 * @see IRoundingStrategy
 */
public class PriceCalculator implements IPriceCalculator {
	
	private IRoundingStrategy roundingStrategy;

	/**
	 * PriceCalculator constructor
	 * @param roundingStrategy
	 */
	public PriceCalculator(IRoundingStrategy roundingStrategy)
	{
		this.roundingStrategy = roundingStrategy;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public long computeSalesTax(IItem item)
	{
		if(item.getTaxRate()==0 || item.getShelfPrice()==0)
			return 0;
		 
		/* Dummy multiplier to turn the tax rate into a long to avoid loosing the double precision 
		 * Assuming here a maximum of 3 decimal fraction digits for tax rates */
	    int dummyMultiplier = 1000; 
	    long taxRateInt = Math.round( item.getTaxRate() * dummyMultiplier );
	    return roundingStrategy.roundValue(item.getShelfPrice() * taxRateInt / dummyMultiplier) * item.getQuantity();

	}

	/**
	 * {@inheritDoc}
	 */
	public long computeTaxedPrice(IItem item)  
	{
		return item.getShelfPrice() * item.getQuantity() + computeSalesTax(item);
	}

	/**
	 * {@inheritDoc}
	 */
	public double format(long value) 
	{
		return Double.valueOf(value) / IItem.CENTS_MULTIPLIER;
	}
}
