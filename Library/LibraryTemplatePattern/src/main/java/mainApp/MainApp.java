package mainApp;

import menu.Display;
import factory.HibernateDbOperations;

public class MainApp {

	public static void main(String[] args) {

		Display display = new Display();
		display.run();

	}

}
