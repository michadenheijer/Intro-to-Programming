package assignments;

import java.io.PrintStream;
import java.util.Scanner;

public class RepeatCharacter1 {

	PrintStream out;
	
	RepeatCharacter1(){
		out = new PrintStream(System.out);
	}
	
	void printExclamationMarks(int ExclamationMarks) {
		for (int i = 0; i < ExclamationMarks; i++) {
			out.printf("!");
		}
		out.printf("\n");
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			printExclamationMarks(in.nextInt());
		}
	}
	
	public static void main(String[] args) {
		new RepeatCharacter1().start();
	}

}
