package longestPath;

import ui.UserInterfaceFactory;

import java.util.Scanner;

import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;

public class LongestPath {
	public static final int LABYRINTH_WIDTH = 32;
	public static final int LABYRINTH_HEIGHT = 24;
	public static final int UI_WAIT_TIME_MS = 10;
	
	LabyrinthUserInterface ui;
	Coordinate startingPosition;
	Coordinate finishPosition;
	CoordinateRow wallsPositions;
	CoordinateRow longestPath;
	int longestPathLength = 0;
	
	LongestPath() {
		ui = UserInterfaceFactory.getLabyrinthUI(LABYRINTH_WIDTH, LABYRINTH_HEIGHT);
	}
	
	Coordinate getCoordinate(String input) {
		Scanner in = new Scanner(input);
		in.useDelimiter(" ");
		
		int x = in.nextInt(),
			y = in.nextInt();
		Coordinate coordinate = new Coordinate(x,y);
		
		in.close();
		return coordinate;
	}
	
	CoordinateRow getWalls(String input) {
		Scanner in = new Scanner(input);
		
		CoordinateRow walls = new CoordinateRow();
		
		while(in.hasNext()) {
			int x = in.nextInt(),
				y = in.nextInt();
			
			ui.place(x, y, LabyrinthUserInterface.WALL);
			
			Coordinate coordinate = new Coordinate(x,y);
			walls.addElement(coordinate);
		}
		
		ui.showChanges();
		in.close();
		return walls;
	}
	
	void setLabyrinth() {
		Scanner input = UIAuxiliaryMethods.askUserForInput().getScanner();
		input.useDelimiter("=");
		
		startingPosition = getCoordinate(input.next());
		finishPosition = getCoordinate(input.next());
		wallsPositions = getWalls(input.next()); 
		 
		
		input.close();
	}
	
	CoordinateRow addPosition(CoordinateRow coordinateRow, Coordinate coordinate) {
		ui.place(coordinate.x, coordinate.y, LabyrinthUserInterface.PATH);
		ui.showChanges();
		
		coordinateRow.addElement(coordinate);
		return coordinateRow;
	}
	
	boolean canPlace(CoordinateRow coordinateRow, Coordinate possiblePosition) {
		if(wallsPositions.isInRow(possiblePosition)) {
			return false;
		} else if (coordinateRow.isInRow(possiblePosition)) {
			return false;
		}
		
		return true;
	}
	
	void finishedPath(CoordinateRow coordinateRow) {
		if(coordinateRow.numberOfElements > longestPathLength) {
			longestPathLength = coordinateRow.numberOfElements;
			longestPath = coordinateRow.copy();
		}
		ui.printf("Found path with length of %d, currently the longest has a length of %d.\n", coordinateRow.numberOfElements, longestPathLength);
	}
	
	void findNextPosition(CoordinateRow coordinateRow) {
		for (int i = 0; i < 4; i++) {
			Coordinate possiblePosition = coordinateRow.getLast();
			possiblePosition.direction(i);
			if (canPlace(coordinateRow, possiblePosition)) {
				coordinateRow = addPosition(coordinateRow, possiblePosition);
				ui.wait(UI_WAIT_TIME_MS);
				findNextPosition(coordinateRow);
			}
		}
		Coordinate lastPosition = coordinateRow.getLast();
		
		if(lastPosition.equals(finishPosition)) {
			finishedPath(coordinateRow);
		}
		
		ui.wait(UI_WAIT_TIME_MS);
		ui.showChanges();
		ui.place(lastPosition.x, lastPosition.y, LabyrinthUserInterface.EMPTY);
		coordinateRow.removeLast();
	}
	
	void solveLabyrinth() {
		CoordinateRow path = new CoordinateRow();
		path = addPosition(path, startingPosition);
		findNextPosition(path);
		
		//clear path
		for (int i = 0; i < path.numberOfElements; i++) {
			Coordinate coordinate = path.elements[i];
			ui.place(coordinate.x, coordinate.y, LabyrinthUserInterface.EMPTY);
			ui.wait(UI_WAIT_TIME_MS);
			ui.showChanges();
		}
	}
	
	void showLongestPath() {
		for (int i = 0; i < longestPathLength; i++) {
			Coordinate coordinate = longestPath.elements[i];
			ui.place(coordinate.x, coordinate.y, LabyrinthUserInterface.PATH);
			ui.wait(UI_WAIT_TIME_MS);
			ui.showChanges();
		}
		
		ui.printf("Showing longest path, with a length of %d.", longestPathLength);
	}
	
	void start() {
		setLabyrinth();
		solveLabyrinth();
		showLongestPath();
	}

	public static void main(String[] args) {
		new LongestPath().start();

	}

}
