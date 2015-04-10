package template;

import org.hibernate.Session;

public interface DatabaseReader {

	<E> E returnQuery(Session session);
}
