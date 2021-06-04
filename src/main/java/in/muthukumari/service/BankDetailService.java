package in.muthukumari.service;

import java.sql.SQLException;
import java.util.Map;

import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.InvalidException;
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
}
