package biblioteka;

public class Korisnik {
	private String ime;
	private String prezime;
	private String adresa;
	private String telefon;
	public Korisnik(String ime, String prezime, String adresa, String korisnik) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.telefon = korisnik;
	}
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
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", adresa="
				+ adresa + ", korisnik=" + telefon + "]";
	}

}
