package replay1;

import java.util.Scanner;
import ui.OthelloReplayUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;

public class Replay1 {
	// Set UI
	OthelloReplayUserInterface ui;
	
	Replay1() {
		ui = UserInterfaceFactory.getOthelloReplayUI();
	}
	
	int getPlayer(String player) {
		// Converts the string with player to the corresponding Player integer
		if (player.equals("white")) {
			return ui.WHITE;
		} else {
			return ui.BLACK;
		}
	}
	
	void playerMove(String xString, int y, int player) {
		// Set position to color
		char xChar = xString.charAt(0);
		int x = (int) xChar - 97; // Convert Char to display x position
		y -= 1; // Convert command position to display y position
		
		ui.place(x, y, player);
	}
	
	void runCommand(String commandString) {
		// Run every line as separate command
		Scanner command = new Scanner(commandString);
		
		String playerString = command.next();
		int player = getPlayer(playerString);
		
		int waitTime = command.nextInt();
		ui.wait(waitTime);
		
		String commandAction = command.next();
		
		// If player moves, add or change disks
		if (commandAction.equals("move")) {
			String x = command.next();
			int y = command.nextInt();
			playerMove(x , y, player);
			ui.showChanges();
		}
		
		command.close();
	}
	
	void startPosition() {
		// Set the start positions of the game
		ui.place(3, 3, ui.WHITE);
		ui.place(4, 4, ui.WHITE);
		
		ui.place(4, 3, ui.BLACK);
		ui.place(3, 4, ui.BLACK);
		
		ui.showChanges();
	}
	
	void start() {
		// Get input file
		Scanner in = UIAuxiliaryMethods.askUserForInput().getScanner();
		
		startPosition();
		
		// Run every line as command
		while (in.hasNextLine()) {
			runCommand(in.nextLine());
		}
		
		in.close();
	}
	
	public static void main(String[] args) {
		new Replay1().start();
	}

}
