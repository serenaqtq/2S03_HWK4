

public class Readable extends Item {
	protected String bookName;
	protected String authorName;
	protected String type;

	public Readable(int sNo, double price, String bookName, String authorName, int quantityAvl) {
		super();
		this.price=price;
		this.sNo = sNo;
		this.quantityAvl = quantityAvl;
		this.bookName = bookName;
		this.authorName = authorName;
		//this.type = type;
	}

	public String getInfo (){
		String bookInfo = Integer.toString(sNo) +", " + Double.toString(price)+ ", " + bookName + ", " + authorName  + ", " + Integer.toString(quantityAvl);
		return bookInfo;
	} //Returns sNo, Name, Author name etc in a string @ override
	
	public double getPrice() {
		return price;
	} // override ...}
	
	public int getQuantity() {
		return quantityAvl;
	} // override ...}
	
	public int changeQuantity(int change) {
		return quantityAvl + change;
	}

	public int getsNo(){
		return sNo;
	}
	
	public String getTitle(){
		return bookName;
	}
	
	public String getAuthorName(){
		return authorName;
	}
	}
