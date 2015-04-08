package template;

import java.util.ArrayList;

import parser.Produkt;
import warehouse.dao.JdbcDatabaseWarehouse;

public class JDBCTemplate {

	public void addProduct(ArrayList<Produkt> produkt) {
		JdbcDatabaseWarehouse jt = new JdbcDatabaseWarehouse();
		jt.addProduct(produkt);
	}

	public ArrayList<Produkt> listProducts() {
		JdbcDatabaseWarehouse jt = new JdbcDatabaseWarehouse();
		ArrayList<Produkt> results = jt.listProducts();
		return results;
	}

}
