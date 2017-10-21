/*
 * Sofia Lee
 * Pile.java
 * A general representation of a pile of Cards.
 * */

import java.util.ArrayList;
import java.util.Collections;

public class Pile {
	protected ArrayList<Card> cardList = new ArrayList<>();
	
	public Pile(){
		
	}
	/**
	 * Adds a card to the pile. Uses an ArrayList to hold the card objects.
	 * @param card
	 * @return
	 */
	public boolean add(Card card){
		if(card != null){
			cardList.add(card);
			return true;
		}
		return false;
	}
	/**
	 * Removes a card from the pile. Takes in an integer index to look for
	 * the card in the pile and then removes it from the ArrayList
	 * @param index
	 * @return
	 */
	public Card remove(int index){
		return cardList.remove(index);
	}
	/**
	 * Sorts the pile. Uses the Collections class to do so
	 */
	public void sort(){
		Collections.sort(cardList);
	}
	/**
	 * Shuffles the pile. Also uses the Collections class
	 */
	public void shuffle(){
		Collections.shuffle(cardList);
	}
	/**
	 * Checks to see if a pile is empty. If so it returns true, else it
	 * returns false.
	 * @return
	 */
	public boolean isEmpty(){
		return cardList.size() == 0;
	}
	/**
	 * Gets the size of the pile by using ArrayLists' method size().
	 * @return
	 */
	public int getSize(){
		return cardList.size();
	}
	/**
	 * Gets an entry in the pile from the ArrayList. Takes in an integer
	 * index to get the Entry and then returns the entry.
	 * @param index
	 * @return
	 */
	public Card get(int index){
		return cardList.get(index);
	}
	
	@Override
	public String toString(){
		String result = "Number of Cards: " + getSize() + "\n";
		for(int i = 0; i < cardList.size(); i++){
			result += cardList.get(i).getID() + "  ";
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println("Create a new pile.");
		Pile pile = new Pile();
		pile.add(new Card(5));
		pile.add(new Card(0));
		pile.add(new Card(1));
		pile.add(new Card(3));
		pile.add(new Card(4));
		pile.add(new Card(1));
		System.out.println(pile);
		
		System.out.println("\nShuffle pile.");
		pile.shuffle();
		System.out.println(pile);
		
		System.out.println("\nSort pile.");
		pile.sort();
		System.out.println(pile);
	}
}
