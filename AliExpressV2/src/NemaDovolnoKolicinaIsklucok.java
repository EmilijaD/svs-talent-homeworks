public class NemaDovolnoKolicinaIsklucok extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String msg = "Nema dovolno kolicina od toj produkt";

	public NemaDovolnoKolicinaIsklucok() {
		super(msg);
	}

}
