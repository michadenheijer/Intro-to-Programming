package pirate;

import java.io.PrintStream;
import ui.UIAuxiliaryMethods;
import java.util.Scanner;

public class Pirate {
	static final String COORDINATE_DELIMITER = ",";
	static final String ROW_DELIMITER = "=";
	static final String COORDINATE_PAIR_DELIMITER = " ";
	
	PrintStream out;
	
	Pirate() {
		out = new PrintStream(System.out);
	}
	
	Coordinate readCoordinate(String input) {
		Scanner in = new Scanner(input);
		in.useDelimiter(COORDINATE_DELIMITER);
		
		int x = in.nextInt();
		int y = in.nextInt();
		
		in.close();
		return new Coordinate(x, y);
	}
	
	CoordinateRow readCoordinateRow(String input) {
		CoordinateRow result = new CoordinateRow();
		Scanner in = new Scanner(input);
		in.useDelimiter(COORDINATE_PAIR_DELIMITER);
		
		while(in.hasNext()) {
			Coordinate coordinate = readCoordinate(in.next());
			result.addCoordinateBehind(coordinate);
		}
		
		in.close();
		return result;
	}
	
	void start() {
		boolean inFront = true;
		CoordinateRow result = new CoordinateRow();
		
		Scanner in = UIAuxiliaryMethods.askUserForInput().getScanner();
		in.useDelimiter(ROW_DELIMITER);
		
		while(in.hasNext()) {
			CoordinateRow coordinateRow = readCoordinateRow(in.next());
			if (inFront) {
				result.addCoordinateRowFront(coordinateRow);
			} else {
				result.addCoordinateRowBehind(coordinateRow);
			}
			
			inFront = !inFront;
		}
		
		result.shiftCoordinates(1, 0);
		
		for (int i = 0; i < result.numberOfElements; i++) {
			out.printf("%d,%d\n", result.elements[i].x, result.elements[i].y);
		}
		
		in.close();
	}
	
	public static void main(String[] args) {
		new Pirate().start();
	}
}
