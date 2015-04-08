import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class InDatabseHibernateWarehouse implements Warehouse {

	public SessionFactory connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(
				Produkt.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;

	}

	public void addProduct(ArrayList<Produkt> produkt) {
		Session session = connection().openSession();
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
			session.close();
		}

	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Produkt> listProducts() {
		Session session = connection().openSession();
		Transaction tx = null;
		List results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Produkt.class);
			results =  cr.list();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		return  (ArrayList<Produkt>) results;

	}
//Just for testing purposes
	public static void main(String[] args) {
		
		InDatabseHibernateWarehouse h = new InDatabseHibernateWarehouse();
		//System.out.println(h.listProducts());
		ArrayList<Produkt> pr = new ArrayList<Produkt>();
		Produkt p = new Produkt();
		p.setName("sok");
		p.setPrice(100);
		pr.add(p);
		h.addProduct(pr);
		System.out.println(h.listProducts());
	}

}
