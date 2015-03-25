import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import warehouse.InMemoryWarehouse;
import basketAndProduct.Produkt;
import basketAndProduct.ShoppingOptions;

public class ParserAndUI {
	public void readAndParse(String fileName) throws IOException,
			NemaDovolnoKolicinaIsklucok {
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = null;
		InMemoryWarehouse magacin = new InMemoryWarehouse();
		ShoppingOptions shopping = new ShoppingOptions();
		ArrayList<Produkt> prod = new ArrayList<Produkt>();
		try {
			File file = new File(fileName);
			reader = new BufferedReader(new FileReader(file));
			String line;
			String kluc = null;
			String ime = null;
			String cena = null;
			String kolicina = null;

			while ((line = reader.readLine()) != null) {

				String[] niza = line.split("/");
				for (int i = 0; i < niza.length; i++) {
					kluc = niza[0];
					ime = niza[1];
					cena = niza[2];
					kolicina = niza[3];
				}
				prod.add(new Produkt(kluc, ime, Integer.parseInt(cena), Integer
						.parseInt(kolicina)));

			}

			magacin.addProduct(prod);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();

		}

		System.out.println("Odberete edna od slednive opcii:");
		System.out.println("1 za listanje na prosuktite");
		System.out
				.println("2 za dodavanje produkt i kolicina pa prodolzuvanje so plakjanje");
		while (scanner.hasNext()) {
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				magacin.listProducts();
				break;
			case 2:
				System.out.println("kolku produkti ke kupite");
				int broj = scanner.nextInt();
				if (broj != 0) {
					for (int i = 0; i < broj; i++) {

						System.out.println("Vnesi produkt");
						String produkt = scanner.next();

						if (!produkt.isEmpty()) {
							System.out.println("Vnesi kolicina");

							int kolicina = scanner.nextInt();

							for (int j = 0; j < prod.size(); j++) {

								if (prod.get(j).getName()
										.equalsIgnoreCase(produkt)) {
									if (prod.get(j).getQuantity() < kolicina) {
										throw new NemaDovolnoKolicinaIsklucok();
									} else {
										shopping.AddQuantityShoppingBusket(
												produkt, kolicina);
									}
								}

							}

						}
					}
					System.out.println(shopping.payment(magacin
							.returnProducts()) + "$");
				}
				break;

			default:
				System.out.println("Pogresna opcija");
				break;
			}

		}
		scanner.close();
	}

}
