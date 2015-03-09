package biblioteka;

public class Kniga {
	private String naslov;
	private String avtor;
	private int godinaIzdavanje;
	private int kopii;

	public Kniga(String naslov, String avtor, int godinaIzdavanje, int kopii) {
		super();
		this.naslov = naslov;
		this.avtor = avtor;
		this.godinaIzdavanje = godinaIzdavanje;
		this.kopii = kopii;
	}

	public Kniga(String naslov2, String avtor2, int godinaIzdavanje2) {
		this.naslov = naslov2;
		this.avtor = avtor2;
		this.godinaIzdavanje = godinaIzdavanje2;
	}

	@Override
	public String toString() {
		return "Kniga [naslov=" + naslov + ", avtor=" + avtor
				+ ", godinaIzdavanje=" + godinaIzdavanje + ", kopii=" + kopii
				+ "]";
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

	public int getGodinaIzdavanje() {
		return godinaIzdavanje;
	}

	public void setGodinaIzdavanje(int godinaIzdavanje) {
		this.godinaIzdavanje = godinaIzdavanje;
	}

	public int getKopii() {
		return kopii;
	}

	public void setKopii(int kopii) {
		this.kopii = kopii;
	}

}
