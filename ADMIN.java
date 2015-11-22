/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the ADMIN extends User
*/
import java.io.BufferedReader;//import BufferedReader
import java.io.BufferedWriter;//import BufferedWriter
import java.io.File;//import file
import java.io.FileReader;//import FileReader
import java.io.FileWriter;//import FileWriter
import java.io.IOException;//import IOException
import java.lang.StringBuilder;//import StringBuilder

public class ADMIN extends User{
	
	private StringBuilder passWord;//Set password as a stringBuilder

	public ADMIN() {//public constructor
		super("ADMIN");//call parent's constructor
		String name = null;//set a string to null
		
		try {//try-catch structure
			BufferedReader input = new BufferedReader(new FileReader("Users.txt"));//file reader
			
			String line = null;//create a string to store each line of the file
			
			while ((line = input.readLine()) != null) {//loop through the file
				
				if (line.contains("ADMIN")) {//check if the user name match "ADMIN"
					name = line.split(", ")[1];//split the string
				}
			}
			
			input.close();//close the file
			passWord = new StringBuilder(name);//new the StringBuilder
		} catch (IOException e) {//catch exception
			System.out.println(e);////print out the exception
		}
	}
	
	
	public String getPassword() {//return password
		
		return passWord.toString();//return as a string
	}
	
	
	public void changePassword(String temp) {//change password to given string
		
		passWord = passWord.replace(0, passWord.length(), temp);//set password
		try {//try-catch structure
			BufferedWriter output = new BufferedWriter(new FileWriter("Users1.txt", false));//file writer
			BufferedReader input = new BufferedReader(new FileReader("Users.txt"));//file reader
			
			String line = null;//set a string to null
			
			while ((line = input.readLine())!= null) {//loop through the file
				if (!line.contains("ADMIN")) {//check if the string contain "ADMIN"
					output.write(line);//if not write the line to the new file
					output.newLine();//print a new line
				}
			}
			input.close();//close the file
			
			output.write("ADMIN, " + passWord.toString());//write new password to the new file
			output.close();//close the file
			
			File file1 = new File("Users.txt");//file1
			File file2 = new File("Users1.txt");//file2
			if (file1.delete()){//delete file1
		        file2.renameTo(file1);//rename file2
			}
		} catch (IOException e) {//catch exception
			System.out.println(e);//print out the error
		}
	}
}
