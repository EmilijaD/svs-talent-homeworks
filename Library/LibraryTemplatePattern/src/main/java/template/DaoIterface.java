package template;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import dao.Member;
import dao.Publications;

public interface DaoIterface {

	public void register(Object object, Session session);

	public List<Publications> listregisteredPublications(Session session,
			Publications publication);

	public void updateBook(String oldisbn, String newIsbn, String newTitle,
			Session session);

	public void updateMagazine(String oldIssn, String newIssn, String newTitle,
			Session session);

	public void unregisterBook(String isbn, Session session);

	public void unregisterMagazine(String issn, Session session);

	public void lendPublication(Member member, Publications publication,
			Date enddate, Date startdate, Session session);

}
