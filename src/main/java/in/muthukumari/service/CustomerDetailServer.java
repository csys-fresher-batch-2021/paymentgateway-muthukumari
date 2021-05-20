package in.muthukumari.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.model.CustomerDetail;
import in.muthukumari.validator.CustomerDetailValidation;

public class CustomerDetailServer {

	public CustomerDetailServer() {
		ifsc.put("IndianBank","IB");
		ifsc.put("IndianOverseasBank","IOB");
		ifsc.put("CanaraBank","CB");
		// Default Constructor
	}

	List<CustomerDetail> customerList = new ArrayList<>();
	static Map<String, String> ifsc = new HashMap<>();
	static Map<String, Long> accountNumber = new HashMap<>();

	public static boolean addCustomerDetail(CustomerDetail customer, CustomerBankDetail bank) {
		boolean isValid = false;
		boolean validName = CustomerDetailValidation.nameValidation(CustomerDetail.customerName);
		boolean validNumber = CustomerDetailValidation.numberValidation(CustomerDetail.mobileNumber);
		boolean validPassword = CustomerDetailValidation.passwordValidation(CustomerDetail.password);
		boolean validBankName = CustomerDetailValidation.nameValidation(CustomerBankDetail.bankName);
		boolean validIfscCode = CustomerDetailValidation.ifscValidation(CustomerBankDetail.ifscCode, CustomerBankDetail.bankName);
		boolean validAccountNumber = CustomerDetailValidation.accountNumberValidation(CustomerBankDetail.accountNumber,
				CustomerBankDetail.bankName);
		// Check all the details are valid
		List<CustomerDetail> customerList = new ArrayList<>();
		if (validName) {
			System.out.println("Valid Name");
			if (validNumber) {
				System.out.println("Valid Mobile Number");
				if (validPassword) {
					System.out.println("Valid Password");
					customerList.add(customer);
					if (validIfscCode) {
						System.out.println("Valid Ifsc code");
						if (validBankName) {
							System.out.println("Valid Bank name");
							ifsc.put(CustomerBankDetail.bankName, CustomerBankDetail.ifscCode);
							if (validAccountNumber) {
								System.out.println("Valid Account Number");
								accountNumber.put(CustomerBankDetail.bankName, CustomerBankDetail.accountNumber);
								isValid = true;
							}
						}

					}
				}
			}
		}
		return isValid;
	}

	// This method returns the customer detail
	public List<CustomerDetail> getCustomerDetail() {
		return customerList;
	}

	// This method returns the ifsc code with bank name
	public Map<String, String> getIfscCode() {
		return ifsc;
	}

	// This method returns the account number with bank name
	public Map<String, Long> getAccountNumber() {
		return accountNumber;
	}

}
