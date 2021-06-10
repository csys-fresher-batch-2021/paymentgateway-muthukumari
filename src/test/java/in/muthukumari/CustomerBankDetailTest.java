package in.muthukumari;

import static org.junit.Assert.*;
import org.junit.Test;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.InvalidException;
import in.muthukumari.exception.NumberInvalidException;
import in.muthukumari.model.CustomerBankDetail;
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
		assertFalse(isValidName);
	}

	/**
	 * Valid Account Number
	 * @throws NumberInvalidException 
	 */
	@Test
	public void testCase3() throws NumberInvalidException {
		customer.setBankName("Indian Bank");
		customer.setAccountNumber(99876456767876787L);
		boolean isValidAccountNum = BankDetailValidator.isValidAccountNumber(customer.getAccountNumber(),customer.getBankName());
		assertTrue(isValidAccountNum);
	}

	/**
	 * Invalid account number
	 * 
	 * @throws DBException
	 * @throws ClassNotFoundException
	 * @throws NumberInvalidException 
	 */
	@Test
	public void testCase4() throws NumberInvalidException {
		customer.setBankName("Indian Bank");
		customer.setAccountNumber(99876457876787L);
		boolean isValidAccountNum = BankDetailValidator.isValidAccountNumber(customer.getAccountNumber(),customer.getBankName());
		assertFalse(isValidAccountNum);
	}

	/**
	 * Valid bank name
	 * @throws InvalidException 
	 */
	@Test
	public void testcase5() throws InvalidException {
		customer.setBankName("Indian Bank");
		boolean isValidBank = BankDetailValidator.isValidBank(customer);
		assertTrue(isValidBank);
	}

	/**
	 * Invalid bank name
	 * @throws InvalidException 
	 */
	@Test
	public void testcase6() throws InvalidException  {
		customer.setBankName("United&Bank");
		boolean isValidBank = BankDetailValidator.isValidBank(customer);
		assertFalse(isValidBank);
	}

	/**
	 * Valid ATM card number
	 */
	@Test
	public void testcase7() {
		customer.setAtmNumber(8765365767898767L);
		boolean isValidAtmNum = BankDetailValidator.isValidAtmCardNumber(customer);
		assertTrue(isValidAtmNum);
	}

	/**
	 * Invalid ATM card number
	 */
	@Test
	public void testcase8() {
		customer.setAtmNumber(87653667898767L);
		boolean isValidAtmNum = BankDetailValidator.isValidAtmCardNumber(customer);
		assertFalse(isValidAtmNum);
	}

	/**
	 * Valid ATM pin number
	 */
	@Test
	public void testcase9() {
		customer.setAtmPinNumber(1234);
		boolean isValidPinNumber = BankDetailValidator.isValidAtmPinNumber(customer);
		assertTrue(isValidPinNumber);
	}

	/**
	 * Invalid ATM pin number
	 */
	@Test
	public void testcase10() {
		customer.setAtmPinNumber(12934);
		boolean isValidPinNumber = BankDetailValidator.isValidAtmPinNumber(customer);
		assertFalse(isValidPinNumber);
	}

	/**
	 * Valid mobile number
	 */
	@Test
	public void testcase11() {
		customer.setMobileNumber(6888888888L);		
		boolean isValidMobileNumber = BankDetailValidator.isValidMobileNumber(customer.getMobileNumber());
		assertTrue(isValidMobileNumber);
	}

	/**
	 * Invalid mobile number
	 */
	@Test
	public void testcase12() {
		customer.setMobileNumber(900000000000L);		
		boolean isValidMobileNumber = BankDetailValidator.isValidMobileNumber(customer.getMobileNumber());
		assertFalse(isValidMobileNumber);
	}

	/**
	 * Valid ifsc code
	 * @throws InvalidException 
	 */
	@Test
	public void testcase13() throws InvalidException {
		customer.setBankName("Indian Bank");
		customer.setIfscCode("IDIB000T035");
		customer.setBranchName("Tirunelveli Town");
		boolean isValidIfscCode = BankDetailValidator.isValidIfscCode(customer);
		assertTrue(isValidIfscCode);
	}

	/**
	 * Invalid ifsc code
	 * @throws InvalidException 
	 */
	@Test
	public void testcase14() throws InvalidException{
		customer.setBankName("Indian Bank");
		customer.setIfscCode("IDIB000T034");
		customer.setBranchName("Tirunelveli Town");
		boolean isValidIfscCode = BankDetailValidator.isValidIfscCode(customer);
		assertFalse(isValidIfscCode);
	}

	/**
	 * Valid ifsc code
	 * @throws InvalidException 
	 */
	@Test
	public void testcase15() throws InvalidException {
		customer.setBankName("Indian Bank");
		customer.setBranchName("Tirunelveli Town");
		boolean isValidBranchName = BankDetailValidator.isValidBranchName(customer);
		assertTrue(isValidBranchName);
	}

	/**
	 * Invalid ifsc code
	 * @throws InvalidException 
	 */
	@Test
	public void testcase16() throws InvalidException {
		customer.setBankName("Indian Bank");
		customer.setBranchName("Tirunelveli1");
		boolean isValidBranchName = BankDetailValidator.isValidBranchName(customer);
		assertFalse(isValidBranchName);
	}
}
