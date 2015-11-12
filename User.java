/*
* Name:​Tianqi Qi,Yihan Lu, Shiyu Luo
* MacID:​qit3, luy27, luos
* Student Number:​1405930,1428072, 1317135
* Description:​This class build the object user.
*/
public class User {//public class

		private String username;//private user name
		
		public User() {}//empty constructor
		
		public User(String str) {//constructor take in a string as user name
			
			username = str;//assign given string to the user name
		}
		
		public String getUsername() {//return the user name as a string
			return username;//retunr the string
		}
		
}
