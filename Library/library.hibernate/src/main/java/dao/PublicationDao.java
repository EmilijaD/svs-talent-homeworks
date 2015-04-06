package dao;

import java.util.List;

public interface PublicationDao {

	public void insert(Publications publications);

	public void update(String currentIsbn, String newIsbn, String newTitle);

	public void delete(String isbn);

	public void memberRegistration(Member member);
	

	public List<Publications> list();

}
