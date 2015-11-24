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
	
	private ArrayList<Readable> contentR = new ArrayList<Readable>();//Store all the readables
	private ArrayList<Audio> contentA = new ArrayList<Audio>();//Store all the audios
	
	private ArrayList<Book> b1 = new ArrayList<Book>();//Store books from file
	private ArrayList<MP3> m1 = new ArrayList<MP3>();//Store MP3s from file
	private ArrayList<eBook> e1 = new ArrayList<eBook>();//Store eBooks from file
	private ArrayList<CD> c1 = new ArrayList<CD>();//Store CDs from file
	
	
	public ShoppingCart(String name){//Constructor which take in a string as user name
		
		super(name);//call parent's constructor
	}
	
	public void loadCart() {//load the cart information from file
		
		try {//try-catch structure to catch any error
			BufferedReader input = new BufferedReader(new FileReader("Cart_" + this.getUsername() + ".txt"));//read in file
			
			String line = null;//define a string to store each line of the file
			while ((line = input.readLine()) != null) {//while loop to loop thorough the file
				String[] temp = line.split(", ");//split the string
				int quan = Integer.parseInt(temp[3]);//store quantity 
				String temp1 = checkType(temp[1]);//store type
				
				if (temp1.equals("Book")) {//if it is a book
					stringToBook(temp[1], quan);//add it to the ArrayList
				}
				
				if (temp1.equals("eBook")) {//if it is a eBook
					stringToEbook(temp[1], quan);//add it to the ArrayList
				}
				
				if (temp1.equals("CD")) {//if it is a CD
					stringToCD(temp[1],quan);//add it to the ArrayList
				}
				
				if (temp1.equals("MP3")) {//if it is a MP3
					stringToMP3(temp[1],quan);//add it to the ArrayList
				}
			}
			
			input.close();//close the file
			
		} catch (FileNotFoundException f) {//catch FileNotFoundException
			try {
				File createShoppingCart = new File ("Cart_"+getUsername()+".txt"); //Create a new file object for user
				if(createShoppingCart.createNewFile()){//Create a new file for user's shopping cart an returns a boolean value true if the file is created successfully, vice versa
					return;
				}else {
			        //System.out.println("File already exists.");
				}
			}catch(IOException e) {//catch IOException
				System.out.println(e);///print out the error message
			}
			
		} catch (IOException e) {//catch IOException
			System.out.println(e);//print out the error message
		}
	}
	
	public void readBook() {//read book from file
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

	
	public void readeBook() {//read eBook from file
		try {//try-catch structure
			BufferedReader inputE = new BufferedReader(new FileReader("EBooks.txt"));//file reader
			
			String lineE = null;//create a string to store each line of the file
			while ((lineE = inputE.readLine()) != null) {//loop through the file
				e1.add(stringToEbook(lineE));//add eBook to ArrayList
			}
			
			inputE.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error in readeBook().");//print out the error message
		}
	}//read eBook.txt into ArrayList
	
	public void readCD() {//read CD from file
		
		try {//try-catch structure
			BufferedReader inputC = new BufferedReader(new FileReader("CDs.txt"));//file reader
			
			String lineC = null;//create a string to store each line of the file
			while ((lineC = inputC.readLine()) != null) {//loop through the file
				c1.add(stringToCD(lineC));//add CD to ArrayList
			}
			
			inputC.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error in readCD().");///print out the error message
		}
	}//read CD.txt into ArrayList
	
	public void readMP3() {//read MP3 from file
		
		try {//try-catch structure
			BufferedReader inputM= new BufferedReader(new FileReader("MP3s.txt"));//file reader
			
			String lineM = null;//create a string to store each line of the file
			while ((lineM = inputM.readLine()) != null) {//loop through the file
				m1.add(stringToMP3(lineM));//add CD to ArrayList
			}
			
			inputM.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println(e);///print out the error message
		}
	}//read MP3.txt into ArrayList
	
	public Book stringToBook(String str) {//convert string to a book

		String[] temp = str.split(", ");//split the string
		Book b1 = new Book(Integer.parseInt(temp[0]), Double.parseDouble(temp[3]), temp[1], temp[2], Integer.parseInt(temp[4]));//call constructor
		return b1;//return the book
	}
	
	public eBook stringToEbook(String str) {//Convert a string to ebook
		
		String[] temp = str.split(", ");//split the string array
		eBook e1 = new eBook(Integer.parseInt(temp[0]), Double.parseDouble(temp[3]), temp[1], temp[2], Integer.parseInt(temp[4]));//call the constructor
		
		return e1;//return the ebook
	}
	
	public CD stringToCD(String str) {//Convert a string to CD
		
		String[] temp = str.split(", ");//split the string array
		CD c1 = new CD(Integer.parseInt(temp[0]), Double.parseDouble(temp[3]), temp[1], temp[2], Integer.parseInt(temp[4]));//call the constructor
		
		return c1;//return the CD
	}
	
	public MP3 stringToMP3(String str) {//Convert a string to MP3
		
		String[] temp = str.split(", ");//split the string array
		MP3 m1 = new MP3(Integer.parseInt(temp[0]), Double.parseDouble(temp[3]), temp[1], temp[2], Integer.parseInt(temp[4]));//call the constructor
		
		return m1;//return the MP3
	}

	public void stringToBook(String str, int quan) {//convert string to book
		
		
		for (int i = 0; i < b1.size(); i++) {//loop through the books from file
			
			if (b1.get(i).getTitle().equals(str)) {//check if has same title
				Book temp = new Book(b1.get(i).getsNo(), b1.get(i).getPrice()/1.02, str, b1.get(i).getAuthorName(), quan);//call constructor
				contentR.add(temp);//add new book to ArrayList
			}
		}
	}
	
	public void stringToEbook(String str, int quan) {//convert string to ebook
		for (int i = 0; i < e1.size(); i++) {//loop through the ebooks from file
			if (e1.get(i).getTitle().equals(str)) {//check if has same title
				eBook temp = new eBook(e1.get(i).getsNo(), e1.get(i).getPrice(), str, e1.get(i).getAuthorName(),quan);//call constructor
				contentR.add(temp);//add new ebook to ArrayList
			}
		}
		
	}
	
	public void stringToCD(String str, int quan) {//convert string to CD
		
		for (int i = 0; i < c1.size(); i++) {//loop through the CD from file
			if (c1.get(i).getTitle().equals(str)) {//check if has same title
				CD temp = new CD(c1.get(i).getsNo(), c1.get(i).getPrice()/1.02, str, c1.get(i).getAuthorName(),quan);//call constructor
				contentA.add(temp);//add new CD to ArrayList
			}
		}
	}
	
	public void stringToMP3(String str, int quan) {//convert string to MP3
		
		for (int i = 0; i < m1.size(); i++) {//loop through the CD from file
			if (m1.get(i).getTitle().equals(str)) {//check if has same title
				MP3 temp = new MP3(m1.get(i).getsNo(), m1.get(i).getPrice(), str, m1.get(i).getAuthorName(),quan);//call constructor
				contentA.add(temp);//add new MP3 to ArrayList
			}
		}
	}
	
	public String checkType(String str) {//return type of the given title of item
		
		int check = 0;//set check to zero
		for (int i = 0; i < b1.size(); i++) {//loop through the ArrayList
			
			if (b1.get(i).getTitle().equals(str)) {//check if has same title
				check = 1; //overWrite check
			}
		}
		
		for (int i = 0; i < e1.size(); i++) {//loop through the ArrayList
			
			if (e1.get(i).getTitle().equals(str)) {//check if has same title
				check = 2;//overWrite check
			}
		}
		
		for (int i = 0; i < m1.size(); i++) {//loop through the ArrayList
			
			if (m1.get(i).getTitle().equals(str)) {//check if has same title
				check = 3;//overWrite check
			}
		}
		
		for (int i = 0; i < c1.size(); i++) {//loop through the ArrayList
			
			if (c1.get(i).getTitle().equals(str)) {//check if has same title
				check = 4;//overWrite check
			}
		}
		
		if (check == 1) {return "Book";}//return type
		if (check == 2) {return "eBook";}//return type
		if (check == 3) {return "MP3";}//return type
		if (check == 4) {return "CD";}//return type
		else {return "No type match!";}//return type if not found
		
	}
	
	
	public void addQuantity(int index, int quan, String str){//add given quantity to the item at given index
		
		if (str.equals("Book") || str.equals("eBook")) {//check type
			(contentR.get(index)).changeQuantityC(quan);//update the quantity for the item
		}
		if (str.equals("MP3") || str.equals("CD")) {//check type
			(contentA.get(index)).changeQuantityC(quan);//update the quantity for the item
		}
		
	}
	
	public void getContent() {//return the content of the cart as string
		
		try {//try-catch structure
			BufferedReader inputB = new BufferedReader(new FileReader("Cart_"+ getUsername()+ ".txt"));//file reader
			
			String lineB = null;//create a string to store each line of the file
			while ((lineB = inputB.readLine()) != null) {//loop through the file
				System.out.println(lineB);//print the message
			}
			
			inputB.close();//close the file
			
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error in getContent().");//print out the error message
		}
	}

	public void writeItemsBought (String confirmationId) {//write order to file
		try {//try-catch structure
		BufferedWriter history = new BufferedWriter(new FileWriter("ItemsBought.txt", true));//file writer
				for (int i = 0; i < contentR.size(); i++) {//loop through the ArrayList
					if (contentR.get(i).getType() == "Book") {//check type
					String display = confirmationId +"   "+ contentR.get(i).getTitle() +"   "+contentR.get(i).getPrice()/1.02;//Divide price by 1.02 to get original price
				    history.write(display);//write file
					history.newLine();//print a new line
					} else{//check type
						String display = confirmationId+ "   " + contentR.get(i).getTitle() +"   "+contentR.get(i).getPrice();//Divide price by 1.02 to get original price
					    history.write(display);//write file
						history.newLine();//print a new line

					}
				}
				for (int i = 0; i < contentA.size(); i++) {//loop through the ArrayList
					if (contentA.get(i).getType() == "CD") {	//check type		
						String display = confirmationId + "   " + contentA.get(i).getTitle() +"   "+contentA.get(i).getPrice()/1.02;//Divide price by 1.02 to get original price
					    history.write(display);//write file
						history.newLine();//print a new line

					} else {//check type
						String display = "U1000   " + contentA.get(i).getTitle() +"   "+contentA.get(i).getPrice();//Divide price by 1.02 to get original price
					    history.write(display);//write file
						history.newLine();//print a new line

					}
				}
			history.close();//close the file
		}catch (Exception e) {  //catch IOexception
	        System.out.println("Some error occured while writing file");//prints error message
		} 
	}	


	public void getItemsBought () {//Prints out the ItemsBought
		try {
			BufferedReader inputB = new BufferedReader(new FileReader("ItemsBought.txt"));//file reader
			String lineB = null;//set string to null
			while ((lineB = inputB.readLine()) != null) {//loop through the file
				String [] output = new String [3];//create new array to store information
				output = lineB.split("   ");//break down the information about the item read from the text file
				System.out.printf("%-20s%-50s%-30s\n", output[0], output[1], output[2]);//print item bought information
			}
			inputB.close(); //close the file
		} catch(IOException e) {//catch IOException
			System.out.println("\nNo previous order");//print out the error message
		}
	}
	
	public int checkItemsBought (){//Check how many items are in ItemBought
		int counter = 0;//set counter to zero
		try {//try-catch structure
			BufferedReader inputB = new BufferedReader(new FileReader("ItemsBought.txt"));//file reader
			while ((inputB.readLine()) != null) {//loop through the file
				counter++;//increment counter by 1
			}
			inputB.close(); //close the file
		}catch(IOException e) {//catch IOException
			System.out.println("\nNo previous order");//print out the error message
		}
		return counter;//return counter
	}
	
	public String getConfirmationId() {//Returns confirmation ID
		int counter = 0;//set counter to zero
		String lineB = "1";//set string to 1
		String [] temp = new String [3];//set array of string to size 3
		try {
			BufferedReader inputB = new BufferedReader(new FileReader("ItemsBought.txt"));//file reader
			while ((inputB.readLine()) != null) {//loop through the file
				counter++;//increment the counter by one
			}
			inputB.close(); //close the file
			
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error in getContent().");//print out the error message
		}
		try {//try-catch structure
			BufferedReader inputB = new BufferedReader(new FileReader("ItemsBought.txt"));//file reader
			for (int i = 0; i < counter; i++) {//loop through the line 
				lineB = inputB.readLine();//read line and stores in a string
			}

			temp = lineB.split("   ");//split the string
			inputB.close();//close the file
		}catch(IOException e) {//catch IOException
			System.out.println("\nNo previous order");//print out the error message
		}
		return temp [0];//return the string
	}
	
	public void getCheckout() {//print out checkout page
		
		for (int i = 0; i < contentR.size(); i++) {//loop through the ArrayList
			
			if (contentR.get(i).getType() == "Book") {//check type
				System.out.printf("%-50s%-20s%-30s\n", contentR.get(i).getTitle(), contentR.get(i).getQuantity(), (contentR.get(i).getPrice())/1.02);//get information about the item and divide price by 1.02 original price
				//System.out.println(contentR.get(i).getTitle() + "    " + contentR.get(i).getQuantity() + "    " + (contentR.get(i).getPrice())/1.02);//Divide price by 1.02 to get original price
			} else {
				System.out.printf("%-50s%-20s%-30s\n", contentR.get(i).getTitle(), contentR.get(i).getQuantity(), (contentR.get(i).getPrice()));//get information about the item
				//System.out.println(contentR.get(i).getTitle() + "    " + contentR.get(i).getQuantity() + "    " + contentR.get(i).getPrice());//Divide price by 1.02 to get original price
			}
		}
		
		for (int i = 0; i < contentA.size(); i++) {//loop through the ArrayList
			if (contentA.get(i).getType() == "CD") {//check type	
				System.out.printf("%-50s%-20s%-30s\n", contentA.get(i).getTitle(), contentA.get(i).getQuantity(), (contentA.get(i).getPrice())/1.02);//get information about item and divide price by 1.02 to get original price
				//System.out.println(contentA.get(i).getTitle() + "    " + contentA.get(i).getQuantity() + "    " + (contentA.get(i).getPrice())/1.02);//Divide price by 1.02 to get original price
			}else{
				System.out.printf("%-50s%-20s%-30s\n", contentA.get(i).getTitle(), contentA.get(i).getQuantity(), (contentA.get(i).getPrice()));//get information about the item
				//System.out.println(contentA.get(i).getTitle() + "    " + contentA.get(i).getQuantity() + "    " + contentA.get(i).getPrice());//Divide price by 1.02 to get original price
			}
		}
	}
	
	public double getEnvirTax() {//get Environmental tax
		
		double tax = 0;//set tax to zero
		for (int i = 0; i < contentR.size(); i++) {//loop through the ArrayList
			if (contentR.get(i).getType().equals("Book")) {//check type
				tax += ((contentR.get(i)).getPrice() - contentR.get(i).getPrice()/1.02) * contentR.get(i).getQuantity();//increment tax
			}
		}
		for (int i = 0; i < contentA.size(); i++) {//loop through the ArrayList
			if (contentA.get(i).getType().equals("CD")) {//check type
				tax += ((contentA.get(i)).getPrice() - contentA.get(i).getPrice()/1.02) * contentA.get(i).getQuantity();//increment tax
			}
		}
		return Math.round(tax * 100)/100.0;//return and round tax to two decimal palce
	}
	
	public double getShipping() {//return the shipping fee of the cart
		
		double shipping = 0;//create a double to store the shipping fee
		for (int i = 0; i < contentR.size();i++) {//loop through the ArrayList
			
			if (contentR.get(i).getType() == "Book") {//eBooks don't need shipping
				shipping += contentR.get(i).getQuantity() * contentR.get(i).getPrice()/1.02;//increment the shipping by the quantity*price
		
			}
		}
		
		for (int i = 0; i < contentA.size();i++) {//loop through the ArrayList
			
			if (contentA.get(i).getType() == "CD") {//MP3s don't need shipping
				shipping += contentA.get(i).getQuantity() * contentA.get(i).getPrice()/1.02;//increment the shipping by the quantity*price
		
			}
		}
		return Math.round(shipping * 0.1 * 100)/100.0;//return shipping * 10%
	}
	
	public double getHST() {//return the hst of the cart
		
		double hst = 0;//create a double to store the hst

		for (int i = 0; i < contentR.size();i++) {//loop through the ArrayList
			if (contentR.get(i).getType() == "Book") {//Divide price by 1.02 to get original price
				hst += contentR.get(i).getQuantity() * (contentR.get(i).getPrice()/1.02);//increment the hst by the quantity*price
			}else{//Divide price by 1.02 to get original price
				hst += contentR.get(i).getQuantity() * (contentR.get(i).getPrice());//increment the hst by the quantity*price
			}
		}
		
		for (int i = 0; i < contentA.size();i++) {//loop through the ArrayList
			if (contentA.get(i).getType() == "CD") {//Divide price by 1.02 to get original price
				hst += contentA.get(i).getQuantity() * (contentA.get(i).getPrice()/1.02);//increment the hst by the quantity*price
			}else{
				hst += contentA.get(i).getQuantity() * (contentA.get(i).getPrice());//increment the hst by the quantity*price1
			}	
		}
		return Math.round(hst * 0.13 * 100)/100.0;//return hst * 13%
	}
	
	public double getTotal() {//return the total amount of the cart
		
		double total = 0;//create a double variable to store the total amount
		for (int i = 0; i < contentA.size();i++) {//loop through the ArrayList
			
			total += contentA.get(i).getQuantity() * contentA.get(i).getPrice();//increment the hst by the quantity*price
		}
		
		for (int i = 0; i < contentR.size();i++) {//loop through the ArrayList
			
			total += contentR.get(i).getQuantity() * contentR.get(i).getPrice();//increment the hst by the quantity*price
		}
		return Math.round((total + getHST() + getShipping())*100)/100.0;//return the total price by adding hst, environmental tax and shipping
	}
	
	public void AddItem(String title, int quan){//add an item to the cart
		String temp1 = checkType(title);//Check the type of the item added
		int sNoDisplay = 0;//set sNo to zero
		
		if (temp1.equals("Book")) {//check type
			for (int i = 0; i < b1.size(); i++) {//loop through the ArrayList
				if (title.equals(b1.get(i).getTitle())) {//check if have same title
					sNoDisplay = b1.get(i).getsNo();//store the sNo
					contentR.add(b1.get(i));//add to ArrayList
					addQuantity(contentR.indexOf(b1.get(i)), quan, "Book");//update the quantity
				}
			}
		}
		
		if (temp1.equals("eBook")) {//check type
			for (int i = 0; i < e1.size(); i++) {//loop through the ArrayList
				if (title.equals(e1.get(i).getTitle())) {//check if have same title
					contentR.add(e1.get(i));//add to ArrayList
					sNoDisplay = e1.get(i).getsNo();//store the sNo
					addQuantity(contentR.indexOf(e1.get(i)), quan, "eBook");//update the quantity
				}
			}
		}
		
		if (temp1.equals("CD")) {//check type
			for (int i = 0; i < c1.size(); i++) {//loop through the ArrayList
				if (title.equals(c1.get(i).getTitle())) {//check if have same title
					contentA.add(c1.get(i));//add to ArrayList
					sNoDisplay = c1.get(i).getsNo();//store the sNo
					addQuantity(contentA.indexOf(c1.get(i)), quan, "CD");//update the quantity
				}
			}
		}
		
		if (temp1.equals("MP3")) {//check type
			for (int i = 0; i < m1.size(); i++) {//loop through the ArrayList
				if (title.equals(m1.get(i).getTitle())) {//check if have same title
					contentA.add(m1.get(i));//add to ArrayList
					sNoDisplay = m1.get(i).getsNo();//store the sNo
					addQuantity(contentA.indexOf(m1.get(i)), quan, "MP3");//update the quantity
				}
			}
		}
		
		
		try {//try-catch structure
			BufferedWriter output = new BufferedWriter(new FileWriter("Cart_" + getUsername() + ".txt", true));//file writer
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//Get current yyyy/MM/dd and display it as it is
			
			Date date = new Date();//get current date time with Date()
			
			String display = sNoDisplay + ", " + title + ", " + dateFormat.format(date) + ", " + quan;//set the string
			
			output.write(display);//write the string to file
			output.newLine();//write a new line
			output.close();//close the file
		} catch (IOException e) {//catch IOException
			System.out.println("There is an error in AddItem()");//print out message
		}
	}
	
	public void clearCart() {//clear the cart after checkout
		File deleteShoppingCart = new File ("Cart_"+getUsername()+".txt");//Create a file object for the user shopping cart text file
		try {
		if (deleteShoppingCart.delete()){//deletes the file and returns true if the file is deleted successfully
			try {
				if (deleteShoppingCart.createNewFile()) {//creates the file and returns true if the file is created successfully
					contentR.clear();//clear the ArrayList
					contentA.clear();//clear the ArrayList
					return;
				}else {
			        System.out.println("File already exist");//prints error message the error already exists
				}
			}catch (IOException e) {
		        System.out.println("File not created");//prints error message
			}
		}else {
	        System.out.println("File not deleted");//prints error message file can not be deleted
		}
		}catch (Exception e) {  
	        System.out.println("Some error occured while deleting file");//prints error messgae
		 } 
	}
}

