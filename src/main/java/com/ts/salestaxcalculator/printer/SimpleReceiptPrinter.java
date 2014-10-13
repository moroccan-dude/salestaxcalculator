package com.ts.salestaxcalculator.printer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ts.salestaxcalculator.receipt.Receipt;
import com.ts.salestaxcalculator.receipt.ReceiptEntry;


/**
 * A {@link IReceiptPrinter} that prints out the receipt directly to the console
 *
 * @author Mehdi Bennani
 */
public class SimpleReceiptPrinter implements IReceiptPrinter 
{
	private static final Logger LOG = LoggerFactory.getLogger(SimpleReceiptPrinter.class);
	
	@SuppressWarnings("unused")
	private Properties properties;
	
	/**
	 * Default constructor
	 */
	public SimpleReceiptPrinter()
	{ /* nothing to configure */ }
	
	/**
	 * {@inheritDoc}
	 */
	public void setProperties(Properties properties)
	{
		this.properties = properties;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Note: If the receipt is null or no items are found in the receipt, the printer does not 
	 * output anything
	 */
	public void print(Receipt receipt)
	{
		/* handle the empty receipt case */
		if(receipt==null || receipt.getEntries().size()==0)
		{	
			return;
		}
		
		for(ReceiptEntry entry:receipt.getEntries())
		{
			LOG.info(entry.getQuantity() + " "  + entry.getDescription()  + ": " + 
					formatValue(entry.getTaxPrice()));
		}
		
		LOG.info("Sales Taxes: " + formatValue(receipt.getTotalSalesTax()));  // TODO i18n
		LOG.info("Total: " + formatValue(receipt.getTotalCost()));   		  // TODO i18n
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
