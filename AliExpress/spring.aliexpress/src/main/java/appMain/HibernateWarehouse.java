package appMain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import template.HibernateDatabaseReader;
import template.HibernateDatabaseWriter;
import template.HibernateTemplate;
import warehouse.dao.Warehouse;

@Repository
public class HibernateWarehouse implements Warehouse {

	public void addProduct(final Produkt produkt) {

		new HibernateTemplate().saveOrUpdateQuery(

		new HibernateDatabaseWriter() {

			public Object insertQuery() {
				return produkt;
			}
		});

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produkt> listProducts() {

		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					public List<Produkt> returnQuery(Session session) {
						List<Produkt> results = session.createQuery(
								"FROM Produkt").list();
						return results;
					}
				});

	}

	public Produkt findProduct(final String name) {
		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					@SuppressWarnings("unchecked")
					@Override
					public Produkt returnQuery(Session session) {
						Criteria cr = session.createCriteria(Produkt.class);
						cr.add(Restrictions.eq("name", name));
						@SuppressWarnings("rawtypes")
						List results = cr.list();
						Produkt p = (Produkt) results.get(0);

						return p;
					}
				});
	}

}
