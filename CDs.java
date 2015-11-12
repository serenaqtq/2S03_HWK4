public class CDs extends Audio {

	
	public CDs(int sNo, double price, String audioName, String artistName, int quantityAvl){
		super(sNo, price, audioName, artistName, quantityAvl);
		this.type= "CD";
	}
	public int changeQuantity (int change){
		return quantityAvl - change;
	}

	public double getPrice(){
		return price*1.02;
	}// override to get the item price and add 2% (Environment Tax)


	public String getType(){
		return type;
	}
}