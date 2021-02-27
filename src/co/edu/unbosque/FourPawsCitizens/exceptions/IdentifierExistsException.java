package co.edu.unbosque.FourPawsCitizens.exceptions;

public class IdentifierExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public IdentifierExistsException() {
		super("The ID has already been created");
	}
}
