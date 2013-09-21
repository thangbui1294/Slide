/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates SlideList class that contains a list of SlideNodes with head, tail, and cursor.  
 */
public class SlideList {
	private SlideNode head;
	private SlideNode tail;
	private SlideNode cursor; 

	/**
	 * Creates a new SlideList with default constructor which is an empty list. 
	 */
	public SlideList(){
		head = null;
		tail = null;
		cursor = null;
	}

	/**
	 * Add a new slide to the end of a particular SlideList
	 * @param newSlide
	 * the Slide which will be added as a data Slide for a new SlideNode
	 * @throws IllegalArgumentException
	 * if the Slide to be added is null 
	 */
	public void addToEnd(Slide newSlide) throws IllegalArgumentException{
		if (newSlide == null){
			throw new IllegalArgumentException("newSlide is null");
		}
		SlideNode newSlideNode = new SlideNode();
		newSlideNode.setSlide(newSlide);
		if (tail == null){
			head = newSlideNode;
			tail = newSlideNode;
			cursor = newSlideNode;
		}
		else{
			newSlideNode.setPrev(tail);
			tail.setNext(newSlideNode);
			tail = newSlideNode;
			cursor = newSlideNode;
		}
	}

	/**
	 * Add a new slide after the current slide of a particular linked list 
	 * @param newSlide
	 * the Slide which will be added as a data Slide for a new SlideNode 
	 * @throws IllegalArgumentException
	 * if the Slide to be added is null 
	 */
	public void addAfterCurrent(Slide newSlide) throws IllegalArgumentException{
		if (newSlide == null){
			throw new IllegalArgumentException("newSlide is null");
		}
		SlideNode newSlideNode = new SlideNode();
		newSlideNode.setSlide(newSlide);
		if (cursor == null){
			head = newSlideNode;
			tail = newSlideNode;
			cursor = newSlideNode;
		}
		else {
			newSlideNode.setNext(cursor.getNext());
			cursor.setNext(newSlideNode);
			newSlideNode.setPrev(cursor);
			cursor = newSlideNode;
			if (cursor.getNext() == null){
				tail = cursor;
			}
		}
	}

	/**
	 * Removes the current slide, which is the cursor. 
	 * @return
	 * true if a slideNode is removed, false otherwise. 
	 */
	public boolean removeCurrentSlide(){
		if (cursor == null){
			return false;
		}
		if (head == tail){
			head = null;
			tail = null;
			cursor = null;
			return true;
		}
		if (cursor == tail){
			cursor.getPrev().setNext(null);
			cursor = cursor.getPrev();
			tail = cursor;
			return true;
		}
		cursor.getPrev().setNext(cursor.getNext());
		cursor.getNext().setPrev(cursor.getPrev());
		cursor = cursor.getNext();
		return true;
	}

	/**
	 * Displays all slides within given range inclusively 
	 * @param start
	 * the start position to print 
	 * @param end
	 * the end position to print 
	 * @throws EmptyListException
	 * if the list is empty 
	 * @throws IllegalArgumentException
	 * if the start position is greater than the end position 
	 * or the start position is beyond the list 
	 */
	public void displaySlides(int start, int end) throws EmptyListException, IllegalArgumentException{
		if (head == null){
			throw new EmptyListException("The list is empty"); 
		}
		if (start > end){
			throw new IllegalArgumentException("start position cannot greater than end position");
		}
		if (start < 1) {
			start = 1; 
		}
		boolean moved = jumpToPosition(start);
		if (moved){
			displayCurrentSlide();
			while ((cursor != null) && (start < end)){
				cursor = cursor.getNext();
				displayCurrentSlide();
				start++;
			}
			if (cursor == null){
				cursor = tail;
			}
		}
		else throw new IllegalArgumentException("Start position is beyond the list");
	}

	/**
	 * Prints out the slide from the current Slide of a particular list. 
	 * @throws EmptyListException
	 * if the list is empty. 
	 */
	public void displayCurrentSlide() throws EmptyListException{
		if (cursor == null){
			throw new EmptyListException("The list is empty");
		}

		SlideNode currentSlide = head;
		int count = 1;
		while  (currentSlide != cursor){
			count++;
			currentSlide = currentSlide.getNext();
		}
		System.out.println("******************** " + count + " ********************");
		try{
			for (int i = 1; i <= 5; i++){
				System.out.println(cursor.getSlide().getText(i));
			}
		}
		catch (IllegalArgumentException ex){
		}
		System.out.println("******************** " + count + " ********************");
	}

	/**
	 * Moves the current slide forward in the list by one position. 
	 * @return
	 * true if the current slide is moved and false otherwise 
	 * @throws EmptyListException
	 * if the list is empty. 
	 */
	public boolean moveForward() throws EmptyListException{
		if (cursor == null){
			throw new EmptyListException("The list is empty");
		}
		if (cursor != tail){
			cursor = cursor.getNext();
			return true;
		}
		return false;
	}

	/**
	 * Moves the current slide backwards in the list by one position. 
	 * @return
	 * true if the current slide is moved and false otherwise 
	 * @throws EmptyListException
	 * if the list is empty. 
	 */
	public boolean moveBack() throws EmptyListException{
		if (cursor == null){
			throw new EmptyListException("The List is empty");
		}
		if (cursor != head){
			cursor = cursor.getPrev();
			return true;
		}
		return false;
	}

	/**
	 * Edits slide context of the current slide.
	 * @param text
	 * the text will be set to a specific position of a slide
	 * @param lineNum
	 * the position of the text will be set
	 * @throws EmptyListException
	 * if the list is empty. 
	 */
	public void editCurrentSlide(String text, int lineNum) throws EmptyListException, IllegalArgumentException{
		if (cursor == null){
			throw new EmptyListException("The list is empty");
		}
		try {
			cursor.getSlide().setText(text, lineNum);
		}
		catch (IllegalArgumentException ex){
			System.out.println("Invalid range of position");
		}
	}

	/**
	 * Moves the current slide to a given position. 
	 * @param position
	 * the position that the current will move to 
	 * @return
	 * true if the current slide was moved, false otherwise.
	 * @throws IllegalArgumentException
	 * if the position is negative. 
	 */
	public boolean jumpToPosition(int position) throws IllegalArgumentException{
		if (cursor == null){
			return false;
		}
		SlideNode nodePtr = head;
		int count = 1; 
		if (position <= 0){
			throw new IllegalArgumentException("The position cannot be negative");
		}
		while ((nodePtr != null) && (count < position)){
			count++;
			nodePtr = nodePtr.getNext();
		}
		if (nodePtr != null){
			cursor = nodePtr;
		}
		return (nodePtr != null);
	}






	public static void main(String[] args){
		try{
			Slide slide1 = new Slide();
			slide1.setText("Line 1-1", 1);
			slide1.setText("Line 1-2", 2);
			slide1.setText("Line 1-3", 3);
			slide1.setText("Line 1-4", 4);
			slide1.setText("Line 1-5", 5);

			Slide slide2 = new Slide();
			slide2.setText("Line 2-1", 1);
			slide2.setText("Line 2-2", 2);
			slide2.setText("Line 2-3", 3);
			slide2.setText("Line 2-4", 4);
			slide2.setText("Line 2-5", 5);

			Slide slide3 = new Slide();
			slide3.setText("Line 3-1", 1);
			slide3.setText("Line 3-2", 2);
			slide3.setText("Line 3-3", 3);
			slide3.setText("Line 3-4", 4);
			slide3.setText("Line 3-5", 5);

			Slide slide4 = new Slide();
			slide4.setText("Line 4-1", 1);
			slide4.setText("Line 4-2", 2);
			slide4.setText("Line 4-3", 3);
			slide4.setText("Line 4-4", 4);
			slide4.setText("Line 4-5", 5);

			SlideList slideList1 = new SlideList();
			slideList1.addAfterCurrent(slide1);
			slideList1.addAfterCurrent(slide2);
			slideList1.addAfterCurrent(slide3);
			slideList1.addToEnd(slide4);
			
			System.out.println(slideList1.head.getSlide());
			System.out.println(slideList1.tail.getSlide());
			slideList1.displayCurrentSlide();
			System.out.println(slideList1.head.getSlide());
			System.out.println(slideList1.tail.getSlide());


		}
		catch (IllegalArgumentException ex){

		}
		catch (EmptyListException ex){

	}
	}
}
