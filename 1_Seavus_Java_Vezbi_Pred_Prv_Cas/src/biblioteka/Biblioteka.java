package biblioteka;

public class Biblioteka {
	
	private String imeBiblioteka;
	private String adresaBiblioteka;
	private String telefonBiblioteka;
	
	private int momentalnoKorisnici;
	private int momentalnoKnigi;
	private static int MAX_CLENOVI = 100;
	private static int MAX_KNIGI = 100;
	private Korisnik[] korisnici = new Korisnik[MAX_CLENOVI];
	private Kniga[] knigi = new Kniga[MAX_KNIGI];
	public Biblioteka(String imeBiblioteka, String adresaBiblioteka,
			String telefonBiblioteka) {
		super();
		this.imeBiblioteka = imeBiblioteka;
		this.adresaBiblioteka = adresaBiblioteka;
		this.telefonBiblioteka = telefonBiblioteka;
		this.momentalnoKnigi = 0;
		this.momentalnoKorisnici = 0;
	}

	public void pecatiKontaktPodatociBiblioteka() {

		System.out.println("Imeto na Bibliotekata e: " + this.imeBiblioteka);
		System.out.println("Adresata na bibliotekata e: "
				+ this.adresaBiblioteka);
		System.out.println("Telefon za kontakt: " + this.telefonBiblioteka);

	}

	public void pecatiInfoZaKniga(String naslov) {
		for (int i = 0; i < momentalnoKnigi; i++) {
			if (knigi[i].getNaslov().equals(naslov)) {
				knigi[i].toString();
				break;
			}
		}}

	public void pecatiKorisnici() {
		for (int i = 0; i < momentalnoKorisnici; i++)

			System.out.println(korisnici[i].toString());
		
	}public void pecatiKnigi() {
		for (int i = 0; i < momentalnoKnigi; i++)

			System.out.println(knigi[i].toString());
		
	}
	
	public void vnesiNovKorisnik(String ime, String prezime,String adresa, String telefon)
	{
		Korisnik korisnik= new Korisnik(ime, prezime, adresa, telefon);
		
		
				this.korisnici[momentalnoKorisnici] = korisnik;
				momentalnoKorisnici++;
				
				
		
	}

	
	public void izbrisiKorisnik(String ime, String prezime,String adresa, String telefon)
	{
		for (int i =0; i<momentalnoKorisnici; i++) {
			
			if (korisnici[i].getIme() == ime && korisnici[i].getPrezime()== prezime && korisnici[i].getAdresa()==adresa && korisnici[i].getTelefon()==telefon)
			{
				korisnici[i].setAdresa(null);
				korisnici[i].setIme(null);
				korisnici[i].setPrezime(null);
				korisnici[i].setTelefon(null);
			}
			
		}
	}
	
	public void dodadiKniga( String naslov, String avtor, int godinaIzdavanje)
	{
		Kniga kniga = new Kniga(naslov, avtor, godinaIzdavanje);
		
			knigi[momentalnoKnigi] = kniga;
			momentalnoKnigi++;
		
	}
	public static void main(String[] args) {
		Biblioteka bl = new Biblioteka("Cris","Ti","NA");
		System.out.println("Vnesi Kniga");
		
		bl.dodadiKniga("Kniga1", "Ggg", 1234);
		Kniga kniga = new Kniga("Kniga1", "Ggg", 1234);
		bl.pecatiInfoZaKniga("Kniga1");
		bl.vnesiNovKorisnik("Kiki", "Nastevska", "D", "DDDD");
		bl.vnesiNovKorisnik("Kikippppp", "Nastevska", "D", "DDDD");
		bl.pecatiKontaktPodatociBiblioteka();
		bl.pecatiKorisnici();
		bl.pecatiKnigi();
		bl.izbrisiKorisnik("Kiki", "Nastevska", "D", "DDDD");
		bl.pecatiKorisnici();
	}

}
