/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the object CD.
*/
public class CD extends Audio {//create class CD

	
	public CD(int sNo, double price, String audioName, String artistName, int quantityAvl){//constructor
		super(sNo, price, audioName, artistName, quantityAvl);//call parent constructor
		this.type = "CD";//set type
	}

	public double getPrice(){//retunr price
		return price*1.02;// override to get the item price and add 2% (Environment Tax)
	}


	public String getType(){//return type
		return type;//return as a string
	}
}