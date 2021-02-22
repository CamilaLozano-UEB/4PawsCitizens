package co.edu.unbosque.FourPawsCitizens.view;

import java.util.Scanner;

public class View {

	private Scanner scan;

	public View() {
		scan = new Scanner(System.in);
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public String readInput() {
		return scan.nextLine();
	}

	public String printOptionsMenu() {
		System.out.println(
				"Welcome \nSelect an option: \n1. Upload Data. \n2. Assign ID. \n3. Find By Microchip. \n4. Count By Species. \n5. Find By Potent Dangerous in Neighborhood. \n6. Find By Multiple fields. \n7. Exit.");
		return this.readInput();
	}
}
