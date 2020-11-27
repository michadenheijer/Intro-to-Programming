package snake;

public class WallRow {
	static final int MAX_NUMBER_OF_ELEMENTS = 1000;
	
	
	Coordinate elements[];
	int numberOfElements;;
	
	WallRow() {
		elements = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		numberOfElements = 0;
	}
	
	void add(Coordinate wall) {
		elements[numberOfElements] = wall;
		numberOfElements++;
	}
	
	boolean isAtLocation(Coordinate coordinate) {
		for (int i = 0; i < this.numberOfElements; i++) {
			if (elements[i].equals(coordinate)) {
				return true;
			}
		}
		
		return false;
	}
	
	boolean collision(SnakeRow snake) {
		for(int i = 0; i < numberOfElements; i++) {
			if(snake.elements[0].equals(this.elements[i])) {
				return true;
			}
		}
		
		return false;
	}
}
