package accountManagement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import template.HibernateDatabaseReader;
import template.HibernateDatabaseWriter;
import template.HibernateTemplate;
import entities.Account;
import entities.CreditCard;

@Repository
public class AccountManagementImpl implements AccountMngmInterface {

	public void createAccount(final Account account) {
		new HibernateTemplate()
				.saveOrUpdateQuery(new HibernateDatabaseWriter() {

					public Object insertQuery() {
						return account;
					}
				});

	}

	public void updateAccount() {
		// TODO Auto-generated method stub

	}

	public List<Account> returnAccount(final String email) {
		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					@SuppressWarnings("unchecked")
					public List<Account> returnQuery(Session session) {
						String hql = "FROM Account where email= :e";
						Query query = session.createQuery(hql);
						query.setParameter("e", email);

						List<Account> results = query.list();

						return results;
					}

				});

	}

	public void deleteAccount(final String email) {
		new HibernateTemplate().returnQuery(new HibernateDatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "DELETE FROM Account WHERE email = :email_usr";
				Query query = session.createQuery(hql);
				query.setParameter("email_usr", email);
				query.executeUpdate();
				return null;
			}
		});

	}

	public void saveCreditCard(final CreditCard card) {
		new HibernateTemplate()
				.saveOrUpdateQuery(new HibernateDatabaseWriter() {

					public Object insertQuery() {

						return card;
					}
				});
	}

}
