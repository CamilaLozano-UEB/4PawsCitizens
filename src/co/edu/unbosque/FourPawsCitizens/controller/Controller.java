package co.edu.unbosque.FourPawsCitizens.controller;

import co.edu.unbosque.FourPawsCitizens.model.Model;
import co.edu.unbosque.FourPawsCitizens.view.View;

public class Controller {

	private Model model;
	private View view;

	public Controller() {
		model = new Model();
		view = new View();
		this.coordinateActions();
	}

	public void coordinateActions() {
		this.view.printMessage("Write your name");
		this.view.printMessage(this.view.readInput());
	}
}
