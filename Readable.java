/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the object CD.
*/
public class Readable extends Item {//public class
	protected String bookName;//string name
	protected String authorName;//string name
	protected String type;//string type

	public Readable(int sNo, double price, String bookName, String authorName, int quantityAvl) {//constructor
		super();//call parent constructor
		this.price = price;//set price
		this.sNo = sNo;//set sNo
		this.quantityAvl = quantityAvl;//set quantity
		this.bookName = bookName;//set name
		this.authorName = authorName;//set name
	}

	public String getInfo (){//Returns sNo, Name, Author name etc in a string @ override
		String bookInfo = Integer.toString(sNo) +", " + bookName + ", " + authorName + ", "+ Double.toString(price)+ ", " + Integer.toString(quantityAvl) + ", " + getType();//set string
		return bookInfo;//return string
	} 
	
	public double getPrice() {//return price
		return price;//return as a double
	} // override ...}
	
	public int getQuantity() {//return quantity
		return quantityAvl;//return as a int
	} // override ...}
	

	public void changeQuantity(int change) {//change quantity
		quantityAvl -= change;
	}
	
	public void changeQuantityC(int num) {//change quantity for shoppingcart
		quantityAvl = num;
	}
	
	public int getsNo(){//return sNo
		return sNo;//return as a int
	}
	
	public String getType() {//return type
		return type;//return as a string
	}
	
	public String getTitle(){//return title
		return bookName;//return as a string
	}
	
	public String getAuthorName(){//return name
		return authorName;//return as a string
	}
	}
