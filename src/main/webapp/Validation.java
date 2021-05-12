package in.muthukumari.validator;

public class Validation {
	
	/*
	 * This method validate the bank name
	 */
	public static boolean nameValidation(String name) {
		boolean isValid = true;// set isValid variable is true
		// Check the bank name is equal to null or is an empty space
		if (name == null || name.trim().equals("")) {
			isValid = false;// if the condition is false set isValid variable is false
		}

		return isValid;// return the isValid variable
	}

}
