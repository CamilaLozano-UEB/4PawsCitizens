package co.edu.unbosque.FourPawsCitizens.Excepcions;

public class EmptyAttributeException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyAttributeException() {
		super("An empty field has been found on the dataset");
	}

}