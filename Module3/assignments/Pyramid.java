package assignments;

import java.io.PrintStream;
import java.util.Scanner;

public class Pyramid {
	static final int SCREEN_WIDTH = 80;
	static final int PYRAMID_LAYERS = 22;
	PrintStream out;
	
	Pyramid(){
		out = new PrintStream(System.out);
	}
	
	void writeSpaces(int spaces) {
		for (int i = 0; i < spaces; i++) {
			out.printf(" ");
		}
	}
	
	void buildLayer(int layerLevel) {
		int charsToWrite = layerLevel * 2 + 1;
		int spaces = (SCREEN_WIDTH - charsToWrite) / 2;
		
		writeSpaces(spaces);
		
		char letterToWrite = (char) (layerLevel + 97);
		
		for (int i = 0; i < charsToWrite; i++) {
			out.printf("%c", letterToWrite);
		}
		
		out.printf("\n");
	}
	
	void buildPyramid(int layers) {
		for (int i = 0; i < layers; i++) {
			buildLayer(i);
		}
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		buildPyramid(PYRAMID_LAYERS);
	}
	
	public static void main(String[] args) {
		new Pyramid().start();
	}

}
