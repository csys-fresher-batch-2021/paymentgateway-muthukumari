package in.muthukumari.service;

import java.sql.SQLException;

import in.muthukumari.dao.CustomerDAO;
import in.muthukumari.exception.CustomerRepeatedException;
import in.muthukumari.exception.DBException;
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
	 * @throws DBException
	 * @throws CustomerRepeatedException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static boolean addCustomerDetail(CustomerBankDetail customer) throws  CustomerRepeatedException {
		boolean isAdded = false;
		try {
			if (CustomerDetailValidator.isValidCustomer(customer)) {
				CustomerDAO.addUser(customer);
				isAdded = true;
			} 
		} catch (ClassNotFoundException | DBException | SQLException e) {
			
			e.printStackTrace();
		}

		return isAdded;
	}

}
