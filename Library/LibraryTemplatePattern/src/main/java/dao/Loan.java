package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import template.Helper;

@Entity
public class Loan implements Helper {
	@Override
	public String toString() {
		return "Loan [member=" + this.getMember() + ", publications="
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

}
