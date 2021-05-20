package in.muthukumari;

import static org.junit.Assert.*;

import org.junit.Test;

import in.muthukumari.validator.CustomerDetailValidation;

public class TestManagerForCustomerDetails {

	/**
	 * Invalid IFSC code
	 */
	@Test
	public void test1() {
		String ifscCode = "abc";
		String bankName = "Indian Bank";
		boolean isValid = CustomerDetailValidation.ifscValidation(ifscCode, bankName);
		assertFalse(isValid);
	}

	/**
	 * valid data
	 */

	@Test
	public void test2() {
		String ifscCode = "IDIB000T035";
		String bankName = "Indian Bank";
		boolean isValid = CustomerDetailValidation.ifscValidation(ifscCode, bankName);
		assertTrue(isValid);
	}

	/**
	 * Invalid bank name
	 */
	@Test
	public void test3() {
		String ifscCode = "IDIB000T035";
		String bankName = null;
		boolean isValid = CustomerDetailValidation.ifscValidation(ifscCode, bankName);
		assertFalse(isValid);
	}

	/**
	 * Invalid account number
	 */
	@Test
	public void test4() {
		long accountNumber = 123L;
		String bankName = "Indian Bank";
		boolean isValid = CustomerDetailValidation.accountNumberValidation(accountNumber, bankName);
		assertFalse(isValid);
	}

	/**
	 * valid account number
	 */
	@Test
	public void test5() {
		long accountNumber = 1237658076L;
		String bankName = "    Indian Bank";
		boolean isValid = CustomerDetailValidation.accountNumberValidation(accountNumber, bankName);
		assertTrue(isValid);
	}
	
	/**
	 * Test case for invalid mobile number
	 */
	@Test
	public void test6() {
		long mobileNumber = 21647L;
		boolean isValid = CustomerDetailValidation.numberValidation(mobileNumber);
		assertFalse(isValid);
	}
	
	/**
	 * Test case for valid mobile number
	 */
	@Test
	public void test8() {
		long mobileNumber = 8765678767L;
		boolean isValid = CustomerDetailValidation.numberValidation(mobileNumber);
		assertTrue(isValid);
	}
	/**
	 * Invalid password
	 * 
	 */
	@Test
	public void test9() {
		String password = "abc";
		boolean isValid = CustomerDetailValidation.passwordValidation(password);
		assertFalse(isValid);
	}
	
	/**
	 * Test case for valid password
	 */
	@Test
	public void test10() {
		String password = "123@a";
		boolean isValid = CustomerDetailValidation.passwordValidation(password);
		assertTrue(isValid);
	}

}
