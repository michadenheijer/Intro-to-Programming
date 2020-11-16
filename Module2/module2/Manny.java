package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class Manny {
	static final double MINIMUM_DONATION = 50.0;
	PrintStream out;
	
	Manny(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		double donation = 0;
		do {
			out.printf("Enter the amount you want to donate: %n");
			donation = in.nextDouble();
		}
		while(donation < MINIMUM_DONATION);
		
		out.printf("Thank you very much for your contribution of \u20AC%02.2f.", donation);
	}
	
	public static void main(String[] args) {
		new Manny().start();
	}
}
