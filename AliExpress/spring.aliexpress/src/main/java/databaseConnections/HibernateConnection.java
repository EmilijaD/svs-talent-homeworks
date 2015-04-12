package databaseConnections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import appMain.Account;
import appMain.CreditCard;
import appMain.Produkt;

public class HibernateConnection {

	public static Session connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Produkt.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(CreditCard.class)
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();

	}

	public static void closeSession() {
		connection().close();
	}

}
