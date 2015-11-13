
public class Book extends Readable {

	public Book(int sNo, double price, String bookName, String authorName, int quantityAvl) {
		super(sNo, price, bookName, authorName, quantityAvl);
		this.type = "Book";
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price * 1.02;
		// override to get the item price and add 2% (Environmental Tax)
	}
}