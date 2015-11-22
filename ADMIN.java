import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;

public class ADMIN extends User{
	
	private StringBuilder passWord;
	//StringBuilder str = new StringBuilder(passWord);
	
	public ADMIN() {
		super("ADMIN");
		String name = null;
		
		try {
			BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
			
			String line = null;//create a string to store each line of the file
			
			while ((line = input.readLine()) != null) {//loop through the file
				
				if (line.contains("ADMIN")) {
					name = line.split(", ")[1];
				}
			}
			
			input.close();//close the file
			passWord = new StringBuilder(name);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	public String getPassword() {
		
		return passWord.toString();
	}
	
	
	public void changePassword(String temp) {
		
		passWord = passWord.replace(0, passWord.length(), temp);
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("Users1.txt", false));
			BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
			
			String line = null;
			
			while ((line = input.readLine())!= null) {//loop through the file
				if (!line.contains("ADMIN")) {
					output.write(line);
					output.newLine();
				}
			}
			input.close();
			
			output.write("ADMIN, " + passWord.toString());
			output.close();
			
			File file1 = new File("Users.txt");
			File file2 = new File("Users1.txt");
			if (file1.delete()){
		        file2.renameTo(file1);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
