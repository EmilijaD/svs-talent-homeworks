
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookBL implements BookDao {

	public void insert(Book book) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres",
				"postgres");

		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into book (isbn, title) values (?, ?)");

		preparedStatement.setString(1, book.getIsbn());
		preparedStatement.setString(2, book.getTitle());
		preparedStatement.addBatch();

		if (preparedStatement.executeBatch() != null) {
			System.out.println("Success!");
		} else {
			System.out.println("Not Successful execution!");
		}

		preparedStatement.close();

	}

	public void update(String currentIsbn, String newIsbn, String newTitle)
			throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres",
				"postgres");

		PreparedStatement preparedStatement = connection
				.prepareStatement("update book set isbn = ? , title = ? where isbn = ?");

		preparedStatement.setString(1, newIsbn);
		preparedStatement.setString(2, newTitle);
		preparedStatement.setString(3, currentIsbn);
		preparedStatement.executeUpdate();

		preparedStatement.close();

	}

	public void delete(String isbn) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres",
				"postgres");
		PreparedStatement preparedStatement = connection
				.prepareStatement("DELETE FROM book WHERE isbn = ?");
		preparedStatement.setString(1, isbn);

		preparedStatement.executeUpdate();

	}

	public ArrayList<Book> list() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres",
				"postgres");
		ArrayList<Book> books = new ArrayList<Book>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from book");
		while (resultSet.next()) {
			// Long id = resultSet.getLong("id");
			String isbn = resultSet.getString("isbn");
			String title = resultSet.getString("title");
			Book book = new Book(isbn, title);
			books.add(book);
		}
		statement.close();
		return books;

	}

}
