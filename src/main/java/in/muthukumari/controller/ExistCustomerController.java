package in.muthukumari.controller;

import java.util.List;
import in.muthukumari.dao.ExistCustomerDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;

public class ExistCustomerController {

	private ExistCustomerController() {
		// Default Constructor
	}

	/**
	 * This mthod used to get the customer name and account number list
	 * 
	 * @return
	 */
	public static List<CustomerBankDetail> getNameAndAccNumList() {
		List<CustomerBankDetail> nameAndAccNumList = null;
		try {
			nameAndAccNumList = ExistCustomerDAO.getNameAndAccNumList();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return nameAndAccNumList;
	}
}
