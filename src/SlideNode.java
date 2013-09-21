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
}
