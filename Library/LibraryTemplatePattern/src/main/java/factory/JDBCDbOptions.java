package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.Book;
import dao.Magazine;
import template.DaoIterface;
import template.JDBCTemplate;
import template.JdbcDatabaseReader;
import template.JdbcDatabaseWriter;

public class JDBCDbOptions implements DaoIterface {

	public void registerBook(final Book book) {
		new JDBCTemplate().insertQuery(new JdbcDatabaseWriter() {

			public void insertQuery(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = null;
				preparedStatement = connection
						.prepareStatement("insert into book (isbn, title) values (?, ?)");

				preparedStatement.setString(1, book.getIsbn());
				preparedStatement.setString(2, book.getTitle());
				preparedStatement.addBatch();
				preparedStatement.execute();

			}
		});

	}

	public List<Book> listregisteredBooks() {
		return new JDBCTemplate().returnQuery(new JdbcDatabaseReader() {

			@SuppressWarnings("unchecked")
			public List<Book> returnQuery(Connection connection)
					throws SQLException {
				ArrayList<Book> books = new ArrayList<Book>();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM book");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Book book = new Book();
					book.setIsbn(resultSet.getString("isbn"));
					book.setTitle(resultSet.getString("title"));

					books.add(book);
				}
				preparedStatement.close();
				return books;
			}
		});
	}

	public void unregisterBook(final String isbn) {
		new JDBCTemplate().insertQuery(new JdbcDatabaseWriter() {

			public void insertQuery(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = null;
				preparedStatement = connection
						.prepareStatement("delete from book where isbn= ?");

				preparedStatement.setString(1, isbn);
				preparedStatement.addBatch();
				preparedStatement.execute();

			}
		});

	}

	public void updateBook(final String oldisbn, final String newIsbn, final String newTitle) {
		new JDBCTemplate().insertQuery(new JdbcDatabaseWriter() {

			public void insertQuery(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = null;
				preparedStatement = connection
						.prepareStatement("UPDATE Book SET isbn = ?, title = ? WHERE isbn = ?");

				preparedStatement.setString(1, newIsbn);
				preparedStatement.setString(2, newTitle);
				preparedStatement.setString(3, oldisbn);
				preparedStatement.addBatch();
				preparedStatement.execute();

			}
		});

	}

	public void updateMagazine(String oldIssn, String newIssn, String newTitle) {
		// TODO Auto-generated method stub

	}

	public void registerMagazine(Magazine magazine) {
		// TODO Auto-generated method stub

	}

	public void unregisterMagazine(String issn) {
		// TODO Auto-generated method stub

	}

}
