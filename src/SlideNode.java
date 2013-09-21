/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates SlideNode class that contains a reference to a Slide object as well as two other SlideNode objects 
 */

public class SlideNode {
	Slide slide;
	SlideNode prev;
	SlideNode next;

	/**
	 * Creates a new SlideNode with default constructor as well as default values for all three instance variables 
	 */
	public SlideNode(){
		this.slide = null;
		prev = null;
		next = null;
	}
	
	/**
	 * Sets a reference for a slide of a particular SlideNode 
	 * @param slide
	 * the slide that the will be referred to from a particular SlideNode 
	 */
	public void setSlide(Slide slide){
		this.slide = slide;
	}
	
	/**
	 * Receives the slide of a particular SlideNode 
	 * @return
	 * the slide of the SlideNode as a Slide object 
	 */
	public Slide getSlide(){
		return slide;
	}
	
	/**
	 * Refers next SlideNode to a different SlideNode in order to connect as a link 
	 * @param node
	 * the node that the next SlideNode will be referred to 
	 */
	public void setNext(SlideNode node){
		next = node;
	}
	
	/**
	 * Refers previous SlideNode to a different SlideNode in order to connect as a link 
	 * @param node
	 * the node that the previous SlideNode will be referred to 
	 */
	public void setPrev(SlideNode node){
		prev = node; 
	}
	
	/**
	 * Receives the next SlideNode that the current SlideNode refer to 
	 * @return
	 * the next node as a SlideNode object 
	 */
	public SlideNode getNext(){
		return next;
	}
	
	/**
	 * Receives the previous SlideNode that the current SlideNode refer to 
	 * @return
	 * the previous node as a SlideNode object 
	 */
	public SlideNode getPrev(){
		return prev;
	}
	public static void main(String[] args){
		Slide sl1 = new Slide();
		Slide sl2 = new Slide();
		Slide sl3 = new Slide();
		try {
		sl1.setText("Line 1-1" , 1);
		sl1.setText("Line 1-2", 2);
		sl1.setText("Line 1-3", 3);
		sl1.setText("Line 1-5", 5);
		sl1.setText("Line 1-4", 4);
		
		sl2.setText("Line 2-1" , 1);
		sl2.setText("Line 2-2", 2);
		sl2.setText("Line 2-3", 3);
		sl2.setText("Line 2-5", 5);
		sl2.setText("Line 2-4", 4);
		
		sl3.setText("Line 3-1" , 1);
		sl3.setText("Line 3-2", 2);
		sl3.setText("Line 3-3", 3);
		sl3.setText("Line 3-5", 5);
		sl3.setText("Line 3-4", 4);
		
		SlideNode sln1 = new SlideNode();
		SlideNode sln2 = new SlideNode();
		SlideNode sln3 = new SlideNode();
		sln1.setSlide(sl1);
		sln2.setSlide(sl2);
		sln3.setSlide(sl3);
		sln2.setNext(sln3);
		sln2.setPrev(sln1);
		System.out.println(sln2.getSlide());
		System.out.println();
		System.out.println(sln2.getNext().getSlide());
		System.out.println();
		System.out.println(sln2.getPrev().getSlide());
		System.out.println();
		
		
		}
		catch (IllegalArgumentException ex){
			System.out.println("Invalid range");
		}
	}
}
