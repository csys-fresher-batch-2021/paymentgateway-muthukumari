package in.muthukumari.exception;

public class CustomerRepeatedException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * This method is used to raise customer repeated exception
	 */
	public CustomerRepeatedException(String message) {
		super(message);
	}

}
