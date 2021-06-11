package in.muthukumari.service;

import java.util.ArrayList;
import java.util.List;

import in.muthukumari.dao.CustomerDAO;
import in.muthukumari.dao.ExistDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.exception.ValidatorException;
import in.muthukumari.model.Customer;
import in.muthukumari.validator.BankDetailValidator;
import in.muthukumari.validator.CustomerDetailValidator;
import in.muthukumari.validator.CustomerRepeatedValidator;

public class CustomerService {

	private CustomerService() {
		// Default Constructor
	}

	/**
	 * This method used to add the customer registration details to the DB after the
	 * validation pass
	 * 
	 * @param customer
	 * @return
	 * @throws ServiceException
	 */
	public static boolean addCustomer(Customer customer) throws ServiceException {
		List<Boolean> errorList = new ArrayList<>();
		boolean isAdded = true;
		boolean isValidFirstName = CustomerDetailValidator.isValidName(customer.getFirstName());
		errorList.add(isValidFirstName);
		boolean isValidLastName = CustomerDetailValidator.isValidName(customer.getLastName());
		errorList.add(isValidLastName);
		boolean isValidMobileNo = BankDetailValidator.isValidMobileNumber(customer.getMobileNo());
		errorList.add(isValidMobileNo);
		boolean isValidEmail = CustomerDetailValidator.isValidEmail(customer.getEmail());
		errorList.add(isValidEmail);
		boolean isValidUserName = CustomerDetailValidator.isValidUserName(customer.getUserName());
		errorList.add(isValidUserName);
		boolean isRepeatedUserName = false;
		boolean isRepeatedEmail = false;
		try {
			isRepeatedUserName = CustomerRepeatedValidator.isRepeatedUserName(customer.getUserName());
			isRepeatedEmail = CustomerRepeatedValidator.isRepeatedEmail(customer.getEmail());
		} catch (ValidatorException e1) {
			throw new ServiceException("The user name is already given");
		}
		errorList.add(isRepeatedUserName);
		errorList.add(isRepeatedEmail);
		boolean isValidPassword = CustomerDetailValidator.isValidPassword(customer.getPassword());
		errorList.add(isValidPassword);
		if (errorList.contains(false)) {
			isAdded = false;
		} else {
			try {
				CustomerDAO.addCustomerDetail(customer);
			} catch (DBException e) {
				throw new ServiceException("Unable to add the customer detail");
			}
		}
		return isAdded;
	}

	/**
	 * This method used to verify the login details
	 * 
	 * @param customer
	 * @return
	 * @throws ServiceException
	 */
	public static boolean loginUser(Customer customer) throws ServiceException {
		boolean isVerified = false;		
		try {
			isVerified = ExistDAO.isLoginVerified(customer.getUserName(), customer.getPassword());
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}		
		return isVerified;
	}
}
