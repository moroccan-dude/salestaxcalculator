package com.ts.salestaxcalculator;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.ts.salestaxcalculator.ShoppingCart;
import com.ts.salestaxcalculator.items.BasicItem;
import com.ts.salestaxcalculator.items.Imported;
import com.ts.salestaxcalculator.items.TaxExempted;
import com.ts.salestaxcalculator.receipt.Receipt;
import com.ts.salestaxcalculator.receipt.ReceiptEntry;

/**
 * Unit Test Class for SalesTax Calculator
 * 
 * @author Mehdi Bennani
 *
 */
public class SalesTaxCalculatorTest 
{
	
	@Test
    public void testExercise() 
    {
		ShoppingCart cart = new ShoppingCart();
		
		//// input 1 ////
		cart.addItem(new TaxExempted(new BasicItem("book",12.49)));
		cart.addItem(new BasicItem("music CD",14.99));
		cart.addItem(new TaxExempted(new BasicItem("chocolate bar",0.85)));
		cart.checkout();
		assertItemValues(cart.getReceipt(), new double[] {29.83,1.50,12.49,16.49,0.85});
		
		//// input 2 ////
    	cart.reset();
		cart.addItem(new Imported(new TaxExempted(new BasicItem("box of chocolates",10.00)))); 
		cart.addItem(new Imported(new BasicItem("bottle of perfume",47.50)));
		cart.checkout();
		assertItemValues(cart.getReceipt(), new double[] {65.15,7.65,10.50,54.65});

		//// input 3 ////
	 	cart.reset();
		cart.addItem(new Imported(new BasicItem("bottle of perfume",27.99)));
		cart.addItem(new BasicItem("bottle of perfume",18.99));
		cart.addItem(new TaxExempted(new BasicItem("headache pills",9.75)));
		cart.addItem(new Imported(new TaxExempted(new BasicItem("box of chocolates",11.25))));
		cart.checkout();
		assertItemValues(cart.getReceipt(), new double[] {74.68,6.70,32.19,20.89,9.75,11.85});
    }
	
	@Test
	public void testLimits()
	{
		ShoppingCart cart = new ShoppingCart();
		
		//// empty cart ////
		cart.reset();
		cart.checkout();
		assertItemValues(cart.getReceipt(), new double[] {0,0});
			
		//// prices * tax < 1  ////
		cart.reset();
		cart.addItem(new BasicItem("music CD",0.09));
		cart.checkout();
		assertItemValues(cart.getReceipt(), new double[] {0.14,0.05,0.14});
		
		//// large number ////
		cart.reset();
		cart.addItem(new BasicItem("house",1000000000.42));
		cart.checkout();
		assertItemValues(cart.getReceipt(), new double[] {1100000000.47,100000000.05,1100000000.47});
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArguments()
	{
		new ShoppingCart().addItem(new BasicItem("music CD",-1));
    }
	
	/**
	 * Convenience method to compare expected result with receipt, nothing too fancy
	 * 
	 * @param receipt the Shopping Cart receipt
	 * @param values  expected values in this order [totalcost, totalSalesTax, salesTaxPriceItem1, salesTaxPriceItem2....]
	 */
	private void assertItemValues(Receipt receipt, double[] values)
	{
		assertEquals(receipt.getTotalCost(),values[0],0);
		assertEquals(receipt.getTotalSalesTax(),values[1],0);
		
		List<ReceiptEntry> entries =  receipt.getReceiptEntries();
		Iterator<ReceiptEntry> itEntries = entries.iterator();
		int i = 0;
		while(itEntries.hasNext())
		{
			assertEquals(itEntries.next().getTaxPrice(),values[i+2],0);
			i++;
		}
	}
}

