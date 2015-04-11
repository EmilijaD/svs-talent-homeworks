package menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Account;
import entities.CreditCard;
import accountManagement.AccountManagementImpl;
import printer.ConsoleInput;
import printer.Printer;

public class UIAccount implements UiInterface {

	Display display = new Display();
	ConsoleInput consoleInput = new ConsoleInput();
	AccountManagementImpl ams;

	public UIAccount(AccountManagementImpl ams) {
		super();
		this.ams = ams;
	}

	public ArrayList<String> actions() {
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("Create Account");
		actions.add("Delete Account");
		actions.add("Update Account");
		actions.add("Return info about account");

		return actions;
	}

	public void deleteAccount() {
		Printer.print("Brisenje na Account");
		Printer.print("Vnesi mail..");
		String email = consoleInput.input().next();
		ams.deleteAccount(email);

	}

	public void createAccount() {
		Printer.print("Kreiranje na Account");
		Printer.print("Vnesi kreditna karticka .....");
		Printer.print("Vnesi tip na karticka , Broj na karticka, CRCcode, vnesi balans, vnesi data na istekuvanje year/month/day");
		// info za kreditna
		String tip = consoleInput.input().next();
		Long broj = consoleInput.input().nextLong();
		int crc = consoleInput.input().nextInt();
		float balans = consoleInput.input().nextFloat();
		int year = consoleInput.input().nextInt();
		int month = consoleInput.input().nextInt();
		int day = consoleInput.input().nextInt();
		@SuppressWarnings("deprecation")
		Date data = new Date(year, month, day);
		CreditCard cc = new CreditCard();
		cc.setCardNumber(broj);
		cc.setCardtype(tip);
		cc.setCRCcode(crc);
		cc.setCurrentBalance(balans);
		cc.setExpirationDate(data);
		ams.saveCreditCard(cc);

		Printer.print("Vnesi podatoci za accountot, ");
		String name = consoleInput.input().next();
		String surname = consoleInput.input().next();
		String email = consoleInput.input().next();
		String password = consoleInput.input().next();
		Account account = new Account();
		account.setUserName(name);
		account.setUserSurname(surname);
		account.setEmail(email);
		account.setPassword(password);
		account.setCreditCard(cc);
		ams.createAccount(account);

	}

	public void returnInfoAccount() {
		Printer.print("Vnesete go vasiot email");
		String email = consoleInput.input().next();
		List<Account> list = ams.returnAccount(email);
		System.out.println(list);
	}

	public void processInput(int choise) {
		Printer.print("\n");
		switch (choise) {
		case 1:
			this.createAccount();
			break;
		case 2:
			this.deleteAccount();
			break;
		case 3:

			break;
		case 4:
			this.returnInfoAccount();
			break;
		case 5:
			display.run();
			break;

		default:
			Printer.print("Nevalidna opcija!");
		}

	}

}
