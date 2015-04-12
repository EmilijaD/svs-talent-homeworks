package warehouse.dao;

import appMain.HibernateWarehouse;
import printer.Printer;

public class FactoryWarehouse {

	public static Warehouse warehouseFactory(int choise) {
		if (choise == 1) {
			Printer.print("In Memory Object");
			return new InMemoryWarehouse();

		}
		if (choise == 2) {
			Printer.print("JDBC object");
			return new JdbcDatabaseWarehouse();

		}
		if (choise == 3) {
			Printer.print("Hibernate object");
			return new HibernateWarehouse();

		} else {

			return null;
		}

	}

}
