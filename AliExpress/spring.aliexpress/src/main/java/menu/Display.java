package menu;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import basket.ShopingBasketMethods;
import basket.ShoppingBasketOptions;
import printer.ConsoleInput;
import printer.Printer;
import warehouse.dao.FactoryWarehouse;
import warehouse.dao.Warehouse;
@Component
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
		UI ui = new UI(basket, warehouse);
		ArrayList<String> actions = ui.actions();
		Menu menu = new Menu(actions, ui);
		menu.start();
	}

}
