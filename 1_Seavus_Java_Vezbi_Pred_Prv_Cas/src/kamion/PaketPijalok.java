package kamion;

public abstract class PaketPijalok implements ImaMasa {
	private double volumenEden;
	private int kolicina;
	public static final double GUSTINA = 0.8;
	public static final double AMBALAZA = 0.2;

	public PaketPijalok(double volumenEden, int kolicina) {
		super();
		this.volumenEden = volumenEden;
		this.kolicina = kolicina;
	}

	@Override
	public double vratiMasa() {
		double masa = volumenEden * GUSTINA *AMBALAZA;
		return masa;
	}

	@Override
	public int sporediMasa(ImaMasa imaMasa) {
		if (this.vratiMasa() == imaMasa.vratiMasa())
			return 0;
		if (this.vratiMasa() > imaMasa.vratiMasa())
			return 1;
		return -1;
	}
	public double getVolumenEden() {
		return volumenEden;
	}

	public void setVolumenEden(double volumenEden) {
		this.volumenEden = volumenEden;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public abstract void pecati();

}
