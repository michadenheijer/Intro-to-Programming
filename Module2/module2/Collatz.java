package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class Collatz {
	PrintStream out;
	
	Collatz(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		while (n != 1) {
			if (n%2 == 0) {
				n /= 2;
			} else {
				n = 3*n + 1;
			}
			out.printf("%d%n", n);
		}
		
	}
	
	public static void main(String[] args) {
		new Collatz().start();
	}
}
