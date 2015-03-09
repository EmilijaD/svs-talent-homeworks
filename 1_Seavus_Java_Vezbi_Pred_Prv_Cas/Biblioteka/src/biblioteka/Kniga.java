package biblioteka;

import java.util.Date;

public class Kniga {
	private static int BROJ_NA_KOPII = 10;
	private String naslov;
	private String avtor;
	private Date godinaNaIzdavanje;

	public void pecatiInfo() {
		System.out.println(naslov);
		System.out.println(avtor);
		System.out.println("Godina na izdavanje:" + godinaNaIzdavanje);
	}

	public Kniga(String naslov, String avtor, Date godinaNaIzdavanje) {
		super();
		this.naslov = naslov;
		this.avtor = avtor;
		this.godinaNaIzdavanje = godinaNaIzdavanje;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getAvtor() {
		return avtor;
	}

	public void setAvtor(String avtor) {
		this.avtor = avtor;
	}

	public Date getGodinaNaIzdavanje() {
		return godinaNaIzdavanje;
	}

	public void setGodinaNaIzdavanje(Date godinaNaIzdavanje) {
		this.godinaNaIzdavanje = godinaNaIzdavanje;
	}
}
