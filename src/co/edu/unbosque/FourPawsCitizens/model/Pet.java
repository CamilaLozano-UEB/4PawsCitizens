package co.edu.unbosque.FourPawsCitizens.model;

public class Pet {
	private String message;
  private String m;


	public Pet() {
    m = "Que la fuerza te acompane";
		this.message = "Que la fuerza no te acompane";
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the m
	 */
	public String getM() {
		return m;
	}

	/**
	 * @param m the m to set
	 */
	public void setM(String m) {
		this.m = m;
	}

}
