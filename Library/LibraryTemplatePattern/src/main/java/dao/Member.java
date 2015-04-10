package dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {
	@OneToOne(mappedBy = "member")
	private Membership membership;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "member", cascade = CascadeType.ALL)
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

}
