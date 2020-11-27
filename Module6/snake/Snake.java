package snake;

import ui.UserInterfaceFactory;
import ui.Event;
import ui.SnakeUserInterface;
import ui.UIAuxiliaryMethods;
import java.util.Scanner;


public class Snake {
	public static final int SNAKE_WIDTH = 32;
	public static final int SNAKE_HEIGHT = 24;
	static final double FRAMES_PER_SECOND = 5.0;
	
	
	SnakeUserInterface ui;
	SnakeRow snake;
	Coordinate apple;
	WallRow walls;
	
	Snake() {
		ui = UserInterfaceFactory.getSnakeUI(SNAKE_WIDTH, SNAKE_HEIGHT);
		walls = new WallRow();
	}
	
	Coordinate generateRandomCoordinate() {
		int x, y;
		x = UIAuxiliaryMethods.getRandom(0, SNAKE_WIDTH);
		y = UIAuxiliaryMethods.getRandom(0, SNAKE_HEIGHT);
		
		Coordinate coordinate = new Coordinate(x,y);
		return coordinate;
	}
	
	void placeApple() {
		Coordinate randomCoordinate = generateRandomCoordinate();
		
		while (snake.isAtLocation(randomCoordinate) || walls.isAtLocation(randomCoordinate)) {
			randomCoordinate = generateRandomCoordinate();
		}
		
		apple = randomCoordinate;
		
		ui.place(apple.x, apple.y, SnakeUserInterface.FOOD);
		ui.showChanges();
	}
	
	void placeWalls(Scanner in) {
		while (in.hasNext()) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			Coordinate wallCoordinate = new Coordinate(x, y);
			
			walls.add(wallCoordinate);
			ui.place(x, y, SnakeUserInterface.WALL);
		}
		
		ui.showChanges();
	}
	
	void setStartPosition(Scanner in) {
		Coordinate firstSnakeCoordinate = new Coordinate(in.nextInt(), in.nextInt());
		Coordinate secondSnakeCoordinate = new Coordinate(in.nextInt(), in.nextInt());
		
		snake = new SnakeRow(firstSnakeCoordinate, secondSnakeCoordinate);
	}
	
	void setStartDirectiong(String in) {
		int direction;
		if (in.equals("R")) {
			direction = 0;
		} else if (in.equals("D")) {
			direction = 1;
		} else if (in.equals("L")) {
			direction = 2;
		} else {
			direction = 3;
		}
		
		snake.currentDirection = direction;
		snake.futureDirection = direction;
	}
	
	void gameOver() {		
		UIAuxiliaryMethods.showMessage("Game Over");
		System.exit(0);
	}
	
	void startGame() {
		Scanner in = UIAuxiliaryMethods.askUserForInput().getScanner();
		in.useDelimiter("=");
		Scanner startCoordinatesInput = new Scanner(in.next());
		String startDirectionInput =  in.next();
		Scanner wallInput = new Scanner(in.next());
		
		setStartPosition(startCoordinatesInput);
		setStartDirectiong(startDirectionInput);
		placeWalls(wallInput);
		
		ui.setFramesPerSecond(FRAMES_PER_SECOND);
		
		ui.place(snake.elements[0].x, snake.elements[0].y, SnakeUserInterface.SNAKE);
		ui.place(snake.elements[1].x, snake.elements[1].x, SnakeUserInterface.SNAKE);
		ui.showChanges();
		
		placeApple();
	}
	
	void moveSnake() {
		Coordinate lastSnake = snake.getLast();
		
		if(snake.eatsApple(apple)) { 
			snake.grow();
			placeApple();
		} else {
			ui.place(lastSnake.x, lastSnake.y, SnakeUserInterface.EMPTY);
			snake.update();
		}
		
		Coordinate firstSnake = snake.getFirst();
		
		ui.place(firstSnake.x, firstSnake.y, SnakeUserInterface.SNAKE);
	}
	
	void processEvent(Event event) {
		if(event.name.equals("arrow")) {
			if (event.data.equals("L")) {
				snake.setLeft();
			} else if (event.data.equals("R")) {
				snake.setRight();
			} else if (event.data.equals("U")) {
				snake.setUp();
			} else if (event.data.equals("D")) {
				snake.setDown();
			}
		}
		
		if(event.name.equals("alarm")) {
			if(snake.getCollision() || walls.collision(snake)) {
				ui.printf("%d", snake.currentDirection);
				gameOver();
			}
			moveSnake();
			ui.showChanges();
		}
	}

	void start() {
		startGame();
		
		while (true) {
			Event event = ui.getEvent();
			processEvent(event);
		}
	}
	
	public static void  main(String args[]) {
		new Snake().start();
	}
	
}
