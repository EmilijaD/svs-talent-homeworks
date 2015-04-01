package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookHibernate {

	@Override
	public String toString() {
		return "BookHibernate [isbn=" + isbn + ", title=" + title + "]";
	}

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "title")
	private String title;

	public BookHibernate() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
