package template;

import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcDatabaseWriter {

	
	void insertQuery(Connection connection) throws SQLException;
}
