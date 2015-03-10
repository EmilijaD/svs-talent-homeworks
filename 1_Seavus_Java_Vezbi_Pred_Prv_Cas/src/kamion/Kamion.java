package kamion;

public class Kamion {

	public static final int MAX = 100;
	private Registracija registracija;
	private String vozac;
	private ImaMasa[] objekti = new ImaMasa[MAX];

	public Kamion(Registracija registracija, String vozac) {
		super();
		this.registracija = registracija;
		this.vozac = vozac;
	}

	public void dodadiElement(ImaMasa objekt) throws NadminataEMaxNosivost {
		int brStoka = objekti.length;
		if (brStoka >= MAX)
			throw new NadminataEMaxNosivost();
		objekti[brStoka] = objekt;

	}
	
	public double vratiVkupnaMasa()
	{
		double vkupnaMasa=0;
		for (int i = 0; i < objekti.length; i++) {
			vkupnaMasa+=objekti[i].vratiMasa();
		}
		return vkupnaMasa;
		
		
	}
	
	public void pecati()
	{
		for (int i = 0; i < objekti.length; i++) {
			System.out.println(objekti[i]);
			
		}
		System.out.println("Registracijata na kamionot e: "+ this.registracija.getBroj()+ this.registracija.getMesto()+ this.registracija.getZbor());
	    System.out.println("Vozacor e: "+ this.vozac);
	    
	
	}

}
