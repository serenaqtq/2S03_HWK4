/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the object MP3.
*/
public class MP3 extends Audio{//public class

	public MP3(int sNo, double price, String audioName, String artistName, int quantityAvl){//constructor
		super(sNo, price, audioName, artistName, quantityAvl);//call the parent constructor
		this.type="MP3";//set type
	}
	
	public double getPrice(){//Overwrite getPrice()
		return super.getPrice();// get base price from super class
	}

	public String getType(){//Overwrite getType()
		return type;//return type as a string
	}

}
