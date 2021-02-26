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
				"Welcome, the data has already been loaded. Please, Select an option: \n1. Assign ID. \n2. Find By Microchip. \n3. Count By Species. \n4. Find By Potent Dangerous in Neighborhood. \n5. Find By Multiple fields. \n6. Exit.");
		return this.readInput();
	}

	public Long findByMicrochipPrint() {
		System.out.println("Ingrese el microchip:");
		try {
			return Long.parseLong(scan.nextLine());
		} catch (Exception e) {
			System.out.println("El dato ingresado no corresponde a un microchip");
			return null;
		}
	}

	public String recieveSpecie() {
		String specie = scan.nextLine();
		if (specie.equalsIgnoreCase("FELINO") || specie.equalsIgnoreCase("CANINO")) {
			return specie;
		} else {
			return null;
		}
	}

}
