package bussinesLogic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.BookDao;
import dao.BookHibernate;

public class BookHibernateOptions implements BookDao {

	public SessionFactory connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(
				BookHibernate.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;

	}

	public void insert(BookHibernate book) {

		Session session = connection().openSession();
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

	public void update(String currentIsbn, String newIsbn, String newTitle) {

		Session session = connection().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE BookHibernate set title = :title, isbn = :isbn WHERE isbn = :book_isbn";
			Query query = session.createQuery(hql);
			query.setParameter("title", newTitle);
			query.setParameter("book_isbn", currentIsbn);
			query.setParameter("isbn", newIsbn);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void delete(String isbn) {
		Session session = connection().openSession();
		Transaction tx = null;
		String hql = "DELETE FROM BookHibernate WHERE isbn = :book_isbn";
		Query query = session.createQuery(hql);
		query.setParameter("book_isbn", isbn);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);

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

	@SuppressWarnings("unchecked")
	public ArrayList<BookHibernate> list() {
		Session session = connection().openSession();
		Transaction tx = null;
		List<BookHibernate> results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(BookHibernate.class);
			results = cr.list();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		return (ArrayList<BookHibernate>) results;

	}

//	public static void main(String[] args) {
//		BookHibernateOptions bh = new BookHibernateOptions();
//		BookHibernate book1 = new BookHibernate();
//		book1.setIsbn("kiki1");
//		book1.setTitle("Hristina1");
//		// bh.insert(book1);
//		System.out.println(bh.list());
//
//	}

}
