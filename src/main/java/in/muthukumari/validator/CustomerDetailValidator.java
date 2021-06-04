package in.muthukumari.validator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.muthukumari.dao.CustomerDAO;
import in.muthukumari.exception.CustomerRepeatedException;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;

public class CustomerDetailValidator {

	private CustomerDetailValidator() {
		// Default Constructor
	}

	public static boolean isUserNotRepeated(CustomerBankDetail customer) throws DBException {
		// Declaration
		boolean valid = false;
		// To get user details
		List<CustomerBankDetail> customerDetail = CustomerDAO.getCustomrBankDetails();

		for (CustomerBankDetail customerBankDetail : customerDetail) {
			if ((customerBankDetail.getAccountNumber()) != (customer.getAccountNumber())
					&& ((customerBankDetail.getAtmNumber()) != (customer.getAtmNumber()))) {
				valid = true;
			} else {
				valid=false;}
		}
		return valid;
	}

	public static boolean isValidName(String userName) {
		boolean isValid = false;
		String regex = ".*[0-9@$%^=()./#&+-].*";
		if (userName.length() > 3 && (!userName.matches(regex))) {
			isValid = true;
		}
		return isValid;

	}

	/**
	 * This method used to check all the details of the customer
	 * 
	 * @param customer
	 * @return
	 * @throws DBException
	 * @throws CustomerRepeatedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean isValidCustomer(CustomerBankDetail customer)
			throws DBException, CustomerRepeatedException, ClassNotFoundException, SQLException {
		boolean isValidCustomer = true;
		List<String> errorList = new ArrayList<>();
		boolean isUserRepeated = CustomerDetailValidator.isUserNotRepeated(customer);
		String isUserRepeatedStr = Boolean.toString(isUserRepeated);
		errorList.add(isUserRepeatedStr);
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
		boolean isValidMobileNum = BankDetailValidator.isValidMobileNumber(customer);
		String isValidMobileNumStr = Boolean.toString(isValidMobileNum);
		errorList.add(isValidMobileNumStr);
		boolean isValidAccNum = BankDetailValidator.isValidAccountNumber(customer);
		String isValidAccNumStr = Boolean.toString(isValidAccNum);
		errorList.add(isValidAccNumStr);
		if (errorList.contains("false")) {
			isValidCustomer = false;
		}
		return isValidCustomer;
	}
}
