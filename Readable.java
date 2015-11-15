

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
		String bookInfo = Integer.toString(sNo) +", " + bookName + ", " + authorName + ", "+ Double.toString(price)+ ", " + Integer.toString(quantityAvl) + ", " + getType();
		return bookInfo;
	} //Returns sNo, Name, Author name etc in a string @ override
	
	public double getPrice() {
		return price;
	} // override ...}
	
	public int getQuantity() {
		return quantityAvl;
	} // override ...}
	

	public void changeQuantity(int change) {
		quantityAvl -= change;
	}
	
	public void changeQuantityC(int num) {
		quantityAvl = num;
	}
	
	public int getsNo(){
		return sNo;
	}
	
	public String getType() {
		return type;
	}
	
	public String getTitle(){
		return bookName;
	}
	
	public String getAuthorName(){
		return authorName;
	}
	}
