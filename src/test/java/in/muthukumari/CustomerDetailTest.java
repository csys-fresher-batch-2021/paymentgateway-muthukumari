package in.muthukumari;

import static org.junit.Assert.*;

import org.junit.Test;

import in.muthukumari.validator.CustomerDetailValidator;

public class CustomerDetailTest {

	/**
	 * Valid user name
	 */
	@Test
	public void testcase1() {
		String name = "Mutu123";
		boolean isValid = CustomerDetailValidator.isValidUserName(name);
		assertTrue(isValid);
	}

	/**
	 * Invalid email
	 */
	@Test
	public void testcase2() {
		String email = "aaaa";
		boolean isValid = CustomerDetailValidator.isValidEmail(email);
		assertFalse(isValid);
	}
	
	/**
	 * Valid mail
	 */
	@Test
	public void testcase3() {
		String email = "muthu99p@gmail.com";
		boolean isValid = CustomerDetailValidator.isValidEmail(email);
		assertTrue(isValid);
	}

	/**
	 *Invalid name
	 */
	@Test
	public void testcase4() {
		String name = "123@m";
		boolean isValid = CustomerDetailValidator.isValidName(name);
		assertFalse(isValid);
	}
	
	/**
	 *Valid name
	 */
	@Test
	public void testcase5() {
		String name = "muthu";
		boolean isValid = CustomerDetailValidator.isValidName(name);
		assertTrue(isValid);
	}

}
