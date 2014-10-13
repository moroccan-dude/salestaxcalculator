package com.ts.salestaxcalculator.items;

/**
 * A basic Shopping Cart Item representing goods in general.
 * 
 * @author Mehdi Bennani
 *
 */
public class BasicItem implements IItem {

	/* A BasicItem is taxable at a {@link #BASIC_SALE_TAX} rate. */
	public static final double BASIC_SALE_TAX = 0.1; // 10%
	
	private String name;
	private int quantity;
	private double shelfPrice;
	
	/**
	 * Constructor that takes the name and the item shelfPrice
	 * Item quantity is by default set to 1
	 * 
	 * @param name
	 * @param shelfPrice
	 * @throws IllegalArgumentException if invalid negative shelfprice
	 * {@link  #BasicItem(String, double, int)}
	 */
	public BasicItem(String name, double shelfPrice)
	{
		this(name, shelfPrice, 1);
	}
	
	/**
	 * Constructor that takes the name, the item shelfPrice and the quantity
	 * 
	 * @param name
	 * @param shelfPrice
	 * @param quantity
	 * @throws IllegalArgumentException if invalid negative shelfprice
	 */
	public BasicItem(String name, double shelfPrice, int quantity)
	{
		if(shelfPrice<0)
		{
			throw new IllegalArgumentException("Illegal price: " + shelfPrice); //TODO i18n
		}
		
		setName(name);
		setShelfPrice(shelfPrice);
		setQuantity(quantity);
	}
	
	/**
	 * (non-Javadoc)
	 * @see com.ts.salestaxcalculator.items.IItem#getTaxRate()
	 */
	public double getTaxRate() {
		return BASIC_SALE_TAX;
	}

	/**
	 * (non-Javadoc)
	 * @see com.ts.salestaxcalculator.items.IItem#getDescription()
	 */
	public String getDescription() {
		return getName();
	}
	
	/**
	 * (non-Javadoc)
	 * @see com.ts.salestaxcalculator.items.IItem#getName()
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * set the Item name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * (non-Javadoc)
	 * @see com.ts.salestaxcalculator.items.IItem#getQuantity()
	 */
	public int getQuantity() 
	{
		return quantity;
	}
	
	/**
	 * set the item quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	/**
	 * (non-Javadoc)
	 * @see com.ts.salestaxcalculator.items.IItem#getShelfPrice()
	 */
	public double getShelfPrice() 
	{
		return shelfPrice;
	}
	
	/**
	 * set the item shelf price
	 * 
	 * @param shelfPrice
	 */
	public void setShelfPrice(double shelfPrice) 
	{
		this.shelfPrice = shelfPrice;
	}
}
