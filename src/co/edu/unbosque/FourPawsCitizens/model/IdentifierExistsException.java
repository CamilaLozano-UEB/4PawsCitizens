package co.edu.unbosque.FourPawsCitizens.model;

public class IdentifierExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public IdentifierExistsException() {
		super("La Id ya ha sido creada, joputa :3");
	}
}
