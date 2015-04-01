package dao;


import java.util.List;

public interface BookDao {

	public void insert(BookHibernate book);

	public void update(String currentIsbn, String newIsbn, String newTitle);

	public void delete(String isbn);

	public List<BookHibernate> list();

}
