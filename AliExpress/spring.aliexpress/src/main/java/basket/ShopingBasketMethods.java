package basket;

import java.util.ArrayList;
import java.util.List;

import appMain.Produkt;

public interface ShopingBasketMethods {

	public void AddProdukt(Produkt produkt);

	public int payment(ArrayList<Produkt> produkt);

	@SuppressWarnings("rawtypes")
	public List listBucket();

}
