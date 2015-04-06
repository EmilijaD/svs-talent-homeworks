package dao;

import java.util.List;

import ifGodBless.SaveAndListOptionInterface;
import ifGodBless.Template;
import ifGodBless.PublicationUpdateDelete;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
public class Magazine extends Publications implements SaveAndListOptionInterface,
		PublicationUpdateDelete {

	@Column(name = "issn")
	private String issn;

	public Magazine() {

	}

	@Override
	public String toString() {
		return "Magazine [issn=" + issn + ", getLoans()=" + getLoans()
				+ ", getTitle()=" + getTitle() + "]";
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public void save() {
		Magazine magazine = new Magazine();
		magazine.setIssn(issn);
		magazine.setLoans(getLoans());
		magazine.setTitle(getTitle());
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(magazine);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List list() {
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		List<Magazine> results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Magazine.class);
			results = cr.list();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		return results;

	}

	public void delete(String isbnOrIssn) {
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		String hql = "DELETE FROM Magazine WHERE issn = :magazine_issn";
		Query query = session.createQuery(hql);
		query.setParameter("magazine_issn", isbnOrIssn);
		query.executeUpdate();

		try {
			tx = session.beginTransaction();

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}

	}

	public void update(String oldisbnOrIssn, String newIsbnOrIssn,
			String newTitle) {

		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Magazine set title = :title, issn = :issn WHERE issn = :magazine_issn";
			Query query = session.createQuery(hql);
			query.setParameter("title", newTitle);
			query.setParameter("magazine_issn", oldisbnOrIssn);
			query.setParameter("issn", newIsbnOrIssn);
			query.executeUpdate();

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}

	}

}
