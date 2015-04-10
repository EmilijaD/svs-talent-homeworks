package dao;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Membership {
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

}
