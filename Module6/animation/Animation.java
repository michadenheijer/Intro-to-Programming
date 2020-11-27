package animation;

import ui.UserInterfaceFactory;
import ui.Event;
import ui.SnakeUserInterface;

public class Animation {
	static int SNAKE_WIDTH = 40;
	static int SNAKE_HEIGHT = 30;
	
	
	SnakeUserInterface ui;
	
	Animation() {
		ui = UserInterfaceFactory.getSnakeUI(SNAKE_WIDTH, SNAKE_HEIGHT);
	}
	
	
	void start() {
		int x = 0;
		int y = 0;
		int object = SnakeUserInterface.WALL;
		
		double frameRate = 10.0;
		
		//Set UI frame rate
		ui.setFramesPerSecond(frameRate);
		
		//Set initial wall
		ui.place(0, 0, object);
		ui.showChanges();
		
		while (true) {
			Event event = ui.getEvent();
			
			//If frame, then move to the left
			if (event.name.equals("alarm")) {
				ui.place(x, y, SnakeUserInterface.EMPTY);
				
				if(x == SNAKE_WIDTH - 1) {
					x = 0;
					
					if (y == SNAKE_HEIGHT - 1) y = 0; else y++;
				
				} else {
					x++;
				}
				
				ui.place(x, y, object);
				ui.showChanges();
			}
			
			//If left, then slow down
			//If right, then speed up
			if (event.name.equals("arrow")) {
				if (event.data.equals("L")) {
					if (frameRate - 0.5 >= 0) {
						frameRate -= 0.5;
					}
				} else if (event.data.equals("R")) {
					frameRate += 0.5;
				}
				
				ui.setFramesPerSecond(frameRate);
			}
			
			//If g, then toggle between wall and snake
			if (event.name.equals("letter") && event.data.equals("g")) {
				if (object == SnakeUserInterface.WALL) {
					object = SnakeUserInterface.SNAKE;
				} else {
					object = SnakeUserInterface.WALL;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Animation().start();
	}
}
