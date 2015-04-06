package dao;

import ifGodBless.SaveAndListOptionInterface;
import ifGodBless.Template;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
public class Loan implements SaveAndListOptionInterface {
	@Override
	public String toString() {
		return "Loan [member="+ this.getMember() + ", publications=" 
				+ ", enddate=" + enddate + ", startdate=" + startdate + "]";
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Member member;
	@ManyToOne
	private Publications publications;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "enddate")
	private Date enddate;
	@Column(name = "startdate")
	private Date startdate;

	public Loan() {

	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Publications getPublication() {
		return publications;
	}

	public void setPublication(Publications publication) {
		this.publications = publication;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public void save() {
		Loan loan = new Loan();
		loan.setEnddate(getEnddate());
		loan.setMember(getMember());
		loan.setPublication(getPublication());
		loan.setStartdate(getStartdate());
		Template template = new Template();
		SessionFactory co = template.connection();
		Session session = co.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(getPublication());
			session.save(getMember());
			session.save(loan);
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
		List<Loan> results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Loan.class, "loan");
			cr.createAlias("loan.member", "member");
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

}
