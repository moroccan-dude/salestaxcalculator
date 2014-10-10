package com.ts.salestaxcalculator.calculator;

/**
 * A {@link IRoundingStrategy} that rounds values up to the nearest {@link #PRECISION} value
 * 
 * @author Mehdi Bennani
 * @see IRoundingStrategy
 * 
 */
public class RoundingUpStrategy implements IRoundingStrategy {

	/**
	 * Rounding value in percentage
	 */
	public final long PRECISION = 5;

	/**
	 * 
	 * @param value
	 * @return rounded up to the nearest {@link #PRECISION}
	 */
	public long roundValue(double value) 
	{
		if(value <= PRECISION)
			 return (long)PRECISION;
	
		/* Dummy multiplier to turn the value into a long to avoid loosing the double precision */ 
		int dummyMultiplier = 10000; 
		long longValue = (Double.valueOf(value * dummyMultiplier).longValue())/dummyMultiplier;
		long roundedValue = longValue % PRECISION == 0 ? longValue : longValue + (PRECISION - (longValue % PRECISION));
		return roundedValue;
	}
}
