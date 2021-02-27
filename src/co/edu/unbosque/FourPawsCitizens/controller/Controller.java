package co.edu.unbosque.FourPawsCitizens.controller;

import java.util.List;

import co.edu.unbosque.FourPawsCitizens.model.Manager;
import co.edu.unbosque.FourPawsCitizens.model.dto.Pet;
import co.edu.unbosque.FourPawsCitizens.view.View;

public class Controller {

	private View view;
	private Manager manager;

	public Controller() {
		view = new View();
		manager = new Manager();
		this.manager.uploadData();
		this.coordinateMenu();
	}

	/**
	 * Método que coordina todo el menu de opciones, recibe los datos validados
	 * desde la consola y conecta la clase y métodos de manager con la clase view
	 */

	public void coordinateMenu() {
		view.printMessage("Welcome, the data has already been loaded.");
		String option = this.view.printOptionsMenu();
		do {
			switch (option) {
			case "1":
				this.manager.assignID();
				this.view.printMessage("El proceso de asignación de ids ha finalizado");
				break;
			case "2":
				Long microchip = this.view.findByMicrochipPrint();
				if (microchip != null) {
					Pet pet = this.manager.findByMicrochip(microchip);
					if (pet != null)
						this.view.printMessage(pet.toString());
					else
						this.view.printMessage("No se encontró ninguna mascota con ese microchip");
				}
				break;
			case "3":
				String specie = this.view.recieveSpecie();
				if (specie != null)
					this.view.printMessage(this.manager.countBySpecies(specie));
				else
					this.view.printMessage("El dato ingresado no corresponde a las especies");
				break;
			case "4":
				String data[] = this.view.receivefindBypotentDangerousInNeighborhood();
				if (data != null) {
					List<Pet> dangerousPet = this.manager.findBypotentDangerousInNeighborhood(Integer.parseInt(data[0]),
							data[1], data[2]);
					for (int i = 0; i < dangerousPet.size(); i++)
						this.view.printMessage(dangerousPet.get(i).toString() + "\n");
				}

				break;
			case "5":
				if (this.manager.getPets().get(0).getId() != null) {
					String[] data2 = this.view.recieveMultipleFields();
					if (data2 != null)
						this.view.printMessage(
								this.manager.findByMultipleFields(data2[0], data2[1], data2[2], data2[3]));
				} else {
					view.printMessage("No se han generado los id´s");
				}
				break;
			default:
				view.printMessage("\n" + option + " no esta dentro de las opciones especificadas \n");
			}
			option = this.view.printOptionsMenu();

		} while (!option.equals("6"));

	}

}
