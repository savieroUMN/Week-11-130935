package week11.praktek3dan4;

public class AuthernticationException extends Exception{
	
	public AuthernticationException() {
		super("Anda telah mencapai jumlah batas login");
	}
	public AuthernticationException(String msg) {
		super(msg);
	}
	
}
