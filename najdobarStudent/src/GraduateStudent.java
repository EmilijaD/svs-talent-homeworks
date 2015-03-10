
public class GraduateStudent extends Student {

	private String nasokaStudii;
	private int brPolozeniIspiti;
	int oceni[]= new int[brPolozeniIspiti];
	

	public String getNasokaStudii() {
		return nasokaStudii;
	}


	public void setNasokaStudii(String nasokaStudii) {
		this.nasokaStudii = nasokaStudii;
	}


	public int getBrPolozeniIspiti() {
		return brPolozeniIspiti;
	}


	public void setBrPolozeniIspiti(int brPolozeniIspiti) {
		this.brPolozeniIspiti = brPolozeniIspiti;
	}


	public int[] getOceni() {
		return oceni;
	}


	public void setOceni(int[] oceni) {
		this.oceni = oceni;
	}


	public GraduateStudent(String ime, String tatkoIme, String prezime,
			String grad, String indeks, String nasokaStudii,
			int brPolozeniIspiti, int[] oceni) {
		super(ime, tatkoIme, prezime, grad, indeks);
		this.nasokaStudii = nasokaStudii;
		this.brPolozeniIspiti = brPolozeniIspiti;
		this.oceni = oceni;
	}





	public GraduateStudent(String ime, String tatkoIme, String prezime,
			String grad, String indeks, String nasokaStudii,
			int brPolozeniIspiti,int br, int[] oceni) {
		super(ime, tatkoIme, prezime, grad, indeks);
		this.nasokaStudii = nasokaStudii;
		this.brPolozeniIspiti = brPolozeniIspiti;
		this.oceni = oceni;
	}


	@Override
	public double prosek() {
	   int zbir =0;
	   double prosek=0.0;
		for (int i=0; i<oceni.length; i++)
		{
		   zbir+=oceni[i];
		}
		
		prosek=zbir/brPolozeniIspiti;
		return prosek;
	}

}
