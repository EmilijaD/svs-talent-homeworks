package databaseConnections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.Book;
import dao.Loan;
import dao.Magazine;
import dao.Member;
import dao.Membership;
import dao.Publications;

public class HibernateConnection {

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