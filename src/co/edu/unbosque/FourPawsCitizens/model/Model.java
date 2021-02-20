package co.edu.unbosque.FourPawsCitizens.model;

import co.edu.unbosque.FourPawsCitizens.model.daos.Manager;

public class Model {

	private Manager manager;

	public Model() {
		manager = new Manager();
	}

	/**
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
