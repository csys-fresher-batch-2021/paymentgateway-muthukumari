package in.muthukumari.model;

import java.util.HashSet;
import java.util.Set;

public class BankDetail {
	
	private BankDetail() {
		// Default Constructor
	}

	private static Set<String> bankName = new HashSet<>();
	static {
		bankName.add("Indian Bank");
		bankName.add("Indian Overseas Bank");
		bankName.add("Canara Bank");
		bankName.add("Union Bank of India");
		bankName.add("Andhra Bank");
	}

	public static Set<String> getBankName() {
		return bankName;
	}

}
