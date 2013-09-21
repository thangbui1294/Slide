/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates Slide class to store actual text that will appear on a slide
 */



public class Slide {
	private String[] text;
	private final int LINES_PER_SLIDE = 5;
	
	/**
	 * Creates a new Slide with the number of lines of text is 5 stored in an array of String
	 */
	public Slide(){
		text = new String[LINES_PER_SLIDE];
	}
	
	/**
	 * Receives text from one line of a particular Slide
	 * @param pos
	 * the line position to get the text from the Slide
	 * @return
	 * the text from a specific line as a String
	 * @throws IllegalArgumentException
	 * if the posistion to receive the text is not in valid range
	 */
	public String getText(int pos) throws IllegalArgumentException{
		if ((pos < 1) || (pos > 5)){
			throw new IllegalArgumentException("Position is not in valid range");
		}
		return text[pos-1];
	}
	
	/**
	 * Set text for a specific line of a particular Slide
	 * @param s
	 * the text as a String that need to be set at a specific line position
	 * @param pos
	 * the position of the line to set text
	 * @throws IllegalArgumentException
	 * if the position to set the text is not in valid range
	 */
	public void setText(String s, int pos) throws IllegalArgumentException{
		if ((pos < 1) || (pos > 5)){
			throw new IllegalArgumentException("Position is not in valid range");
		}
		text[pos-1] = s;
	}
	public String toString(){
		return text[0] + "\n" + text[1] + "\n" + text[2] + "\n" + text[3] + "\n" + text[4] + "\n"; 
	}
	public static void main(String[] args){
		Slide sl1 = new Slide();
		try {
		sl1.setText("Line 1" , 1);
		sl1.setText("Line 2", 2);
		sl1.setText("Line 3", 3);
		sl1.setText("Line 5", 5);
		sl1.setText("Line 4", 4);
		System.out.println(sl1);
		System.out.println(sl1.getText(5));
		System.out.println(sl1.getText(4));
		System.out.println(sl1.getText(3));
		System.out.println(sl1.getText(2));
		System.out.println(sl1.getText(1));
		
		}
		catch (IllegalArgumentException ex){
			System.out.println("Invalid range");
		}
		
	}
}
