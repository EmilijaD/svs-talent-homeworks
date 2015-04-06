package ifGodBless;

import java.util.List;

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

	public void save(SaveAndListOptionInterface doi) {
		doi.save();
	}

	public void deletePublication(PublicationUpdateDelete publication,
			String isbnOrIssn) {

		publication.delete(isbnOrIssn);
	}

	public void updatePublications(PublicationUpdateDelete publication,
			String oldIsbnOrIssn, String newIsbnOrIssn, String newTitle) {
		publication.update(oldIsbnOrIssn, newIsbnOrIssn, newTitle);
	}

	public void deleteMember(MemberUpdateDelete member, String email) {
		member.delete(email);
	}

	public void updateMember(MemberUpdateDelete member, String oldEmail,
			String newName, String newEmail) {
		member.update(oldEmail, newName, newEmail);
	}

	@SuppressWarnings("rawtypes")
	public List list(SaveAndListOptionInterface doi) {
		return doi.list();
	}

	public SessionFactory connection() {

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
		return sessionFactory;

	}

}
