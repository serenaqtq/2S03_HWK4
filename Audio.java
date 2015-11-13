public class Audio extends Item {
	protected String artistName;
	protected String audioName;
	protected String type;
	
	public Audio(int sNo, double price, String audioName, String artistName, int quantityAvl){//constructor
		super();
		this.price=price;
		this.sNo=sNo;
		this.quantityAvl=quantityAvl;
		this.artistName=artistName;
		this.audioName=audioName;
	}

	public String getInfo(){
		String bookInfo = Integer.toString(sNo) +", " + Double.toString(price)+ ", " + audioName + ", " + artistName  + ", " + Integer.toString(quantityAvl);
		return bookInfo;
	} //Returns sNo, Name, Artist name, etc in a string

	public int getsNo(){
		return sNo;
	}

	public int getQuantity(){
		return quantityAvl;
	}

	public String getTitle(){
		return audioName;
	}

	public double getPrice(){
		return price;
	} // override

	public String getArtistName(){
		return artistName;
	}


}
