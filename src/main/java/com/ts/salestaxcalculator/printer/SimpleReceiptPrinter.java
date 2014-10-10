package com.ts.salestaxcalculator.printer;

import com.ts.salestaxcalculator.receipt.Receipt;
import com.ts.salestaxcalculator.receipt.ReceiptEntry;

//
//import com.ts.salestaxcalculator.receipt.Receipt;
//import com.ts.salestaxcalculator.receipt.ReceiptEntry;

/**
 * A {@link IReceiptPrinter} that prints out the receipt directly to the console
 *
 * @author Mehdi Bennani
 */
public class SimpleReceiptPrinter implements IReceiptPrinter 
{

//	final Logger LOGGER = LoggerFactory.getLogger(SimpleReceiptPrinter.class);
	
	/**
	 * {@inheritDoc}
	 * 
	 * Note: If the receipt is null or no items are found in the receipt, the printer does not 
	 * output anything
	 */
	public void print(Receipt receipt)
	{
		/* handle the empty receipt case */
		if(receipt==null || receipt.getReceiptEntries().size()==0)
			return;
		
		for(ReceiptEntry entry:receipt.getReceiptEntries())
		{
			System.out.println(entry.getQuantity() + " "  + entry.getDescription()  + ": " + 
					formatValue(entry.getTaxPrice()));
		}
		
		System.out.println("Sales Taxes: " + formatValue(receipt.getTotalSalesTax()));
		System.out.println("Total: " + formatValue(receipt.getTotalCost()));
	}
	
	/**
	 * Pretty print value
	 * 
	 * @param value
	 * @return the formatted value with 2 fraction digits
	 */
	private String formatValue(double value)
	{
		return String.format("%.2f", value);
	}
}
