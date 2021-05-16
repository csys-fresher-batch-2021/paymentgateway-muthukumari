package in.muthukumari.validator;

import java.util.regex.Pattern;

public class Validation {

	private Validation() {

		// Default Constructor
	}

	/*
	 * This method validate the bank name
	 */
	public static boolean nameValidation(String name) {
		boolean isValid = false;// set isValid variable is false
		// Check the bank name
		if (!name.equals(null) && !name.trim().equals("") && Pattern.matches("a-zA-Z]{3,}", name)) {
			isValid = true;// if the condition is true set isValid variable is true
		}

		return isValid;// return the isValid variable
	}

}