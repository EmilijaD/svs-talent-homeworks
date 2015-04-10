package template;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.Book;
import dao.Magazine;
import dao.Publications;

public class DbOperations implements DaoIterface {

	public void registerBook(final Book book) {
		new Template().saveOrUpdateQuery(new DatabaseWriter() {

			public Object insertQuery() {

				return book;
			}
		});

	}

	public void unregisterBook(final String isbn) {

		new Template().returnQuery(new DatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "DELETE FROM Book WHERE isbn = :book_isbn";
				final Query query = session.createQuery(hql);
				query.setParameter("book_isbn", isbn);
				query.executeUpdate();
				return null;
			}
		});

	}

	public List<Book> listregisteredBooks() {
		return new Template().returnQuery(new DatabaseReader() {

			@SuppressWarnings("unchecked")
			public List<Publications> returnQuery(Session session) {
				List<Publications> results = session.createQuery("FROM Book")
						.list();
				return results;
			}

		});
	}

	public void updateBook(final String oldisbn, final String newIsbn,
			final String newTitle) {
		new Template().returnQuery(new DatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "UPDATE Book set title = :title, isbn = :isbn WHERE isbn = :book_isbn";
				Query query = session.createQuery(hql);
				query.setParameter("title", newTitle);
				query.setParameter("book_isbn", oldisbn);
				query.setParameter("isbn", newIsbn);
				query.executeUpdate();
				return null;
			}
		});

	}

	public void updateMagazine(final String oldIssn, final String newIssn,
			final String newTitle) {
		new Template().returnQuery(new DatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "UPDATE Magazine set title = :title, issn = :issn WHERE issn = :magazine_issn";
				Query query = session.createQuery(hql);
				query.setParameter("title", newTitle);
				query.setParameter("magazine_issn", oldIssn);
				query.setParameter("issn", newIssn);
				query.executeUpdate();
				return null;
			}
		});

	}

	public void unregisterMagazine(final String issn) {
		new Template().returnQuery(new DatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "DELETE FROM Magazine WHERE issn = :magazine_issn";
				Query query = session.createQuery(hql);
				query.setParameter("magazine_issn", issn);
				query.executeUpdate();
				return null;
			}
		});

	}

	public void registerMagazine(final Magazine magazine) {
		new Template().saveOrUpdateQuery(new DatabaseWriter() {

			public Object insertQuery() {

				return magazine;
			}
		});

	}

}
