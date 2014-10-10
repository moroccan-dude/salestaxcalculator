package com.ts.salestaxcalculator.items;

/**
 * A {@link TaxableItem} class that exempts an Item from sales tax
 *
 * @author Mehdi Bennani
 * @see TaxableItem
 */
public class TaxExempted extends TaxableItem {

	public TaxExempted(IItem taxableItem) {
		super(taxableItem);
	}

	@Override
	public double getTaxRate() {
		return 0;
	}

}
