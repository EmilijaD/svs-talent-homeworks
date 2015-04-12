package menu;

import java.util.ArrayList;

import factory.FactoryLibrary;
import printer.ConsoleInput;
import printer.Printer;
import template.DaoIterface;

public class Display {

	ConsoleInput consoleInput = new ConsoleInput();

	public void run() {
		Printer.print("Choose the technique: ");
		Printer.print("1 for In memory");
		Printer.print("2 for JDBC");
		Printer.print("3 for hibernate");
		int choiseTechnique = consoleInput.input().nextInt();
		DaoIterface libraryObject = FactoryLibrary
				.libraryFactory(choiseTechnique);

		Ui ui = new Ui(libraryObject);
		ArrayList<String> actions = ui.actions();
		Menu menu = new Menu(actions, ui);
		menu.start();
	}

}
