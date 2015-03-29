package basket;

public class ShoppingBasket {

	String produkt;
	int quantity;

	public ShoppingBasket(String produkt, int quantity) {
		this.produkt = produkt;
		this.quantity = quantity;
	}

	public ShoppingBasket() {
		super();
	}

	public String getProdukt() {
		return produkt;
	}

	public void setProdukt(String produkt) {
		this.produkt = produkt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ShoppingBasket [produkt=" + produkt + ", quantity=" + quantity
				+ "]";
	}

}
