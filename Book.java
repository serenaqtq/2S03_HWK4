/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the object CD.
*/
public class Book extends Readable {//public class

	public Book(int sNo, double price, String bookName, String authorName, int quantityAvl) {//constructor
		super(sNo, price, bookName, authorName, quantityAvl);//call parent constructor
		this.type = "Book";//set type
	}

	public String getType() {//return type
		return type;//return as a string
	}

	public double getPrice() {// override to get the item price and add 2% (Environmental Tax)
		return price * 1.02;//return as a double
		
	}
}