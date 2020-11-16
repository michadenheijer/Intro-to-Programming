package module2;

import java.io.PrintStream;
import java.util.Scanner;

public class Othello2 {
	static final double MILLISECONDS_IN_SECOND = 1000.0;
	
	static final int SECONDS_IN_MINUTES = 60;
	static final int SECONDS_IN_HOUR = 3600;
	
	static final int MAXIMUM_TIME_COMPUTER = 1000;
	
	PrintStream out;
	
	Othello2(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the time the first player thought: ");
		int firstPlayerTime = in.nextInt();
		
		out.printf("Enter the time the seconds player thought: ");
		int secondPlayerTime = in.nextInt();
		
		int humanTimeMilliseconds, humanTimeSeconds;
		
		if (firstPlayerTime >= MAXIMUM_TIME_COMPUTER) {
			humanTimeMilliseconds = firstPlayerTime;
		} else {
			humanTimeMilliseconds = secondPlayerTime;
		}
		
		humanTimeSeconds = (int) (humanTimeMilliseconds/MILLISECONDS_IN_SECOND + 0.5);
		
		// Round the milliseconds to the nearest second
		// Check the rest if divided by 60
		int seconds = humanTimeSeconds % SECONDS_IN_MINUTES,
			minutes = (humanTimeSeconds % SECONDS_IN_HOUR)/SECONDS_IN_MINUTES,
			hours = humanTimeSeconds/SECONDS_IN_HOUR; 
		
		out.printf("The time the human player has spent thinking is: %02d:%02d:%02d", hours, minutes, seconds);
	}

	public static void main(String[] args) {
		new Othello2().start();
	}

}
