package basket;

import java.util.ArrayList;

import warehouse.Produkt;

public interface ShopingBasketMethods {

	public void AddQuantityShoppingBusket(String produkt, int quantity);

	public int payment(ArrayList<Produkt> produkt);
}
