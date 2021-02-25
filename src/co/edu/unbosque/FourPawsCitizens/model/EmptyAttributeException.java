package co.edu.unbosque.FourPawsCitizens.model;

public class EmptyAttributeException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyAttributeException() {
		super("An empty field has been found on the dataset");
	}

}
