import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryWarehouse implements Warehouse {

	HashMap<String, Integer> mapa = new HashMap<String, Integer>();
	ArrayList<Produkt> produkti = new ArrayList<Produkt>();

	public void addProduct(ArrayList<Produkt> produkt) {
		this.produkti = produkt;

	}

	public ArrayList<Produkt> returnProducts() {
		return this.produkti;

	}

	public ArrayList<Produkt> listProducts() {
		ArrayList<Produkt> products = new ArrayList<Produkt>();
		for (int i = 0; i < produkti.size(); i++) {
			mapa.put(produkti.get(i).getName(), produkti.get(i).getPrice());
			Produkt product = new Produkt();
			product.setName(produkti.get(i).getName());
			product.setPrice(produkti.get(i).getPrice());
			products.add(product);

		}
		return produkti;

	}

}
