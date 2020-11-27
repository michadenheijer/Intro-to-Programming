package snake;

public class SnakeRow {
	static final int MAX_NUMBER_OF_ELEMENTS = 1000;
	static final int SNAKE_WIDTH = Snake.SNAKE_WIDTH;
	static final int SNAKE_HEIGHT = Snake.SNAKE_HEIGHT;
	
	Coordinate[] elements;
	int numberOfElements;
	int futureDirection; // 0 = right, 1 = bottom, 2 = left, 3 = up
	int currentDirection;
	
	SnakeRow(Coordinate firstSnakeCoordinate, Coordinate secondSnakeCoordinate) {
		elements = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		futureDirection = 0;
		currentDirection = 0;
		
		numberOfElements = 2;
		elements[0] = firstSnakeCoordinate;
		elements[1] = secondSnakeCoordinate;
	}
	
	Coordinate getLast() {
		return elements[numberOfElements - 1];
	}
	
	Coordinate getFirst() {
		return elements[0];
	}
	
	boolean getCollision() {
		for(int i = 1; i < numberOfElements; i++) {
			
			if (elements[0].equals(elements[i])) {
				return true;
			}
			
		}
		
		return false;
	}
	
	boolean eatsApple(Coordinate apple) {
		return apple.equals(elements[0]);
	}
	
	boolean isAtLocation(Coordinate coordinate) {
		for (int i = 0; i < this.numberOfElements; i++) {
			if (elements[i].equals(coordinate)) {
				return true;
			}
		}
		
		return false;
	}
	
	void update() {
		currentDirection = futureDirection;
		
		for (int i = this.numberOfElements - 1; i > 0; i--) {
			elements[i] = elements[i - 1]; 
		}
		
		int x = elements[1].x, 
			y = elements[1].y;
		
		//If direction is right
		if (currentDirection == 0) {
			x += 1;
			
			if (x >= SNAKE_WIDTH) {
				x = 0;
			}
		} 
		//If direction is down
		else if (currentDirection == 1) {
			y += 1;
			
			if (y >= SNAKE_HEIGHT) {
				y = 0;
			}
			
		} 
		//If direction is left
		else if (currentDirection == 2) {
			x -= 1;
			
			if (x < 0) {
				x = SNAKE_WIDTH - 1;
			}
		} 
		//If direction is right
		else {
			y -= 1;
			
			if (y < 0) {
				y = SNAKE_HEIGHT - 1;
			}
		}
		
		elements[0] = new Coordinate(x,y);
	}
	
	void grow() {
		Coordinate last = this.getLast();
		this.update();
		
		elements[numberOfElements] = last;
		numberOfElements++;
	}
	
	void setLeft() {
		if (currentDirection != 0) {
			futureDirection = 2;
		}
	}
	
	void setRight() {
		if (currentDirection != 2) {
			futureDirection = 0;
		}
	}
	
	void setUp() {
		if (currentDirection != 1) {
			futureDirection = 3;
		}
	}
	
	void setDown() {
		if (currentDirection != 3) {
			futureDirection = 1;
		}
	}
}
