package aliExpress;

import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse {

	ArrayList<Produkti> produkti;
	ArrayList<ShoppingBasket> kosnicka = new ArrayList<ShoppingBasket>();
	ShoppingBasket busket;
	public Warehouse(ArrayList<Produkti> produkti) {
		super();
		this.produkti = produkti;
		
	}

	public void ListAllProducts() {

		for (int i = 0; i < produkti.size(); i++) {
			mapa.put(produkti.get(i).getName(), produkti.get(i).getPrice());
			System.out.println(produkti.get(i).getName() + " "
					+ produkti.get(i).getPrice() + "$");
			
		}

	}

	public void AddQuantityShoppingBusket(String produkt, int quantity) {
	 busket = new ShoppingBasket(produkt, quantity);
		kosnicka.add(busket);
	}
	
	public int payment ()
	{
		int sum=0;
		for (int i = 0; i < kosnicka.size(); i++) {
			System.out.println(kosnicka.get(i).getProdukt());
			for (int j = 0; j < produkti.size(); j++) {
		        if(kosnicka.get(i).getProdukt().contains(produkti.get(j).getName()))
		        {
		        	sum+=kosnicka.get(i).getQuantity()* produkti.get(j).getPrice();
		        }
		     
		    
			
		}}
		return sum;
	}

}
