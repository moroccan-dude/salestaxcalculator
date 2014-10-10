package com.ts.salestaxcalculator.printer;


import com.ts.salestaxcalculator.receipt.Receipt;

/**
 * Interface to be implemented by Printers to output a receipt
 *
 * @author Mehdi Bennani
 */
public interface IReceiptPrinter {

	/**
	 * Prints out the receipt
	 * 
	 * @param receipt to output
	 */
	public void print(Receipt receipt);
}
