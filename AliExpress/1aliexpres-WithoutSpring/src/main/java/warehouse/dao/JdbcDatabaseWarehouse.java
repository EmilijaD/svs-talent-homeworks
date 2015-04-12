package warehouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Produkt;
import template.JDBCTemplate;
import template.JdbcDatabaseReader;
import template.JdbcDatabaseWriter;

public class JdbcDatabaseWarehouse implements Warehouse {
	public void addProduct(final Produkt produkt) {
		new JDBCTemplate().insertQuery(new JdbcDatabaseWriter() {

			public void insertQuery(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = null;
				preparedStatement = connection
						.prepareStatement("insert into product (key, name,price,quantity) values (?, ?, ?, ?)");

				preparedStatement.setString(1, produkt.getKey());
				preparedStatement.setString(2, produkt.getName());
				preparedStatement.setInt(3, produkt.getPrice());
				preparedStatement.setInt(4, produkt.getQuantity());
				preparedStatement.addBatch();
				preparedStatement.execute();

			}
		});

	}

	public ArrayList<Produkt> listProducts() {

		return new JDBCTemplate().returnQuery(new JdbcDatabaseReader() {

			@SuppressWarnings("unchecked")
			public List<Produkt> returnQuery(Connection connection)
					throws SQLException {
				ArrayList<Produkt> products = new ArrayList<Produkt>();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM product");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Produkt prod = new Produkt();
					prod.setKey(resultSet.getString("key"));
					prod.setName(resultSet.getString("name"));
					prod.setPrice(resultSet.getInt("price"));
					prod.setQuantity(resultSet.getInt("quantity"));
					products.add(prod);
				}
				preparedStatement.close();
				return products;
			}
		});

	}

}
