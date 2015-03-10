package kamion;

public class PaketSok  extends PaketPijalok {
	
	private boolean eGaziran;

	public PaketSok(double volumenEden, int kolicina, boolean eGaziran) {
		super(volumenEden, kolicina);
		this.eGaziran = eGaziran;
	}

	public int sporediMasa(ImaMasa imaMasa) {
		if (this.vratiMasa() == imaMasa.vratiMasa())
			return 0;
		if (this.vratiMasa() > imaMasa.vratiMasa())
			return 1;
		return -1;
	}
	public double vratiMasa() {
		double masaNaEdenPijalak = (getVolumenEden() * GUSTINA + AMBALAZA);
		if (eGaziran) {
			masaNaEdenPijalak += 0.1;
		}
		double masa = masaNaEdenPijalak + getKolicina();
		return masa;
	}

	@Override
	public void pecati() {
		System.out.println("Paket pijalok");
		System.out.println("Kolicina: " + getKolicina());
		System.out.println("Masa na paket: " + vratiMasa());
	}




	
	
	

}
