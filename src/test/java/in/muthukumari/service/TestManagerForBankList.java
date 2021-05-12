package in.muthukumari.service;

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
	OperationsOnBankList add = new OperationsOnBankList();

	/**
	 * Test case for valid bank name
	 */
	@Before
	public void TestCase1() {
		String bankName = "   Indian bank   ";
		boolean bankNameValidation = Validation.nameValidation(bankName);
		assertTrue(bankNameValidation);
	}

	/**
	 * Test case for Invalid bank name
	 */
	@Before
	public void TestCase2() {
		String bankName = "";
		boolean bankNameValidation = Validation.nameValidation(bankName);
		assertFalse(bankNameValidation);
	}

	/*
	 * Test case for add valid bank name
	 */
	@Test
	public void TestCase3() {
		String bankName = "Indian Bank";
		boolean bankNameValidation = add.addBankList(bankName);
		assertTrue(bankNameValidation);
	}

	/*
	 * Test case for add Invalid bank name
	 */
	@After
	public void TestCase4() {
		String bankName = null;
		boolean bankNameValidation = add.addBankList(bankName);
		assertFalse(bankNameValidation);
	}

	/*
	 * TestCase for get size of bank list
	 */
	@After
	public void TestCase5() {
		Set<String> bankList = OperationsOnBankList.getBankList();
		assertEquals(3, bankList.size());

	}
	
	/*
	 * TestCase for display the bank list
	 */
	@After
	public void TestCase6() {
		OperationsOnBankList.displayBankList();

	}
	
	/*
	 * Test case for add valid bank name
	 */
	@Before
	public void TestCase7() {
		boolean bankNameValidation = add.addBankList("Indian Overseas Bank");
		assertTrue(bankNameValidation);
	}
	/*
	 * Test case for add valid bank name 
	 * and already added bank name
	 */
	@Before
	public void TestCase8() {
		add.addBankList("Canara Bank");
		add.addBankList("Indian Overseas Bank");
	}

}
