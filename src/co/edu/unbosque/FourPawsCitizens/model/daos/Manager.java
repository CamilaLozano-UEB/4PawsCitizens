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

	public void uploadData() {
		String line = "";
		try {
			FileReader fr = new FileReader(new File("./Data/pets-citizens.csv"));
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			while (line != null) {
				String[] data = line.split(";");
				line = br.readLine();
				this.pets.add(new Pet(null, Long.parseLong(data[0]), data[1], data[2], data[3],
						Boolean.parseBoolean(data[4]), data[4]));
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
