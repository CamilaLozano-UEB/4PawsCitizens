package co.edu.unbosque.FourPawsCitizens.model.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.FourPawsCitizens.model.EmptyAttributeException;
import co.edu.unbosque.FourPawsCitizens.model.IdentifierExistsException;

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

				try {
					this.verifyEmptyFields(data);
					this.verifyMicrochip(data[0]);

					this.pets.add(new Pet(null, Long.parseLong(data[0]), data[1], data[2], data[3],
							Boolean.parseBoolean(data[4]), data[5]));
				} catch (EmptyAttributeException | NumberFormatException e) {

				}

			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 23337
		System.out.println(pets.size());
	}

	private void verifyEmptyFields(String[] data) throws EmptyAttributeException {

		for (int i = 0; i < data.length; i++)
			if (data[i].equals(""))
				throw new EmptyAttributeException();

		if (data.length <= 5)
			throw new EmptyAttributeException();
	}

	/**
	 * 
	 * @param microchip
	 * @return true if don't generates a exception, else return false
	 */
	private void verifyMicrochip(String microchip) throws NumberFormatException {
		try {
			Long.parseLong(microchip);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}

	public void assignID() {
		int pos = 0;
		for (Pet pet : pets) {
			pet.setId(this.generateID(pet, pos, 3));
			pos++;
		}
	}

	private String generateID(Pet pet, int pos, int lessNumber) {
		String potentDangerous = "F";
		int lastIndex = String.valueOf(pet.getMicrochip()).length();

		if (pet.isPotentDangerous())
			potentDangerous = "T";

		String id = String.valueOf(pet.getMicrochip()).substring(lastIndex - lessNumber, lastIndex) + "-"
				+ pet.getSpecies().substring(0, 1) + pet.getSex().substring(0, 1) + pet.getSize().substring(0, 1)
				+ potentDangerous + "-" + pet.getNeighborhood();
		try {
			this.isExistingID(id, pos);
			return id;
		} catch (IdentifierExistsException e) {
			return this.generateID(pet, pos, lessNumber + 1);
		}
	}

	private void isExistingID(String id, int pos) throws IdentifierExistsException {
		for (int i = 0; i < pos; i++)
			if (id.equals(this.pets.get(i).getId()))
				throw new IdentifierExistsException();
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
