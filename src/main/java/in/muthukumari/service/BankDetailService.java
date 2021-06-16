package in.muthukumari.service;

import java.util.Map;
import java.util.Set;
import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.NumberInvalidException;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.validator.BankDetailValidator;

public class BankDetailService {

	private BankDetailService() {
		// Default Constructor
	}

	/**
	 * This method used to get the bank name list
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public static Set<String> getBankNameList() throws ServiceException {
		Set<String> banks;
		try {
			banks = BankDAO.getBankNameList();
		} catch (DBException e) {

			throw new ServiceException(e.getMessage());
		}

		return banks;
	}

	/**
	 * This method used to get the ifsc code
	 * 
	 * @param bankName
	 * @param branchName
	 * @return
	 * @throws ServiceException
	 */
	public static String getIfscCode(String bankName, String branchName) throws ServiceException {
		String ifscCode = null;
		Map<String, String> branchAndIfscList = null;
		try {
			branchAndIfscList = BankDAO.getBranchNameAndIfscList(bankName);
			if (branchAndIfscList.containsKey(branchName)) {
				ifscCode = branchAndIfscList.get(branchName); // get the ifsc code for the particular branch
			}
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
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
			isValidAccountNumber = BankDetailValidator.isValidAccountNumber(customer.getAccountNumber(),
					customer.getBankName());
		} catch (NumberInvalidException e) {
			throw new ServiceException("Invalid Account Number");
		}
		return isValidAccountNumber;
	}

	/**
	 * This method used to get the branch name list of each bank
	 * 
	 * @param bankName
	 * @return
	 * @throws ServiceException
	 */
	public static Set<String> getBranchNameList(String bankName) throws ServiceException {
		Set<String> branchNameList = null;
		Map<String, String> branchAndIfscList = null;
		try {
			branchAndIfscList = BankDAO.getBranchNameAndIfscList(bankName);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		branchNameList = branchAndIfscList.keySet(); // get branch name list only
		return branchNameList;
	}
}
