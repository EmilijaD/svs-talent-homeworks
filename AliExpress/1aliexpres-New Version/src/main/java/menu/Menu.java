package menu;

import java.util.ArrayList;

import printer.ConsoleInput;
import printer.Printer;

public class Menu implements ManuCreator {

	private ArrayList<String> actions = new ArrayList<String>();
	private UiInterface ui;
	ConsoleInput choise = new ConsoleInput();
	boolean stop = true;

	public Menu(ArrayList<String> actions, UiInterface ui) {
		super();
		this.actions = actions;
		this.ui = ui;
		actions.add("Exit");
	}

	public void exit() {
		stop = false;
	}

	public void start() {
		while (stop) {
			int i = 1;

			for (String string : actions) {
				Printer.print(i + " - " + string);
				i++;
			}
			int exitNumber = actions.size();
			int myChoise = choise.input().nextInt();
			if (myChoise == exitNumber) {
				this.exit();
			} else {
				ui.processInput(myChoise);
			}
		}

	}

}
