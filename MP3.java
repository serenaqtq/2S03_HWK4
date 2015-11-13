public class MP3 extends Audio{ 

	public MP3(int sNo, double price, String audioName, String artistName, int quantityAvl){
		super(sNo, price, audioName, artistName, quantityAvl);
		this.type="MP3";
	}
	
<<<<<<< HEAD:MP3s.java
=======
	public int changeQuantity (int change){
		return quantityAvl + change;
	}

>>>>>>> origin/master:MP3.java
	public double getPrice(){
		return super.getPrice();
	}// get base price from super class

	public String getType(){
		return type;
	}

}
