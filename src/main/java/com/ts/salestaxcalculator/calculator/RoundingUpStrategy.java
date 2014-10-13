package com.ts.salestaxcalculator.calculator;

/**
 * A {@link IRoundingStrategy} that rounds values up to the nearest {@link #PRECISION_PERCENT} value
 * 
 * @author Mehdi Bennani
 * @see IRoundingStrategy
 * 
 */
public class RoundingUpStrategy implements IRoundingStrategy {

	/**
	 * Rounding value in percentage
	 */
	public static final long PRECISION_PERCENT = 5;

	/**
	 * 
	 * @param value
	 * @return rounded up to the nearest {@link #PRECISION_PERCENT}
	 */
	public long roundValue(double value) 
	{
		if(value <= PRECISION_PERCENT)
		{
			 return PRECISION_PERCENT;
		}
		
		/* Dummy multiplier to turn the value into a long to avoid loosing the double precision */ 
		int dummyMultiplier = 10000; 
		long longValue = (Double.valueOf(value * dummyMultiplier).longValue())/dummyMultiplier;
		
		long roundedValue = longValue % PRECISION_PERCENT == 0 ? longValue : longValue + (PRECISION_PERCENT - (longValue % PRECISION_PERCENT));
		return roundedValue;
	}
}
