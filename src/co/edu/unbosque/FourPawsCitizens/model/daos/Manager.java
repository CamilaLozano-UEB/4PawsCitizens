package co.edu.unbosque.FourPawsCitizens.model.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public void assignID() {
		int pos = 0;
		for (Pet pet : pets) {
			pet.setId(this.generateID(pet, pos));
			pos++;
		}
	}

	private String generateID(Pet pet, int pos) {

		String potentDangerous = "F";
		String id = "";
		int lastIndex = String.valueOf(pet.getMicrochip()).length();
		int numOfCharacters = lastIndex - 3;

		if (pet.isPotentDangerous())
			potentDangerous = "T";

		do {
			id = String.valueOf(pet.getMicrochip()).substring(numOfCharacters, lastIndex) + "-"
					+ pet.getSpecies().substring(0, 1) + pet.getSex().substring(0, 1) + pet.getSize().substring(0, 1)
					+ potentDangerous + "-" + pet.getNeighborhood();
			numOfCharacters--;
		} while (isExistingID(id, pos));

		return id;
	}

	private boolean isExistingID(String id, int pos) {
		boolean value = false;
		for (int i = 0; i < pos; i++) {
			if (id.equals(this.pets.get(i).getId())) {
				value = true;
			}
		}
		return value;
	}

	public Pet findByMicrochip(Long microchip) {
		Pet foundedPet = null;
		for (Pet pet2 : pets)
			if (microchip.equals(pet2.getMicrochip()))
				foundedPet = pet2;
		return foundedPet;
	}

	public String countBySpecies(String species) {
		int cont = 0;
		for (int i = 0; i < getPets().size(); i++) {
			if (species.equals(pets.get(i).getSpecies()))
				cont++;
		}
		return "El número de animales de la especie " + species + " es: " + cont++;
	}

	public List<Pet> findBypotentDangerousInNeighborhood(int n, String position, String neighborhood) {

		ArrayList<Pet> pdinPet = new ArrayList<Pet>();
		int start = 0;
		int end = 0;

		for (Pet pet : pets) {
			if (pet.getNeighborhood().equals(neighborhood) && pet.isPotentDangerous()) {
				pdinPet.add(pet);
			}
		}

		if (position.equals("TOP")) {
			end = n;
		} else {
			end = pdinPet.size();
			start = end - n;
		}

		return pdinPet.subList(start, end);
	}

	public String findByMultipleFields(String species, String sex, String size, String potentDangerous) {
		String ids = "";

		if (potentDangerous.equals("NO"))
			potentDangerous = "false";
		else
			potentDangerous = "true";
		for (Pet pet : pets) {
			if (sex.equals(pet.getSex()) && species.equals(pet.getSpecies())
					&& Boolean.parseBoolean(potentDangerous) == pet.isPotentDangerous() && size.equals(pet.getSize())) {
				ids += pet.getId() + "\n";
			}
		}
		return ids;
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
