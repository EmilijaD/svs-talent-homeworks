package warehouse;
import java.util.ArrayList;

import basketAndProduct.Produkt;


public interface Warehouse {

	public void addProduct(ArrayList<Produkt> produkt);
	public void listProducts();
	
	
}
