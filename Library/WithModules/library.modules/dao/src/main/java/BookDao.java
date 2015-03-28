

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDao {

	public void insert(Book book) throws SQLException;

	public void update(String currentIsbn,String newIsbn,String newTitle) throws SQLException;

	public void delete(String isbn) throws SQLException;

	public ArrayList<Book> list() throws SQLException;

}
