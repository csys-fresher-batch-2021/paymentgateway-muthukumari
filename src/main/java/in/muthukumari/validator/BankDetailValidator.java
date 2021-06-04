package in.muthukumari.validator;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import in.muthukumari.constants.AccountNumberLength;
import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;

public class BankDetailValidator {

	private BankDetailValidator() {
		// Default constructor
	}

	/**
	 * This method validate the account number
	 * @param customer
	 * @return
	 * @throws DBException
	 */
	public static boolean isValidAccountNumber(CustomerBankDetail customer) throws DBException {

		boolean isValidAccountNumber = false;
		String accountNumberStr = Long.toString(customer.getAccountNumber());
		int lengthOfAccountNumberStr=accountNumberStr.length();
		Map<String, Integer> bankAndAccountNumberLengthList = AccountNumberLength.getAccountNumberLength();
		if (bankAndAccountNumberLengthList.containsKey(customer.getBankName())) {
			int accountNumberLength = bankAndAccountNumberLengthList.get(customer.getBankName());
			if (accountNumberLength == lengthOfAccountNumberStr) {
				isValidAccountNumber = true;
			}
		}
		else {
			throw new DBException("Bank Name Not Exists");
		}
		return isValidAccountNumber;
	}
	
	/**
	 * This method used to check the bank name
	 * @param customer
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DBException
	 */
	public static boolean isValidBank(CustomerBankDetail customer) throws ClassNotFoundException, SQLException, DBException {
		Set<String> bankNameList=BankDAO.getBankNameList();
		boolean isValid=false;
		if(bankNameList.contains(customer.getBankName())) {
			isValid=true;
		}
		return isValid;
	}

	/**
	 * This method used to check the atm card number
	 * @param customer
	 * @return
	 */
	public static boolean isValidAtmCardNumber(CustomerBankDetail customer) {
		boolean isValidNum=false;
		String atmNumStr=Long.toString(customer.getAtmNumber());
		String regex="[0-9]";
		if(atmNumStr.length()==16 && atmNumStr.matches(regex)) {
			isValidNum=true;
		}
		return isValidNum;
	}

	public static boolean isValidAtmPinNumber(CustomerBankDetail customer) {
		boolean isValidNum=false;
		String atmPinNumStr=Long.toString(customer.getAtmPinNumber());
		if(atmPinNumStr.length()==4) {
			isValidNum=true;
		}
		return isValidNum;
	}

	public static boolean isValidMobileNumber(CustomerBankDetail customer) {
		boolean isValidNum=false;
		String atmPinNumStr=Long.toString(customer.getAtmPinNumber());
		if(atmPinNumStr.length()==10 && atmPinNumStr.charAt(0)=='0' ) {
			isValidNum=true;
		}
		return isValidNum;
	}

}
