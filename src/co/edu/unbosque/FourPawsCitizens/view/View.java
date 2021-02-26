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

	public String printOptionsMenu() {
		System.out.println(
				"Welcome, the data has already been loaded. Please, Select an option: \n1. Assign ID. \n2. Find By Microchip. \n3. Count By Species. \n4. Find By Potent Dangerous in Neighborhood. \n5. Find By Multiple fields. \n6. Exit.");
		return scan.nextLine();
	}

	public Long findByMicrochipPrint() {
		System.out.println("Ingrese el microchip");
		try {
			return Long.parseLong(scan.nextLine());
		} catch (Exception e) {
			System.out.println("El dato ingresado no corresponde a un microchip");
			return null;
		}
	}

	public String recieveSpecie() {
		System.out.println("Ingrese la especie");
		String specie = scan.nextLine().toUpperCase();
		if (specie.equals("FELINO") || specie.equals("CANINO"))
			return specie;
		else
			return null;
	}

	public String[] receivefindBypotentDangerousInNeighborhood() {
		System.out.println(
				"Ingrese los datos en el siguiente orden y sin espacios: Número, Posición (TOP/LAST), Localidad");
		String[] data = scan.nextLine().toUpperCase().replaceAll(" ", "").split(",");
		try {
			Integer.parseInt(data[0]);
		} catch (NumberFormatException e) {
			System.out.println("Ingrese solo números en el primer valor, usuario pendejo");
			return null;
		}
		if (data.length != 3) {
			System.out.println("Error en el ingreso de datos");
			return null;
		} else if (!data[1].equals("TOP") || !data[1].equals("LAST")) {
			System.out.println("Error en el ingreso de la posición");
			return null;
		} else if (data[2].equals(null)) {
			System.out.println("Error en el ingreso de la localidad");
			return null;
		}
		return data;
	}

	public String[] recieveMultipleFields() {

		System.out.println(
				"Ingrese los datos de la siguiente manera \"ESPECIE (FELINO / CANINO), SEXO (MACHO / HEMBRA), TAMAÑO (PEQUEÑO / MEDIANO / GRANDE), PELIGROSO (SI/NO)\"");
		String[] data = scan.nextLine().toUpperCase().replaceAll(" ", "").split(",");

		if (data.length != 4) {
			System.out.println("Datos incompletos");
			return null;

		} else if (!data[0].equals("FELINO") && !data[0].equals("CANINO")) {
			System.out.println("El valor de la especie no es correcto!");
			return null;

		} else if (!data[1].equals("MACHO") && !data[1].equals("HEMBRA")) {
			System.out.println("El valor del sexo no es correcto!");
			return null;

		} else if (!data[2].equals("PEQUEÑO") && !data[2].equals("MEDIANO") && !data[1].equals("GRANDE")) {
			System.out.println("El valor del tamaño no es correcto!");
			return null;

		} else if (!data[3].equals("SI") && !data[3].equals("NO")) {
			System.out.println("El valor potent dangerous no es correcto!");
			return null;

		} else {
			return data;
		}
	}

}
