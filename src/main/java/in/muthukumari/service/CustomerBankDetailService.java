package in.muthukumari.service;

import in.muthukumari.dao.CustomerDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.InvalidException;
import in.muthukumari.exception.NumberInvalidException;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.exception.ValidatorException;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.validator.CustomerDetailValidator;

public class CustomerBankDetailService {

	private CustomerBankDetailService() {
		// Default Constructor
	}
	/**
	 * This method used to add the customer details
	 * @param customer
	 * @return
	 * @throws ServiceException 
	 */
	public static boolean addCustomerDetail(CustomerBankDetail customer) throws ServiceException {
		boolean isAdded = false;
		try {
			if (CustomerDetailValidator.isValidCustomer(customer)) {
				CustomerDAO.addCustomerBankDetail(customer);
				isAdded = true;
			} 
		} catch (InvalidException | ValidatorException | NumberInvalidException | DBException e) {
			
			throw new ServiceException("Unable to add customer");
		}
		return isAdded;
	}

}
