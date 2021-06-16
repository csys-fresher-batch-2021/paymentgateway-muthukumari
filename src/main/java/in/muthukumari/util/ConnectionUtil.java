package in.muthukumari.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	private ConnectionUtil() {
		// default constructor
	}

	private static final String DRIVER_CLASS_NAME = System.getenv("spring.datasource.driver-class-name");
	private static final String DB_URL = System.getenv("spring.datasource.url");
	private static final String DB_USERNAME = System.getenv("spring.datasource.username");
	private static final String DB_PASSWORD = System.getenv("spring.datasource.password");

	/**
	 * This method used to get the DB connection
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// Step 1: Load the jdbc driver in memory
		Class.forName(DRIVER_CLASS_NAME);
		// Step 2: Get the connection
		return (DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD));

	}

	/**
	 * This method used to close the connection(connection,prepared stmt,resultset)
	 * 
	 * @param result
	 * @param preparedStatement
	 * @param connection
	 */
	public static void close(ResultSet result, PreparedStatement preparedStatement, Connection connection) {

		try {
			if (result != null) {
				result.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to close the connection(connection,prepared stmt)
	 * 
	 * @param connection
	 * @param preparedStatement
	 */
	public static void close(PreparedStatement preparedStatement, Connection connection) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
