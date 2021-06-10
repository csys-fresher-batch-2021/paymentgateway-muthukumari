package in.muthukumari.exception;

public class ValidatorException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * This method is used to raise customer repeated exception
	 */
	public ValidatorException(String message) {
		super(message);
	}

}
