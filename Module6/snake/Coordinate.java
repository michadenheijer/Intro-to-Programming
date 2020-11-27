package snake;

public class Coordinate {
	int x;
	int y;
	
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	boolean equals(Coordinate coordinate) {
		return (coordinate.x == this.x && coordinate.y == this.y);
	}
}
