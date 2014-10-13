package com.ts.salestaxcalculator.calculator;

/**
 * Interface to be implemented by RoundingStrategies used in the Item PriceCalculation
 *
 * @author Mehdi Bennani
 * @see IPriceCalculator
 */
public interface IRoundingStrategy {
	
	/**
	 * Round the value according to the RoudingStrategy
	 * 
	 * @param value to round
	 * @return the rounded value as per the strategy definition
	 */
	long roundValue(double value);

}
