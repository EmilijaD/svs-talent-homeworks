package menu;

import basket.ShopingBasketMethods;
import basket.ShoppingBasketOptions;
import printer.ConsoleInput;
import printer.Printer;
import warehouse.dao.FactoryWarehouse;
import warehouse.dao.Warehouse;

public class Display {

	ConsoleInput consoleInput = new ConsoleInput();

	public void run() {
		Printer.print("Choose the technique: ");
		Printer.print("1 for In memory");
		Printer.print("2 for JDBC");
		Printer.print("3 for hibernate");
		int choiseTechnique = consoleInput.input().nextInt();
		Warehouse warehouse = FactoryWarehouse
				.warehouseFactory(choiseTechnique);
		ShopingBasketMethods basket = new ShoppingBasketOptions();
		Menu manu = new Menu(basket, warehouse);
		manu.start();
	}

}
