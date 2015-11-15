
public class eBook extends Readable {

	public eBook(int sNo, double price, String bookName, String authorName, int quantityAvl) {
		super(sNo, price, bookName, authorName, quantityAvl);
		this.type = "eBook";
	}

	public String getType() {
		return type;
	}
	
//	public int getQuantity() {
//		return quantityAvl;
//	}

//	public void changeQuantity(int change) {
//		quantityAvl -= change;
//	}

	public double getPrice() {
		return price;

	}
}
