package basketAndProduct;

import java.util.ArrayList;

import warehouse.InMemoryWarehouse;

public class ShoppingOptions implements ShopingBasketMethods {

	ArrayList<ShoppingBasket> kosnicka = new ArrayList<ShoppingBasket>();
	ShoppingBasket busket;
	InMemoryWarehouse warehouse = new InMemoryWarehouse();

	@Override
	public void AddQuantityShoppingBusket(String produkt, int quantity) {
		
		busket = new ShoppingBasket(produkt, quantity);
		kosnicka.add(busket);

	}

	@Override
	public int payment(ArrayList<Produkt> produkti) {
		int sum = 0;
		for (int i = 0; i < kosnicka.size(); i++) {
			System.out.println(kosnicka.get(i).getProdukt());
			for (int j = 0; j < produkti.size(); j++) {

				if (kosnicka.get(i).getProdukt()
						.contains(produkti.get(j).getName())) {
					sum += kosnicka.get(i).getQuantity()
							* produkti.get(j).getPrice();
				}

			}
		}
		return sum;
	}

}
