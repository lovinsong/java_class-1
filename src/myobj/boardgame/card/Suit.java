package myobj.boardgame.card;

public enum Suit {
	SPADE(3), DIAMOND(2), HEART(1), CLUB(0);
	
	private Integer suitValue;
	 	
	private Suit(int sv) {
	    suitValue = sv;
	}
 
	public Integer getSuitValue() {
	    return suitValue;
	}	
}
