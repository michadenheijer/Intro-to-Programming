package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class Alphabet {
	PrintStream out;
	
	Alphabet(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		for (char c = 'a'; c <= 'z'; c++) {
			out.printf("%c", c);
		}
	}
	
	public static void main(String[] args) {
		new Alphabet().start();
	}
}
