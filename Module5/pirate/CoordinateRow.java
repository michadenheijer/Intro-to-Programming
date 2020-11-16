package pirate;

public class CoordinateRow {
	static final int MAX_NUMBER_OF_ELEMENTS = 1000;
	
	Coordinate[] elements;
	int numberOfElements;
	
	CoordinateRow() {
		elements = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		numberOfElements = 0;
	}
	
	void addCoordinateFront(Coordinate coordinate) {
		for(int i = numberOfElements; i > 0; i--) {
			this.elements[i] = this.elements[i - 1];
		}
		
		this.numberOfElements++;
		this.elements[0] = coordinate;
	}
	
	void addCoordinateRowFront(CoordinateRow coordinateRow) {
		int move = coordinateRow.numberOfElements;
		
		for (int i = this.numberOfElements; i > 0; i--) {
			this.elements[(i - 1) + move] = this.elements[i - 1];
		}
		
		for (int i = 0; i < move; i++) {
			this.elements[i] = coordinateRow.elements[i];
			this.numberOfElements++;
		}
	}
	
	void addCoordinateBehind(Coordinate coordinate) {
		this.elements[this.numberOfElements] = coordinate;
		this.numberOfElements++;
	}
	
	void addCoordinateRowBehind(CoordinateRow coordinateRow) {
		for(int i = 0; i < coordinateRow.numberOfElements; i++) {
			Coordinate coordinate = coordinateRow.elements[i];
			this.addCoordinateBehind(coordinate);
		}
	}
	
	void shiftCoordinates(int x, int y) {
		for (int i = 0; i < this.numberOfElements; i++) {
			this.elements[i].x += x;
			this.elements[i].y += y;
		}
	}
}
