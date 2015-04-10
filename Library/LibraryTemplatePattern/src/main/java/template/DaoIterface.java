package template;

import java.util.List;
import dao.Book;
import dao.Magazine;

public interface DaoIterface {

	public void registerBook(final Book book);

	public List<Book> listregisteredBooks();

	public void unregisterBook(final String isbn);

	public void updateBook(String oldisbn, String newIsbn, String newTitle);

	public void updateMagazine(String oldIssn, String newIssn, String newTitle);

	public void registerMagazine(final Magazine magazine);

	public void unregisterMagazine(String issn);

}
