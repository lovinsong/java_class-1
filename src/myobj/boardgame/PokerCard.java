package myobj.boardgame;

import myobj.boardgame.card.Rank;
import myobj.boardgame.card.Suit;

public class PokerCard {
	private Rank rank;
	private Suit suit;
	
	public PokerCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {	
		return String.format("%s of %s", rank, suit);
	}
	
	public static void main(String[] args) {
		System.out.println(new PokerCard(Rank.ACE, Suit.SPADE));	
	}
	
}






