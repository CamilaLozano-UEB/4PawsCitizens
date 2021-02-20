package co.edu.unbosque.FourPawsCitizens.model.daos;

import java.util.ArrayList;

public class Manager {

	private ArrayList<Pet> pets;

	public Manager() {
		pets = new ArrayList<Pet>();
	}

	public void uploadData() {

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
