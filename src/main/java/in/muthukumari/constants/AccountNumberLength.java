package in.muthukumari.constants;

import java.util.HashMap;
import java.util.Map;

public class AccountNumberLength {
	/**
	 * This method used to declare the account number length of each bank
	 * 
	 * @return
	 */
	public static Map<String, Integer> getAccountNumberLength() {

		Map<String, Integer> bankAndAccountLength = new HashMap<>();

		bankAndAccountLength.put("Indian Bank", 17);
		bankAndAccountLength.put("Indian Overseas Bank", 15);
		bankAndAccountLength.put("Canara Bank", 13);
		bankAndAccountLength.put("ICICI Bank", 12);
		bankAndAccountLength.put("Andhra Bank", 15);
		bankAndAccountLength.put("Union Bank", 13);

		return bankAndAccountLength;

	}

}
