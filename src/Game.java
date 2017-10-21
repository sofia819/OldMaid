/**
 * Austin
 * Controls the card game Old Maid.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	static Scanner in = new Scanner(System.in);
	static ArrayList<Player> finishedPlayers = new ArrayList<>();
	/**
	 * Initializes the players, the deck and deals the cards to the players. It also runs the game and 
	 * has players take turns drawing from each other.
	 */
	public static void initialize()
	{
		Deck deck = new Deck();

		//if second parameter is true the player is human
		Player player1 = new Player(1, true);
		Player player2 = new Player(2, false);
		Player player3 = new Player(3, false);
		Player player4 = new Player(4, false);
		
		ArrayList<Player> players = new ArrayList<>();
		
		//adding players to arraylist
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		
		//dealing cards
		while(deck.getSize()>= players.size()+1)
		{
			for(int j = 0; j < players.size(); j++)
			{
				deck.deal(players.get(j));
				//playerDone(players, j);
			}	
		}
		
		//Last card
		deck.deal(players.get(0));
		
		//checks for pregame matches
		for(int cardCheck = 0; cardCheck < players.size(); cardCheck++)
		{
			playerDone(players, cardCheck);
		}

		
		//while there are more than 1 player run the game
		while(players.size() > 1)
		{
			System.out.println("\n\n***NEW TURN");
			System.out.println("Number of players: " + players.size());
			//players will draw from previous index
			for(int i = players.size() - 1; i >= 0;i--)
			{
				if(i != 0)
				{
					if(players.size() == 1)
						break;

					playerTurn(players.get(i), players.get(i - 1));
					playerDone(players, i);
					
				}
				//last player draws from first player
				else
				{
					if(players.size() == 1)
						break;
				
					playerTurn(players.get(i), players.get(players.size() - 1));	
					playerDone(players, i);
				}
			}

		}
		//scoreboard
		System.out.println("\n");
		
		for (int i = 0; i < finishedPlayers.size(); i ++)
		{
			System.out.println( finishedPlayers.get(i));
		}
		
		System.out.println("LOSER " + players.get(0));
		}
	
	//Method that checks and removes players with 0 cards
	
	/**
	 * Checks to see if the player is done and no longer has cards. Checks first if they have any pairs in their hand
	 * and then checks if their hand is empty. If it is then it removes them from the array list, adds them to another 
	 * list of finished players.
	 * @param players
	 * @param playerIndex
	 */
	public static void playerDone(ArrayList<Player> players, int playerIndex)
	{
		//removes pair in hands of player
		players.get(playerIndex).pickPair();
		//card in hand = 0
		if(players.get(playerIndex).getSize() == 0)
			{
				System.out.println("Player " + players.get(playerIndex).getID() + " finishes.");
				finishedPlayers.add(players.remove(playerIndex));
			}
	}
	/**
	 * Has players draw from each other. A player and the person the player is drawing from are passed in. It checks
	 * to make sure the drawing player is not the first player, since each player is supposed to draw from the previous player.
	 * If not, the player chooses a random card to draw from the player and that card is removed from their hand and given to
	 * the drawing player. If the drawing player is the first player, they draw from the last player.
	 * @param drawingPlayer
	 * @param beingDrawnFromPlayer
	 */
	
	//players turn will pick a card from other player if there is a human player will send a message
		public static void playerTurn(Player drawingPlayer, Player beingDrawnFromPlayer)
		{
			if(drawingPlayer.getSize()!=0)
			{
				int rand;
				//human input
				if(drawingPlayer.isHuman()){
					System.out.print("Choose a card from 0 to " + (beingDrawnFromPlayer.getSize() - 1) + ": ");
					rand = in.nextInt();
					while(rand < 0 || rand > beingDrawnFromPlayer.getSize() - 1){
						System.out.print("Choose a card from 0 to " + (beingDrawnFromPlayer.getSize() - 1));
						rand = in.nextInt();
					}
				}
				//AI
				else
					rand = (int)(Math.random() * beingDrawnFromPlayer.getSize());
				
				drawingPlayer.drawCardFrom(beingDrawnFromPlayer, rand);
				System.out.println("Player " + drawingPlayer.getID() + " drew from player " + beingDrawnFromPlayer.getID() + ".");
				System.out.println(drawingPlayer.displayCards());
			}
			
		}

	public static void main(String[] args){
		initialize();
	}
}
