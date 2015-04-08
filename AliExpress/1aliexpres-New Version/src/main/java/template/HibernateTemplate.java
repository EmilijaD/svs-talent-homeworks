package template;

import java.util.ArrayList;

import parser.Produkt;
import warehouse.dao.HibernateWarehouse;

public class HibernateTemplate {

	public void addProduct(ArrayList<Produkt> produkt) {
		HibernateWarehouse ht = new HibernateWarehouse();
		ht.addProduct(produkt);

	}

	public ArrayList<Produkt> listProducts() {
		HibernateWarehouse ht = new HibernateWarehouse();
		ArrayList<Produkt> results = ht.listProducts();

		return (ArrayList<Produkt>) results;

	}
}
