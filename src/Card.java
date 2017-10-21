/*
 * Justin Koutros
 * Card.java
 * Creates card objects and implements Comparable to compare them.
 */
public class Card implements Comparable<Card> {

	private final int id;
	/**
	 * Constructs card with an integer as it identification.
	 * @param An integer
	 */
	public Card(int id) {
		
		this.id = id;
	}
	/**
	 * Method that determines if two cards are equals using the compareTo(Object object) method.
	 * @param card
	 * @return true if compareTo returns 0, false if otherwise
	 */
	public boolean equals(Card card) {

		int i = this.compareTo(card);
		
		return i == 0;
	}
	/**
	 * Gets id of a card object.
	 * @return id
	 */
	public int getID() {

		return id;
	}

	@Override
	/**
	 * Compares card objects
	 * @param Card the current card is being compared to.
	 * @return -1 if current card is less than Card o, 1 if it is larger, 0 if they are the same.
	 */
	public int compareTo(Card o) {

		if (this.getID() < o.getID()) {
			return -1;
		} else if (this.getID() > o.getID()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString(){
		return "ID: " + id;
	}
	
	public static void main (String [] args){
		Card card1 = new Card (0);
		Card card2 = new Card (1);
		System.out.println("card1 id: " + card1.getID());
		System.out.println("card2 id: " + card2.getID());
		System.out.println("card1.equals(card2): " + card1.equals(card2));
		System.out.println("card1.compareTo(card2): " + card1.compareTo(card2));
		System.out.println("card2.compareTo(card1): " + card2.compareTo(card1));
		
		Card card3 = new Card (1);
		System.out.println("card3 id: " + card3.getID());
		System.out.println("card3.equals(card2): " + card3.equals(card2));
		System.out.println("card3.compareTo(card2): " + card3.compareTo(card2));
	}

}
