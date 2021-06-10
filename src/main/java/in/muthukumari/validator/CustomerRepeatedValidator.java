package in.muthukumari.validator;

import in.muthukumari.dao.ExistDAO;
import in.muthukumari.exception.CustomerRepeatedException;
import in.muthukumari.exception.DBException;

public class CustomerRepeatedValidator {

	private CustomerRepeatedValidator() {
		// Default Constructor
	}

	/**
	 * This method used to check the account number is already given or not
	 * 
	 * @param customer
	 * @return
	 * @throws CustomerRepeatedException
	 */
	public static boolean isRepeatedAccountNumber(long accountNum) throws CustomerRepeatedException {
		boolean isRepeatedAccNum = true;
		try {
			boolean isExists = ExistDAO.isRepeatedAccountNumber(accountNum);
			if (isExists) {
				isRepeatedAccNum = false;
			}
		} catch (DBException e) {
			throw new CustomerRepeatedException("The account detail is already given in the DB");
		}
		return isRepeatedAccNum;
	}
	
	/**
	 * This method used to check the account number is already given or not
	 * 
	 * @param customer
	 * @return
	 * @throws CustomerRepeatedException
	 */
	public static boolean isRepeatedAtmNumber(long atmNum) throws CustomerRepeatedException {
		boolean isRepeatedAtmNum = true;
		try {
			boolean isExists = ExistDAO.isRepeatedAtmNumber(atmNum);
			if (isExists) {
				isRepeatedAtmNum = false;
			}
		} catch (DBException e) {
			throw new CustomerRepeatedException("The atm number is already given in the DB");
		}
		return isRepeatedAtmNum;
	}

	/**
	 * This method used to check the username is exists or not with validation
	 * 
	 * @param userName
	 * @return
	 * @throws CustomerRepeatedException
	 */
	public static boolean isRepeatedUserName(String userName) throws CustomerRepeatedException {
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
			throw new CustomerRepeatedException("The user name is already given in the DB");
		}
		return isRepeatedUser;
	}

	/**
	 * This method used to get check if the email is exists or not
	 * 
	 * @param email
	 * @return
	 * @throws CustomerRepeatedException
	 */
	public static boolean isRepeatedEmail(String email) throws CustomerRepeatedException {
		boolean isRepeatedEmail = true;
		try {
			boolean isExists = ExistDAO.isExistEmail(email);
			if (isExists) {
				isRepeatedEmail = false;
			}

		} catch (DBException e) {
			throw new CustomerRepeatedException("The email id is already given");
		}
		return isRepeatedEmail;
	}

	/**
	 * This method used to check the user name exists or not without validation
	 * 
	 * @param userName
	 * @return
	 * @throws CustomerRepeatedException
	 */
	public static boolean isUserNameExists(String userName) throws CustomerRepeatedException {
		boolean isRepeatedUser = false;
		boolean isExists = false;
		try {
			isExists = ExistDAO.isExistUserName(userName);
			if (isExists) {
				isRepeatedUser = true;
			}
		} catch (DBException e) {
			throw new CustomerRepeatedException("The user name is already given in the DB");
		}
		return isRepeatedUser;
	}

}
