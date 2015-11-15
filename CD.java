public class CD extends Audio {

	
	public CD(int sNo, double price, String audioName, String artistName, int quantityAvl){
		super(sNo, price, audioName, artistName, quantityAvl);
		this.type= "CD";
	}
//	public void changeQuantity (int change){
//		quantityAvl + change;
//	}
//
//	public int getQuantity() {
//		return quantityAvl;
//	}
//	
	public double getPrice(){
		return price*1.02;
	}// override to get the item price and add 2% (Environment Tax)


	public String getType(){
		return type;
	}
}