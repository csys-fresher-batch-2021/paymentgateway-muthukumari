package in.muthukumari.exception;

public class CustomerRepeatedException extends Exception {

	/**
	 * This method is used to raise customer repeated exception
	 */
	private static final long serialVersionUID = 1L;

	public CustomerRepeatedException(String message) {
		super(message);
	}

}
