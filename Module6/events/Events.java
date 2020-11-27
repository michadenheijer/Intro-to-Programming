package events;

import ui.UserInterfaceFactory;
import ui.Event;
import ui.SnakeUserInterface;
import java.util.Scanner; 

public class Events {
	
	SnakeUserInterface ui;
	
	Events() {
		ui = UserInterfaceFactory.getSnakeUI(40, 30);
	}
	
	void placeWall(String input) {
		Scanner in = new Scanner(input);
		
		int x = in.nextInt();
		int y = in.nextInt();
		
		in.close();
		
		ui.place(x, y, SnakeUserInterface.WALL);
	}
	
	void processEvent(Event event) {
		if (event.name.equals("click")) {
			placeWall(event.data);
		} else if (event.name.equals("other_key") && event.data.equals("␣")){
			ui.clear();
		}
		else if (event.name.equals("alarm")) {
			ui.showChanges();
		}
	}
	
	void start() {
		ui.setFramesPerSecond(3);
		
		while (true) {
			Event event = ui.getEvent();
			processEvent(event);	
			ui.printf("%s - %s\n", event.name, event.data);
		}
	}
	
	public static void main(String[] args) {
		new Events().start();
	}
}
