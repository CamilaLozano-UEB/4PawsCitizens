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
			this.model.getManager().assignID();

//		for (int i = 0; i < this.model.getManager().getPets().size(); i++) {
//			System.out.println(this.model.getManager().getPets().get(i).getId());
//		}
			System.out.println(this.model.getManager().findByMicrochip(Long.parseLong("9781010809288690")));
	}
}
