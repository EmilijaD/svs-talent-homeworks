package dao;

import javax.persistence.Column;
import javax.persistence.Entity;

import template.Helper;

@Entity
public class Book extends Publications implements Helper {

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
