package biblioteka;

import java.util.Date;

public class Biblioteka {
	private static int MAX_CLENOVI = 100;
	private static int MAX_KNIGI = 100;
	private String ime;
	private String telefon;
	private String adresa;
	private int momentalnoKnigi;
	private int momentalnoKorisnici;

	public Kniga dodadiKniga(String naslov, String avtor, Date godinaNaIzdavanje) {
		if (momentalnoKnigi >= MAX_KNIGI)
			return null;
		Kniga kniga = new Kniga(naslov, avtor, godinaNaIzdavanje);
		knigi[momentalnoKnigi] = kniga;
		momentalnoKnigi++;
		return kniga;
	}

	public void pecatiInfoZaKniga(String naslov) {
		for (int i = 0; i < momentalnoKnigi; i++) {
			if (knigi[i].getNaslov().equals(naslov)) {
				knigi[i].pecatiInfo();
				break;
			}
		}
	}

	void pecatiInfo() {
		System.out.println(ime);
		System.out.println(adresa);
		System.out.println("Tel. " + telefon);
	}

	public String getIme() {
		return ime;
	}

	public String getTelefon() {
		return telefon;
	}

	public Biblioteka(String ime, String telefon, String adresa) {
		super();
		this.ime = ime;
		this.telefon = telefon;
		this.adresa = adresa;
		this.momentalnoKnigi = 0;
		this.momentalnoKorisnici = 0;
	}

	public Biblioteka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAdresa() {
		return adresa;
	}

	public int getMomentalnoKnigi() {
		return momentalnoKnigi;
	}

	public int getMomentalnoKorisnici() {
		return momentalnoKorisnici;
	}

	public Korisnik[] getKorisnici() {
		return korisnici;
	}

	public Kniga[] getKnigi() {
		return knigi;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setMomentalnoKnigi(int momentalnoKnigi) {
		this.momentalnoKnigi = momentalnoKnigi;
	}

	public void setMomentalnoKorisnici(int momentalnoKorisnici) {
		this.momentalnoKorisnici = momentalnoKorisnici;
	}

	public void setKorisnici(Korisnik[] korisnici) {
		this.korisnici = korisnici;
	}

	public void setKnigi(Kniga[] knigi) {
		this.knigi = knigi;
	}

	private Korisnik[] korisnici = new Korisnik[MAX_CLENOVI];
	private Kniga[] knigi = new Kniga[MAX_KNIGI];
}
