package in.muthukumari.exception;

public class DBException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * This method is used to define DB exception
	 */
	public DBException(String message) {
		super(message);
	}
}
