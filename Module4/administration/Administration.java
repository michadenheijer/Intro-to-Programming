package administration;

import java.util.Scanner;
import ui.UIAuxiliaryMethods;
import java.io.PrintStream;


public class Administration {
	
	PrintStream out;
	
	Administration() {
		out = new PrintStream(System.out);
	}
	
	String getAverageGrade(String grades) {
		Scanner parser = new Scanner(grades);
		parser.useDelimiter(" ");
		
		int totalOfGrades = 0;
		int numberOfGrades = 0;
		
		while (parser.hasNext()) {
			totalOfGrades += parser.nextInt();
			numberOfGrades++;
		}
		
		double averageOfGrades = (double) totalOfGrades/numberOfGrades;
		String outputGrade = (averageOfGrades >= 5.5 && averageOfGrades < 6) ? "6-" : (int) (averageOfGrades * 2 + 0.5) / 2.0 + "";
		
		parser.close();
		
		return outputGrade;
	}
	
	String getSimilarityScores(String similarityScores) {
		Scanner parser = new Scanner(similarityScores);
		parser.useDelimiter("=");
		
		String similarityDisplay = "";
		
		for (int i = 0; i < 10; i++) {
			int matches = parser.nextInt();
			
			if (matches == 0) similarityDisplay += "_";
			else if (matches <= 20) similarityDisplay += "-";
			else similarityDisplay += "^";
		}
		
		parser.close();
		
		return similarityDisplay;
	}
	
	String getNamesToInvestigate(String names) {
		Scanner parser = new Scanner(names);
		parser.useDelimiter(",");
		
		String namesList = "";
		
		while (parser.hasNext()) {
			namesList += "\t";
			namesList += parser.next();
			namesList += "\n";
		}
		
		parser.close();
		
		return namesList;
	}
	
	
	void start() {
		Scanner in = UIAuxiliaryMethods.askUserForInput().getScanner();
		
		while (in.hasNext()) {
			Scanner studentWithGrades = new Scanner(in.nextLine());
			Scanner similarityScoresAndInvestigations = new Scanner(in.nextLine());
			
			studentWithGrades.useDelimiter("_");
			similarityScoresAndInvestigations.useDelimiter(";");
			
			String studentName = studentWithGrades.next();
			String averageGrade = getAverageGrade(studentWithGrades.next());
			
			String similarityString = getSimilarityScores(similarityScoresAndInvestigations.next());
			String namesToInvestigate = "";
			
			if (similarityScoresAndInvestigations.hasNext()) {
				namesToInvestigate = getNamesToInvestigate(similarityScoresAndInvestigations.next());
			} else {
				namesToInvestigate = "\tNo matches found\n";
			}
			
			
			out.printf("%s has an average of %s\n", studentName, averageGrade);
			out.printf("\t%s\n%s", similarityString, namesToInvestigate);
		}
		
		in.close();
	}
	
	public static void main(String[] args) {
		new Administration().start();
	}
	
}
