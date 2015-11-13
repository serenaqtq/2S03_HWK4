
public class eBook extends Readable {

	public eBook(int sNo, double price, String bookName, String authorName, int quantityAvl) {
		super(sNo, price, bookName, authorName, quantityAvl);
		this.type = "eBook";
	}

	public String getType() {
		return type;
	}

	public int changeQuantity(int change) {
		return quantityAvl + change;
	}

	public double getPrice() {
		return price;

	}
}
