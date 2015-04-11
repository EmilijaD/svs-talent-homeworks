package menu;

import isklucok.NemaDovolnoKolicinaIsklucok;

import java.util.ArrayList;

import entities.Produkt;
import parser.ProductsParser;
import printer.ConsoleInput;
import printer.Printer;
import warehouse.dao.Warehouse;
import accountManagement.AccountManagementImpl;
import basket.ShopingBasketMethods;

public class UI implements UiInterface {
	ShopingBasketMethods basket;
	Warehouse warehouse;
	public boolean stop = false;
	ProductsParser parser = new ProductsParser();
	ConsoleInput consoleInput = new ConsoleInput();
	Display display = new Display();
	ArrayList<Produkt> lista = parser.parseFile();
	AccountManagementImpl ami;
	UIAccount accountMenu = new UIAccount(ami);
	Menu amenu = new Menu(accountMenu.actions(), accountMenu);

	public UI(ShopingBasketMethods basket, Warehouse warehouse) {

		this.basket = basket;
		this.warehouse = warehouse;
	}

	public ArrayList<String> actions() {
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("Listanje na produktite");
		actions.add("Dodadi produkt vo kosnickata");
		actions.add("Naplakjanje");
		actions.add("Account Options");
		actions.add("Vrati se nazad");

		return actions;

	}

	public void listProducts() {

		System.out.println(warehouse.listProducts());

	}

	public void AddProductIntoBasket() throws NemaDovolnoKolicinaIsklucok {
		Printer.print("kolku produkti ke kupite");
		int broj = consoleInput.input().nextInt();
		if (broj != 0) {
			for (int i = 0; i < broj; i++) {
				Printer.print("Vnesi produkt");
				String produkt = consoleInput.input().next();
				if (!produkt.isEmpty()) {
					Printer.print("Vnesi kolicina");
					int kolicina = consoleInput.input().nextInt();
					for (int j = 0; j < lista.size(); j++) {

						if (lista.get(j).getQuantity() < kolicina) {
							throw new NemaDovolnoKolicinaIsklucok();
						}
					}
					Produkt prod = new Produkt();
					prod.setName(produkt);
					prod.setQuantity(kolicina);
					basket.AddProdukt(prod);
				}
			}
		}
		System.out.println(basket.listBucket());
	}

	public void payment() {
		Printer.print(basket.payment(lista) + " $");
	}

	public void processInput(int choise) {

		Printer.print("\n");
		switch (choise) {
		case 1:
			listProducts();
			break;
		case 2:
			try {
				AddProductIntoBasket();
			} catch (NemaDovolnoKolicinaIsklucok e) {
				e.printStackTrace();
			}
			break;
		case 3:
			payment();
			break;
		case 4:
			amenu.start();

			break;
		case 5:
			display.run();
			break;

		default:
			Printer.print("Nevalidna opcija!");
		}
	}

}
