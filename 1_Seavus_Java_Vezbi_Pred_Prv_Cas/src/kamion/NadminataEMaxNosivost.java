package kamion;

public class NadminataEMaxNosivost extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String message = "Nadminata e maksimalnata nosivost na kamionot od 100 stavki";

	public NadminataEMaxNosivost() {
		super(message);
	}

}
