

/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates an exception class to throw if the position to add, get or remove a song is not in valid range
 */
public class IllegalArgumentException extends Exception{
	/**
	 * Creates new default IllegalArgumentException exception
	 */
	public IllegalArgumentException(){
		super("Invalid range of the position");
	}

	/**
	 * Creates new IllegalArgumentException exception with a String parameter
	 * @param message
	 * the String for a new exception 
	 */
	public IllegalArgumentException(String message){
		super(message);
	}
}