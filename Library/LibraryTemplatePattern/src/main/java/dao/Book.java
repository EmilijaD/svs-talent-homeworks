package dao;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends Publications {

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", getTitle()=" + getTitle() + "]";
	}

	@Column(name = "isbn")
	private String isbn;

	public Book() {

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
