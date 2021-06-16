package in.muthukumari.model;

import lombok.ToString;

@ToString
public class Customer {

	// Declare all the variables
	private String userName;
	private String firstName;
	private String lastName;
	private Long mobileNo;
	private String email;
	private String password;

	/**
	 * This method used to get the user name
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method used to set the user name
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method used to get the first name
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method used to set the first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method used to get the last name
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method used to set the last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method used to get the mobile number
	 * 
	 * @return
	 */
	public Long getMobileNo() {
		return mobileNo;
	}

	/**
	 * This method used to set the mobile number
	 * 
	 * @param mobileNo
	 */
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * This method used to get the email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method used to set the email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method used to get the password
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method used to set the password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}