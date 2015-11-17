/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the object CD.
*/
public class eBook extends Readable {//public class

	public eBook(int sNo, double price, String bookName, String authorName, int quantityAvl) {//constructor
		super(sNo, price, bookName, authorName, quantityAvl);//call parent constructor
		this.type = "eBook";//set type
	}

	public String getType() {//return type
		return type;//return as a string
	}
	

	public double getPrice() {
		return price;//return as a double

	}
}
