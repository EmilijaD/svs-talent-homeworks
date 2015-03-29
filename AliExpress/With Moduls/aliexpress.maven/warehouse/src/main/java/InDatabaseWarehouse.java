import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InDatabaseWarehouse implements Warehouse {

	public void addProduct(ArrayList<Produkt> produkt) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres",
				"postgres");
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into product (key, name,price,quantity) values (?, ?, ?, ?)");

		for (int i = 0; i < produkt.size(); i++) {

			preparedStatement.setString(1, produkt.get(i).getKey());
			preparedStatement.setString(2, produkt.get(i).getName());
			preparedStatement.setInt(3, produkt.get(i).getPrice());
			preparedStatement.setInt(4, produkt.get(i).getQuantity());
			preparedStatement.addBatch();
		}

		if (preparedStatement.executeBatch() != null) {
			System.out.println("Success!");
		} else {
			System.out.println("Not Successful execution!");
		}

		preparedStatement.close();

	}

	public void listProducts() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres",
				"postgres");

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from product");
		while (resultSet.next()) {
			String key = resultSet.getString("key");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			int quantity = resultSet.getInt("quantity");
			System.out.println(key);
			System.out.println(name);
			System.out.println(price);
			System.out.println(quantity);

		}
		statement.close();

	}

	// Just for testing purposes :)
	public static void main(String[] args) throws SQLException {

		ArrayList<Produkt> test = new ArrayList<Produkt>();
		Produkt produkt1 = new Produkt("kluc1", "cokolado", 50, 10);
		Produkt produkt2 = new Produkt("kluc2", "smoki", 20, 23);
		Produkt produkt3 = new Produkt("kluc3", "kafe", 40, 50);
		Produkt produkt4 = new Produkt("kluc4", "pizza", 320, 4);
		test.add(produkt1);
		test.add(produkt2);
		test.add(produkt3);
		test.add(produkt4);

		InDatabaseWarehouse data = new InDatabaseWarehouse();
		// data.addProduct(test);
		data.listProducts();

	}

}
