package databaseConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
	public static Connection connection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres",
				"postgres");

	}

	public static void closeConnection() throws SQLException {

		JDBConnection.connection().close();

	}
}
