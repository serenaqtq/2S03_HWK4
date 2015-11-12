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

public class ShoppingCart extends User{//public ShoopingCart
	
	private ArrayList<Item> content = new ArrayList<Item>();//ArrayList of items
	
	public ShoppingCart(String name){//Constructor which take in a string as user name
		
		super(name);//call parent's constructor
		
		try {//try-catch structure to catch ant error
			BufferedReader input = new BufferedReader(new FileReader("Cart_" + this.getUsername() + ".txt"));//read in file
			
			String line = null;//define a string to store each line of the file
			while ((line = input.readLine()) != null) {//while loop to loop thorough the file
				content.add(stringToItem(line));//add item to the ArrayList
			}
			
			input.close();//close the file
			
		} catch (FileNotFoundException e) {//catch FileNotFoundException
			
			File createShoppingCart = new File ("Cart_"+n1+".txt"); //Create a shopping cart for the new user
		}
		
		
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
			
			shipping += content.get(i).getQuantity() * content.get(i).getPrice();//increment the shipping by the quantity*price
		}
		return shipping * 0.1;//return shipping * 10%
	}
	
	public double getHST() {//return the hst of the cart
		
		double hst;//create a double to store the hst
		for (int i = 0; i < content.size();i++) {//loop through the ArrayList
			
			hst += content.get(i).getQuantity() * content.get(i).getPrice();//increment the hst by the quantity*price
		}
		return hst * 0.13;//return hst * 13%
	}
	
	public double getTotal() {//return the total amount of the cart
		
		double total;//create a double variable to store the total amount
		for (int i = 0; i < content.size();i++) {//loop through the ArrayList
			
			total += content.get(i).getQuantity() * content.get(i).getPrice();//increment total by the quantity*price
		}
		return total + getHST() + getShipping() + getEnvirTax();//return the total price by adding hst, environmental tax and shipping
	}
	
	public void AddItem(Item a){//add an item to the cart
		
		content.add(a);//add to ArrayList
	}
	
	public Item stringToItem(String str) {//convert a string to item
		
		String[] temp = str.split(", ");//split the string
		Item i1 = new Item();//call the constructor
		
		return i1//return the item
	}
	
	public void writeCart() {//write the ArrayList back to the text file
		
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("Cart_" + super.getUsername() + ".txt", false));//file writer
			for (int i = 0; i < this.content.size(); i++) {//loop through the ArrayList
				
				output.write(content.get(i).getInfo());//write the information of each item as a string
				output.newLine();//print a new line
			}
			
			output.close();//close the file
		} catch (IOException e) {}//Catch IOException
	}
}
