/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates an exception class to throw if the doubly linked list is empty 
 */
public class EmptyListException extends Exception {

	/**
	 * Creates new default EmptyListException exception
	 */
	public EmptyListException(){
		super("The Link is empty");
	}

	/**
	 * Creates new EmptyListException exception with a String parameter
	 * @param message
	 * the String for a new exception 
	 */
	public EmptyListException(String message){
		super(message);
	}
}

