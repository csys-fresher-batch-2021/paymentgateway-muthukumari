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

public class ExistCustomerDAO {

	private ExistCustomerDAO() {
		// Default Constructor
	}

	static String sql;

	/**
	 * This method used to get the mobile number of the particular user name
	 * 
	 * @param userName
	 * @return
	 * @throws DBException
	 */
	public static long getMobileNumber(String userName) throws DBException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		long mobileNum = 0;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select mobile_no from customerdetails where username=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if (rs.next()) {
				mobileNum = rs.getLong("mobile_no");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the mobile number");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return mobileNum;
	}

	/**
	 * Return list of account number connected with the particular number
	 * 
	 * @param mobileNum
	 * @return
	 * @throws DBException
	 */
	public static List<Long> getAccountNumber(long mobileNum) throws DBException {
		List<Long> accNumList = new ArrayList<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql;
		long accNum;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select account_no from customerbankdetails where mobile_no=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, mobileNum);
			rs = pst.executeQuery();
			while (rs.next()) {
				accNum = rs.getLong("account_no");
				accNumList.add(accNum); // add the account number list to the List
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the account number");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return accNumList;
	}

	/**
	 * This method used to get the balance amount for the particular account number
	 * 
	 * @param accNum
	 * @return
	 * @throws DBException
	 */
	public static double getAmount(long accNum) throws DBException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql;
		double amount = 0;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select balanceamount from customerbankdetails where account_no=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, accNum);
			rs = pst.executeQuery();
			if (rs.next()) {
				amount = rs.getDouble("balanceamount");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the balance amount");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return amount;
	}

	/**
	 * This method used to update the sender balance amount
	 * 
	 * @param senderAccNum
	 * @param balanceAmount
	 * @return
	 * @throws DBException
	 */
	public static boolean updateBalanceAmount(long senderAccNum, double balanceAmount) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		String sql;
		int rs;
		boolean isUpdated = false;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "update customerbankdetails set balanceamount=? where account_no=?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, balanceAmount);
			pst.setLong(2, senderAccNum);
			rs = pst.executeUpdate();
			if (rs == 1) {
				isUpdated = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to update the balance amount");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return isUpdated;

	}

	/**
	 * This method used to update the sender balance amount
	 * 
	 * @param senderAccNum
	 * @param balanceAmount
	 * @return
	 * @throws DBException
	 */
	public static boolean updateRecipientBalanceAmount(long recipientAccNum, double balanceAmount) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		String sql;
		int rs;
		boolean isUpdated = false;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "update recipientdetails set balance_amount=? where recipient_accnum=?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, balanceAmount);
			pst.setLong(2, recipientAccNum);
			rs = pst.executeUpdate();
			if (rs == 1) {
				isUpdated = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to update the balance amount");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return isUpdated;
	}

	/**
	 * This method used to get the customer name and account number list
	 * @return
	 * @throws DBException
	 */
	public static List<CustomerBankDetail> getNameAndAccNumList() throws DBException {		
		List<CustomerBankDetail> nameAndAccNumList=new ArrayList<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select customername,account_no from customerbankdetails";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String	name = rs.getString("customername");				
				long accNum=rs.getLong("account_no");
				nameAndAccNumList.add(new CustomerBankDetail(name,accNum));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get user details");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return nameAndAccNumList;
	}
}
