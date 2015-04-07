package template;

import java.util.Date;
import java.util.List;

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

public class Template {

	public void save(Helper object) {
		DbOperations db = new DbOperations();
		db.register(object, connection());

	}

	public List<Publications> listPublications(Publications publications) {
		DbOperations db = new DbOperations();
		List<Publications> result = db.listregisteredPublications(connection(),
				publications);
		return result;
	}

	public void updateBook(String oldisbn, String newIsbn, String newTitle) {
		DbOperations db = new DbOperations();
		db.updateBook(oldisbn, newIsbn, newTitle, connection());
	}

	public void updateMagazine(String oldIssn, String newIssn, String newTitle) {
		DbOperations db = new DbOperations();
		db.updateMagazine(oldIssn, newIssn, newTitle, connection());
	}

	public void unregisterBook(String isbn) {
		DbOperations db = new DbOperations();
		db.unregisterBook(isbn, connection());
	}

	public void unregisterMagazine(String issn) {
		DbOperations db = new DbOperations();
		db.unregisterMagazine(issn, connection());
	}

	public void lendPublication(Member member, Publications publication,
			Date enddate, Date startdate) {
		DbOperations db = new DbOperations();
		db.lendPublication(member, publication, enddate, startdate,
				connection());
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

}
