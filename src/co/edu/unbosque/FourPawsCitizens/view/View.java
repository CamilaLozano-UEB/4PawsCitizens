package co.edu.unbosque.FourPawsCitizens.view;

import java.util.Scanner;

public class View {

	private Scanner scan;

	/**
	 * @param scan
	 */
	public View() {
		scan = new Scanner(System.in);
	}

	/**
	 * Método que recibe un parametro de tipo string que imprime un mensaje en
	 * consola
	 * 
	 * @param message
	 */

	public void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Método que captura las opciones desde la consola
	 * 
	 * @return
	 */

	public String printOptionsMenu() {
		System.out.println(
				"Welcome, the data has already been loaded. Please, Select an option: \n1. Assign ID. \n2. Find By Microchip. \n3. Count By Species. \n4. Find By Potent Dangerous in Neighborhood. \n5. Find By Multiple fields. \n6. Exit.");
		return scan.nextLine();
	}

	/**
	 * Método que captura el ingreso del microchip y valida que su valor sea
	 * correcto.
	 * 
	 * @return
	 */

	public Long findByMicrochipPrint() {
		System.out.println("Ingrese el microchip");
		try {
			return Long.parseLong(scan.nextLine());
		} catch (Exception e) {
			System.out.println("El dato ingresado no corresponde a un microchip");
			return null;
		}
	}

	/**
	 * Método que captura desde consola las dos especies, valida su valor y lo
	 * retorna
	 * 
	 * @return
	 */

	public String recieveSpecie() {
		System.out.println("Ingrese la especie");
		String specie = scan.nextLine().toUpperCase();
		if (specie.equals("FELINO") || specie.equals("CANINO"))
			return specie;
		else
			return null;
	}

	/**
	 * Método que captura desde la consola los valores de número, posición y la
	 * localidad, los válida y los retorna en forma de array
	 * 
	 * @return
	 */

	public String[] receivefindBypotentDangerousInNeighborhood() {
		System.out.println(
				"Ingrese los datos en el siguiente orden y sin espacios: Número, Posición (TOP/LAST), Localidad");
		String[] data = scan.nextLine().toUpperCase().replaceAll(" ", "").split(",");
		try {
			Integer.parseInt(data[0]);
		} catch (NumberFormatException e) {
			System.out.println("Ingrese solo números en el primer valor");
			return null;
		}
		if (data.length != 3) {
			System.out.println("Error en el ingreso de datos");
			return null;
		} else if (!data[1].equals("TOP") && !data[1].equals("LAST")) {
			System.out.println("Error en el ingreso de la posición");
			return null;
		}
		return data;
	}

	/**
	 * Método que captura los valores de especie, sexo, tamaño y potencial de
	 * peligro, los valida y los retorna en forma de array
	 * 
	 * @return
	 */

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

		} else if (!data[2].equals("PEQUEÑO") && !data[2].equals("MEDIANO") && !data[2].equals("GRANDE")) {
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
