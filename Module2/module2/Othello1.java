package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class Othello1 {
	static final int TOTAL_SQUARES = 8*8;
	
	PrintStream out;
	
	Othello1(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the number of white pieces on the board: ");
		int whitePieces = in.nextInt();
		
		out.printf("Enter the number of black pieces on the board: ");
		int blackPieces = in.nextInt();
		int totalPieces = whitePieces + blackPieces;
		
		double squaresPercentBlack = 100.0 * blackPieces / TOTAL_SQUARES;
		double piecesPercentBlack =  100.0 * blackPieces / totalPieces;
		out.printf("The percentage of black pieces on the board is: %01.2f%%%n", squaresPercentBlack);
		out.printf("The percentage of black pieces of all the pieces on the board is: %01.2f%%", piecesPercentBlack);
	}

	public static void main(String[] args) {
		new Othello1().start();
	}

}
