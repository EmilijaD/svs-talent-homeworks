package warehouse.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import entities.Produkt;
@Service
public interface Warehouse {

	public void addProduct(Produkt produkt);

	public ArrayList<Produkt> listProducts();

}
