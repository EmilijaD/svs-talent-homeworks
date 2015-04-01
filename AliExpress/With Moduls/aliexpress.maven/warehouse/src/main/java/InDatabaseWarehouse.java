import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InDatabaseWarehouse implements Warehouse {

	public void addProduct(ArrayList<Produkt> produkt) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/library", "postgres",
					"postgres");
			preparedStatement = connection
					.prepareStatement("insert into product (key, name,price,quantity) values (?, ?, ?, ?)");

			for (int i = 0; i < produkt.size(); i++) {

				preparedStatement.setString(1, produkt.get(i).getKey());
				preparedStatement.setString(2, produkt.get(i).getName());
				preparedStatement.setInt(3, produkt.get(i).getPrice());
				preparedStatement.setInt(4, produkt.get(i).getQuantity());
				preparedStatement.addBatch();
			}

		} catch (Exception e) {

		} finally {

			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Produkt> listProducts() {

		Statement statement = null;
		ArrayList<Produkt> products = new ArrayList<Produkt>();
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/library", "postgres",
					"postgres");

			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from product");
			while (resultSet.next()) {
				String key = resultSet.getString("key");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				int quantity = resultSet.getInt("quantity");
				Produkt produkt = new Produkt();
				produkt.setKey(key);
				produkt.setName(name);
				produkt.setPrice(price);
				produkt.setQuantity(quantity);
				products.add(produkt);

			}
		} catch (Exception e) {

		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;

	}

	// Just for testing purposes :)
	public static void main(String[] args) throws SQLException {

		ArrayList<Produkt> test = new ArrayList<Produkt>();
		Produkt produkt1 = new Produkt();
		produkt1.setKey("kluc1");
		produkt1.setName("cokolado");
		produkt1.setPrice(50);
		produkt1.setQuantity(10);
		Produkt produkt2 = new Produkt();
		produkt2.setKey("kluc2");
		produkt2.setName("smoki");
		produkt2.setPrice(20);
		produkt2.setQuantity(23);
		Produkt produkt3 = new Produkt();
		produkt3.setKey("kluc3");
		produkt3.setName("kafe");
		produkt3.setPrice(40);
		produkt3.setQuantity(50);
		Produkt produkt4 = new Produkt();
		produkt4.setKey("kluc4");
		produkt4.setName("pizza");
		produkt4.setPrice(320);
		produkt4.setQuantity(4);
		test.add(produkt1);
		test.add(produkt2);
		test.add(produkt3);
		test.add(produkt4);

		InDatabaseWarehouse data = new InDatabaseWarehouse();
		// data.addProduct(test);
		System.out.println(data.listProducts());

	}

}
