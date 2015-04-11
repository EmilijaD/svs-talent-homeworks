package accountManagement;

import java.util.List;

import entities.Account;
import entities.CreditCard;

public interface AccountMngmInterface {
	public void createAccount(Account account);

	public void updateAccount();

	public List<Account> returnAccount(String email);

	public void deleteAccount(String email);

	public void saveCreditCard(CreditCard card);
}
