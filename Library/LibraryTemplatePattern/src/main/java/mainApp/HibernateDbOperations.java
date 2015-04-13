package mainApp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import template.DaoIterface;
import template.DatabaseReader;
import template.DatabaseWriter;

import template.HibernateTemplate;
import dao.Book;
import dao.Magazine;

@Repository
public class HibernateDbOperations implements DaoIterface {

	public void registerBook(final Book book) {
		new HibernateTemplate().saveOrUpdateQuery(new DatabaseWriter() {

			public Object insertQuery() {

				return book;
			}
		});

	}

	public void unregisterBook(final String isbn) {

		new HibernateTemplate().returnQuery(new DatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "DELETE FROM Book WHERE isbn = :book_isbn";
				final Query query = session.createQuery(hql);
				query.setParameter("book_isbn", isbn);
				query.executeUpdate();
				return null;
			}
		});

	}

	public void unregisterBookById(final Long id) {

		new HibernateTemplate().returnQuery(new DatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "DELETE FROM Book WHERE id = :id";
				final Query query = session.createQuery(hql);
				query.setParameter("id", id);
				query.executeUpdate();
				return null;
			}
		});

	}

	public List<Book> listregisteredBooks() {
		return new HibernateTemplate().returnQuery(new DatabaseReader() {

			@SuppressWarnings("unchecked")
			public List<Book> returnQuery(Session session) {
				List<Book> results = session.createQuery("FROM Book").list();
				return results;
			}

		});
	}

	public Book findBook(final Long id) {
		return new HibernateTemplate().returnQuery(new DatabaseReader() {

			@SuppressWarnings("unchecked")
			@Override
			public Book returnQuery(Session session) {
				Criteria cr = session.createCriteria(Book.class);
				cr.add(Restrictions.eq("id", id));
				@SuppressWarnings("rawtypes")
				List results = cr.list();
				Book b = (Book) results.get(0);

				return b;
			}
		});
	}

	public void updateBook(final String oldisbn, final String newIsbn,
			final String newTitle) {
		new HibernateTemplate().returnQuery(new DatabaseReader() {

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
		new HibernateTemplate().returnQuery(new DatabaseReader() {

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
		new HibernateTemplate().returnQuery(new DatabaseReader() {

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
		new HibernateTemplate().saveOrUpdateQuery(new DatabaseWriter() {

			public Object insertQuery() {

				return magazine;
			}
		});

	}

}
