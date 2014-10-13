package com.ts.salestaxcalculator.calculator;

import com.ts.salestaxcalculator.items.IItem;

/**
 * A {@link IPriceCalculator} that computes the item sales tax and its price after tax using a RoundingStrategy
 * In all its calculation and in order to avoid precision loss, this class handles cents as opposed to dollars.
 * 
 * Callers must call {@link #toDoublePrice(long)} to convert prices back into double. 
 * 
 * @author Mehdi Bennani
 * @see IRoundingStrategy
 */
public class PriceCalculator implements IPriceCalculator {
	
	private IRoundingStrategy roundingStrategy;
	
	/**
	 * internal multiplier used to convert price dollar values into cents
	 */
	final static int TO_CENTS = 100;

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
		{
			return 0;
		}
		 
		/* Dummy multiplier to turn the tax rate into a long to avoid loosing the double precision 
		 * Assuming here a maximum of 3 decimal fraction digits for tax rates */
	    int dummyMultiplier = 1000; 
	    long roundedTaxRate = Math.round( item.getTaxRate() * dummyMultiplier );

	    return roundingStrategy.roundValue(toInternalPrice(item.getShelfPrice()) * roundedTaxRate / dummyMultiplier) * item.getQuantity();
	}

	/**
	 * {@inheritDoc}
	 */
	public long computeTaxedPrice(IItem item)  
	{
		return toInternalPrice(item.getShelfPrice()) * item.getQuantity() + computeSalesTax(item);
	}
	
	/**
	 * (non-Javadoc)
	 * @see com.ts.salestaxcalculator.calculator.IPriceCalculator#toDoublePrice(long)
	 */
	public double toDoublePrice(long price) 
	{
		return toExternalPrice(price);
	}

	/**
	 * Utility method to convert prices from external representation to its internal representation.
	 * 
	 * <p><strong>Note</strong>: this method assumes prices with a maximum of 2 decimal fraction digits</p>
	 * 
	 * @param externalPrice external representation of the price
	 * @return the internal representation of the price
	 */
	private long toInternalPrice(double externalPrice)
	{
		return Math.round(externalPrice * TO_CENTS);
	}
	
	/**
	 * Utility method to convert price from internal representation to its external representation
	 * 
	 * @param internalPrice internal representation of the price
	 * @return the external representation of the price
	 */
	private double toExternalPrice(long internalPrice) 
	{
		return Double.valueOf(internalPrice) / TO_CENTS;
	}	
}
