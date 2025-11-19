package week11.praktek3;

public class ExcessiveFailLoginException extends Exception {
	public ExcessiveFailLoginException() {
		super("Anda telah mencapai jumlah batas login");
	}
	public ExcessiveFailLoginException(String msg) {
		super(msg);
	}
}
