package warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import entities.Produkt;
import template.HibernateDatabaseReader;
import template.HibernateDatabaseWriter;
import template.HibernateTemplate;

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

}
