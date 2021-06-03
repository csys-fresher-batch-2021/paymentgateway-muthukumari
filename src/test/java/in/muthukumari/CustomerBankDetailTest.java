package in.muthukumari;

import static org.junit.Assert.*;
import org.junit.Test;

import in.muthukumari.exception.CustomerRepeatedException;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.service.CustomerBankDetailService;
import in.muthukumari.validator.BankDetailValidator;
import in.muthukumari.validator.CustomerDetailValidator;

public class CustomerBankDetailTest {
	CustomerBankDetail customer = new CustomerBankDetail();

	/**
	 * Test case for valid name
	 */
	@Test
	public void testCase1() {
		customer.setUserName("Muthu");
		boolean isValidName = CustomerDetailValidator.isValidName(customer.getUserName());
		assertTrue(isValidName);
	}

	/**
	 * Test case for invalid name
	 */
	@Test
	public void testCase2() {
		customer.setUserName("$56*&9");
		boolean isValidName = CustomerDetailValidator.isValidName(customer.getUserName());
		assertTrue(isValidName);
	}
	/**
	 * Valid Account Number
	 * @throws DBException
	 */
	@Test
	public void testCase3() throws DBException {
		customer.setBankName("Indian Bank");
		customer.setAccountNumber(99876456767876787L);
		boolean isValidBank=BankDetailValidator.isValidAccountNumber(customer);
		assertTrue(isValidBank);
	}
	/**
	 * Invalid account number
	 * @throws DBException
	 */
	@Test
	public void testCase4() throws DBException {
		customer.setBankName("Indian Bank");
		customer.setAccountNumber(99876457876787L);
		boolean isValidBank=BankDetailValidator.isValidAccountNumber(customer);
		assertFalse(isValidBank);
	}
	
}
