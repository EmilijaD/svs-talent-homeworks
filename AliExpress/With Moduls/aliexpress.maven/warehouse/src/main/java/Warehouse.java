
import java.sql.SQLException;
import java.util.ArrayList;


public interface Warehouse {

	public void addProduct(ArrayList<Produkt> produkt) throws SQLException;

	public void listProducts() throws SQLException;
	
	
}
