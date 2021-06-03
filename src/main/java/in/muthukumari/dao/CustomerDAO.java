package in.muthukumari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.util.ConnectionUtil;

public class CustomerDAO {
	static Connection connection = null;
	static PreparedStatement pst = null;

	public static void addUser(CustomerBankDetail customer) throws DBException {

		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO customerbankdetails(customername, bankname, branchname, ifsccode, account_no, balanceamount,atm_no,atmpin_no,mobile_no) VALUES(?,?,?,?,?,?,?,?,?)";
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
			ConnectionUtil.close(connection, pst);
		}
	}

	/**
	 * This method used to get customer bank details from database It will add
	 * customer bank details in a ArrayList and it will return that ArrayList
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<CustomerBankDetail> getCustomrBankDetails() throws DBException {

		ResultSet rs = null;
		List<CustomerBankDetail> customerBankDetails;
		try {
			customerBankDetails = new ArrayList<>();
			// To establish connection
			connection = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "SELECT * FROM customerbankdetails";

			// Execute query
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String name = rs.getString("customername");
				String bankName = rs.getString("bankname");
				String branchName = rs.getString("branchname");
				String ifscCode = rs.getString("ifsccode");
				long accountNumber = rs.getInt("account_no");
				Double balanceAmount = rs.getDouble("balanceamount");
				CustomerBankDetail customer = new CustomerBankDetail();
				customer.setUserName(name);
				customer.setBankName(bankName);
				customer.setBranchName(branchName);
				customer.setIfscCode(ifscCode);
				customer.setAccountNumber(accountNumber);
				customer.setBalanceAmount(balanceAmount);
				customerBankDetails.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Sorry! Unable to get User details");
		}

		finally {
			// Close the connection
			ConnectionUtil.close(rs, pst, connection);
		}
		return customerBankDetails;
	}
}
