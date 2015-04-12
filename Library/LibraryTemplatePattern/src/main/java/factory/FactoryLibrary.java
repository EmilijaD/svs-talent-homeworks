package factory;

import printer.Printer;
import template.DaoIterface;

public class FactoryLibrary {

	public static DaoIterface libraryFactory(int choise) {
		if (choise == 1) {
			Printer.print("In Memory Object");
			return new InMemoryLibrary();

		}
		if (choise == 2) {
			Printer.print("JDBC object");
			return new JDBCDbOptions();

		}
		if (choise == 3) {
			Printer.print("Hibernate object");
			return new HibernateDbOperations();

		} else {

			return null;
		}

	}

}
