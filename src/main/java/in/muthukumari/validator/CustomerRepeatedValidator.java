package in.muthukumari.validator;

import in.muthukumari.dao.ExistDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.ValidatorException;
import in.muthukumari.model.Recipient;

public class CustomerRepeatedValidator {

	private CustomerRepeatedValidator() {
		// Default Constructor
	}

	/**
	 * This method used to check the account number is already given or not
	 * 
	 * @param customer
	 * @return
	 * @throws ValidatorException
	 */
	public static boolean isRepeatedAccountNumber(long accountNum) throws ValidatorException {
		boolean isRepeatedAccNum = true;
		try {
			boolean isExists = ExistDAO.isRepeatedAccountNumber(accountNum);
			if (isExists) {
				isRepeatedAccNum = false;
			}
		} catch (DBException e) {
			throw new ValidatorException("The account detail is already given in the DB");
		}
		return isRepeatedAccNum;
	}

	/**
	 * This method used to check the account number is already given or not
	 * 
	 * @param customer
	 * @return
	 * @throws ValidatorException
	 */
	public static boolean isRepeatedAtmNumber(long atmNum) throws ValidatorException {
		boolean isRepeatedAtmNum = true;
		try {
			boolean isExists = ExistDAO.isRepeatedAtmNumber(atmNum);
			if (isExists) {
				isRepeatedAtmNum = false;
			}
		} catch (DBException e) {
			throw new ValidatorException("The atm number is already given in the DB");
		}
		return isRepeatedAtmNum;
	}

	/**
	 * This method used to check the username is exists or not with validation
	 * 
	 * @param userName
	 * @return
	 * @throws ValidatorException
	 */
	public static boolean isRepeatedUserName(String userName) throws ValidatorException {
		boolean isRepeatedUser = false;
		try {
			boolean isValid = CustomerDetailValidator.isValidUserName(userName);
			if (isValid) {
				boolean isExists = ExistDAO.isExistUserName(userName);
				if (isExists) {
					isRepeatedUser = true;
				}
			}
		} catch (DBException e) {
			throw new ValidatorException("The user name is already given in the DB");
		}
		return isRepeatedUser;
	}

	/**
	 * This method used to get check if the email is exists or not
	 * 
	 * @param email
	 * @return
	 * @throws ValidatorException
	 */
	public static boolean isRepeatedEmail(String email) throws ValidatorException {
		boolean isRepeatedEmail = true;
		try {
			boolean isExists = ExistDAO.isExistEmail(email);
			if (isExists) {
				isRepeatedEmail = false;
			}

		} catch (DBException e) {
			throw new ValidatorException("The email id is already given");
		}
		return isRepeatedEmail;
	}

	/**
	 * This method used to check the user name exists or not without validation
	 * 
	 * @param userName
	 * @return
	 * @throws ValidatorException
	 */
	public static boolean isUserNameExists(String userName) throws ValidatorException {
		boolean isRepeatedUser = false;
		boolean isExists = false;
		try {
			isExists = ExistDAO.isExistUserName(userName);
			if (isExists) {
				isRepeatedUser = true;
			}
		} catch (DBException e) {
			throw new ValidatorException("The user name is already given in the DB");
		}
		return isRepeatedUser;
	}

	/**
	 * This method used to check the sender and recipient account numbers are same
	 * or not
	 * 
	 * @param recipient
	 * @return
	 * @throws ValidatorException
	 */
	public static boolean isSameAccountNumber(Recipient recipient) throws ValidatorException {
		boolean isNotSame = false;
		long senderAccNum = recipient.getSenderAccNum();
		long recipientAccNum = recipient.getReceiverAccNum();
		if (senderAccNum != recipientAccNum) {
			isNotSame = true;
		} else {
			throw new ValidatorException("Both the acconut numbrs are same.");
		}
		return isNotSame;
	}

}
