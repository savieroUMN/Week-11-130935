package week11.praktek3dan4;

public class InvalidPropertyException extends Exception{
	public InvalidPropertyException() {
		super("input data tidak valid");
	}
	public InvalidPropertyException(String msg) {
		super(msg);
	}
}
