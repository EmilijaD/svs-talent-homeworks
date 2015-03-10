

public abstract class Student {
	private String ime;
	private String tatkoIme;
	private String prezime;
	private String grad;
	private String indeks;

	public abstract double prosek();

	public Student(String ime, String tatkoIme, String prezime, String grad,
			String indeks) {
		this.ime = ime;
		this.tatkoIme = tatkoIme;
		this.prezime = prezime;
		this.grad = grad;
		this.indeks = indeks;
	}

	public Student(String readLine) {
		super();
		String[] st=readLine.split("\\s");
		this.indeks=st[0];
		this.ime=st[1];
		
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getTatkoIme() {
		return tatkoIme;
	}

	public void setTatkoIme(String tatkoIme) {
		this.tatkoIme = tatkoIme;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String toString()

	{
		return this.ime + " " + this.tatkoIme + " " + this.prezime
				+ " indeks: " + this.indeks;
	}
}
