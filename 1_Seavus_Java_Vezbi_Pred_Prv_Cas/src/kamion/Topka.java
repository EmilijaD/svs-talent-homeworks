package kamion;

public class Topka implements ImaMasa {
	private double radius;
	private double gustina;

	public Topka(double radius, double gustina) {
		super();
		this.radius = radius;
		this.gustina = gustina;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getGustina() {
		return gustina;
	}

	public void setGustina(double gustina) {
		this.gustina = gustina;
	}

	public void pecati() {
		System.out.println("Gustinata na topkata e: " + this.gustina);
		System.out.println("Radiusot na topkata e: " + this.radius);
	}

	@Override
	public double vratiMasa() {

		double volumen = 4 / 3 * 3.14 + radius * radius * radius;
		return volumen * gustina;
	}

	@Override
	public int sporediMasa(ImaMasa m) {
		if (this.vratiMasa() > m.vratiMasa())
			return 1;
		if (this.vratiMasa() == m.vratiMasa())
			return 0;
		return -1;
		
	}

}
