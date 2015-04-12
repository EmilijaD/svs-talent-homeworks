package template;

import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcDatabaseReader {
	<E> E returnQuery(Connection connection) throws SQLException;
}
