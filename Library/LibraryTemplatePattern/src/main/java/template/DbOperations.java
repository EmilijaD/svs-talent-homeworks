package template;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Book;
import dao.Loan;
import dao.Magazine;
import dao.Member;
import dao.Publications;

public class DbOperations implements DaoIterface {

	public void register(Object object, Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(object);
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

	public void unregisterBook(String isbn, Session session) {
		Transaction tx = null;
		String hql = "DELETE FROM Book WHERE isbn = :book_isbn";
		Query query = session.createQuery(hql);
		query.setParameter("book_isbn", isbn);
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

	public List<Publications> listregisteredPublications(Session session,
			Publications publication) {
		Transaction tx = null;
		List results = null;
		Criteria cr = null;
		try {
			tx = session.beginTransaction();
			if (publication instanceof Book) {
				cr = session.createCriteria(Book.class);
			}
			if (publication instanceof Magazine) {
				cr = session.createCriteria(Book.class);
			}
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

	public void updateBook(String oldisbn, String newIsbn, String newTitle,
			Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Book set title = :title, isbn = :isbn WHERE isbn = :book_isbn";
			Query query = session.createQuery(hql);
			query.setParameter("title", newTitle);
			query.setParameter("book_isbn", oldisbn);
			query.setParameter("isbn", newIsbn);
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

	public void updateMagazine(String oldIssn, String newIssn, String newTitle,
			Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Magazine set title = :title, issn = :issn WHERE issn = :magazine_issn";
			Query query = session.createQuery(hql);
			query.setParameter("title", newTitle);
			query.setParameter("magazine_issn", oldIssn);
			query.setParameter("issn", newIssn);
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

	public void lendPublication(Member member, Publications publication,
			Date enddate, Date startdate, Session session) {
		Transaction tx = null;
		Loan loan = new Loan();
		loan.setEnddate(enddate);
		loan.setStartdate(startdate);
		loan.setMember(member);
		loan.setPublication(publication);
		try {
			tx = session.beginTransaction();
			session.save(publication);
			session.save(member);
			session.save(loan);
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

	public void unregisterMagazine(String issn, Session session) {
		Transaction tx = null;
		String hql = "DELETE FROM Magazine WHERE issn = :magazine_issn";
		Query query = session.createQuery(hql);
		query.setParameter("magazine_issn", issn);
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

}
