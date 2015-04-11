package parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entities.Produkt;

public class ProductsParser {

	public ArrayList<Produkt> parseFile() {

		BufferedReader reader = null;
		ArrayList<Produkt> prod = new ArrayList<Produkt>();
		try {
			File file = new File("src/main/resources/produkti.txt");
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
				Produkt produkt = new Produkt();
				produkt.setKey(kluc);
				produkt.setName(ime);
				produkt.setPrice(Integer.parseInt(cena));
				produkt.setQuantity(Integer.parseInt(kolicina));

				prod.add(produkt);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return prod;

	}

}
