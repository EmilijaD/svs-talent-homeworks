package template;

import java.sql.Connection;
import java.sql.SQLException;

import databaseConnections.JDBConnection;

public class JDBCTemplate {

	public <E> E returnQuery(JdbcDatabaseReader jdbcReader) {
		E object = null;
		try{
		Connection connection = JDBConnection.connection();
		object = jdbcReader.returnQuery(connection);
		JDBConnection.closeConnection();
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return object;

	}
	
	public void insertQuery (JdbcDatabaseWriter jdbcWriter)
	{
		try{
			Connection connection = JDBConnection.connection();
			jdbcWriter.insertQuery(connection);
			JDBConnection.closeConnection();
		
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
}
