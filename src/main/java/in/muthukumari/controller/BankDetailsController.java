package in.muthukumari.controller;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.InvalidException;

public class BankDetailsController {
	
	private BankDetailsController() {
		//Default constructor
	}
	
	/**
	 * This method used to get the branch name list of each bank
	 * @param bankName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Set<String> getBranchNameList(String bankName) throws ClassNotFoundException, SQLException {
		Set<String> branchNameList = null;
		Map<String, String> branchAndIfscList = null;
		branchAndIfscList = BankDAO.getBranchNameAndIfscList(bankName);
		branchNameList = branchAndIfscList.keySet(); //get branch name list only
		return branchNameList;
	}

	/**
	 * This method used to get the ifsc code list for the particular branch
	 * @param bankName
	 * @param branchName
	 * @return
	 * @throws InvalidException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String getIfscCode(String bankName, String branchName)
			throws InvalidException, ClassNotFoundException, SQLException {

		String ifscCode = null;

		Map<String, String> branchAndIfscList = BankDAO.getBranchNameAndIfscList(bankName);

		if (branchAndIfscList.containsKey(branchName)) {

			ifscCode = branchAndIfscList.get(branchName); //get the ifsc code for the particular branch

		} else {

			throw new InvalidException("Invalid branch name");
		}
		return ifscCode;
	}

}
