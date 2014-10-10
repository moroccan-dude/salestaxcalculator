package com.ts.salestaxcalculator.items;

/**
 * A {@link TaxableItem} class that adds import taxes into an item
 *
 * @author Mehdi Bennani
 * @see TaxableItem
 */
public class Imported extends TaxableItem {

	private final double IMPORT_TAX = 0.05; //5%

	public Imported(IItem taxableItem) {
		super(taxableItem);
	}

	@Override
	public double getTaxRate() {
		return super.getTaxRate() + IMPORT_TAX;
	}

	@Override
	public String getDescription() {
		return "imported " + super.getDescription();
	}

}
