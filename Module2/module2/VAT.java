package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class VAT {
	static final double VAT_PERCENT = 21.0;
	
	PrintStream out;
	
	VAT() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		out.printf("Enter the price of an article including VAT: ");
		
		double priceWithTax = in.nextDouble();
		double priceOriginal = priceWithTax / (1 + VAT_PERCENT/100); //Calculate the original price
		
		out.printf("This article will cost %05.2f euro without %05.2f%% VAT.", priceOriginal, VAT_PERCENT);
	}
	
	public static void main(String[] argv) {
		new VAT().start();
	}
	
}
