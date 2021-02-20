package co.edu.unbosque.FourPawsCitizens.model;

public class ExistingIDException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExistingIDException() {
		super("La Id ya ha sido creada, joputa :3");
	}
}
