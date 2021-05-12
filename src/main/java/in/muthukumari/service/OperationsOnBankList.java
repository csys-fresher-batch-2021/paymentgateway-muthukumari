package in.muthukumari.service;

import in.muthukumari.validator.*;

import java.util.HashSet;

import java.util.Set;

public class OperationsOnBankList {

	private OperationsOnBankList() {
		// Default Constructor
	}

	private static Set<String> bankList = new HashSet<>();

	/**
	 * This method used to add the bank list
	 * 
	 * @param bankName
	 * @return
	 */
	public boolean addBankList(String bankName) {
		boolean addBankName = false;

		if (Validation.nameValidation(bankName)) {
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

		System.out.println("------------- List of Banks ------------");
		for (String bankName : bankList) {
			System.out.println(bankName.trim());
		}
	}

}
