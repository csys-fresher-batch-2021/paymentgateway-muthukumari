package in.muthukumari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import in.muthukumari.exception.DBException;
import in.muthukumari.util.ConnectionUtil;

public class BankRulesDAO {

	private BankRulesDAO() {
		// Default Constructor
	}

	/**
	 * This method used to get the account number length of the bank
	 * 
	 * @return
	 * @throws DBException
	 */
	public static Map<String, Integer> getAccountNumberLength() throws DBException {
		String sql;
		Map<String, Integer> bankNameList = new HashMap<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String bankName;
		int accountNoLength;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select * from banknamelist where bankname!=''";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			// Step 4: Iterate the result
			while (rs.next()) {
				bankName = rs.getString("bankname");
				accountNoLength = rs.getInt("accountno_length");
				bankNameList.put(bankName, accountNoLength); // add the bank name list and account number length
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to display bank name list and Account Number length");
		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(rs, pst, con);
		}
		return bankNameList;

	}

}
