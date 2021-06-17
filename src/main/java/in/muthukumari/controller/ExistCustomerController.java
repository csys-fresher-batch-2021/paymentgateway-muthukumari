package in.muthukumari.controller;

import java.util.List;
import java.util.logging.Logger;

import in.muthukumari.dao.ExistCustomerDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.model.CustomerBankDetail;

public class ExistCustomerController {
	final Logger logger = Logger.getLogger(this.getClass().getName());

	public ExistCustomerController() {
		//Default Constructor
	}

	/**
	 * This method used to get the customer name and account number list
	 * 
	 * @return
	 * @throws ServiceException 
	 */
	public List<CustomerBankDetail> getNameAndAccNumList() {
		List<CustomerBankDetail> nameAndAccNumList = null;
		try {
			nameAndAccNumList = ExistCustomerDAO.getNameAndAccNumList();
		} catch (DBException e) {
			logger.info(e.getMessage());
		}
		return nameAndAccNumList;
	}
}
