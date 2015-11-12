public class MP3s extends Audio{ 

	public MP3s(int sNo, double price, String audioName, String artistName, int quantityAvl){
		super(sNo, price, audioName, artistName, quantityAvl);
		this.type="MP3";
	}
	
	public int changeQuantity (int change){
		return quantityAvl - change;
	}

	public double getPrice(){
		return super.getPrice();
	}// get base price from super class

	public String getType(){
		return type;
	}

}
