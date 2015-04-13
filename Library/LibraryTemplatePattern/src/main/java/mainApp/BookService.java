package mainApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book;
import dao.Magazine;
import template.DaoIterface;

@Service
public class BookService implements DaoIterface {

	HibernateDbOperations bookRepo;

	@Autowired
	public BookService(HibernateDbOperations bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public void registerBook(Book book) {
		bookRepo.registerBook(book);

	}
	public void unregisterBookById(Long id)
	{
		bookRepo.unregisterBookById(id);
	}

	public Book findBook(Long id) {
		return bookRepo.findBook(id);
	}

	@Override
	public List<Book> listregisteredBooks() {
		return bookRepo.listregisteredBooks();
	}

	@Override
	public void unregisterBook(String isbn) {
		bookRepo.unregisterBook(isbn);

	}

	@Override
	public void updateBook(String oldisbn, String newIsbn, String newTitle) {
		bookRepo.updateBook(oldisbn, newIsbn, newTitle);

	}

	@Override
	public void updateMagazine(String oldIssn, String newIssn, String newTitle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerMagazine(Magazine magazine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterMagazine(String issn) {
		// TODO Auto-generated method stub

	}

}
