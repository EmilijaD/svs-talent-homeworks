package ifGodBless;

public interface PublicationUpdateDelete {

	public void delete(String isbnOrIssn);
	public void update(String oldisbnOrIssn,  String newIsbnOrIssn, String newTitle);
	
	
}
