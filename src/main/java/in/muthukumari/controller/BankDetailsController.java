package in.muthukumari.controller;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import in.muthukumari.dao.BankDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.InvalidException;
import in.muthukumari.service.BankDetailService;

public class BankDetailsController {
	
	final Logger logger =  Logger.getLogger(this.getClass().getName());
	
	public BankDetailsController() {
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
	 * @throws DBException 
	 */
	public String getIfscCode(String bankName, String branchName)
			throws InvalidException {
		
		String ifscCode = null;
		try {
			ifscCode = BankDetailService.getIfscCode(bankName, branchName);
		} catch (ClassNotFoundException | SQLException e) {
			
			logger.info(e.getMessage());
		}
		return ifscCode;
	}

}
