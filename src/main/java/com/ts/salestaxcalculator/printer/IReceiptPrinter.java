package com.ts.salestaxcalculator.printer;


import java.util.Properties;

import com.ts.salestaxcalculator.receipt.Receipt;

/**
 * Interface to be implemented by Printers to output a receipt
 *
 * @author Mehdi Bennani
 */
public interface IReceiptPrinter {

	/**
	 * Setting properties on the printer for initialization purposes
	 * 
	 * @param properties
	 */
	void setProperties(Properties properties);
	
	/**
	 * Prints out the receipt
	 * 
	 * @param receipt to output
	 */
	void print(Receipt receipt);
}
