package in.muthukumari;

import in.muthukumari.service.BankDetailServer;

import in.muthukumari.validator.*;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestManagerForBankList {
	
	/**
	 * Test case for valid bank name
	 */
	@Test
	public void aTest() {

		String bankName = "   Indian bank   ";
		boolean bankNameValidation = CustomerDetailValidation.nameValidation(bankName);
		assertTrue(bankNameValidation);
		
	}

	/**
	 * Test case for Invalid bank name
	 */
	@Test
	public void bTest() {		
		String bankName = "";
		boolean bankNameValidation = CustomerDetailValidation.nameValidation(bankName);
		assertFalse(bankNameValidation);
	}

	/**
	 * Test case for add valid bank name
	 */
	@Test
	public void cTest() {		
		String bankName = "Indian Bank";
		boolean bankNameValidation = BankDetailServer.addBankList(bankName);
		assertTrue(bankNameValidation);
	}

	/*
	 * Test case for add Invalid bank name
	 */
	@Test
	public void dTest() {
		
		String bankName = null;
		boolean bankNameValidation = BankDetailServer.addBankList(bankName);
		assertFalse(bankNameValidation);
	}

	/*
	 * TestCase for get size of bank list
	 */
	@Test
	public void gTest() {
		Set<String> bankList = BankDetailServer.getBankList();
		assertEquals(3, bankList.size());

	}
	
	/*
	 * TestCase for display the bank list
	 */
	@Test
	public void hTest() {
			
		BankDetailServer.displayBankList();

	}
	
	/*
	 * Test case for add valid bank name
	 */
	
	@Test	
	public void eTest() {		
		boolean bankNameValidation = BankDetailServer.addBankList("Indian Overseas Bank");
		assertTrue(bankNameValidation);
	}
	/*
	 * Test case for add valid bank name 
	 * and already added bank name
	 */
	@Test
	public void fTest() {
		
		BankDetailServer.addBankList("Canara Bank");
		BankDetailServer.addBankList("Indian Overseas Bank");
	}

}
