package in.muthukumari.validator;

import java.util.ArrayList;
import java.util.List;
import in.muthukumari.exception.CustomerRepeatedException;
import in.muthukumari.exception.InvalidException;
import in.muthukumari.exception.NumberInvalidException;
import in.muthukumari.model.CustomerBankDetail;

public class CustomerDetailValidator {

	private CustomerDetailValidator() {
		// Default Constructor
	}

	/**
	 * This method used to validate the name
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isValidName(String userName) {
		boolean isValid = false;
		String regex = "^[a-zA-Z]";
		if (userName.length() > 2 && (userName.matches(regex))) {
			isValid = true;
		}
		return isValid;

	}

	/**
	 * This method used to validate the email
	 */
	public static boolean isValidEmail(String email) {
		boolean isValid = false;
		String regex = "^[A-Za-z0-9+_.-]+@(.+)";
		if ((email.matches(regex))) {
			isValid = true;
		}
		return isValid;

	}

	/**
	 * This method use to validate the password
	 */
	public static boolean isValidPassword(String password) {
		boolean isValid = false;
		String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*_=+-]).{5,10}";
		if ((password.matches(regex))) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * This method use to validate the username
	 */
	public static boolean isValidUserName(String userName) {
		boolean isValid = false;
		String regex = "^(?=.*[0-9])(?=.*[a-zA-Z]).{5,10}";
		if ((userName.matches(regex))) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * This method used to check all the details of the customer
	 * 
	 * @param customer
	 * @return
	 * @throws InvalidException
	 * @throws CustomerRepeatedException
	 * @throws NumberInvalidException
	 */
	public static boolean isValidCustomer(CustomerBankDetail customer)
			throws InvalidException, CustomerRepeatedException, NumberInvalidException {
		boolean isValidCustomer = true;
		List<String> errorList = new ArrayList<>();
		boolean isValidAccountNum = BankDetailValidator.isValidAccountNumber(customer.getAccountNumber(),
												customer.getBankName());
		String isValidAccountNumStr = Boolean.toString(isValidAccountNum);
		errorList.add(isValidAccountNumStr);
		boolean isValidName = CustomerDetailValidator.isValidName(customer.getUserName());
		String isValidNameStr = Boolean.toString(isValidName);
		errorList.add(isValidNameStr);
		boolean isValidBankName = BankDetailValidator.isValidBank(customer);
		String isValidBankNameStr = Boolean.toString(isValidBankName);
		errorList.add(isValidBankNameStr);
		boolean isValidBranchName = BankDetailValidator.isValidBranchName(customer);
		String isValidBranchNameStr = Boolean.toString(isValidBranchName);
		errorList.add(isValidBranchNameStr);
		boolean isValidIfscCode = BankDetailValidator.isValidIfscCode(customer);
		String isValidIfscCodeStr = Boolean.toString(isValidIfscCode);
		errorList.add(isValidIfscCodeStr);
		boolean isValidAtmNum = BankDetailValidator.isValidAtmCardNumber(customer);
		String isValidAtmNumStr = Boolean.toString(isValidAtmNum);
		errorList.add(isValidAtmNumStr);
		boolean isValidAtmPinNum = BankDetailValidator.isValidAtmPinNumber(customer);
		String isValidAtmPinNumStr = Boolean.toString(isValidAtmPinNum);
		errorList.add(isValidAtmPinNumStr);
		boolean isValidMobileNum = BankDetailValidator.isValidMobileNumber(customer.getMobileNumber());
		String isValidMobileNumStr = Boolean.toString(isValidMobileNum);
		errorList.add(isValidMobileNumStr);
		boolean isRepeatedAccNum = CustomerRepeatedValidator
				.isRepeatedAccountNumber(customer.getAccountNumber());
		String isRepeatedAccNumStr = Boolean.toString(isRepeatedAccNum);
		errorList.add(isRepeatedAccNumStr);
		boolean isRepeatedAtmNum = CustomerRepeatedValidator
				.isRepeatedAtmNumber(customer.getAtmNumber());
		String isRepeatedAtmNumStr = Boolean.toString(isRepeatedAtmNum);
		errorList.add(isRepeatedAtmNumStr);
		if (errorList.contains("false")) {
			isValidCustomer = false;
		}
		return isValidCustomer;
	}
}
