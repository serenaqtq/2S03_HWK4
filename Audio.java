/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the object Audio.
*/
public class Audio extends Item {//public class
	protected String artistName;//string name
	protected String audioName;//string name
	protected String type;//string type
	
	public Audio(int sNo, double price, String audioName, String artistName, int quantityAvl){//constructor
		super();//call parent constructor
		this.price = price;//set price
		this.sNo = sNo;//set sNo
		this.quantityAvl = quantityAvl;//set quantity
		this.artistName = artistName;//set name
		this.audioName = audioName;//set name
	}

	public String getInfo(){//Returns sNo, Name, Artist name, etc in a string
		String bookInfo = Integer.toString(sNo) +", " + audioName + ", " + artistName + ", " + Double.toString(price) + ", "+  Integer.toString(quantityAvl) + ", " + getType();//set string 
		return bookInfo;//return the string
	} 

	public int getsNo(){//return sNo
		return sNo;//return as a int
	}

	public int getQuantity(){//return quantity
		return quantityAvl;//retunr as a int
	}
	
	public void changeQuantity(int change) {//changeQuantity
		quantityAvl -= change;//decrement quantity
	}

	public int changeQuantityC(int num) {//change quantity for shoppingcart
		return quantityAvl = num;//set quantity to the given int 
	}
	
	public String getTitle(){//return title
		return audioName;//return as a string
	}
	
	public String getType() {//return type
		return type;//return as a string
	}

	public double getPrice(){//return price
		return price;//return as a double
	} // override

	public String getAuthorName(){//return name
		return artistName;//return as a string
	}


}

