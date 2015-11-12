/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the UserInterface which contains all the page navigation
*/
import java.util.ArrayList;//import ArrayList
import java.util.Scanner;//import Scanner
import java.lang.StringBuilder;//import StringBuilder
import java.io.*;//import IO
public class UserInterface {//public the class
	
	private ArrayList<Readable> readables = new ArrayList<Readable>();//ArrayList contains all the readable item
	private ArrayList<Audio> audioProducts = new ArrayList<Audio>();//ArrayList contains all the audio item
	private ArrayList<User> name = new ArrayList<User>();//ArrayList contains all the user
	private ShoppingCart cart;//Create a shopping cart object
	
	private int currentPage;//Create a int to track the page
	
	public UserInterface(int num) {//Constructor
		
		currentPage = num;//set current page as given int
	}
	
	public int getCurrentPage(){//return current page
		
		return currentPage;//return the value of currentPage
	}
	
	public int changeCurrentPage(int newPage){//update the value of currentPage
		
		currentPage = newPage;//set currentPage to the given int
		displayPage(currentPage);//display the page message
	}
	
	public void getUser(){//initialize the user ArrayList
		
		try {//try-catch structure
			BufferedReader inputU = new BufferedReader(new FileReader("Users.txt"));//file reader
			String lineU = null;//create a string to store each line of the file
			
			while ((lineU = inputU.readLine()) != null) {//loop through the file
				
				name.add(stringToUser(lineU));//add user to the ArrayList
			}
			
			inputU.close();//close the file
			
		} catch (IOException e) {//catch IOException
			System.out.println("There is an error.");//print out error message
		}
	}
	
	
	
	public void getReadables(){//initialize the readable ArrayList
		
		try {//try-catch structure
			BufferedReader inputB = new BufferedReader(new FileReader("Books.txt"));//file reader
			BufferedReader inputE = new BufferedReader(new FileReader("Ebooks.txt"));//file reader
			
			String lineB = null;//create a string to store each line of the file
			while ((lineB = inputB.readLine()) != null) {//loop through the file
				readables.add(stringToBook(lineB));//add book to ArrayList
			}
			
			inputB.close();//close the file
			
			String lineE = null;//create a string to store each line of the file
			while ((lineE = inputE.readLine()) != null) {//loop through the file
				readables.add(stringToEbook(lineE));//add eBook to ArrayList
			}
			
			inputE.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");//print out the error message
		}
	}
	
	public void getAudioProducts(){//initialize the audio ArrayList
		
		try {//try-catch structure
			BufferedReader inputC = new BufferedReader(new FileReader("CDs.txt"));//file reader
			BufferedReader inputM= new BufferedReader(new FileReader("MP3.txt"));//file reader
			
			String lineC = null;//create a string to store each line of the file
			while ((lineC = inputC.readLine()) != null) {//loop through the file
				audioProducts.add(stringToCD(lineC));//add CD to ArrayList
			}
			
			inputC.close();//close the file
			
			String lineM = null;//create a string to store each line of the file
			while ((lineM = inputM.readLine()) != null) {//loop through the file
				audioProducts.add(stringToMP3(lineM));//add CD to ArrayList
			}
			
			inputM.close();//close the file
		} catch(IOException e) {//catch IOException
			System.out.println("There is an error.");///print out the error message
		}
	}
	
	public void showReadables(){//print out the item in ArrayList
		
		for (int i = 0; i < readables.size(); i++) {//loop through the ArrayList
			
			System.out.println((readables.get(i)).getInfo());//print out the information as string
		}
	}
	
	public void showAudioProducts(){//print out the item in ArrayList
		
		for (int i = 0; i < audioProducts.size(); i++) {//loop through the ArrayList
			
			System.out.println((audioProducts.get(i)).getInfo());//print out the information as string
		}
	}
	
	public Book stringToBook(String str) {//Convert a string to book
		
		String[] temp = str.split(", ");//split the string array
		Book b1 = new Book();//call the constructor
		
		return b1;//return the book
	}
	
	public eBook stringToEbook(String str) {//Convert a string to ebook
		
		String[] temp = str.split(", ");//split the string array
		eBook e1 = new eBook();//call the constructor
		
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
	
	public User stringToUser(String str) {//Take in the user name and return a user
		
		User u1 = new User(str);//call the constructor
		return u1;//return the user
	}
	
	public void displayPage(int pageNum){//display the message of each page according to the given int
		
		switch(pageNum) {//case structure
		case 1: p1Info();//if pageNum = 1, display the p1 message
				break; //break the loop
		case 2: p2Info();//if pageNum = 2, display the p2 message
				break;//break the loop
		case 3: p34Info();//if pageNum = 3, display the p34 message
				break;//break the loop
		case 5: p5Info();//if pageNum = 5, display the p5 message
				break;//break the loop
		case 6: p6Info();//if pageNum = 6, display the p6 message
				break;//break the loop
		case 7: p7Info();//if pageNum = 7, display the p7 message
				break;//break the loop
		case 8: p8Info();//if pageNum = 8, display the p8 message
				break;//break the loop
		case 9: p9Info();//if pageNum = 8, display the p9 message
				break;//break the loop
		case 10: p10Info();//if pageNum = 10, display the p10 message
				break;//break the loop
			
		}
		
	}
	
	public void p1Info(){//display the information of page 1
		Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("1. Sign in");//print each option
		System.out.println("2. Sign up");//print each option
		System.out.println("Choose your option: ");//ask for user input
		double choice = sc.nextDouble();//take a user input as double
		
		while (choice != 1 && choice != 2) {//check if choice == 1 or 2
			
			System.out.println("Plz enter choice 1 or 2: ");//if not, ask for another user input
			choice = sc.nextDouble();//overwrite the double
		}
		if ((int)choice == 2) {changeCurrentPage(2);}//if user choose 1, display page 2
		if ((int)choice == 1) {changeCurrentPage(3);}//if user choose 2, display page 3
		
	}
	
	public void p2Info(){//display the information of page 2
		
		Scanner sc = new Scanner(System.in);//create a scanner
		
		System.out.println("Choose your user name:");//ask for user name
		String n1 = sc.nextLine();//read user input as a string
		File createShoppingCart = new File ("Cart_"+n1+".txt"); //Create a shopping cart for the new user
		cart = new ShoppingCart(n1);//initialize the shopping cart
		name.add(stringToUser(n1));//add user to the ArrayList
		System.out.println("\nUser name successfully added");//print out the message
		changeCurrentPage(1);//change current page to page 1
	}
	
	public void p34Info(){//display the information for page 3 and 4
		
		Scanner sc = new Scanner(System.in);//create the scanner
		
		System.out.println("Enter your username: ");//ask for user name
		String n1 = sc.nextLine();//store user input as a string
		boolean check = false;//set boolean to false
		
		for (int i = 0; i < name.size(); i++) {//loop through the user ArrayList
			if (((name.get(i)).getUsername()).equals(n1)) {//check if the user input match the existing name
				
				check = true;//if match, change to true
			}
		}
		
		if (check) {//name match the existing name
			cart = new ShoppingCart(n1);//assign to the shopping cart
			System.out.println("Hello Mr/Miss. " + n1);//print out the welcome message
			changeCurrentPage(5);//change current page to page 5
		} else {//if not match the existing name
			
			System.out.println("No Access");//print out the message
			changeCurrentPage(1);////change current page to page 1
		}
	}
	
	public void p5Info(){//display the information for page 5
		
		Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("1. View Items By Category");//print out option
		System.out.println("2. View Shooping Cart");//print out option
		System.out.println("3. Sign Out");//print out option
		System.out.println("\nChoose your option: ");//ask for user input
		
		double option = sc.nextDouble();//store user input into a double
		
		while(option != 1 && option != 2 && option != 3) {//check if user input equals to 1, 2 or 3
			
			System.out.println("Plz enter option 1, 2 or 3: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		
		if (option == 1) {changeCurrentPage(6);}//if option = 1, change current page to page 6
		if (option == 2) {changeCurrentPage(7);}//if option = 2, change current page to page 7
		if (option == 3) {changeCurrentPage(1);}//if option = 3, change current page to page 1
		
	}
	
	public void p6Info() {//display the information for page 6
		
		Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("1. Readables");//print out option
		System.out.println("2. Audio");//print out option
		System.out.println("\nChoose your oprion: ");//ask for user input
		System.out.println("\nPress -1 to return  to previous meanu");//print out option
		
		double option = sc.nextDouble();//store the user input in a double
		
		while(option != 1 && option != 2 && option != -1) {//check if user input equals to 1, 2 or -1
		
			System.out.println("Plz enter option 1, 2 or -1: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		
		if (option == 1) {changeCurrentPage(8);}//if option = 1, change current page to page 8
		if (option == 2) {changeCurrentPage(9);}//if option = 2, change current page to page 9
		if (option == -1) {changeCurrentPage(5);}//if option = -1, change current page to page 5
	}
	
	public void p7Info() {//display the information for page 7
		
		Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println(cart.getContent());//print out the whole cart
		System.out.println("Plz enter 1 to checkout or -1 to previous page: ");//ask for user input
		double option = sc.nextDouble();//store the user input in a double
		
		while(option != 1 && option != -1) {//check if user input equals to 1 or -1
		
			System.out.println("Plz enter option 1 or -1: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		
		if (option == 1) {changeCurrentPage(10);}//if option = 1, change current page to page 10
		if (option == -1) {changeCurrentPage(5);}//if option = -1, change current page to page 5
	}
	
	public void p8Info() {//display the information for page 8
		
		Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("Readables: \n");//print out the message
		System.out.println("S.No  Name of the Book   Author  Price($)  Quantity in Store  Type");//print out the message
		
		getReadables();//print out the readable ArrayList
		
		System.out.println("Choose your option: ");//ask for user input
		System.out.println("Press -1 to return to previous menu.");//print out the message
		
		double option = sc.nextDouble();//store the user input in a double
		
		while (option > readables.size() && option != -1) {//check if user input equals to -1 or option larger than the quantity of item
			
			System.out.println("Plz enter a valid option: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		
		if (option == -1) {changeCurrentPage(6);}//if option = -1, change current page to page 6
		else {//if user want to add item to cart
			
			System.out.println("Enter quantity: ");//ask for user input
			int quan = sc.nextInt();//store the user input in a int
			
			while(quan > (readables.get((int)option - 1)).getQuantity()) {//check if user input larger than the given quantity
				
				System.out.println("Not enough item. Plz enter a smaller quantity.");//if not, ask for user input
				quan = sc.nextInt();//overwrite the int with new user input
			}
			
			
			cart.AddItem(readables.get((int)option - 1));//add item to cart
			readables.get((int)option - 1).changeQuantity(-quan);//update the quantity of readable
			int i = cart.getIndex(readables.get((int)option - 1));//get the index of given item in cart
			cart.addQuantity(i, quan);//update quantity of cart
			
			System.out.println(quan + readables.get((int)option - 1).getTitle() + "successfully added to your cart.");//print out message
			
			System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOur: ");//ask for user input
			
			double option1 = sc.nextDouble();//store the user input in a double
			
			while (option1 != 0 && option1 != -2) {//check if user input equals to 0 or -2
				
				System.out.println("Plz enter option 0 or -2: ");//if not, ask for user input
				option1 = sc.nextDouble();//overwrite the double with new user input
			}
			
			if (option1 == 0) {changeCurrentPage(10);}//if option = 0, change current page to page 10
			if (option1 == -2) {changeCurrentPage(6);}//if option = 2, change current page to page 6
			
			
		}
	}
	
	public void p9Info() {//display the information for page 9
		
		Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("Audio: \n");//print out the message
		System.out.println("S.No  Name   Author  Price($)  Quantity in Store  Type");//print out the message
		
		getAudioProducts();//print out the information of the audio ArrayList
		
		System.out.println("Choose your option: ");//ask for user input
		System.out.println("Press -1 to return to previous menu.");//print out the message
		
		double option = sc.nextDouble();//store the user input in a double
		
		while (option > audioProducts.size() && option != -1) {//check if user input equals to -1 or option larger than the quantity of item
			
			System.out.println("Plz enter a valid option: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		
		if (option == -1) {changeCurrentPage(6);}//check if user input equals to -1
		else {//if not
			
			System.out.println("Enter quantity: ");//ask for user input
			int quan = sc.nextInt();//store the user input in a int
			
			while(quan > (audioProducts.get((int)option - 1)).getQuantity()) {//check if user input larger than the given quantity
				
				System.out.println("Not enough item. Plz enter a smaller quantity.");//if not, ask for user input
				quan = sc.nextInt();//overwrite the int with new user input
			}
			
			cart.AddItem(audioProducts.get((int)option - 1));//add item to cart
			audioProducts.get((int)option - 1).changeQuantity(-quan);//update the quantity of audioProducts
			int i = cart.getIndex(audioProducts.get((int)option - 1));//get the index of given item in cart
			cart.addQuantity(i, quan);//update quantity of cart
			
			System.out.println(quan + audioProducts.get((int)option - 1).getTitle() + "successfully added to your cart.");//print out message
			
			System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOur: ");//ask for user input
			
			double option1 = sc.nextDouble();//store the user input in a double
			
			while (option1 != 0 && option1 != -2) {//check if user input equals to 0 or -2
				
				System.out.println("Plz enter option 0 or -2: ");//if not, ask for user input
				option1 = sc.nextDouble();//overwrite the double with new user input
			}
			
			if (option1 == 0) {changeCurrentPage(10);}//if option = 0, change current page to page 10
			if (option1 == -2){changeCurrentPage(6);}//if option = 2, change current page to page 6
		}
	}
	
	public void p10Info() {//display the information for page 10
		
		Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("Billing Information: ");//print out message
		System.out.println("Name     Quantity   Price");//print out message
		
		System.out.println(cart.getContent());//print out the content of the cart
		
		System.out.print("Environment Tax    2%    ");//print out message
		
		System.out.println(cart.getEnvirTax());//print EnviroTax
		System.out.print("HST    13%    ");//print out message
		
		System.out.println(cart.getHST());//print hst
		System.out.print("Shipping    10%    ");//print out message
		
		System.out.println(cart.getShipping());//print shipping
		System.out.print("\nTotal: ");//print out message
		
		System.out.println(cart.getTotal());//print total
		System.out.println("Are you sure you want to pay?");//ask for user input
		String s1 = sc.nextLine().toLowerCase();//store the user input in a string and make it not case sensitive
		
		while (!s1.equals("yes") && !s1.equals("no")) {//check if user input is yes or no
			
			System.out.println("Plz enter yes or no: ");//if not, ask for user input
			s1 = sc.nextLine().toLowerCase();//!!!!!String cannot be overwritten!! How to do the error handle
		}
		
		if (s1.equals("yes")) {//if the user want to pay
			System.out.println("Comfirmation ID: U1000");//!!!U1000 should be upadated, but how?
			System.out.println("Items shipped to: " + cart.getUsername());//print out message
			System.out.println("Thanks for shopping! Now goes to browse item page");//print out message
			changeCurrentPage(5);//change current page to page 5
		}
		
		if (s1.equals("no")) {// if they don't want to pay
			System.out.println("Checkout not finished. Go to browse item page");//print out message
			changeCurrentPage(5);//change current page to page 5
		}
	}
	
	public void writeReadable() {//write the readable ArrayList to a file
		
		try {
			BufferedWriter outputB = new BufferedWriter(new FileWriter("Books.txt", false));//file writer
			BufferedWriter outputE = new BufferedWriter(new FileWriter("Ebooks.txt", false));//file writer
			for (int i = 0; i < readables.size(); i++) {//loop thorough the readable ArrayList
				
				if (readables.get(i).getType().equals("Book")) {//check type
					
					outputB.write(readables.get(i).getInfo());//write book into text file
					outputB.newLine();//print a new line
				} else {//if it is a ebook
					outputE.write(readables.get(i).getInfo());//write ebook into text file
					outputE.newLine();//print a new line
				}
				
				outputB.close();//close the file
				outputE.close();//close the file
			}
		} catch (IOException e) {}//handle exception
	}
	
public void writeAudio() {//write the audio ArrayList to a file
		
		try {
			BufferedWriter outputC = new BufferedWriter(new FileWriter("CDs.txt", false));//file writer
			BufferedWriter outputM = new BufferedWriter(new FileWriter("MP3.txt", false));//file writer
			for (int i = 0; i < audioProducts.size(); i++) {//loop thorough the audio ArrayList
				
				if (audioProducts.get(i).getType().equals("CD")) {//check type
					
					outputC.write(audioProducts.get(i).getInfo());//write CD into text file
					outputC.newLine();//print a new line
				} else {//if it is a MP3
					outputM.write(audioProducts.get(i).getInfo());//write MP3 into text file
					outputM.newLine();//print a new line
				}
				
				outputC.close();//close the file
				outputM.close();//close the file
			}
		} catch (IOException e) {}//handle exception
	}
}
