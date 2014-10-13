package com.ts.salestaxcalculator.items;

/**
 * A {@link TaxableItem} class that adds import taxes into an item
 *
 * @author Mehdi Bennani
 * @see TaxableItem
 */
public class Imported extends TaxableItem {

	/**
	 * Import taxes
	 */
	public static final double TAX_VALUE = 0.05; //5%
	public static final String IMPORTED_PREFIX = "imported ";     //TODO i18n

	public Imported(IItem taxableItem) {
		super(taxableItem);
	}

	@Override
	public double getTaxRate() {
		return super.getTaxRate() + TAX_VALUE;
	}

	@Override
	public String getDescription() {
		return IMPORTED_PREFIX + super.getDescription();
	}

}
