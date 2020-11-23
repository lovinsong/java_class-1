package myobj.boardgame.card;

public enum Rank {
	ACE(12), DEUCE(0), THREE(1), FOUR(2), FIVE(3), SIX(4), 
	SEVEN(5), EIGHT(6),	NINE(7), TEN(8), JACK(9), QUEEN(10), KING(11);
	
	private Integer rankValue;
	
	private Rank(int rv) {
		rankValue = rv;
	}
	
	public Integer getRankValue() {
		return rankValue;
	}
}
