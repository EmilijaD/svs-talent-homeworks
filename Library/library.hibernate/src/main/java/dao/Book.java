package dao;

import java.util.List;

import ifGodBless.SaveAndListOptionInterface;
import ifGodBless.Template;
import ifGodBless.PublicationUpdateDelete;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
public class Book extends Publications implements SaveAndListOptionInterface,PublicationUpdateDelete{

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", getLoans()=" + getLoans()
				+ ", getTitle()=" + getTitle() + "]";
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

	public void delete(String isbnOrIssn) {
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		String hql = "DELETE FROM Book WHERE isbn = :book_isbn";
		Query query = session.createQuery(hql);
		query.setParameter("book_isbn", isbnOrIssn);
		query.executeUpdate();

		try {
			tx = session.beginTransaction();

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		
	}

	public void update(String oldisbnOrIssn, String newIsbnOrIssn,
			String newTitle) {
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Book set title = :title, isbn = :isbn WHERE isbn = :book_isbn";
			Query query = session.createQuery(hql);
			query.setParameter("title", newTitle);
			query.setParameter("book_isbn", oldisbnOrIssn);
			query.setParameter("isbn", newIsbnOrIssn);
			query.executeUpdate();

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
	}

	public void save() {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setLoans(getLoans());
		book.setTitle(getTitle());
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		} finally {
			session.close();
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List list() {
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		List<Book> results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Book.class);
			results = cr.list();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		return results;

	}

}
