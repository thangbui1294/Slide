/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates SlideShow class that allows user to interact with the current list of slides. 
 */

import java.util.*;
public class SlideShow {
	/**
	 * Operation method 
	 * @param args
	 */
	public static void main(String[] args){
		SlideList slideList1 = new SlideList();
		int count = 0;
		while (count == 0){
			Scanner s = new Scanner(System.in);
			System.out.print("MENU OPTION: \nA) Add a new slide to end of the list  \nI) Insert a new slide after the current slide \nR) Remove the current slide from the list \nD) Display a range of slides \nC) Display the current slide  \nF) Move the current slide forward  \nB) Move the current slide backwards  \nJ) Jump to a given position  \nE) Edit current slide  \nQ) Exit the program \nYOUR OPTION: ");
			char menu = (s.nextLine()).toCharArray()[0] ;
			switch (menu) {
			case 'a':
			case 'A': {
				try{
					Slide newSlide = new Slide();
					System.out.print("1) ");
					newSlide.setText(s.nextLine(), 1);
					System.out.print("2) ");
					newSlide.setText(s.nextLine(), 2);
					System.out.print("3) ");
					newSlide.setText(s.nextLine(), 3);
					System.out.print("4) ");
					newSlide.setText(s.nextLine(), 4);
					System.out.print("5) ");
					newSlide.setText(s.nextLine(), 5);
					slideList1.addToEnd(newSlide);
				}
				catch (IllegalArgumentException ex){
				}
				break;
			}
			case 'i':
			case 'I':{
				try{
					Slide newSlide = new Slide();
					System.out.print("1) ");
					newSlide.setText(s.nextLine(), 1);
					System.out.print("2) ");
					newSlide.setText(s.nextLine(), 2);
					System.out.print("3) ");
					newSlide.setText(s.nextLine(), 3);
					System.out.print("4) ");
					newSlide.setText(s.nextLine(), 4);
					System.out.print("5) ");
					newSlide.setText(s.nextLine(), 5);
					slideList1.addAfterCurrent(newSlide);
				}
				catch (IllegalArgumentException ex){
				}
				break;
			}
			case 'r':
			case 'R':{
				boolean removed = slideList1.removeCurrentSlide();
				if (!removed){
					System.out.println("There is no current slide to remove");
				}
				break;
			}
			case 'd':
			case 'D':{
				try {
					System.out.print("Enter the start position: ");
					int start = s.nextInt();
					System.out.print("Enter the end position: ");
					int end = s.nextInt();
					slideList1.displaySlides(start, end);
				}
				catch (EmptyListException ex){
					System.out.println("The list is empty");
				}
				catch (IllegalArgumentException ex){
					System.out.println("The positions is not in valid range");
				}
				break;
			}
			case 'c':
			case 'C':{
				try{
					slideList1.displayCurrentSlide();
				}
				catch (EmptyListException ex){
					System.out.println("There is no current slide to display");
				}
				break;
			}
			case 'f':
			case 'F':{
				try {
					boolean moved = slideList1.moveForward();
					if (!moved){
						System.out.println("The current slide is already the last one");
					}
				}
				catch (EmptyListException ex){
					System.out.println("There is no current slide to move");
				}
				break;
			}
			case 'b':
			case 'B':{
				try{
					boolean moved = slideList1.moveBack();
					if (!moved){
						System.out.println("The current slide is already the first one");
					}
				}
				catch (EmptyListException ex){
					System.out.println("There is no current slide to move");
				}
				break;
			}
			case 'j':
			case 'J':{
				try{
					System.out.print("Enter the position you want to move the current slide to: ");
					boolean moved = slideList1.jumpToPosition(s.nextInt());
					if (!moved){
						System.out.println("Cannot find the position in the list");
					}
				}
				catch (IllegalArgumentException ex){
					System.out.println("The position cannot be negative");
				}
				break;
			}
			case 'e':
			case 'E':{
				try{
					System.out.print("Enter text you want to edit: ");
					String s1 = s.nextLine();
					System.out.print("Enter the line number of the slide you want to edit: ");
					int line = s.nextInt();
					slideList1.editCurrentSlide(s1, line);
				}
				catch (EmptyListException ex){
					System.out.println("There is no current slide to edit");
				}
				catch (IllegalArgumentException ex){
					System.out.println("The position is not in the valid range (1-5)");
				}

				break;
			}
			case 'q':
			case 'Q':{
				count++;
				break;
			}
			default: System.out.println("Invalid menu option! Try again");
			}

		}
	}

}
