package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.Transaction;

import template.Helper;

import template.Template;

@Entity
public class Membership implements Helper {
	@Override
	public String toString() {
		return "Membership [member=" + member + ", enddate=" + enddate
				+ ", memebershiptype=" + memebershiptype + ", startdate="
				+ startdate + "]";
	}

	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Member member;
	@Column(name = "enddate")
	private Date enddate;
	@Column(name = "membershiptype")
	private String memebershiptype;
	@Column(name = "startdate")
	private Date startdate;

	public Membership() {

	}

	public Member getMemberid() {
		return member;
	}

	public void setMemberid(Member member) {
		this.member = member;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getMemebershiptype() {
		return memebershiptype;
	}

	public void setMemebershiptype(String memebershiptype) {
		this.memebershiptype = memebershiptype;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public void save() {
		Membership membership = new Membership();
		membership.setEnddate(enddate);
		membership.setStartdate(startdate);
		membership.setMemebershiptype(memebershiptype);
		membership.setMemberid(getMemberid());
		Template template = new Template();
		Session session = template.connection();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(this.getMemberid());
			session.save(membership);
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

	public List list() {

		Template template = new Template();
		Session session = template.connection();
		Transaction tx = null;
		List<Loan> results = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session
					.createCriteria(Membership.class, "membership");
			cr.createAlias("membership.member", "member");
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
