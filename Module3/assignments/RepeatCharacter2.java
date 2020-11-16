package assignments;

import java.io.PrintStream;
import java.util.Scanner;

public class RepeatCharacter2 {

	PrintStream out;
	
	RepeatCharacter2(){
		out = new PrintStream(System.out);
	}
	
	void printExclamationMarks(int ExclamationMarks) {
		for (int i = 0; i < ExclamationMarks; i++) {
			out.printf("!");
		}
		out.printf("\n");
	}
	
	void printCommas(int Commas) {
		for (int i = 0; i < Commas; i++) {
			out.printf(",");
		}
		out.printf("\n");
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			printExclamationMarks(in.nextInt());
			printCommas(in.nextInt());
		}
	}
	
	public static void main(String[] args) {
		new RepeatCharacter2().start();
	}

}
