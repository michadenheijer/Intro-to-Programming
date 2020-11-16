package assignments;

import java.io.PrintStream;
import java.util.Scanner;

public class Pizza {
	PrintStream out;
	
	Pizza(){
		out = new PrintStream(System.out);
	}
	
	int factorial(int n) {
		int answer = 1;
		for (int i = 1; i <= n; i++) {
			answer *= i;
		}
		return answer;
	}
	
	int nCr(int n, int k) {
		int answer = factorial(n) / (factorial(k) * factorial(n-k));
		return answer;
	}
	
	int calculateMarioPizzas() {
		int answer = nCr(10, 3);
		return answer;
	}
	
	int calculateLuigiPizzas() {
		int answer = nCr(9, 4);
		return answer;
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		out.printf("Mario: %d\n", calculateMarioPizzas());
		out.printf("Luigi: %d\n", calculateLuigiPizzas());
	}
	
	public static void main(String[] args) {
		new Pizza().start();
	}
}
