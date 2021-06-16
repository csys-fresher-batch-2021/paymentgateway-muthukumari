package in.muthukumari.service;

import java.util.List;
import in.muthukumari.dao.ExistCustomerDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.ServiceException;

public class BankService {

	private BankService() {
		// Default Constructor
	}

	/**
	 * This method use to get the account number list
	 * 
	 * @param userName
	 * @return
	 * @throws ServiceException
	 */
	public static List<Long> getAccountNumber(String userName) throws ServiceException {
		long mobileNum = getMobileNum(userName);
		List<Long> accNumList = null;
		try {
			accNumList = ExistCustomerDAO.getAccountNumber(mobileNum);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return accNumList;
	}

	/**
	 * This method used to get the mobile number forthe particular user name
	 * 
	 * @param userName
	 * @return
	 * @throws ServiceException
	 */
	private static long getMobileNum(String userName) throws ServiceException {
		long mobileNum;
		try {
			mobileNum = ExistCustomerDAO.getMobileNumber(userName);

		} catch (DBException e) {
			throw new ServiceException("You are the new Customer, So please create your account");
		}
		return mobileNum;
	}

	/**
	 * This method used to get the balance amount
	 * 
	 * @param accNum
	 * @return
	 * @throws ServiceException
	 */
	public static double getBalanceAmount(long accNum) throws ServiceException {
		double amount;
		try {
			amount = ExistCustomerDAO.getAmount(accNum);
		} catch (DBException e) {
			throw new ServiceException("You don't have th amount in your account");
		}
		return amount;
	}
}
