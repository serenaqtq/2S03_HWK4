/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the UserInterface which contains all the page navigation
*/
import java.util.ArrayList;//import ArrayList
import java.util.Collections;
import java.util.Scanner;//import Scanner
import java.io.*;//import IO
public class UserInterface {//public the class
	
	private ArrayList<Readable> readables = new ArrayList<Readable>();//ArrayList contains all the readable item
	private ArrayList<Audio> audioProducts = new ArrayList<Audio>();//ArrayList contains all the audio item
	private ArrayList<User> name = new ArrayList<User>();//ArrayList contains all the user
	private ShoppingCart cart;//Create a shopping cart object
	private String confirmationId;//Create a string to store the confirmation ID for each order
	private ADMIN adm;

	
	private int currentPage;//Create a int to track the page
	
	Scanner sc = new Scanner(System.in);//Create Scanenr
	
	public UserInterface(int num) {//Constructor
		
		currentPage = num;//set current page as given int
	}
	
	public int getCurrentPage(){//return current page
		
		return currentPage;//return the value of currentPage
	}
	
	public void changeCurrentPage(int newPage){//update the value of currentPage
		
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
			System.out.println("There is an error in getUser().");//print out error message
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
			System.out.println("There is an error in getReadable().");//print out the error message
		}
	}
	
	public void getAudioProducts(){//initialize the audio ArrayList
		
		try {//try-catch structure
			BufferedReader inputC = new BufferedReader(new FileReader("CDs.txt"));//file reader
			BufferedReader inputM= new BufferedReader(new FileReader("MP3s.txt"));//file reader
			
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
			System.out.println("There is an error in getAudioProducts().");///print out the error message
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
		Book b1 = new Book(Integer.parseInt(temp[0]), Double.parseDouble(temp[3]), temp[1], temp[2], Integer.parseInt(temp[4]));//call the constructor
		
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
		case 11: p11Info(); //if pageNum = 11, display the p11 message
				break;//break the loop
		case 12: p12Info(); //if pageNum = 12, display the p12 message
				break;//break the loop
		case 13: p13Info();//if pageNum = 12, display the p13 message
				break;//break the loop
		case 14: p14Info();//if pageNum = 12, display the p14 message
				break;//break the loop
		case 15: p15Info();//if pageNum = 12, display the p15 message
				break;//break the loop
		case 16: p16Info();//if pageNum = 12, display the p16 message
				break;//break the loop
		}
		
	}
	
	public void p1Info(){//display the information of page 1
		//Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("1. Sign in");//print each option
		System.out.println("2. Sign up");//print each option
		System.out.println("Choose your option: ");//ask for user input
		double choice = sc.nextDouble();//take a user input as double
		while (choice != 1 && choice != 2) {//check if choice == 1 or 2
			
			System.out.println("Plz enter choice 1 or 2: ");//if not, ask for another user input
			choice = sc.nextDouble();//overwrite the double
		}
		System.out.println("\n========================================");//formating
		if ((int)choice == 2) {changeCurrentPage(2);}//if user choose 1, display page 2
		if ((int)choice == 1) {changeCurrentPage(3);}//if user choose 2, display page 3
		
	}
	
	public void p2Info(){//display the information of page 2
		
		//Scanner sc = new Scanner(System.in);//create a scanner
		try {
			System.out.println("Choose your user name:");//ask for user name
			sc.nextLine();
			String n1 = sc.nextLine();//read user input as a string
			File createShoppingCart = new File ("Cart_"+n1+".txt"); //Create a new file object for user
			if(createShoppingCart.createNewFile()){//Create a new file for user's shopping cart an returns a boolean value true if the file is created successfully, vice versa
				cart = new ShoppingCart(n1);//initialize the shopping cart
				name.add(stringToUser(n1));//add user to the ArrayList
				writeUser();
				System.out.println("\nUser name successfully added");//print out the message
				changeCurrentPage(1);//change current page to page 1
				System.out.println("\n========================================");//formating
			}else {
				System.out.println("\n========================================");//formating
		        changeCurrentPage(1);
		        //System.out.println("File already exists.");
			}
		}catch(IOException e) {//catch IOException
			System.out.println("There is an error in p2Info().");///print out the error message
		}
	}
		
	
	public void p34Info(){//display the information for page 3 and 4
		
		//Scanner sc = new Scanner(System.in);//create the scanner
		System.out.println("Enter your username: ");//ask for user name
		sc.nextLine();
		String n1 = sc.nextLine();//store user input as a string
		boolean check = false;//set boolean to false
		
		if (n1.equals("ADMIN")) {
			adm = new ADMIN();
			System.out.println("Plz enter your password: ");
			//sc.nextLine();
			String p1 = sc.nextLine();
			if (!p1.equals(adm.getPassword())) {
				System.out.println("Access denied. Back to previous menu.");
				System.out.println("\n========================================");//formating
				changeCurrentPage(1);
			} else {
				System.out.println("Hello, ADMIN");
				System.out.println("\n========================================");//formating
				cart = new ShoppingCart(n1);
				cart.readBook();
				cart.readCD();
				cart.readeBook();
				cart.readMP3();
				cart.loadCart();//assign to the shopping cart
				changeCurrentPage(12);
			}
		} else {
		
			for (int i = 0; i < name.size(); i++) {//loop through the user ArrayList
				if (((name.get(i)).getUsername()).equals(n1)) {//check if the user input match the existing name
					
					check = true;//if match, change to true
				}
			}
			
			if (check) {//name match the existing name
				
				cart = new ShoppingCart(n1);
				cart.readBook();
				cart.readCD();
				cart.readeBook();
				cart.readMP3();
				cart.loadCart();//assign to the shopping cart
				System.out.println("Hello Mr/Miss. " + n1);//print out the welcome message
				changeCurrentPage(5);//change current page to page 5
				System.out.println("\n========================================");//formating
			} else {//if not match the existing name
				
				System.out.println("No Access");//print out the message
				System.out.println("\n========================================");//formating
				changeCurrentPage(1);////change current page to page 1
			}
		}
	}
	
	public void p5Info(){//display the information for page 5
		
		//Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("1. View Items By Category");//print out option
		System.out.println("2. View Shooping Cart");//print out option
		System.out.println("3. Sign Out");//print out option
		System.out.println("4. View Previous Orders");
		System.out.println("\nChoose your option: ");//ask for user input
		
		double option = sc.nextDouble();//store user input into a double
		
		while(option != 1 && option != 2 && option != 3 && option != 4) {//check if user input equals to 1, 2 or 3
			
			System.out.println("Plz enter option 1, 2, 3 or 4: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		System.out.println("\n========================================");//formating
		if (option == 1) {changeCurrentPage(6);}//if option = 1, change current page to page 6
		if (option == 2) {changeCurrentPage(7);}//if option = 2, change current page to page 7
		if (option == 3) {changeCurrentPage(1);}//if option = 3, change current page to page 1
		if (option == 4) {changeCurrentPage(11);}//if option = 4, change current page to page 11
		
	}
	
	public void p6Info() {//display the information for page 6
		
		//Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("1. Readables");//print out option
		System.out.println("2. Audio");//print out option
		System.out.println("\nChoose your oprion: ");//ask for user input
		System.out.println("\nPress -1 to return  to previous menu");//print out option
		
		double option = sc.nextDouble();//store the user input in a double
		
		while(option != 1 && option != 2 && option != -1) {//check if user input equals to 1, 2 or -1
		
			System.out.println("Plz enter option 1, 2 or -1: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		System.out.println("\n========================================");//formating
		if (option == 1) {changeCurrentPage(8);}//if option = 1, change current page to page 8
		if (option == 2) {changeCurrentPage(9);}//if option = 2, change current page to page 9
		if (option == -1) {
			if (adm.getAdmin() == "ADMIN") {
					changeCurrentPage(12);
			}//if option = -1 and user is admin, change current page to page 12
			else {
				changeCurrentPage(5);//if option = -1 and not admin, change current page to 5
			}
		}
	}
	
	public void p7Info() {//display the information for page 7
		
		//Scanner sc = new Scanner(System.in);//create scanner
		System.out.println("\n========================================");
		cart.getContent();//print out the whole cart
		System.out.println("Plz enter 1 to checkout or -1 to previous page: ");//ask for user input
		double option = sc.nextDouble();//store the user input in a double
		
		while(option != 1 && option != -1) {//check if user input equals to 1 or -1
		
			System.out.println("Plz enter option 1 or -1: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		System.out.println("\n========================================");//formating
		if (option == 1) {changeCurrentPage(10);}//if option = 1, change current page to page 10
		if (option == -1) {changeCurrentPage(5);}//if option = -1, change current page to page 5
	}
	
	public void p8Info() {//display the information for page 8
		
		//Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("Readables: \n");//print out the message
		System.out.println("S.No  Name of the Book   Author  Price($)  Quantity in Store  Type");//print out the message
		
		printReadable();//print out the readable ArrayList
		
		System.out.println("Choose your option from 1 to " + readables.size() + ": ");//ask for user input
		System.out.println("Press -1 to return to previous menu.");//print out the message
		
		double option = sc.nextDouble();//store the user input in a double
		
		while (option > readables.size() && option != -1) {//check if user input equals to -1 or option larger than the quantity of item
			
			System.out.println("Plz enter a valid option: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}

		
		if (option == -1) {changeCurrentPage(6);}//if option = -1, change current page to page 6
		else {//if user want to add item to cart
			while (readables.get((int)option - 1).getQuantity() == 0) {
				System.out.println("Sorry, the item is out of stock! Plz choose another item: ");
				option = sc.nextDouble();
			}
			System.out.println("Enter quantity: ");//ask for user input
			int quan = sc.nextInt();//store the user input in a int
			
			while(quan > (readables.get((int)option - 1)).getQuantity()) {//check if user input larger than the given quantity
				
				System.out.println("Not enough item. Plz enter a smaller quantity.");//if not, ask for user input
				quan = sc.nextInt();//overwrite the int with new user input
			}
			
			
			cart.AddItem(readables.get((int)option - 1).getTitle(), quan);//add item to cart
			readables.get((int)option - 1).changeQuantity(quan);//update the quantity of readable

			System.out.println(quan + " " + readables.get((int)option - 1).getTitle() + " successfully added to your cart.");//print out message
			
			System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut: ");//ask for user input
			
			double option1 = sc.nextDouble();//store the user input in a double
			
			while (option1 != 0 && option1 != -2) {//check if user input equals to 0 or -2
				
				System.out.println("Plz enter option 0 or -2: ");//if not, ask for user input
				option1 = sc.nextDouble();//overwrite the double with new user input
			}
			System.out.println("\n========================================");//formating
			if (option1 == 0) {changeCurrentPage(10);}//if option = 0, change current page to page 10
			if (option1 == -2) {changeCurrentPage(6);}//if option = 2, change current page to page 6
			
			
		}
	}
	
	public void p9Info() {//display the information for page 9
		
		//Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("Audio: \n");//print out the message
		System.out.println("S.No  Name   Author  Price($)  Quantity in Store  Type");//print out the message
		
		printAudioProduct();;//print out the information of the audio ArrayList
		
		System.out.println("Choose your option from 1 to " + audioProducts.size() + ": ");//ask for user input
		System.out.println("Press -1 to return to previous menu.");//print out the message
		
		double option = sc.nextDouble();//store the user input in a double
		
		while (option > audioProducts.size() && option != -1) {//check if user input equals to -1 or option larger than the quantity of item
			
			System.out.println("Plz enter a valid option: ");//if not, ask for user input
			option = sc.nextDouble();//overwrite the double with new user input
		}
		
		
		if (option == -1) {changeCurrentPage(6);}//check if user input equals to -1
		else {//if not
			
			while (audioProducts.get((int)option - 1).getQuantity() == 0) {
				System.out.println("Sorry, the item is out of stock! Plz choose another item: ");
				option = sc.nextDouble();
			}
			
			System.out.println("Enter quantity: ");//ask for user input
			int quan = sc.nextInt();//store the user input in a int
			
			while(quan > (audioProducts.get((int)option - 1)).getQuantity()) {//check if user input larger than the given quantity
				
				System.out.println("Not enough item. Plz enter a smaller quantity.");//if not, ask for user input
				quan = sc.nextInt();//overwrite the int with new user input
			}
			
			cart.AddItem(audioProducts.get((int)option - 1).getTitle(), quan);//add item to cart
			audioProducts.get((int)option - 1).changeQuantity(quan);//update the quantity of audioProducts
			
			System.out.println(quan + " " + audioProducts.get((int)option - 1).getTitle() + " successfully added to your cart.");//print out message
			
			System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut: ");//ask for user input
			
			double option1 = sc.nextDouble();//store the user input in a double
			
			while (option1 != 0 && option1 != -2) {//check if user input equals to 0 or -2
				
				System.out.println("Plz enter option 0 or -2: ");//if not, ask for user input
				option1 = sc.nextDouble();//overwrite the double with new user input
			}
			System.out.println("\n========================================");//formating
			if (option1 == 0) {changeCurrentPage(10);}//if option = 0, change current page to page 10
			if (option1 == -2){changeCurrentPage(6);}//if option = 2, change current page to page 6
		}
	}
	
	public void p10Info() {//display the information for page 10
		
		//Scanner sc = new Scanner(System.in);//create scanner
		
		System.out.println("Billing Information: ");//print out message
		System.out.println("Name     Quantity   Price");//print out message
		
		cart.getCheckout();//print out the content of the cart
		
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
		//System.out.println(s1);
		
		while (!s1.equals("yes") && !s1.equals("no")) {//check if user input is yes or no
			
			System.out.println("Plz enter yes or no: ");//if not, ask for user input
			s1 = sc.nextLine().toLowerCase();//!!!!!String cannot be overwritten!! How to do the error handle
		}
		
		if (s1.equals("yes")) {//if the user want to pay
			int num = cart.checkItemsBought(); //Check how many items are in ItemsBought
			if (num == 0) {
				confirmationId = "U1000";//If ItemsBought is empty, begin with U1000 as confirmation id
			}
			else {
				String a=cart.getConfirmationId();//Get confirmation ID as a string
				int id =Integer.parseInt(a.substring(1,a.length())) + 1;//Convert 1000 to a number and add 1
				confirmationId = "U" + String.valueOf(id);//Set new confirmation id
			}
			System.out.println(confirmationId);//prints confirmation Id
			System.out.println("Items shipped to: " + cart.getUsername());//print out message
			System.out.println("Thanks for shopping! Now goes to browse item page");//print out message
			cart.writeItemsBought(confirmationId);//Write the order to the text file
			cart.clearCart();//Clear the cart after checkout
			writeReadable();//Write readable back to file
			writeAudio();//Write audio back to file
			System.out.println("\n========================================");//formating
			changeCurrentPage(5);//change current page to page 5
		}
		
		if (s1.equals("no")) {// if they don't want to pay
			System.out.println("Checkout not finished. Go to browse item page");//print out message
			System.out.println("\n========================================");//formating
			changeCurrentPage(5);//change current page to page 5
		}
	}
	
	public void p11Info() {
		System.out.println("Confirmation Id   Product Name   Total");//print out the message
		cart.getItemsBought();//print out the order information
		System.out.println("Press -1 to return to the previous page: ");//ask for user input
		double option1 = sc.nextDouble();//store the user input in a double
		while (option1 != -1) {//check if user input equals to -1
			
			System.out.println("Plz enter option -1: ");//if not, ask for user input
			option1 = sc.nextDouble();//overwrite the double with new user input
		}
		System.out.println("\n========================================");//formating
		if (option1 == -1){changeCurrentPage(5);}//if option = -1, change current page to page 5
	}
	
	public void p12Info(){
		
		System.out.println("1. View Items By Category");//print out option
		System.out.println("2. View Shooping Cart");//print out option
		System.out.println("3. Sign Out");//print out option
		System.out.println("4. View Previous Orders");
		System.out.println("5. Change password");
		System.out.println("6. Delete duplicate username");
		System.out.println("7. Add items to inventory");
		System.out.println("8. Sort the inventory");
		System.out.println("\nChoose your option: ");//ask for user input
		
		//sc.nextLine();
		String option = sc.nextLine();
		while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && 
				!option.equals("5") && !option.equals("6") && !option.equals("7") && !option.equals("8")) {
			System.out.println("Plz enter a number between 1-8: ");
			option = sc.nextLine();
		}
		
		if (Integer.parseInt(option) == 1) {changeCurrentPage(6);}//if option = 1, change current page to page 6
		if (Integer.parseInt(option) == 2) {changeCurrentPage(7);}//if option = 2, change current page to page 7
		if (Integer.parseInt(option) == 3) {changeCurrentPage(1);}//if option = 3, change current page to page 1
		if (Integer.parseInt(option) == 4) {changeCurrentPage(11);}//if option = 4, change current page to page 11
		if (Integer.parseInt(option) == 5) {changeCurrentPage(13);}//if option = 5, change current page to page 13
		if (Integer.parseInt(option) == 6) {changeCurrentPage(14);}//if option = 6, change current page to page 14
		if (Integer.parseInt(option) == 7) {changeCurrentPage(15);}//if option = 7, change current page to page 15
		if (Integer.parseInt(option) == 8) {changeCurrentPage(16);}//if option = 8, change current page to page 16
		
	}
	
	public void p13Info() {
		
		System.out.println("Plz enter your new password: ");
		String str = sc.nextLine();
		
		adm.changePassword(str);
		//System.out.println(adm.getPassword());
		System.out.println("Password successfully changed. Now back to previous menu");
		System.out.println("\n========================================");//formating
		changeCurrentPage(12);
	}
	
	public void p14Info() {
		System.out.println("System checking for duplicate username ...");
		System.out.println("Users.txt before checking: ");
		
		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i).getUsername());
		}
		
		System.out.println("\n========================================");//formating
		for (int i = 0; i < name.size(); i++) {
			
			String temp = name.get(i).getUsername();
			for (int j = i + 1; j < name.size(); j++) {
				if (name.get(j).getUsername().equals(temp)) {
					name.remove(j);
				}
			}
		}
		
		System.out.println("Users after checking");
		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i).getUsername());
		}
		System.out.println("\n========================================");//formating
		System.out.println("Operation finished. Now back to previous menu.");
		System.out.println("\n========================================");//formating
		changeCurrentPage(12);
	}
	
	public void p15Info() {
	
		System.out.println("Enter the information of the item: ");
		System.out.println("sNO: ");
		
		while (!sc.hasNextInt()) {
			System.out.println("Plz enter a integer as sNo: ");
			sc.next();
		}
		
		int num = sc.nextInt();
	
		System.out.println("Title: ");
		sc.nextLine();
		String title = sc.nextLine();
		
		System.out.println("Author name/Artist name: ");
		String aName = sc.nextLine();
		
		System.out.println("Price: ");
		
		while (!sc.hasNextDouble()) {
			System.out.println("Plz enter a double as price: ");
			sc.next();
		}
		
		double price = sc.nextDouble();
		
		System.out.println("Quantity: ");
		
		while (!sc.hasNextInt()) {
			System.out.println("Plz enter a integer as sNo: ");
			sc.next();
		}
		int quan = sc.nextInt();
		
		System.out.println("Choose inventory: ");
		System.out.println("1. Books");//print out option
		System.out.println("2. eBooks");//print out option
		System.out.println("3. CDs");
		System.out.println("4. MP3s");
		System.out.println("\nChoose your oprion: ");//ask for user input
		
		String option = sc.nextLine();
		while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")) {
			System.out.println("Plz enter a number between 1-4: ");
			option = sc.nextLine();
		}
		
		if (Integer.parseInt(option) == 1) {
			System.out.println("Now add item to book inventory...");
			Book tempB = new Book(num, price, title, aName, quan);
			readables.add(tempB);
		}
		if (Integer.parseInt(option) == 2) {
			System.out.println("Now add item to eBook inventory...");
			eBook tempB = new eBook(num, price, title, aName, quan);
			readables.add(tempB);
		}
		if (Integer.parseInt(option) == 3) {
			System.out.println("Now add item to CD inventory...");
			CD tempB = new CD(num, price, title, aName, quan);
			audioProducts.add(tempB);
		}
		if (Integer.parseInt(option) == 4) {
			System.out.println("Now add item to MP3 inventory...");
			MP3 tempB = new MP3(num, price, title, aName, quan);
			audioProducts.add(tempB);
		}
		System.out.println("Item add succesfully. Do you wanna ad  another item? ");
		String s1 = sc.nextLine().toLowerCase();//store the user input in a string and make it not case sensitive
		
		while (!s1.equals("yes") && !s1.equals("no")) {//check if user input is yes or no
			
			System.out.println("Plz enter yes or no: ");//if not, ask for user input
			s1 = sc.nextLine().toLowerCase();//!!!!!String cannot be overwritten!! How to do the error handle
		}
		
		if (s1.equals("no")) {
			writeReadable();//Write readable back to file
			writeAudio();//Write audio back to file
			System.out.println("Now back to previous menu.");
			System.out.println("\n========================================");//formating
			changeCurrentPage(12);
		}
		if (s1.equals("yes")) {
			System.out.println("\n========================================");//formating
			changeCurrentPage(15);
		}
	}
	
	public void p16Info() {
		
		System.out.println("Which inventory you want to sort? ");
		System.out.println("1. Readable");
		System.out.println("2. Audio");
		System.out.println("Choose your option: ");
		
		String option = sc.nextLine();
		while (!option.equals("1") && !option.equals("2")) {
			System.out.println("Plz enter a number between 1-2: ");
			option = sc.nextLine();
		}
		
		System.out.println("\n========================================");//formating
		
		System.out.println("What kind of sorting algorithm you want to use? ");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by price");
		System.out.println("Choose your option: ");
		
		String option1 = sc.nextLine();
		while (!option1.equals("1") && !option1.equals("2")) {
			System.out.println("Plz enter a number between 1-2: ");
			option1 = sc.nextLine();
		}
		
		if (Integer.parseInt(option) == 1) {
			if (Integer.parseInt(option1) == 1) {
				for (int i = 0; i < readables.size() - 1; i++){
		            int index = i;
		            for (int j = i + 1; j < readables.size(); j++){
		            	double temp;
		            	temp = readables.get(j).getTitle().compareTo(readables.get(j).getTitle());
		                if (temp > 0){
		                    index = j;}
		            
		            Collections.swap(readables, i, index);
		            }
				}
			}
			if (Integer.parseInt(option1) == 2) {
				for (int i = 0; i < readables.size() - 1; i++){
		            int index = i;
		            for (int j = i + 1; j < readables.size(); j++){
		                if (readables.get(j).getPrice() < readables.get(index).getPrice()){
		                    index = j;
		                }
		            }
		            
		            Collections.swap(readables, i, index);
		        }
			}
		}
		
		if (Integer.parseInt(option) == 2) {
			if (Integer.parseInt(option1) == 1) {

				for (int i = 0; i < audioProducts.size() - 1; i++){
		            int index = i;
		            for (int j = i + 1; j < audioProducts.size(); j++){
		            	double temp;
		            	temp = audioProducts.get(j).getTitle().compareTo(audioProducts.get(j).getTitle());
		                if (temp > 0){
		                    index = j;}
		            
		            Collections.swap(audioProducts, i, index);
		            }
				}
			
			}
			if (Integer.parseInt(option1) == 2) {
				for (int i = 0; i < audioProducts.size() - 1; i++){
		            int index = i;
		            for (int j = i + 1; j < audioProducts.size(); j++){
		                if (audioProducts.get(j).getPrice() < audioProducts.get(index).getPrice()){
		                    index = j;
		                }
		            }		            
		            Collections.swap(audioProducts, i, index);
		        }
			}
		}
//		for (int i = 0; i < audioProducts.size(); i++) {
//			System.out.println(audioProducts.get(i).getInfo());
//		}
		writeReadable();
		writeAudio();
		System.out.println("Sorting finished. Now back to previous page");
		System.out.println("\n========================================");//formating
		changeCurrentPage(12);

		
	}
		
	
	public void printReadable() {//print out the readable on the screen
		
		for (int i = 0; i < readables.size(); i++) {//loop through the readable
			System.out.println(readables.get(i).getInfo());//call the getInfo() for each item
		}
	}
	
	public void printAudioProduct() {//print out the audio on the screen
		
		for (int i = 0; i < audioProducts.size(); i++) {//loop through the audio
			System.out.println(audioProducts.get(i).getInfo());//call the getInfo() for each item
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
				
			}
			outputB.close();//close the file
			outputE.close();//close the file
		} catch (IOException e) {
			System.out.println(e);
		}//handle exception
	}
	
	public void writeAudio() {//write the audio ArrayList to a file
		
		try {
			BufferedWriter outputC = new BufferedWriter(new FileWriter("CDs.txt", false));//file writer
			BufferedWriter outputM = new BufferedWriter(new FileWriter("MP3s.txt", false));//file writer
			for (int i = 0; i < audioProducts.size(); i++) {//loop thorough the audio ArrayList
				
				if (audioProducts.get(i).getType().equals("CD")) {//check type
					
					outputC.write(audioProducts.get(i).getInfo());//write CD into text file
					outputC.newLine();//print a new line
				} else {//if it is a MP3
					outputM.write(audioProducts.get(i).getInfo());//write MP3 into text file
					outputM.newLine();//print a new line
				}
				
			}
			outputC.close();//close the file
			outputM.close();//close the file
		} catch (IOException e) {
			System.out.println("There is an error in writeAudio()");//handle exception
		}
	}

	public void writeUser() {//Write user back to text file
		
		try {//try-catch structure
			BufferedWriter output = new BufferedWriter(new FileWriter("Users.txt", false));//file writer
			
			for (int i = 0; i < name.size(); i++) {//loop through ArrayList
				output.write(name.get(i).getUsername());//write the name in file
				output.newLine();//print out a new line
			}
			output.close();//close the file
		} catch (IOException e) {//catch IOException
			System.out.println("There is an error in writeUser()");//print out the message
		}
	}
}
