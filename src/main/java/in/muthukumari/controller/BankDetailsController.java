package in.muthukumari.controller;

import java.util.Set;
import java.util.logging.Logger;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.service.BankDetailService;

public class BankDetailsController {
	
	final Logger logger =  Logger.getLogger(this.getClass().getName());
	
	/**
	 * This method used to get the branch name list of each bank
	 * @param bankName
	 * @return
	 */
	public Set<String> getBranchNameList(String bankName) {		
		Set<String> branchNameList = null;
		try {
			branchNameList = BankDetailService.getBranchNameList(bankName);
		} catch (ServiceException e) {
			logger.info(e.getMessage());
		}
		return branchNameList;
	}

	/**
	 * This method used to get the ifsc code list for the particular branch
	 * @param bankName
	 * @param branchName
	 * @return
	 */
	public String getIfscCode(String bankName, String branchName)
			 {
		String ifscCode = null;
		try {
			ifscCode = BankDetailService.getIfscCode(bankName, branchName);
		} catch (ServiceException e) {
			
			logger.info(e.getMessage());
		}
		return ifscCode;
	}

}
