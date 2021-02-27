package co.edu.unbosque.FourPawsCitizens.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.FourPawsCitizens.exceptions.EmptyAttributeException;
import co.edu.unbosque.FourPawsCitizens.exceptions.IdentifierExistsException;
import co.edu.unbosque.FourPawsCitizens.model.dto.Pet;

public class Manager {

	private ArrayList<Pet> pets;

	public Manager() {
		pets = new ArrayList<Pet>();
	}

	/**
	 * Lee el archivo .csv y discrimina la información que se encuentra allí para
	 * lograr hacer bien la carga a memoria, implementa el método verifyEmptyFields
	 * para verificar campos vacios y verifyMicrochip para verificar el microchip
	 */
	public void uploadData() {
		String line = "";
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File("./Data/pets-citizens.csv")), "ISO-8859-1"));
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Verifica campos los campos vacios del arreglo proporcionado y si falta algún
	 * dato, de lo contrario arroja una excepción
	 * 
	 * @param data
	 * @throws EmptyAttributeException
	 */
	private void verifyEmptyFields(String[] data) throws EmptyAttributeException {

		for (int i = 0; i < data.length; i++)
			if (data[i].equals(""))
				throw new EmptyAttributeException();

		if (data.length != 6)
			throw new EmptyAttributeException();
	}

	/**
	 * Verifica si el microchip ingresado puede convertirse a un objeto de la clase
	 * Long, de lo contrarío arroja una excepción
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

	/**
	 * Método encargado de asignar un ID a cada mascota, se apoya del método
	 * generateID
	 */
	public void assignID() {
		int pos = 0;
		for (Pet pet : pets) {
			pet.setId(this.generateID(pet, pos, 3));
			pos++;
		}
	}

	/**
	 * Genera un ID para una mascota y a su vez verifica que este no se encuentre ya
	 * usado, se implementa el método isExistingID que lanza una excepción si el ID
	 * ya se encuentra.
	 * 
	 * @param pet,        Mascota a la cual se le genera el ID
	 * @param pos,        Posición en la lista hasta la cual se ha generado un ID
	 * @param lessNumber, Cantidad de caracteres del microchip que se van a tomar
	 * @return
	 */
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

	/**
	 * Determina si hay un ID igual entre los ya asignados, si es así lanza una
	 * excepción
	 * 
	 * @param id,  ID a verificar
	 * @param pos, Posición de la lista hasta la cual se ha asignado un ID
	 * @throws IdentifierExistsException
	 */
	private void isExistingID(String id, int pos) throws IdentifierExistsException {
		for (int i = 0; i < pos; i++)
			if (id.equals(this.pets.get(i).getId()))
				throw new IdentifierExistsException();
	}

	/**
	 * Se encarga de buscar una mascota por su microchip y retornarla, si no la
	 * encuentra retorna null
	 * 
	 * @param microchip
	 * @return
	 */
	public Pet findByMicrochip(Long microchip) {
		Pet foundedPet = null;
		for (int i = 0; i < this.pets.size(); i++) {
			if (microchip.equals(this.pets.get(i).getMicrochip())) {
				foundedPet = this.pets.get(i);
				i = this.pets.size();
			}
		}
		return foundedPet;
	}

	/**
	 * Se encarga de contar cuántas mascotas de especie felino o canino se
	 * encuentran en el registro
	 * 
	 * @param species
	 * @return
	 */
	public String countBySpecies(String species) {
		int cont = 0;
		for (int i = 0; i < getPets().size(); i++)
			if (species.equals(pets.get(i).getSpecies()))
				cont++;

		return "El número de animales de la especie " + species + " es: " + cont++;
	}

	/**
	 * Busca cierta cantidad de mascotas potencialmente peligrosos de una localidad
	 * pueden ser los primeros o los últimos.
	 * 
	 * @param n,            Cantidad de animales que se quieren obtener
	 * @param position,     posición de los animales, los últimos o primeros
	 * @param neighborhood, Localidad donde están los animales
	 * 
	 * @return lista de objetos de la clase Pet
	 */
	public List<Pet> findBypotentDangerousInNeighborhood(int n, String position, String neighborhood) {

		ArrayList<Pet> pdinPet = new ArrayList<Pet>();
		int start = 0;
		int end = 0;

		for (Pet pet : pets) {
			if (pet.getNeighborhood().equals(neighborhood) && pet.isPotentDangerous()) {
				if (pet.getId() == null)
					pet.setId("NO-ID");
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

	/**
	 * Se encarga de buscar una mascota de acuerdo a varias caractrísticas, si
	 * coincide con todas, se genera una lista con el o los ID's de las mascotas que
	 * coincidieron
	 * 
	 * @param species
	 * @param sex
	 * @param size
	 * @param potentDangerous
	 * @return
	 */
	public String findByMultipleFields(String species, String sex, String size, String potentDangerous) {
		String ids = "";

		if (potentDangerous.equals("NO"))
			potentDangerous = "false";
		else
			potentDangerous = "true";
		for (Pet pet : pets)
			if (sex.equals(pet.getSex()) && species.equals(pet.getSpecies())
					&& Boolean.parseBoolean(potentDangerous) == pet.isPotentDangerous() && size.equals(pet.getSize()))
				ids += pet.getId() + "\n";

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
