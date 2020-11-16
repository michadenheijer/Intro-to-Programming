package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class SecondSmallest {
	PrintStream out;
	
	SecondSmallest(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter some numbers: %n");
		
		int smallest = 0, 
			secondSmallest = 0;
		
		while (in.hasNext()) {
			
			int input = in.nextInt();
			
			// This doesn't assume that the first number is smaller than the second number
			// But this still works so I didn't change it
			if (smallest == 0) {
				smallest = input;
			} else if (secondSmallest == 0 && smallest > input) {
				secondSmallest = smallest;
				smallest = input;
			} else if (secondSmallest == 0) {
				secondSmallest = input;
			} else if (input < smallest) {
				secondSmallest = smallest;
				smallest = input;
			} else if (input < secondSmallest) {
				secondSmallest = input;
			}
		}
		
		out.printf("The second smallest number is: %d", secondSmallest);
	}
	
	public static void main(String[] args) {
		new SecondSmallest().start();
	}
}
