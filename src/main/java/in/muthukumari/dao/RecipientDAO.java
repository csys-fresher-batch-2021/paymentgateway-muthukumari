package in.muthukumari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.Recipient;
import in.muthukumari.util.ConnectionUtil;

public class RecipientDAO {

	private RecipientDAO() {
		// Default Construtor
	}

	/**
	 * This method used to add the recipient bank details to the DB
	 * 
	 * @param recipient
	 * @throws DBException
	 */
	public static void addRecipientDetail(Recipient recipient) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO recipientdetails(recipient_bankname,recipient_accnum, balance_amount, sender_accnum) VALUES(?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);
			pst.setString(1, recipient.getReceiverbank());
			pst.setLong(2, recipient.getReceiverAccNum());
			pst.setDouble(3, recipient.getTransferAmount());
			pst.setLong(4, recipient.getSenderAccNum());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Sorry! Something went wrong, Unable to add recipient details");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
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
			String sql = "select * from recipientdetails where recipient_accnum=?";
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
	 * This method used to get the balance amount for the recipient account number
	 * 
	 * @param accNum
	 * @return
	 * @throws DBException
	 */
	public static double getBalanceAmount(long accNum) throws DBException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql;
		double amount = 0;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select balance_amount from recipientdetails where recipient_accnum=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, accNum);
			rs = pst.executeQuery();
			if (rs.next()) {
				amount = rs.getDouble("balance_amount");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the balance amount");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return amount;
	}
}
