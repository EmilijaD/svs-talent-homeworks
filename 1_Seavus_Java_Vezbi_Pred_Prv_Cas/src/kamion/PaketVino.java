package kamion;

public class PaketVino extends PaketPijalok{

	private double procentAlkohol;

	public PaketVino(double volumenEden, int kolicina, double procentAlkohol) {
		super(volumenEden, kolicina);
		this.procentAlkohol = procentAlkohol;
	}
	 public double vratiMasa()
	  {
		
				double masaNaEden = getVolumenEden() * GUSTINA + AMBALAZA + (procentAlkohol + 0.9);
				return masaNaEden * getKolicina();
			
	  }
	public int sporediMasa(ImaMasa imaMasa) {
		if (this.vratiMasa() == imaMasa.vratiMasa())
			return 0;
		if (this.vratiMasa() > imaMasa.vratiMasa())
			return 1;
		return -1;
	}
	@Override
	public void pecati() {
		System.out.println("Paket vino");
		System.out.println("Kolicina: " + getKolicina());
		System.out.println("Masa " + vratiMasa());
		
	}
 

}
