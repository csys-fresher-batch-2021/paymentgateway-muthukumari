package in.muthukumari.model;

public class CustomerBankDetail {

	// Declare variables for storing customer bank details
	private String userName;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private long accountNumber;
	private long atmNumber;
	private int atmPinNumber;
	private long mobileNumber;
	private double balanceAmount;

	/**
	 * This method used to get the user name
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method used to set the username
	 * 
	 * @param username
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method used to get the bank name
	 * 
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * This method used to set the bank name
	 * 
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * This method used to get the branch name
	 * 
	 * @return
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * This method used to set the branch name
	 * 
	 * @param branchName
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * This method used to get the ifsc code
	 * 
	 * @return
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * This method used to set the ifsc code
	 * 
	 * @param ifscCode
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * This method used to get the account number
	 * 
	 * @return
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * This method used to set the account number
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * This method used to get the balance amount
	 * 
	 * @return
	 */
	public double getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * This method used to set the balance amount
	 * 
	 * @param balanceAmount
	 */
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * This method used to get Atm number
	 * 
	 * @return
	 */
	public long getAtmNumber() {
		return atmNumber;
	}

	/**
	 * This method used to set atm number
	 * 
	 * @param atmNumber
	 */
	public void setAtmNumber(long atmNumber) {
		this.atmNumber = atmNumber;
	}

	/**
	 * This method used to get atm pin number
	 * 
	 * @return
	 */
	public int getAtmPinNumber() {
		return atmPinNumber;
	}

	/**
	 * This method used to set the atm pin number
	 * 
	 * @param atmPinNumber
	 */
	public void setAtmPinNumber(int atmPinNumber) {
		this.atmPinNumber = atmPinNumber;
	}

	/**
	 * This method used to get the mobile number
	 * 
	 * @return
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * This method used to set the mobile number
	 * 
	 * @param mobileNumber
	 */
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "CustomerBankDetail [userName=" + userName + ", bankName=" + bankName + ", branchName=" + branchName
				+ ", ifscCode=" + ifscCode + ", accountNumber=" + accountNumber + ", atmNumber=" + atmNumber
				+ ", atmPinNumber=" + atmPinNumber + ", mobileNumber=" + mobileNumber + ", balanceAmount="
				+ balanceAmount + "]";
	}

}
