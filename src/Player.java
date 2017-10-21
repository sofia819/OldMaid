/*
 * Sofia Lee
 * Player.java
 * A representation of a player.
 * It has player ID, a hand of Cards, and the score of the player.
 * */

public class Player {
	private int id;
	private Hand hand;
	private int score = 0;
	private boolean human;
	/**
	 * Player constructor. Instantiates player objects with an id number and a
	 * corresponding hand object.
	 * @param id
	 */
	public Player(int id, boolean human){
		this.id = id;
		this.human = human;
		this.hand = new Hand();
	}
	/**
	 * Removes a card from a players hand. Takes in and integer index to do so
	 * @param index
	 * @return removed card from the hand
	 */
	public Card remove(int index){
		return hand.remove(index);
	}
	/**
	 * Adds a card to a players hand. Takes in a card object to do so
	 * @param card
	 */
	public void add(Card card){
		hand.add(card);
	}
	/**
	 * Gets the ID of the player
	 * @return id
	 */
	public int getID(){
		return id;
	}
	/**
	 * Gets the size of the players hand
	 * @return size of Hand
	 */
	public int getSize(){
		return hand.getSize();
	}
	/**
	 * Gets the players score, which comes from Hand's match method
	 * @return score
	 */
	public int getScore(){
		return score;
	}
	/**
	 * Determines the score by finding pairs in a players hand. Uses hand's 
	 * match() method to do so
	 */
	public void pickPair(){
		score = hand.match();
	}
	/**
	 * Allows a player to draw from another player using a randomly generated
	 * integer to do so. First the hand is shuffled and then a card is removed
	 * from the other players hand using the random number.
	 * @param otherPlayer
	 * @param rand
	 */
	public void drawCardFrom(Player otherPlayer, int rand){
		hand.shuffle();
		Card card = otherPlayer.remove(rand);
		System.out.println("Player " + getID() + " drew " + card);
		add(card);
	}
	/**
	 * Displays the cards in the Hand of the player. 
	 * @return result
	 */
	public String displayCards(){
		String result = "Number of cards: " + hand.getSize() + "\n";
		for(int i = 0; i < hand.getSize(); i++){
			result += hand.get(i) + "  ";
		}
		return result;
	}
	/**
	 * Gets the value of human.
	 * @return human
	 */
	public boolean isHuman(){
		return human;
	}
	
	@Override
	public String toString(){
		String result = "Player " + id + "	";
		result += "Score: " + score;
		return result;
	}
	
	public static void main(String[] args){
		Player player = new Player(1, false);
		System.out.println(player);
		player.add(new Card(0));
		System.out.println(player.displayCards());
	}
}
