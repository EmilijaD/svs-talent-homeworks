package aliExpress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AliExpress {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = null;
		Warehouse magacin = null;
		ArrayList<Produkti> prod = new ArrayList<Produkti>();
		try {
			File file = new File("produkti.txt");
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
				prod.add(new Produkti(kluc, ime, Integer.parseInt(cena),
						Integer.parseInt(kolicina)));

			}

			magacin = new Warehouse(prod);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}

		System.out.println("Odberete edna od slednive opcii:");
		System.out.println("1 za listanje na prosuktite");
		System.out
				.println("2 za dodavanje produkt i kolicina pa prodolzuvanje so plakjanje");

		int option = scanner.nextInt();

		switch (option) {
		case 1:
			magacin.ListAllProducts();
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
						magacin.AddQuantityShoppingBusket(produkt, kolicina);
					}
				}
				System.out.println(magacin.payment()+ "$");
			}
			break;

		default:
			System.out.println("Pogresna opcija");
			break;
		}
	}

}
