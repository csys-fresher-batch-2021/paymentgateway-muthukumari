package in.muthukumari.validator;

public class CustomerDetailValidation {

	private CustomerDetailValidation() {

		// Default Constructor
	}

	/*
	 * This method validate the name
	 */
	
	public static boolean nameValidation(String name) {
		boolean isValid = true;// set isValid variable is true
		// Check the bank name
		String regex = ".*[0-9@$%^=()./#&+-].*"; // the regular expression for numbers and special characters

		if (name == null || name.trim().equals("")|| name.matches(regex) || name.length() < 3) {
			isValid = false;
		}

		return isValid;// return the isValid variable
	}

	public static boolean numberValidation(long number) {
		boolean isValid = false;// set isValid variable is false
		String regex = ".*[0-9].*";// the regular expression for numbers
		String mobileNumber = String.valueOf(number);
		if (mobileNumber.matches(regex) && mobileNumber.length() == 10) {
			isValid = true;
		}

		return isValid;// return the isValid variable
	}

	public static boolean passwordValidation(String password) {
		boolean isValid = false;// set isValid variable is false
		String regex = "^(?=.*[0-9])(?=.*[@#$%^&+=]).{5}$";// the regular expression for numbers and special characters.
		if (password.matches(regex)) {
			isValid = true;
		}

		return isValid;// return the isValid variable
	}

	public static boolean ifscValidation(String ifsc, String bankName) {
		boolean isValid = false;
		int value = bankNameValue(bankName);
		switch (value) {
		case 0: {
			isValid = false;
			break;
		}
		case 1: {
			if (ifsc.trim().equals("IDIB000T035")) {
				isValid = true;
				break;
			}
		}
		case 2: {
			if (ifsc.trim().equals("IOBA0000094")) {
				isValid = true;
				break;
			}
		}
		case 3: {
			if (ifsc.trim().equals("CNRB0001120")) {
				isValid = true;
				break;
			}
		}
		}
		return isValid;
	}

	public static boolean accountNumberValidation(Long accountNumber, String bankName) {
		boolean isValid = false;
		int value = bankNameValue(bankName);
		String strAccountNumber = String.valueOf(accountNumber);
		switch (value) {
		case 0: {
			isValid = false;
			break;
		}
		case 1: {
			if (strAccountNumber.length() > 8 && strAccountNumber.length() < 18) {
				isValid = true;
				break;
			}
		}
		case 2: {
			if (strAccountNumber.length() == 15) {
				isValid = true;
				break;
			}
		}
		case 3: {
			if (strAccountNumber.length() == 13) {
				isValid = true;
				break;
			}
		}
		}
		return isValid;
	}

	public static int bankNameValue(String bankName) {
		int bankValue = 0;
		if (bankName == null || bankName.trim().equals("")) {
			bankValue = 0;
		} else if (bankName.trim().equalsIgnoreCase("Indian Bank")) {
			bankValue = 1;
		} else if (bankName.trim().equalsIgnoreCase("Indian Overseas Bank")) {
			bankValue = 2;
		} else if (bankName.trim().equalsIgnoreCase("Canara Bank")) {
			bankValue = 3;
		}

		return bankValue;
	}

}