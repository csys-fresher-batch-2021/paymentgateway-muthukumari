package in.muthukumari.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import in.muthukumari.exception.DBException;
import in.muthukumari.util.ConnectionUtil;

public class BankDAO {

	private BankDAO() {
		// Default constructor
	}

	static String sql;

	/**
	 * This method used to get the bank name list
	 * 
	 * @return
	 * @throws DBException
	 */
	public static Set<String> getBankNameList() throws DBException {
		Set<String> bankNameList = new HashSet<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		String bankName;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select bankname from banknamelist where bankname!=''";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			// Step 4: Iterate the result
			while (rs.next()) {
				bankName = rs.getString("bankname");
				bankNameList.add(bankName); // add the bank name list to the Set
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to display bank name list");
		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(rs, pst, con);
		}
		return bankNameList;
	}

	/**
	 * This method used to get the branch and ifsc code list
	 * 
	 * @param bankName
	 * @return
	 * @throws DBException
	 */
	public static Map<String, String> getBranchNameAndIfscList(String bankName) throws DBException {
		Map<String, String> branchAndIfscCodeList = new HashMap<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			// Step 1: Get Connection
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			sql = "select branchname,IFSCcode from branchandifsclist where bankname=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, bankName);
			rs = pst.executeQuery();
			// Step 4: Iterate the result
			while (rs.next()) {
				String branchName = rs.getString("branchname");
				String ifscCode = rs.getString("IFSCcode");
				branchAndIfscCodeList.put(branchName, ifscCode);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to get the data from DB");

		} finally {
			// Step 5: Release the connection
			ConnectionUtil.close(pst, con);
		}
		return branchAndIfscCodeList;
	}
}
