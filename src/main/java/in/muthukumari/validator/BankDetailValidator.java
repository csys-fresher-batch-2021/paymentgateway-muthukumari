package in.muthukumari.validator;

import java.util.Map;
import in.muthukumari.constants.AccountNumberLength;
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
		String AccountNumberStr = Long.toString(customer.getAccountNumber());
		int lengthOfAccountNumberStr=AccountNumberStr.length();
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

}
