/*
 * Sofia Lee
 * Deck.java
 * A representation of a deck of cards.
 * */

public class Deck extends Pile{
	
	final int MAX_CARD = 37;
	/**
	 * Deck constructor. Instantiates cards for the game by creating 37 cards, 18 of which
	 * have duplicates and one that acts as the old maid (Card(0)). Inherits the ArrayList cardList
	 * from Pile, and adds the cards to the list. After they have been instantiated, they are shuffled 
	 * using Pile's shuffle method.
	 */
    public Deck(){
    	cardList.add(new Card(0));
    	for(int i = 1; i <= (MAX_CARD - 1) / 2; i++){
    		cardList.add(new Card(i));
    		cardList.add(new Card(i));
    	}
    	shuffle();
    }
    /**
     * Handles dealing the cards to each player. Removes dealt cards
     * from the deck.
     * @param player
     */
    public void deal(Player player){
    	player.add(cardList.remove(getSize() -1));
    }
    
    @Override
    public String toString(){
    	String result = "The deck has " + getSize() + " cards.";
    	return result;
    }
    
    public static void main(String[] args){
    	Deck deck = new Deck();
    	Player player = new Player(1, false);
		System.out.println(player);
    	System.out.println(deck);
    	
    	deck.deal(player);
    	deck.deal(player);
    	deck.deal(player);
    	deck.deal(player);
    	
    	System.out.println(player);
    	System.out.println(deck);
    	
    }
} // end class Deck