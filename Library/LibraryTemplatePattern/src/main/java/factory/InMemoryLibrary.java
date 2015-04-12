package factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import template.DaoIterface;
import dao.Book;
import dao.Magazine;

public class InMemoryLibrary implements DaoIterface {

	ArrayList<Book> books = new ArrayList<Book>();

	public void registerBook(Book book) {
		books.add(book);

	}

	public List<Book> listregisteredBooks() {

		return books;
	}

	public void unregisterBook(String isbn) {

		Iterator<Book> bookIterator = books.iterator();
		while (bookIterator.hasNext()) {
			if (bookIterator.next().getIsbn() == isbn) {
				books.remove(bookIterator);
			}

		}

	}

	public void updateBook(String oldisbn, String newIsbn, String newTitle) {

		Iterator<Book> bookIterator = books.iterator();
		while (bookIterator.hasNext()) {
			if (bookIterator.next().getIsbn() == oldisbn) {
				bookIterator.next().setIsbn(newIsbn);
				bookIterator.next().setTitle(newTitle);
			}
		}

	}

	public void updateMagazine(String oldIssn, String newIssn, String newTitle) {

	}

	public void registerMagazine(Magazine magazine) {

	}

	public void unregisterMagazine(String issn) {

	}

}
