package in.muthukumari.service;

import in.muthukumari.validator.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankDetailServer {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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

		if (Validation.nameValidation(bankName)) {
			if(!bankList.contains(bankName)) {
			bankList.add(bankName);
			addBankName = true;
			}
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

		LOGGER.log(Level.INFO, "------------- List of Banks ------------");
		for (String bankName : bankList) {
			String name = bankName.trim();
			LOGGER.log(Level.INFO, name);
		}
	}
}
