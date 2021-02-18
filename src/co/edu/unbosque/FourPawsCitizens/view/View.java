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
}
