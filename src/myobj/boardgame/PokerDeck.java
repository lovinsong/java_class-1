package myobj.boardgame;

import java.util.Collections;
import java.util.LinkedList;

import myobj.boardgame.card.Rank;
import myobj.boardgame.card.Suit;

public class PokerDeck {

	final static int DECK_SIZE = 52;
	
	private LinkedList<PokerCard> deck;
	
	public PokerDeck() {
		deck = new LinkedList<>();
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new PokerCard(rank, suit));				
			}
		}		
		shuffle();
	}
	
	public PokerCard draw() {		
		return deck.pop();
	}
	
	@Override
	public String toString() {	
		return deck.toString();
	}
	
	private void shuffle() {
		Collections.shuffle(deck);
		System.out.println("[System] - The dealer shuffles the deck");
	}
	
	public static void main(String[] args) {
		PokerDeck deck = new PokerDeck();
		
		System.out.println(deck);
		System.out.println(deck.draw());
		System.out.println(deck.draw());
		System.out.println(deck.draw());
		System.out.println(deck.draw());
		System.out.println(deck.draw());
	}
}








