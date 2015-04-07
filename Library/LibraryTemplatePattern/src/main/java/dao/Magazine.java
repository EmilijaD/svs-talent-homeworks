package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import template.Helper;

@Entity
public class Magazine extends Publications implements Helper {

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

}
