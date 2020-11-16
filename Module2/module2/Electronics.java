package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class Electronics {
	static final double DISCOUNT_PERCENT = 15 * 0.01; // Set discount to 15%
	static final char CURRENCY = '\u20AC'; // Unicode character for Euro
	
	PrintStream out;
	
	Electronics() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the price of the first article: %c ", CURRENCY);
		double articleOne = in.nextDouble();
		
		out.printf("Enter the price of the second article: %c ", CURRENCY);
		double articleTwo = in.nextDouble();
		
		out.printf("Enter the price of the third article: %c ", CURRENCY);
		double articleThree = in.nextDouble();
		
		double totalPrice = articleOne + articleTwo + articleThree;
		double discount;
		
		// Find the most expensive article and calculate the discount
		if (articleOne >= articleTwo && articleOne >= articleThree) {
			discount = articleOne * DISCOUNT_PERCENT;
		} else if (articleTwo >= articleThree) {
			discount = articleTwo * DISCOUNT_PERCENT;
		} else {
			discount = articleThree * DISCOUNT_PERCENT;
		}
		
		totalPrice -= discount; // Subtract the discount from the total price
		
		out.printf("Discount: %c%.2f%n", CURRENCY, discount);
		out.printf("Total: %c%.2f", CURRENCY, totalPrice);
		
	}	
	
	public static void main(String[] args) {
		new Electronics().start();
	}

}
