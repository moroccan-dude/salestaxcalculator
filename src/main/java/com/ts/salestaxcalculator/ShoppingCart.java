package com.ts.salestaxcalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ts.salestaxcalculator.calculator.IPriceCalculator;
import com.ts.salestaxcalculator.calculator.PriceCalculator;
import com.ts.salestaxcalculator.calculator.RoundingUpStrategy;
import com.ts.salestaxcalculator.items.IItem;
import com.ts.salestaxcalculator.printer.IReceiptPrinter;
import com.ts.salestaxcalculator.printer.SimpleReceiptPrinter;
import com.ts.salestaxcalculator.receipt.Receipt;
import com.ts.salestaxcalculator.receipt.ReceiptEntry;

/**
 * Represents the Shopping Cart. It is also the default entry point of the application. 
 * A typical interaction with this class would be:
 * <pre>
 * {@code
 *  ShoppingCart cart = new ShoppingCart();
 *  cart.addItem(new BasicItem("book",12.49));
 *  cart.addItem(new BasicItem("music CD",14.99));
 *  cart.checkout();
 *  cart.printReceipt();
 * }
 * </pre>
 * 
 * @author Mehdi Bennani
 */
public class ShoppingCart {

	/**
	 * Shopping cart list of items
	 */
	private List<IItem> items;
	
	/**
	 * Default receipt printer implementation
	 */
	private IReceiptPrinter printer = new SimpleReceiptPrinter();
	
	/**
	 * Default Price Calculator with the default rounding up strategy
	 */
	private IPriceCalculator calculator = new PriceCalculator(new RoundingUpStrategy());
	
	/**
	 * Shopping cart receipt instance
	 */
	private Receipt receipt = null;
	
	
	/**
	 * Default Constructor
	 */
	public ShoppingCart() {
		items = new ArrayList<IItem>();
	}

	/**
	 * Add an <code>@{IItem}<code> to the shopping cart
	 * 
	 * 
	 * <p>Note: This method does not handle item quantity increment, i.e.: if the same item is added twice in the cart,
	 * it will be handled as two items</p>
	 * @param item
	 */
	public void addItem(IItem item)
	{
		items.add(item);
	}

	/**
	 * Invoke this method to set the IReceiptPrinter to use for this shoppingCart.
	 * The Default implementation {@link SimpleReceiptPrinter} is used by default  
	 * 
	 * @param printer
	 * @see IReceiptPrinter
	 */
	public void setPrinter(IReceiptPrinter printer)
	{
		this.printer = printer;
	}
	
	/**
	 * Invoke this method to set the IPriceCalculator to use for this shoppingCart.
	 * The Default implementation {@link PriceCalculator} is used by default  
	 * 
	 * @param calculator
	 */
	public void setPriceCalculator(IPriceCalculator calculator)
	{
		this.calculator = calculator;
	}

	/**
	 * Invoking this method will trigger the price calculation and Receipt generation for this purchase.
	 * 
	 * Note: this method does NOT clear the cart
	 */
	public void checkout()
	{
		receipt = makeReceipt(Collections.unmodifiableList(new ArrayList<IItem>(items)));
	}

	/** 
	 * @param items
	 * @return to make the receipt bases on the passed in items
	 */
	private Receipt makeReceipt(List<IItem> items)
	{
		long taxPrice;
		long totalSalesTax = 0;	
		long totalCost = 0;
		List<ReceiptEntry> entries  = new ArrayList<ReceiptEntry>(); 
		for(IItem item:items)
		{
			taxPrice = calculator.computeTaxedPrice(item);
			totalSalesTax += calculator.computeSalesTax(item);
			totalCost += taxPrice;
			
			entries.add(new ReceiptEntry(item.getQuantity(), item.getDescription(), calculator.toDoublePrice(taxPrice)));
		}
		
		return new Receipt(entries, calculator.toDoublePrice(totalSalesTax), calculator.toDoublePrice(totalCost));
	}
	
	/**
	 * Prints the receipt corresponding to this cart.
	 * Note that invoking this method with no element in the cart might not produce any result depending on the 
	 * {@link IReceiptPrinter} implementation 
	 */
	public void printReceipt() 
	{
		printer.print(receipt);
	}
	
	/**
	 * @return the receipt corresponding to this cart's purchase.
	 * Will return null if {{@link #checkout()} has not been called
	 * 
	 * @see Receipt
	 */
	public Receipt getReceipt()
	{
		return this.receipt;
	}

	/**
	 * Convenience method 
	 * @return the item count in the cart
	 */
	public int itemCount()
	{
		return items.size();
	}
	
	/**
	 * Resets the Shopping Cart
	 * It empties the cart and clears out the receipt.
	 * 
	 * The same Shopping Cart object can be reused after this call.
	 */
	public void reset()
	{
		items.clear();
		receipt = null;
	}
}
