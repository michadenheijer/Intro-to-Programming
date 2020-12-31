package longestPath;

//direction: 0 = right, 1 = up, 2 = left, 3 = down

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
	
	void direction(int i) {
		if (i == 0) {
			this.x++;
		} else if (i == 1) {
			this.y--;
		} else if (i == 2) {
			this.x--;
		} else if (i == 3) {
			this.y++;
		}
	}
}
