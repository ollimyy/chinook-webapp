package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");
	
	public Connection connect() throws SQLException {
			return DriverManager.getConnection(JDBC_URL);
	}
	    
	public void closeAll(Connection connection, PreparedStatement statement, ResultSet result) {
		if (connection != null) {
	         try {
	            connection.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }

	   if (statement != null) {
	         try {
	            statement.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }

	   if (result != null) {
	         try {
	            result.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }
	}
}