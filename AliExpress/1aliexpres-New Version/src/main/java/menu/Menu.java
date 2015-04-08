package menu;

import isklucok.NemaDovolnoKolicinaIsklucok;

import java.util.ArrayList;

import parser.ProductsParser;
import parser.Produkt;
import printer.ConsoleInput;
import printer.Printer;
import basket.ShopingBasketMethods;
import warehouse.dao.Warehouse;

public class Menu implements ManuCreator {
	ShopingBasketMethods basket;
	Warehouse warehouse;
	ProductsParser parser = new ProductsParser();
	private boolean stop = false;
	ConsoleInput consoleInput = new ConsoleInput();
	Display display = new Display();
	ArrayList<Produkt> lista = parser.parseFile();

	public Menu(ShopingBasketMethods basket, Warehouse warehouse) {

		this.basket = basket;
		this.warehouse = warehouse;
	}

	public void manuOptions() {
		Printer.print("1- Listanje na produktite");
		Printer.print("2- Dodadi produkt vo kosnickata");
		Printer.print("3- Naplakjanje");
		Printer.print("4- Vrati se nazad");
		Printer.print("5- Izlezi od aplikacijata");
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

	public void start() {
		while (!stop) {
			this.manuOptions();
			Printer.print("\n");
			switch (consoleInput.input().nextInt()) {
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
				display.run();
				break;
			case 5:
				Printer.print("kraj cao");
				stop = true;
				break;
			default:
				Printer.print("Nevalidna opcija!");
			}
		}
	}

}
