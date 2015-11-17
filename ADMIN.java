import java.lang.StringBuilder;
public class ADMIN extends User{
	
	private StringBuilder passWord;
	//StringBuilder str = new StringBuilder(passWord);
	
	public ADMIN() {
		super("ADMIN");
		passWord = new StringBuilder("ADMIN");
	}
	
	public String getPassword() {
		
		return passWord.toString();
	}
	
	public void changePassword(String temp) {
		passWord = passWord.replace(0, passWord.length(), temp);
	}
}
