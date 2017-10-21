/**
 * Scott Phillips
 * A collection of cards that belong to a player.
 * 2 protected instances from Pile: numCards and cardList.
 */
public class Hand extends Pile{
	
	private int pairCount = 0;
	
	public Hand(){
	}
	
	// add(Card card)
	// remove(int index)
	// sort()
	// shuffle()
	/**
	 * Checks to see if there is a match in a players hand. First it sorts the cards hand, then 
	 * if there is a match it removes the matching cards and increments the pairCount to keep
	 * track of the score.
	 * @return
	 */
	public int match(){ // also add a "point" for the player
		int i = 0;
		sort();
		while(i <= getSize() - 2){
		if (cardList.get(i).equals(cardList.get(i + 1))){
			cardList.remove(i + 1);
			cardList.remove(i);
			pairCount++;
			}
		else
			i++;
		}
		
		return pairCount;
	}
	
	@Override
	public String toString(){
		String result = "Player currently has " + getSize() + " cards.\n";
		for(int i = 0; i < getSize(); i++)
			result += cardList.get(i).toString() + "  ";
		return result;
	}
	
	public static void main(String[] args){
		Hand hand = new Hand();
		hand.add(new Card(5));
		hand.add(new Card(0));
		hand.add(new Card(1));
		hand.add(new Card(3));
		hand.add(new Card(4));
		hand.add(new Card(1));
		hand.add(new Card(4));
		hand.add(new Card(5));
		hand.add(new Card(2));
		hand.add(new Card(0));
		
		System.out.println(hand);
		System.out.println("Pair count: " + hand.match());
		System.out.println(hand);
	}
}
