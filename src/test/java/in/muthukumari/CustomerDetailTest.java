package in.muthukumari;

import static org.junit.Assert.*;

import org.junit.Test;

import in.muthukumari.validator.CustomerDetailValidator;

public class CustomerDetailTest {

	@Test
	public void test() {
		String name="Mutu123";
		boolean isValid=CustomerDetailValidator.isValidUserName(name);
		assertTrue(isValid);
	}

}
