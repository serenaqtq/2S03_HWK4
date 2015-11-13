/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the shopping cart for each user
*/
import java.io.BufferedReader;//import BufferedReader
import java.io.BufferedWriter;//import BufferedWriter
import java.io.File;
import java.io.FileNotFoundException;//import FileNotFoundException
import java.io.FileReader;//import FileReader
import java.io.FileWriter;//import FileWriter
import java.io.IOException;//import IOException
import java.util.ArrayList;//import ArrayList
import java.util.Date;//Import Date Function
import java.text.DateFormat;//Import DateFormat
import java.text.SimpleDateFormat;//Import SimpleDateFormat

//Question, in the readable and audio text files, does an item still exist if it has 0 quantity? If it doesn't, how do we find the type of an item in the shopping cart if it's sold out?

public class ShoppingCart extends User{//public ShoopingCart
	
	private ArrayList<Readable> contentR = new ArrayList<Readable>();
	private ArrayList<Audio> contentA = new ArrayList<Audio>();
	
	private ArrayList<Book> b1 = new ArrayList<Book>();
	private ArrayList<MP3> m1 = new ArrayList<MP3>();
	private ArrayList<eBook> e1 = new ArrayList<eBook>();
	private ArrayList<CD> c1 = new ArrayList<CD>();
	private String temp1;
	
	public ShoppingCart(String name){//Constructor which take in a string as user name
		
		super(name);//call parent's constructor
		
		try {//try-catch structure to catch ant error
			BufferedReader input = new BufferedReader(new FileReader("Cart_" + this.getUsername() + ".txt"));//read in file
			
			String line = null;//define a string to store each line of the file
			while ((line = input.readLine()) != null) {//while loop to loop thorough the file
				String[] temp = line.split(", ");
				int quan = Integer.parseInt(temp[3]);
				temp1 = checkType(temp[1]);
				
				if (temp1.equals("Book")) {
					contentR.add(stringToBook(temp1, quan));
				}
				
				if (temp1.equals("eBook")) {
					contentR.add(stringToEbook(temp1, quan));
				}
				
				if (temp1.equals("CD")) {
					contentA.add(stringToCD(temp1,quan));
				}
				
				if (temp1.equals("MP3")) {
					contentA.add(stringToAudio(temp1,quan));
				}
			}
			
			input.close();//close the file
			
		} catch (FileNotFoundException e) {//catch FileNotFoundException
			
			File createShoppingCart = new File ("Cart_"+name+".txt"); //Create a shopping cart for the new user
			
		} catch (IOException e) {
			System.out.println("There is an error");
		}
	}
	
	public void readBook() {
		try {//try-catch structure
			BufferedReader inputB = new BufferedReader(new FileReader("Books.txt"));//file reader
			
			String lineB = null;//create a string to store each line of the file
			while ((lineB = inputB.readLine()) != null) {//loop through the file
				b1.add(stringToBook(lineB));//add book to ArrayList
			}
			
			inputB.close();//close the file
			
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");//print out the error message
		}
	}//read Book.txt into ArrayList
<<<<<<< HEAD
	
	public void readeBook() {
		try {//try-catch structure
			BufferedReader inputE = new BufferedReader(new FileReader("EBooks.txt"));//file reader
			
			String lineE = null;//create a string to store each line of the file
			while ((lineE = inputE.readLine()) != null) {//loop through the file
				e1.add(stringToEbook(lineE));//add eBook to ArrayList
			}
			
			inputE.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");//print out the error message
		}
	}//read eBook.txt into ArrayList
	
	public void readCD() {
		
		try {//try-catch structure
			BufferedReader inputC = new BufferedReader(new FileReader("CDs.txt"));//file reader
			
			String lineC = null;//create a string to store each line of the file
			while ((lineC = inputC.readLine()) != null) {//loop through the file
				c1.add(stringToCD(lineC));//add CD to ArrayList
			}
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");///print out the error message
		}
	}//read CD.txt into ArrayList
	
	public void readMP3() {
		
		try {//try-catch structure
			BufferedReader inputM= new BufferedReader(new FileReader("MP3.txt"));//file reader
			
			String lineM = null;//create a string to store each line of the file
			while ((lineM = inputM.readLine()) != null) {//loop through the file
				m1.add(stringToMP3(lineM));//add CD to ArrayList
			}
			
			inputM.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");///print out the error message
		}
	}//read MP3.txt into ArrayList
	
	public eBook stringToEbook(String str) {//Convert a string to ebook
		
		String[] temp = str.split(", ");//split the string array
		eBook e1 = new eBook(Integer.parseInt(temp[0]), (double)Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]));//call the constructor
		
		return e1;//return the ebook
	}
	
	public CD stringToCD(String str) {//Convert a string to CD
		
		String[] temp = str.split(", ");//split the string array
		CD c1 = new CD(Integer.parseInt(temp[0]), (double)Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]));//call the constructor
		
		return c1;//return the CD
	}
	
	public MP3 stringToMP3(String str) {//Convert a string to MP3
		
		String[] temp = str.split(", ");//split the string array
		MP3 m1 = new MP3(Integer.parseInt(temp[0]), (double)Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]));//call the constructor
		
		return m1;//return the MP3
	}

	public Book stringToBook(String str) {

		String[] temp = str.split(", ");
		Book b1 = new Book(Integer.parseInt(temp[0]), (double)Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]));
	}

=======
	
	public void readeBook() {
		try {//try-catch structure
			BufferedReader inputE = new BufferedReader(new FileReader("EBooks.txt"));//file reader
			
			String lineE = null;//create a string to store each line of the file
			while ((lineE = inputE.readLine()) != null) {//loop through the file
				e1.add(stringToEbook(lineE));//add eBook to ArrayList
			}
			
			inputE.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");//print out the error message
		}
	}//read eBook.txt into ArrayList
	
	public void readCD() {
		
		try {//try-catch structure
			BufferedReader inputC = new BufferedReader(new FileReader("CDs.txt"));//file reader
			
			String lineC = null;//create a string to store each line of the file
			while ((lineC = inputC.readLine()) != null) {//loop through the file
				c1.add(stringToCD(lineC));//add CD to ArrayList
			}
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");///print out the error message
		}
	}//read CD.txt into ArrayList
	
	public void readMP3() {
		
		try {//try-catch structure
			BufferedReader inputM= new BufferedReader(new FileReader("MP3.txt"));//file reader
			
			String lineM = null;//create a string to store each line of the file
			while ((lineM = inputM.readLine()) != null) {//loop through the file
				m1.add(stringToMP3(lineM));//add CD to ArrayList
			}
			
			inputM.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");///print out the error message
		}
	}//read MP3.txt into ArrayList
	public eBook stringToEbook(String str) {//Convert a string to ebook
		
		String[] temp = str.split(", ");//split the string array
		eBook e1 = new eBook(Integer.parseInt(temp[0]), (double)Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]));//call the constructor
		
		return e1;//return the ebook
	}
	
	public CD stringToCD(String str) {//Convert a string to CD
		
		String[] temp = str.split(", ");//split the string array
		CD c1 = new CD();//call the constructor
		
		return c1;//return the CD
	}
	
	public MP3 stringToMP3(String str) {//Convert a string to MP3
		
		String[] temp = str.split(", ");//split the string array
		MP3 m1 = new MP3();//call the constructor
		
		return m1;//return the MP3
	}
>>>>>>> origin/master
	public Book stringToBook(String str, int quan) {
		
		Book temp;
		for (int i = 0; i < b1.size(); i++) {
			
			if (b1.get(i).getTitle().equals(str)) {
				temp = new Book(b1.get(i).getsNo(), b1.get(i).getPrice(), str, b1.get(i).getAuthorName(), quan); 
			}
		}
		return temp;
	}
	
	public eBook stringToEbook(String str, int quan) {
		eBook temp;
		for (int i = 0; i < e1.size(); i++) {
			temp = new eBook(e1.get(i).getsNo(), b1.get(i).getPrice(), str, b1.get(i).getAuthorName(),quan);
		}
		return temp;
	}
	
	public CD stringToCD(String str, int quan) {
		CD temp;
		for (int i = 0; i < c1.size(); i++) {
			temp = new eBook(c1.get(i).getsNo(), c1.get(i).getPrice(), str, c1.get(i).getArtistName(),quan);
		}
		return temp;
	}
	
	public MP3 stringToMP3(String str, int quan) {
		MP3 temp;
		for (int i = 0; i < m1.size(); i++) {
			temp = new eBook(m1.get(i).getsNo(), m1.get(i).getPrice(), str, m1.get(i).getAuthorName(),quan);
		}
		return temp;
	}
	
	public String checkType(String str) {
		
		int check = 0;
		for (int i = 0; i < b1.size(); i++) {
			
			if (b1.get(i).getTitle().equals(str)) {
				check = 1; 
			}
		}
		
		for (int i = 0; i < e1.size(); i++) {
			
			if (e1.get(i).getTitle().equals(str)) {
				check = 2;
			}
		}
		
		for (int i = 0; i < m1.size(); i++) {
			
			if (m1.get(i).getTitle().equals(str)) {
				check = 3;
			}
		}
		
		for (int i = 0; i < c1.size(); i++) {
			
			if (c1.get(i).getTitle().equals(str)) {
				check = 4;
			}
		}
		
		if (check == 1) {return "Book";}
		if (check == 2) {return "eBook";}
		if (check == 3) {return "MP3";}
		if (check == 4) {return "CD";}
		else {return "No type match!";}
		
	}
	
	public int getIndex(Item name) {//return the index of the ArrayList of a given item
		
		return this.content.indexOf(name);//return the index
	}
	
	public void addQuantity(int index, int quan){//add given quantity to the item at given index
		
		(content.get(index)).changeQuantity(quan);//update the quantity for the item
	}
	
	public String getContent() {//return the content of the cart as string
		
		for (int i = 0; i < content.size(); i++) {//loop through the ArrayList
			
			return content.get(i).getTitle() + content.get(i).getQuantity() + content.get(i).getPrice();//return the string
		}
	}
	
	public double getEnvirTax() {}
	
	public double getShipping() {//return the shipping fee of the cart
		
		double shipping;//create a double to store the shipping fee
		for (int i = 0; i < content.size();i++) {//loop through the ArrayList
			
			if (content.get(i).getType() != "MP3" || content.get(i).getType() != "eBook") {//MP3 don't need shipping
				shipping += content.get(i).getQuantity() * content.get(i).getPrice();//increment the shipping by the quantity*price
		
			}
		}
		return shipping * 0.1;//return shipping * 10%
	}
	
	public double getHST() {//return the hst of the cart
		
		double hst = 0;//create a double to store the hst
		for (int i = 0; i < content.size();i++) {//loop through the ArrayList
			
			hst += content.get(i).getQuantity() * content.get(i).getPrice();//increment the hst by the quantity*price
		}
		return hst * 0.13;//return hst * 13%
	}
	
	public double getTotal() {//return the total amount of the cart
		
		double total = 0;//create a double variable to store the total amount
		for (int i = 0; i < content.size();i++) {//loop through the ArrayList
			
			total += content.get(i).getQuantity() * content.get(i).getPrice();//increment total by the quantity*price
		}
		return total + getHST() + getShipping() + getEnvirTax();//return the total price by adding hst, environmental tax and shipping
	}
	
	public void AddItem(String title){//add an item to the cart
		temp1 = checkType(title);//Check the type of the item added
		private int sNoDisplay;
		private int quantityDisplay;
		
		if (temp1.equals("Book") || temp1.equals("eBook")) {
			sNoDisplay = contentR.get(contentR.indexOf(title)).getsNo();//Get sNo in the shopping cart
			quantityDisplay = contentR.get(contentR.indexOf(title)).getQuantity();//Get quantity in the shopping cart
		}
				
		if (temp1.equals("CD") || temp1.equals("MP3")) {
			sNoDisplay = contentA.get(contentR.indexOf(title)).getsNo();//Get sNo in the shopping cart
			quantityDisplay = contentA.get(contentR.indexOf(title)).getQuantity();//Get quantity in the shopping cart
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//Get current yyyy/MM/dd and display it as it is
		//get current date time with Date()
		Date date = new Date();
		String display = sNoDisplay + " ," + title + " ," + dateFormat.format(date) + " ," + quantityDisplay; //The format of displaying information in shopping cart
		content.add(display);//add to ArrayList
	}
	
	
	public void writeCart() {//write the ArrayList back to the text file
		
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("Cart_" + super.getUsername() + ".txt", false));//file writer
			
			output.close();//close the file
		} catch (IOException e) {}//Catch IOException
	}
}
