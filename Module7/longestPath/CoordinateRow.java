package longestPath;

public class CoordinateRow {
	public static int MAX_NUMBER_OF_ELEMENTS = 1000;
	
	Coordinate[] elements;
	int numberOfElements;
	
	CoordinateRow() {
		elements = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		numberOfElements = 0;
	}
	
	void addElement(Coordinate coordinate) {
		this.elements[numberOfElements] = coordinate;
		numberOfElements++;
	}
	
	void removeLast() {
		this.elements[numberOfElements - 1] = null;
		numberOfElements--;
	}
	
	boolean isInRow(Coordinate coordinate) {
		for(int i = 0; i < numberOfElements; i++) {
			if (coordinate.equals(elements[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	Coordinate getLast() {
		Coordinate last = elements[numberOfElements - 1];
		return new Coordinate(last.x, last.y);
	}
	
	CoordinateRow copy() {
		CoordinateRow copy = new CoordinateRow();
		
		for (int i = 0; i < numberOfElements; i++) {
			copy.addElement(elements[i]);
		}
		
		return copy;
	}
}
