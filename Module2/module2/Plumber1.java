package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class Plumber1 {
	static final char CURRENCY = '\u20AC'; //Unicode character for Euro
	static final double CALL_OUT_COST = 16.0;
	
	
	PrintStream out;
	
	Plumber1(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the hourly wages: %c", CURRENCY);
		double wageHourly = in.nextDouble();
		
		out.printf("Enter the number of billable hours: ");
		int workHours = in.nextInt(); //Get and round work hours
		
		double totalPrice = workHours * wageHourly + CALL_OUT_COST;
		out.printf("The total cost of this repair is: %c %01.2f", CURRENCY, totalPrice);
	}

	public static void main(String[] args) {
		new Plumber1().start();
	}

}
