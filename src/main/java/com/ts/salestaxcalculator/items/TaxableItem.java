package com.ts.salestaxcalculator.items;

/**
 * The base abstract class decorator for an {@link IItem}.
 * Subclass this abstract class to change the run-time behavior of an IItem.
 * 
 * @author Mehdi Bennani
 * @see IItem
 */
public abstract class TaxableItem implements IItem
{
	protected IItem taxableItem;
	 
    public TaxableItem(IItem taxableItem) {
        this.taxableItem = taxableItem;
    }

	@Override
	public double getTaxRate()
	{
		return taxableItem.getTaxRate();
	}
	
    @Override
	public String getDescription()
	{
		return taxableItem.getDescription();
	}

	@Override
	public int getQuantity() 
	{
		return taxableItem.getQuantity();
	}

	@Override
	public String getName() {
		return taxableItem.getName();
	}

	@Override
	public double getShelfPrice() {
		return taxableItem.getShelfPrice();
	}
	
//    @Override
//	public double format(long price) {
//		return taxableItem.format(price);
//	}
}
