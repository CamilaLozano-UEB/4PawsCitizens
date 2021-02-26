package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.Manager;
import co.edu.unbosque.FourPawsCitizens.model.dtos.Pet;
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

	public void coordinateMenu() {
		String option = this.view.printOptionsMenu();
		do {
			if (0 < Integer.parseInt(option) && Integer.parseInt(option) < 7) {

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
					for (int i = 0; i < this.manager.getPets().size(); i++) {
					}
					break;
				case "5":
					for (int i = 0; i < this.manager.getPets().size(); i++) {
					}
					break;
				default:
				}
				option = this.view.printOptionsMenu();
			}
		} while (!option.equals("6"));

	}

}
