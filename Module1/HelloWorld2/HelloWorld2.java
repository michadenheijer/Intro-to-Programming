package HelloWorld2;

import java.io.PrintStream;
import java.util.Scanner;

class HelloWorld2 {
	// Name : Micha den Heijer
	// Assignment : HelloWorld1 
	// Date : 09 September 2020
	PrintStream out;

	HelloWorld2() {
		out = new PrintStream(System.out);
	}

	void start() {
		Scanner in = new Scanner(System.in);
		out.printf("Enter your name: "); 
		String name = in.nextLine();
		
		out.printf("Hello world!! ");
		out.printf("Written by: %s\n", name);
	}

	public static void main(String[] argv) {
		new HelloWorld2().start();
	}
}