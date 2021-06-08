package in.muthukumari.exception;

public class InvalidException extends Exception {	
	private static final long serialVersionUID = 1L;

	/**
	 * The method raise the invalid exception
	 * 
	 * @param message
	 */
	public InvalidException(String message) {
		super(message);
	}

}
