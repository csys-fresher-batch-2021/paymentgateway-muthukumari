package in.muthukumari.exception;

public class NumberInvalidException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * This method raise the number exception
	 */
	public NumberInvalidException(String message) {
		super(message);

	}
}
