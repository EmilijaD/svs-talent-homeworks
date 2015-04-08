package basket;

import java.util.ArrayList;
import java.util.List;

import parser.Produkt;

public interface ShopingBasketMethods {

	public void AddProdukt(Produkt produkt);

	public int payment(ArrayList<Produkt> produkt);

	@SuppressWarnings("rawtypes")
	public List listBucket();

}
