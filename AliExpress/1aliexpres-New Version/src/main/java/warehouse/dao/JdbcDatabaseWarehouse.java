package warehouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import parser.Produkt;
import databaseConnections.JDBConnection;

public class JdbcDatabaseWarehouse implements Warehouse {
	public void addProduct(ArrayList<Produkt> produkt) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBConnection.connection();
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
			Connection connection = JDBConnection.connection();
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
}
