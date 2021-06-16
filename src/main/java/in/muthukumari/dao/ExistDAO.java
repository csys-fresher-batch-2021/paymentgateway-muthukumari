package in.muthukumari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.muthukumari.exception.DBException;
import in.muthukumari.util.ConnectionUtil;

public class ExistDAO {

	private ExistDAO() {
		// Default Constructor
	}

	/**
	 * This method used to check if the usename is exists or not
	 * 
	 * @param userName
	 * @return
	 * @throws DBException
	 */
	public static boolean isExistUserName(String userName) throws DBException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql;
		boolean isNotExists = true;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select username from customerdetails where exists (select *from customerdetails where customerdetails.username=?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if (rs.next()) {
				isNotExists = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the username from DB");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return isNotExists;
	}

	/**
	 * This method used to check if the usename and password is exists or not
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DBException
	 */
	public static boolean isLoginVerified(String userName, String password) throws DBException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql;
		boolean isValid = false;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select username from customerdetails where username=? and password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				isValid = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the username and password from DB");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return isValid;
	}

	/**
	 * This method used to check if the email is exists or not
	 * 
	 * @param email
	 * @return
	 * @throws DBException
	 */
	public static boolean isExistEmail(String email) throws DBException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql;
		boolean isNotExists = false;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select email from customerdetails where exists (select *from customerdetails where customerdetails.email=?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next()) {
				isNotExists = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the email from DB");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return isNotExists;
	}

	/**
	 * This method used to check if the account number is exists or not
	 * 
	 * @return
	 * @throws DBException
	 */
	public static boolean isRepeatedAccountNumber(long accountNum) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean isRepeated = false;
		try {
			// To establish connection
			connection = ConnectionUtil.getConnection();
			// SQl commands
			String sql = "select * from customerbankdetails where account_no=?";
			// Execute query
			pst = connection.prepareStatement(sql);
			pst.setLong(1, accountNum);
			rs = pst.executeQuery();

			if (rs.next()) {
				isRepeated = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Sorry! Unable to get Account number");
		}

		finally {
			// Close the connection
			ConnectionUtil.close(rs, pst, connection);
		}
		return isRepeated;
	}

	/**
	 * This method used to chck if the atm number is exists or not
	 * 
	 * @return
	 * @throws DBException
	 */
	public static boolean isRepeatedAtmNumber(long atmNum) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean isRepeated = false;
		try {
			// To establish connection
			connection = ConnectionUtil.getConnection();
			// SQl commands
			String sql = "select * from customerbankdetails where atm_no=?";
			// Execute query
			pst = connection.prepareStatement(sql);
			pst.setLong(1, atmNum);
			rs = pst.executeQuery();

			if (rs.next()) {
				isRepeated = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Sorry! Unable to get Atm number");
		}

		finally {
			// Close the connection
			ConnectionUtil.close(rs, pst, connection);
		}
		return isRepeated;
	}

}
