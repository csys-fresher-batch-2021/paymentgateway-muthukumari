package in.muthukumari.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * The method raise the service exception
	 * 
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}
}
