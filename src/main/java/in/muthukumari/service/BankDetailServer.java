package in.muthukumari.service;

import in.muthukumari.validator.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class BankDetailServer {
	private static final Logger Logger1 = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private BankDetailServer() {
		// Default Constructor
	}

	private static Set<String> bankList = new HashSet<>();

	/**
	 * This method used to add the bank list
	 * 
	 * @param bankName
	 * @return
	 */
	public static boolean addBankList(String bankName) {
		boolean addBankName = false;

		if ((Validation.nameValidation(bankName)) && (!bankList.contains(bankName))) {
			bankList.add(bankName);
			addBankName = true;
		}

		return addBankName;
	}

	/**
	 * This method used to get the no of bank list
	 * 
	 * @return
	 */
	public static Set<String> getBankList() {
		return bankList;
	}

	/**
	 * This method used to display the bank list
	 */
	public static void displayBankList() {
		Logger1.info("------------- List of Banks ------------");
		for (String bankName : bankList) {
			String name=bankName.trim();
			Logger1.info(name);
		}
	}
}
