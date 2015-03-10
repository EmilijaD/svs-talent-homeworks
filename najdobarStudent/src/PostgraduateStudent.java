

public class PostgraduateStudent extends Student {

	private String mentor;
	private double prosek;

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	public PostgraduateStudent(String ime, String tatkoIme, String prezime,
			String grad, String indeks, String mentor, double prosek) {
		super(ime, tatkoIme, prezime, grad, indeks);
		this.mentor = mentor;
		this.prosek = prosek;
	}

	@Override
	public double prosek() {
		
		return prosek;
	}

}
