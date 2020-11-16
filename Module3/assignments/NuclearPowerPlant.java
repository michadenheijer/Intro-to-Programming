package assignments;

import java.io.PrintStream;

public class NuclearPowerPlant {
	static final int SHOW_ERROR_MESSAGE = 3;
	
	
	PrintStream out;
	
	NuclearPowerPlant(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		for (int i = 0; i < SHOW_ERROR_MESSAGE; i++) {
			showErrorMessage();
		}
	}
	
	void showErrorMessage() {
		out.printf("NUCLEAR CORE UNSTABLE!!!\n" + 
				"Quarantine is in effect.\n" + 
				"Surrounding hamlets will be evacuated.\n" + 
				"Anti-radiationsuits and iodine pills are mandatory.\n\n");
	}
	
	public static void main(String[] args) {
		new NuclearPowerPlant().start();
	}

}
