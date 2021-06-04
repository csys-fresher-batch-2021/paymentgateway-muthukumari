package in.muthukumari.service;

import java.sql.SQLException;
import java.util.Map;

import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.InvalidException;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.validator.BankDetailValidator;

public class BankDetailService {

	private BankDetailService() {
		// Default Constructor
	}

	/**
	 * This method used toget the ifsc code
	 * 
	 * @param bankName
	 * @param branchName
	 * @return
	 * @throws DBException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InvalidException
	 */
	public static String getIfscCode(String bankName, String branchName)
			throws ClassNotFoundException, SQLException, InvalidException {

		String ifscCode;
		Map<String, String> branchAndIfscList = BankDAO.getBranchNameAndIfscList(bankName);

		if (branchAndIfscList.containsKey(branchName)) {

			ifscCode = branchAndIfscList.get(branchName); // get the ifsc code for the particular branch

		} else {

			throw new InvalidException("Invalid branch name");
		}
		return ifscCode;
	}

	/**
	 * This method used to check the account number is valid or not
	 * 
	 * @param customer
	 * @return
	 * @throws ServiceException
	 */
	public static boolean isValidAccountNumber(CustomerBankDetail customer) throws ServiceException {
		boolean isValidAccountNumber = false;
		try {
			isValidAccountNumber = BankDetailValidator.isValidAccountNumber(customer);
		} catch (ClassNotFoundException e) {
			throw new ServiceException("Invalid Account Number");
		}

		return isValidAccountNumber;
	}
}
