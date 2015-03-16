package aliExpress;

public class Produkti {

	String key;
	String name;
	int price;
	int quantity;

	public Produkti(String key, String name, int price, int quantity) {
		super();
		this.key = key;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return " key=" + key + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity;
	}

}
