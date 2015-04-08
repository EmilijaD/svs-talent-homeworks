package warehouse.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import parser.Produkt;
import databaseConnections.HibernateConnection;

public class HibernateWarehouse implements Warehouse{

	public void addProduct(ArrayList<Produkt> produkt) {
		Session session = HibernateConnection.connection();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < produkt.size(); i++) {
				session.save(produkt.get(i));
			}

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		} finally {
			HibernateConnection.closeSession();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produkt> listProducts() {
		Session session = HibernateConnection.connection();
		Transaction tx = null;
		ArrayList<Produkt> results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Produkt.class);
			results = (ArrayList<Produkt>) cr.list();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			HibernateConnection.closeSession();
		}
		return results;
	}

}
