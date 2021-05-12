package in.muthukumari.model;

import java.util.HashSet;
import java.util.Set;

public class BankDetail {
	
	private BankDetail() {
		// Default Constructor
	}

	private static Set<String> bankNameList = new HashSet<>();
	static {
		bankNameList.add("Indian Bank");
		bankNameList.add("Indian Overseas Bank");
		bankNameList.add("Canara Bank");
		bankNameList.add("Union Bank of India");
		bankNameList.add("Andhra Bank");
	}
	/*
	 * This method returns the list of bank name
	 */
	public static Set<String> getBankName() {
		return bankNameList;
	}

}
