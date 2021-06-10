package in.muthukumari.validator;

import java.util.Map;
import java.util.Set;
import in.muthukumari.dao.BankRulesDAO;
import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.InvalidException;
import in.muthukumari.exception.NumberInvalidException;
import in.muthukumari.model.CustomerBankDetail;

public class BankDetailValidator {

	static String regex = "[0-9]*";// Declare regex for number

	private BankDetailValidator() {
		// Default constructor
	}

	/**
	 * This method validate the account number
	 * 
	 * @param accountNum
	 * @return
	 * @throws NumberInvalidException
	 */
	public static boolean isValidAccountNumber(long accountNum,String bankName) throws NumberInvalidException {

		boolean isValidAccountNumber = false;
		String accountNumberStr = Long.toString(accountNum);
		int lengthOfAccountNumberStr = accountNumberStr.length();
		Map<String, Integer> bankAndAccountNumberLengthList = null;
		try {
			bankAndAccountNumberLengthList = BankRulesDAO.getAccountNumberLength();
			if (bankAndAccountNumberLengthList.containsKey(bankName)) {
				int accountNumberLength = bankAndAccountNumberLengthList.get(bankName);
				if (accountNumberLength == lengthOfAccountNumberStr && accountNumberStr.matches(regex)) {
					isValidAccountNumber = true;
				}
			}
		} catch (DBException e) {
			throw new NumberInvalidException("Account number length not valid");
		}
		return isValidAccountNumber;
	}

	/**
	 * This method used to check the bank name
	 * 
	 * @param customer
	 * @return
	 * @throws InvalidException
	 */
	public static boolean isValidBank(CustomerBankDetail customer) throws InvalidException {
		Set<String> bankNameList = null;
		boolean isValid = false;
		try {
			bankNameList = BankDAO.getBankNameList();
			if (bankNameList.contains(customer.getBankName())) {
				isValid = true;
			}
		} catch (DBException e) {
			throw new InvalidException(e.getMessage());
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
	 * This method used to validate the mobile number
	 * 
	 * @param customer
	 * @return
	 */
	public static boolean isValidMobileNumber(long mobilNo) {
		boolean isValidNum = false;
		String mobileNumStr = Long.toString(mobilNo);
		String regex1="([6-9]{1})+([0-9]{9})*";
		boolean isValid=mobileNumStr.matches(regex1);
		if (isValid) {
			isValidNum = true;
		}
		return isValidNum;
	}

	/**
	 * This method used to validate th ifsc code
	 * 
	 * @param customer
	 * @return
	 * @throws InvalidException
	 */
	public static boolean isValidIfscCode(CustomerBankDetail customer) throws InvalidException {
		boolean isValidIfsc = false;
		Map<String, String> branchAndIfscList = null;
		try {
			branchAndIfscList = BankDAO.getBranchNameAndIfscList(customer.getBankName());
			if (branchAndIfscList.containsKey(customer.getBranchName())) {
				String ifsc = branchAndIfscList.get(customer.getBranchName());
				if (ifsc.equals(customer.getIfscCode())) {
					isValidIfsc = true;
				} else {
					isValidIfsc = false;
				}
			}
		} catch (DBException e) {
			throw new InvalidException("Unable to validate the ifsc code");
		}

		return isValidIfsc;
	}

	/**
	 * This method used to validate the branch name
	 * 
	 * @param customer
	 * @return
	 * @throws InvalidException
	 */
	public static boolean isValidBranchName(CustomerBankDetail customer) throws InvalidException {
		boolean isValidIfsc = false;
		Map<String, String> branchAndIfscList = null;
		try {
			branchAndIfscList = BankDAO.getBranchNameAndIfscList(customer.getBankName());
			if (branchAndIfscList.containsKey(customer.getBranchName())) {
				isValidIfsc = true;
			}
		} catch (DBException e) {
			throw new InvalidException("Unable to validate the branch name");
		}

		return isValidIfsc;
	}

}
