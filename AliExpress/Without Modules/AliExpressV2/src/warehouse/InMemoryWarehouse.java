package warehouse;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryWarehouse implements Warehouse {

	HashMap<String, Integer> mapa = new HashMap<String, Integer>();
	ArrayList<Produkt> produkti = new ArrayList<Produkt>();

	@Override
	public void addProduct(ArrayList<Produkt> produkt) {
		this.produkti = produkt;

	}

	public ArrayList<Produkt> returnProducts() {
		return this.produkti;

	}

	@Override
	public void listProducts() {
		for (int i = 0; i < produkti.size(); i++) {
			mapa.put(produkti.get(i).getName(), produkti.get(i).getPrice());
			System.out.println(produkti.get(i).getName() + " "
					+ produkti.get(i).getPrice() + "$");

		}

	}

}
