package in.muthukumari.validator;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import in.muthukumari.constants.AccountNumberLength;
import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;

public class BankDetailValidator {

	static String regex = ".*[0-9].*";// Declare regex for number

	private BankDetailValidator() {
		// Default constructor
	}

	/**
	 * This method validate the account number
	 * 
	 * @param customer
	 * @return
	 * @throws DBException
	 */
	public static boolean isValidAccountNumber(CustomerBankDetail customer) throws DBException {

		boolean isValidAccountNumber = false;
		String accountNumberStr = Long.toString(customer.getAccountNumber());
		int lengthOfAccountNumberStr = accountNumberStr.length();
		Map<String, Integer> bankAndAccountNumberLengthList = AccountNumberLength.getAccountNumberLength();
		if (bankAndAccountNumberLengthList.containsKey(customer.getBankName())) {
			int accountNumberLength = bankAndAccountNumberLengthList.get(customer.getBankName());
			if (accountNumberLength == lengthOfAccountNumberStr) {
				isValidAccountNumber = true;
			}
		} else {
			throw new DBException("Bank Name Not Exists");
		}
		return isValidAccountNumber;
	}

	/**
	 * This method used to check the bank name
	 * 
	 * @param customer
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DBException
	 */
	public static boolean isValidBank(CustomerBankDetail customer)
			throws ClassNotFoundException, SQLException, DBException {
		Set<String> bankNameList = BankDAO.getBankNameList();
		boolean isValid = false;
		if (bankNameList.contains(customer.getBankName())) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * This method used to check the atm card number
	 * 
	 * @param customer
	 * @return
	 */
	public static boolean isValidAtmCardNumber(CustomerBankDetail customer) {
		boolean isValidNum = false;
		String atmNumStr = Long.toString(customer.getAtmNumber());

		if (atmNumStr.length() == 16 && atmNumStr.matches(regex)) {
			isValidNum = true;
		}
		return isValidNum;
	}

	/**
	 * This method used to check th atm pin number
	 * 
	 * @param customer
	 * @return
	 */
	public static boolean isValidAtmPinNumber(CustomerBankDetail customer) {
		boolean isValidNum = false;
		String atmPinNumStr = Long.toString(customer.getAtmPinNumber());
		if (atmPinNumStr.length() == 4 && atmPinNumStr.matches(regex)) {
			isValidNum = true;
		}
		return isValidNum;
	}

	/**
	 * Thismethod used to validate the mobile number
	 * 
	 * @param customer
	 * @return
	 */
	public static boolean isValidMobileNumber(CustomerBankDetail customer) {
		boolean isValidNum = false;
		String mobileNumStr = Long.toString(customer.getMobileNumber());
		if (mobileNumStr.length() == 10 && mobileNumStr.charAt(0) != '0' && mobileNumStr.matches(regex)) {
			isValidNum = true;
		}
		return isValidNum;
	}

	/**
	 * This method used to validate th ifsc code
	 * 
	 * @param customer
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean isValidIfscCode(CustomerBankDetail customer) throws ClassNotFoundException, SQLException {
		boolean isValidIfsc = false;
		Map<String, String> branchAndIfscList = BankDAO.getBranchNameAndIfscList(customer.getBankName());
		if (branchAndIfscList.containsKey(customer.getBranchName())) {
			String ifsc = branchAndIfscList.get(customer.getBranchName());
			if (ifsc.equals(customer.getIfscCode())) {
				isValidIfsc = true;
			} else {
				isValidIfsc = false;
			}
		}
		return isValidIfsc;
	}

	/**
	 * This method used to validate the branch name
	 * 
	 * @param customer
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean isValidBranchName(CustomerBankDetail customer) throws ClassNotFoundException, SQLException {
		boolean isValidIfsc = false;
		Map<String, String> branchAndIfscList = BankDAO.getBranchNameAndIfscList(customer.getBankName());
		if (branchAndIfscList.containsKey(customer.getBranchName())) {
			isValidIfsc = true;
		}
		return isValidIfsc;
	}

}
