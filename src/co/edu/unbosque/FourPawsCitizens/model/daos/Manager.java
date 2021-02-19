package co.edu.unbosque.FourPawsCitizens.model.daos;

import java.util.ArrayList;

public class Manager {

	private ArrayList<Pet> pet;

	/**
	 * @param pet
	 */

	public Manager(ArrayList<Pet> pet) {
		this.setPet(pet);
	}

	public ArrayList<Pet> getPet() {
		return pet;
	}

	public void setPet(ArrayList<Pet> pet) {
		this.pet = pet;
	}
}
