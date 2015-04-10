package template;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.Book;
import dao.Loan;
import dao.Magazine;
import dao.Member;
import dao.Membership;
import dao.Publications;

public class Template {

	public <E> E returnQuery(DatabaseReader databaseReader) {
		Session session = connection();
		Transaction tx = null;
		E object;
		try {
			tx = session.beginTransaction();
			object = databaseReader.returnQuery(session);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			closeConnection();
		}

		return object;
	}

	public void saveOrUpdateQuery(DatabaseWriter databaseWriter) {
		Session session = connection();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Object object = databaseWriter.insertQuery();
			session.saveOrUpdate(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			closeConnection();
		}

	}

	public Session connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Publications.class)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Magazine.class)
				.addAnnotatedClass(Member.class).addAnnotatedClass(Loan.class)
				.addAnnotatedClass(Membership.class)
				.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();
		return session;

	}

	public void closeConnection() {
		this.connection().close();
	}

}
