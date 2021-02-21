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
	//	System.out.println(this.model.getManager().findByMicrochip(Long.parseLong("978101081928801")).toString());
	//	System.out.println(this.model.getManager().countBySpecies("CANINO"));
		System.out.println(this.model.getManager().findByMultipleFields("CANINO", "HEMBRA", "MINIATURA", "NO"));
	}

}
