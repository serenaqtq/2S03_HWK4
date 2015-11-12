public abstract class Item {
	
	public abstract String getInfo();

	public abstract double getPrice();

	public abstract int getsNo();

	public abstract int getQuantity();

	public abstract String getAuthorName();

	public abstract String getTitle();
	
	//public abstract String getType();

	protected double price;
	protected int sNo;
	protected int quantityAvl;

//	public static void main(String[] args) {
//		Readable book1 = new Readable(1, 2, "H", "A", 100);
//		Book book2 = new Book(1, 2, "H", "A", 100);
//		eBook book3 = new eBook(1, 2, "H", "A", 100);
//		System.out.println(
//				"Readable: " + book1.getPrice() + " Book: " + book2.getPrice() + " eBook: " + book3.getPrice());
//		System.out.println("Readable: " + book1.getInfo() + " Book: " + book2.getInfo() + " eBook: " + book3.getInfo());
//		System.out.println("Readable: " + book1.getsNo() + " Book: " + book2.getsNo() + " eBook: " + book3.getsNo());
//		System.out.println("Readable: " + book1.getQuantity() + " Book: " + book2.getQuantity() + " eBook: "
//				+ book3.getQuantity());
//		System.out.println("Readable: " + book1.getAuthorName() + " Book: " + book2.getAuthorName() + " eBook: "
//				+ book3.getAuthorName());
//		System.out.println(" Book:" + book2.getType() + " eBook:" + book3.getType());
//		System.out.println("Readable:" + " " + book1.getBookName() + " Book: " + book2.getBookName() + " eBook: "
//				+ book3.getBookName());
//	}

}
