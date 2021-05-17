package in.muthukumari;

import in.muthukumari.service.BankDetailServer;
import in.muthukumari.validator.*;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.After;

import org.junit.Before;

public class TestManagerForBankList {
	
	/**
	 * Test case for valid bank name
	 */
	@After
	public void TestCase1() {
		System.out.println("testcase1");
		String bankName = "   Indian bank   ";
		boolean bankNameValidation = Validation.nameValidation(bankName);
		assertTrue(bankNameValidation);
	}

	/**
	 * Test case for Invalid bank name
	 */
	@After
	public void TestCase2() {
		System.out.println("testcase2");

		String bankName = "";
		boolean bankNameValidation = Validation.nameValidation(bankName);
		assertFalse(bankNameValidation);
	}

	/*
	 * Test case for add valid bank name
	 */
	@After
	public void TestCase3() {
		System.out.println("testcase3");
		String bankName = "Indian Bank";
		boolean bankNameValidation = BankDetailServer.addBankList(bankName);
		assertTrue(bankNameValidation);
	}

	/*
	 * Test case for add Invalid bank name
	 */
	@Test
	public void TestCase4() {
		System.out.println("testcase4");

		String bankName = null;
		boolean bankNameValidation = BankDetailServer.addBankList(bankName);
		assertFalse(bankNameValidation);
	}

	/*
	 * TestCase for get size of bank list
	 */
	@After
	public void TestCase5() {
		System.out.println("testcase5");

		Set<String> bankList = BankDetailServer.getBankList();
		assertEquals(3, bankList.size());

	}
	
	/*
	 * TestCase for display the bank list
	 */
	@After
	public void TestCase6() {
		System.out.println("testcase6");

		BankDetailServer.displayBankList();

	}
	
	/*
	 * Test case for add valid bank name
	 */
	@Before
	public void TestCase7() {
		System.out.println("testcase7");
		boolean bankNameValidation = BankDetailServer.addBankList("Indian Overseas Bank");
		assertFalse(bankNameValidation);
	}
	/*
	 * Test case for add valid bank name 
	 * and already added bank name
	 */
	@Before
	public void TestCase8() {
		System.out.println("testcase8");
		BankDetailServer.addBankList("Canara Bank");
		BankDetailServer.addBankList("Indian Overseas Bank");
	}

}
