package template;

import org.hibernate.Session;
import org.hibernate.Transaction;

import databaseConnections.HibernateConnection;

public class HibernateTemplate {
	HibernateConnection connect = new HibernateConnection();

	public <E> E returnQuery(DatabaseReader databaseReader) {
		Session session = connect.connection();
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
			connect.closeConnection();
		}

		return object;
	}

	public void saveOrUpdateQuery(DatabaseWriter databaseWriter) {
		Session session = connect.connection();
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
			connect.closeConnection();
		}

	}

}
