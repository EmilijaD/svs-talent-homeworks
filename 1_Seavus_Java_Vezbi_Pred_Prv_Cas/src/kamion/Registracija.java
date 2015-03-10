package kamion;

public class Registracija {
private String mesto;
private int broj;
private String zbor;
public Registracija(String mesto, int broj, String zbor) {
	super();
	this.mesto = mesto;
	this.broj = broj;
	this.zbor = zbor;
}
public String getMesto() {
	return mesto;
}
public void setMesto(String mesto) {
	this.mesto = mesto;
}
public int getBroj() {
	return broj;
}
public void setBroj(int broj) {
	this.broj = broj;
}
public String getZbor() {
	return zbor;
}
public void setZbor(String zbor) {
	this.zbor = zbor;
}


}
