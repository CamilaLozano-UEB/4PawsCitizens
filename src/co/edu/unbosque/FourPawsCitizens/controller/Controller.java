package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.Manager;
import co.edu.unbosque.FourPawsCitizens.view.View;

public class Controller {

	private View view;
	private Manager manager;

	public Controller() {
		view = new View();
		manager = new Manager();
		this.coordinateMenu();
	}

	public void coordinateMenu() {
		this.view.printOptionsMenu();
		this.manager.uploadData();
		String option = this.view.printOptionsMenu();
		if (0 < Integer.parseInt(option) && Integer.parseInt(option) < 7) {
			while (!option.equals("6")) {
				switch (option) {
				case "1":
					this.manager.assignID();
					this.view.printMessage("El proceso de asignación de ids ha finalizado");
					break;
				case "2":
					this.view.printMessage(
							this.manager.findByMicrochip(Long.parseLong(this.view.readInput())).toString());
					break;
				case "3":
					this.view.printMessage(this.manager.countBySpecies(this.view.readInput()));
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
			}
		}

	}

}
