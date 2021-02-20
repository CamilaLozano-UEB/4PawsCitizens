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
		this.model.getManager().uploadData();
		for (int i = 0; i < this.model.getManager().getPets().size(); i++) {
				System.out.println(this.model.getManager().getPets().get(i).isPotentDangerous() + "" + i);
		}
		System.out.println(this.model.getManager().getPets().size());
	}
}
