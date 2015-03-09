package biblioteka;

public class Korisnik {
	private String ime;
	private String prezime;
	private String telefon;
	private String adresa;
	private int dolzi;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getDolzi() {
		return dolzi;
	}

	public void setDolzi(int dolzi) {
		this.dolzi = dolzi;
	}

	public Korisnik(String ime, String prezime, String telefon, String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.adresa = adresa;
		this.dolzi = 0;
	}
}
