package in.muthukumari.validator;

public class Validation {

	private Validation() {

		// Default Constructor
	}

	/*
	 * This method validate the bank name
	 */
	public static boolean nameValidation(String name) {
		boolean isValid = true;// set isValid variable is true
		// Check the bank name
		
		if(name==null || name.trim().equals("")) {
			isValid = false;
		}

		return isValid;// return the isValid variable
	}

}