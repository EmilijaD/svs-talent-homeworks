package menu;

import java.util.ArrayList;

import dao.Book;
import printer.ConsoleInput;
import printer.Printer;
import template.DaoIterface;

public class Ui implements UiInterface {

	private DaoIterface daoLibrary;
	Display display = new Display();
	ConsoleInput consoleInput = new ConsoleInput();

	public Ui(DaoIterface daoLibrary) {
		super();
		this.daoLibrary = daoLibrary;
	}

	public ArrayList<String> actions() {
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("Listanje na registrirani knigi ");
		actions.add("Registriraj kniga");
		actions.add("Odregistriraj kniga");
		actions.add("Azuriraj kniga");
		actions.add("Vrati se nazad");

		return actions;
	}

	public void listRegisteredBook() {

		System.out.println(daoLibrary.listregisteredBooks());

	}

	public void registerBook() {
		Printer.print("Vnesi isbn");
		String isbn = consoleInput.input().next();
		Printer.print("Vnesi naslov");
		String title = consoleInput.input().next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		daoLibrary.registerBook(book);

	}

	public void unregisterBook() {
		Printer.print("Vnesi go isbn na knigata");
		String isbn = consoleInput.input().next();
		daoLibrary.unregisterBook(isbn);

	}

	public void updateBook() {
		Printer.print("Vnesi go isbn na knigata");
		String oldIsbn = consoleInput.input().next();
		Printer.print("Vnesi go noviot isbn");
		String newIsbn = consoleInput.input().next();
		Printer.print("Vnesi go noviot naslov");
		String newTitle = consoleInput.input().next();
		daoLibrary.updateBook(oldIsbn, newIsbn, newTitle);
	}

	public void processInput(int choise) {
		switch (choise) {
		case 1:
			this.listRegisteredBook();
			break;
		case 2:
			this.registerBook();
			break;
		case 3:
			this.unregisterBook();
			break;
		case 4:
			this.updateBook();
			break;
		case 5:
			display.run();
			break;

		default:
			Printer.print("Nevalidna opcija");
			break;
		}

	}

}
