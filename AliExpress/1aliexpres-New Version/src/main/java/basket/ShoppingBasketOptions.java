package basket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import entities.Produkt;
@Service
public class ShoppingBasketOptions implements ShopingBasketMethods {

	ArrayList<ShoppingBasket> kosnicka = new ArrayList<ShoppingBasket>();
	ShoppingBasket busket;

	public void AddProdukt(Produkt produkt) {

		busket = new ShoppingBasket(produkt.getName(), produkt.getQuantity());
		kosnicka.add(busket);

	}

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

	@SuppressWarnings("rawtypes")
	public List listBucket() {

		return kosnicka;
	}

}
