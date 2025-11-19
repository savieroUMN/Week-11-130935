package week11.praktek3dan4;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Formatter;
import exceptions.ExcessiveFailLoginException;
import exceptions.InvalidPropertyException;

public class User {
	private String firstName;
	private String lastName;
	private Character gender;
	private String address;
	private String userName;
	private String password;
	private MessageDigest digest;
	
	private static final int maxLoginAttempts = 3;
	private static int LoginAttempts;
	
	private String hash(String strToHash) {
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
			for(byte b: hash)
				sb.append(String.format("%02x", b));
			return sb.toString();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	public User(String firstName,String lastName, Character gender, String address,String userName,String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.userName = userName;
		this.password = hash(password);
	}
	
	public boolean login(String username,String password) throws ExcessiveFailLoginException{
		if(this.userName.equals(username)) {
			if(LoginAttempts == maxLoginAttempts) {
				LoginAttempts++;
				throw new ExcessiveFailLoginException();
			}else if(LoginAttempts>maxLoginAttempts) {
				throw new ExcessiveFailLoginException("Anda telah mencapai batas login");
			}
			if(this.password.equals(hash(password))) {
				LoginAttempts = 0;
				return true;
			} else {
				System.out.println("password yang anda masukkan salah");
				System.out.print("kesempatan anda login " + (maxLoginAttempts-LoginAttempts));
				System.out.println(" Kali lagi");
				LoginAttempts++;
			}
		}
		return false;
	}
	
	public String greeting() {
		String greet = "Selanat datang";
		switch(gender) {
		case 'L': greet+="Tuan"; break;
		case 'P': greet+="Tuan"; break;
		}
		greet += this.firstName + " " + this.lastName;
		return greet;
	}
	
	public String getUserName() {
		return userName;
	}
}
