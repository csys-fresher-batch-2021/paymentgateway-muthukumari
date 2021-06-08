package in.muthukumari.service;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

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
	public static String getIfscCode(String bankName, String branchName) throws ServiceException {
		String ifscCode = null;
		Map<String, String> branchAndIfscList;
		try {
			branchAndIfscList = BankDAO.getBranchNameAndIfscList(bankName);
			if (branchAndIfscList.containsKey(branchName)) {
				ifscCode = branchAndIfscList.get(branchName); // get the ifsc code for the particular branch
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new ServiceException("Invalid branch name");
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
	
	/**
	 * This method used to get the branch name list of each bank
	 * @param bankName
	 * @return
	 * @throws ServiceException 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Set<String> getBranchNameList(String bankName) throws ServiceException{
		Set<String> branchNameList = null;
		Map<String, String> branchAndIfscList = null;
		try {
			branchAndIfscList = BankDAO.getBranchNameAndIfscList(bankName);
			branchNameList = branchAndIfscList.keySet(); //get branch name list only
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServiceException("Unable to get branch name list");
		}		
		return branchNameList;
	}
}
