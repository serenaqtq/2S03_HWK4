import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {
	public static void main(String [] args){
		
		try {//try-catch structure
			BufferedReader inputU = new BufferedReader(new FileReader("Users.txt"));//file reader
			System.out.println("Reader create successfully");
			String lineU = null;//create a string to store each line of the file
			
			while ((lineU = inputU.readLine()) != null) {//loop through the file
				
				System.out.println(lineU);
			}
			
			inputU.close();//close the file
			
		} catch (FileNotFoundException e) {//catch IOException
			System.out.println("There is an error in getUser1().");//print out error message
		} catch (IOException e) {
			System.out.println("ioe");
		}
	}
}
