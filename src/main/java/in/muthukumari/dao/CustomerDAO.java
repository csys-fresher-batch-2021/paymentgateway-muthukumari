package in.muthukumari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.Customer;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.util.ConnectionUtil;

public class CustomerDAO {

	private CustomerDAO() {
		// Default constructor
	}

	/**
	 * This method used to add the customer bank details to the DB
	 * 
	 * @param customer
	 * @throws DBException
	 */
	public static void addCustomerBankDetail(CustomerBankDetail customer) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO customerbankdetails(customername, bankname, branchname, ifsccode, account_no, balanceamount, atm_no, atmpin_no, mobile_no) VALUES(?,?,?,?,?,?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);
			pst.setString(1, customer.getUserName());
			pst.setString(2, customer.getBankName());
			pst.setString(3, customer.getBranchName());
			pst.setString(4, customer.getIfscCode());
			pst.setLong(5, customer.getAccountNumber());
			pst.setDouble(6, customer.getBalanceAmount());
			pst.setLong(7, customer.getAtmNumber());
			pst.setInt(8, customer.getAtmPinNumber());
			pst.setLong(9, customer.getMobileNumber());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Sorry! Something went wrong, Unable to add customer bank details");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method used to add the customer detail in DB
	 * 
	 * @param customer
	 * @throws DBException
	 */
	public static void addCustomerDetail(Customer customer) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO customerdetails(mobile_no,first_name,last_name,email,username,password) VALUES(?,?,?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);
			pst.setLong(1, customer.getMobileNo());
			pst.setString(2, customer.getFirstName());
			pst.setString(3, customer.getLastName());
			pst.setString(4, customer.getEmail());
			pst.setString(5, customer.getUserName());
			pst.setString(6, customer.getPassword());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Sorry! Something went wrong, Unable to add customer details");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}
}