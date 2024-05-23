package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
		//
		System.out.println(dob);
		if ("siddharth".equals(username) && "sid_pass".equals(password)) {
			return true;
		}
		return false;
	}
	
	
}
