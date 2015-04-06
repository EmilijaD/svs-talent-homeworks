package dao;

import ifGodBless.SaveAndListOptionInterface;
import ifGodBless.MemberUpdateDelete;
import ifGodBless.Template;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
public class Member implements SaveAndListOptionInterface, MemberUpdateDelete {
	@OneToOne(mappedBy = "member")
	private Membership membership;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "member", cascade = CascadeType.ALL)
	private Set<Loan> loans;

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String name;

	public Member() {

	}

	public Membership getMembership() {
		return membership;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Member [ email=" + email + ", name=" + name + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void save() {
		Member member = new Member();
		member.setName(getName());
		member.setEmail(getEmail());
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(member);
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
		List<Member> results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Member.class);
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

	public void delete(String memberEmail) {
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		String hql = "DELETE FROM Member WHERE email = :member_email";
		Query query = session.createQuery(hql);

		query.setParameter("member_email", memberEmail);
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

	public void update(String oldEmail, String newName, String newEmail) {
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Member set name = :name, email = :email WHERE  email = :member_email";
			Query query = session.createQuery(hql);
			query.setParameter("member_email", oldEmail);
			query.setParameter("name", newName);
			query.setParameter("email", newEmail);
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
