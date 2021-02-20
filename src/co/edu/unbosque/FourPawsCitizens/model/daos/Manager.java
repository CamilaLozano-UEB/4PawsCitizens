package co.edu.unbosque.FourPawsCitizens.model.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {

	private ArrayList<Pet> pets;

	public Manager() {
		pets = new ArrayList<Pet>();
	}

	/**
	 * Read's the .cvs file and verify the information format
	 */
	public void uploadData() {
		String line = "";
		try {
			FileReader fr = new FileReader(new File("./Data/pets-citizens.csv"));
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			line = br.readLine();

			while (line != null) {

				String[] data = line.split(";");
				line = br.readLine();

				if (data[4].equals("NO"))
					data[4] = "false";
				else
					data[4] = "true";

				if (data.length > 5)
					if (this.verifyMicrochip(data[0]))
						this.pets.add(new Pet(null, Long.parseLong(data[0]), data[1], data[2], data[3],
								Boolean.parseBoolean(data[4]), data[5]));
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param microchip
	 * @return true if don't generates a exception, else return false
	 */
	private boolean verifyMicrochip(String microchip) {
		try {
			Long.parseLong(microchip);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @return the pets
	 */
	public ArrayList<Pet> getPets() {
		return pets;
	}

	/**
	 * @param pets the pets to set
	 */
	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

}
