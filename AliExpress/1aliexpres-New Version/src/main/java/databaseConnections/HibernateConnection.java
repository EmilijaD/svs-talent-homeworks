package databaseConnections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import parser.Produkt;

public class HibernateConnection {

	public static Session connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(
				Produkt.class).buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();

	}
	
	
	public static void closeSession(){
		connection().close();
	}

}
