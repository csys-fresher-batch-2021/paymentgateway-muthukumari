package in.muthukumari.validator;

import java.util.List;
import in.muthukumari.dao.CustomerDAO;
import in.muthukumari.exception.CustomerRepeatedException;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;

public class CustomerDetailValidator {

	private CustomerDetailValidator() {
		// Default Constructor
	}

	public static boolean isUserNotRepeated(CustomerBankDetail customer) throws DBException, CustomerRepeatedException {
		// Declaration
		boolean valid = false;
		// To get user details
		List<CustomerBankDetail> customerDetail = CustomerDAO.getCustomrBankDetails();
		
		for (CustomerBankDetail customerBankDetail : customerDetail) {
			if ((customerBankDetail.getAccountNumber()) != (customer.getAccountNumber())) {
				valid = true;
			} else {
				throw new CustomerRepeatedException(
						"Sorry! This account number is already used by another customer please, try again using another account number");
			}
		}
		return valid;
	}

	public static boolean isValidName(String userName) {
		boolean isValid=false;
		String regex=".*[0-9@$%^=()./#&+-].*";
		if(userName.length()>3 && (!userName.matches(regex))) {
			isValid = true;			
		}
		return isValid;
		
	}
	public static boolean isValidMobileNum(long mobileNum) {
		boolean isValidNum=false;
		String mobileNumStr=Long.toString(mobileNum);
		if(mobileNumStr.length()==10 && mobileNumStr.charAt(0)!='0') {
			isValidNum=true;
		}		
		return isValidNum;
	}
}
