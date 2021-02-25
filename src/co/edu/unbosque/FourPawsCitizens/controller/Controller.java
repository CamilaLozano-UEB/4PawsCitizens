package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.Model;
import co.edu.unbosque.FourPawsCitizens.view.View;

public class Controller {

	private Model model;
	private View view;

	public Controller() {
		model = new Model();
		view = new View();
		this.coordinateMenu();
	}

	public void coordinateMenu() {
		
		this.model.getManager().uploadData();
//		String option = this.view.printOptionsMenu();
//		while (!option.equals("7")) {
//			switch (option) {
//			case "1":
//				this.model.getManager().uploadData();
//				this.view.printMessage("El proceso de carga del archivo ha finalizado");
//				break;
//			case "2":
//				this.model.getManager().assignID();
//				this.view.printMessage("El proceso de asignación de ids ha finalizado");
//				break;
//			case "3":
//				this.view.printMessage(
//						this.model.getManager().findByMicrochip(Long.parseLong(this.view.readInput())).toString());
//				break;
//			case "4":
//				this.view.printMessage(this.model.getManager().countBySpecies(this.view.readInput()));
//				break;
//			case "5":
//				for (int i = 0; i < this.model.getManager().getPets().size(); i++) {
//				}
//				break;
//			case "6":
//				for (int i = 0; i < this.model.getManager().getPets().size(); i++) {
//				}
//				break;
//			default:
//			}
//		}
//
	}

}
