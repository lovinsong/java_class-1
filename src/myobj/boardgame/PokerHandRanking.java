package myobj.boardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import myobj.boardgame.card.Rank;

public class PokerHandRanking {

	public static final int ROYAL_FLUSH = 9;
	public static final int STRAIGHT_FLUSH = 8;
	public static final int FOUROAK = 7;
	public static final int FULLHOUSE = 6;
	public static final int FLUSH = 5;
	public static final int STRAIGHT = 4;
	public static final int THREEOAK = 3;
	public static final int TWOPAIR = 2;
	public static final int ONEPAIR = 1;
	public static final int HIGHCARD = 0;
	
	public static ArrayList<Integer> rank_count;
	public static ArrayList<Integer> suit_count;
	
	public static final Set<Rank> MOUNTAIN;
	public static final Set<Set<Rank>> STRAIGHTS;
	
	static {
		Rank[] ranks = Rank.values();
		
		MOUNTAIN = new HashSet<>();
		Collections.addAll(MOUNTAIN, 
				Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE);
		
		STRAIGHTS = new HashSet<>();
		
		for (Rank rank : ranks) {
			if (rank.equals(Rank.TEN)) {
				break;
			}			
			HashSet<Rank> straight = new HashSet<>(5);
			
			int order = rank.ordinal();
			straight.add(rank);
			straight.add(ranks[order + 1]);
			straight.add(ranks[order + 2]);
			straight.add(ranks[order + 3]);
			straight.add(ranks[order + 4]);
			STRAIGHTS.add(straight);															
		}
//		for (Set s : STRAIGHTS) {
//			System.out.println(s);
//		}		
		
		rank_count = new ArrayList<>(13);		
		suit_count = new ArrayList<>(4);	
		for (int i = 0; i < 13; ++i) {
			rank_count.add(0);
		}
		for (int i = 0; i < 4; ++i) {
			suit_count.add(0);
		}
	}	
	
	public static void check(PokerHand player) {
		
		for (PokerCard card : player.hands) {
			int ro = card.getRank().ordinal();			
			rank_count.set(ro, rank_count.get(ro) + 1);
			
			int so = card.getSuit().ordinal();
			suit_count.set(so, suit_count.get(so) + 1);
		}	
		
		System.out.println("rank : " + rank_count);
		System.out.println("suit : " + suit_count);
		
		Set<Rank> ranks = player.getRankSet();
		
		// 높은 패 순으로 적용
		if (suit_count.contains(5) && checkMountain(ranks)) {
			System.out.println("로얄 스트레이트 플러쉬");			
		} else if (suit_count.contains(5) && checkStraight(ranks)) {
			System.out.println("스트레이트 플러쉬");						
		} else if (rank_count.contains(4)) {
			System.out.println("포카드");			
		} else if (rank_count.contains(3) && rank_count.contains(2)) {
			System.out.println("풀 하우스");			
		} else if (suit_count.contains(5)) {
			System.out.println("플러쉬");
		} else if (checkStraight(ranks)) {
			System.out.println("스트레이트");
		} else if (rank_count.contains(3)) {
			System.out.println("쓰리 오브 어 카인드");
		} else if (rank_count.contains(2)) {
			if (rank_count.indexOf(2) != rank_count.lastIndexOf(2)) {
				System.out.println("투 페어");
			} else {			
				System.out.println("원 페어");
			}
		} else {
			System.out.println("하이카드");			
		}
		
		reset();
	}
	
	private static void reset() {
		for (int i = 0; i < 13; ++i) {
			rank_count.set(i, 0);
		}
		for (int i = 0; i < 4; ++i) {
			suit_count.set(i, 0);
		}
	}
	
	private static boolean checkMountain(Set<Rank> ranks) {
		return ranks.containsAll(MOUNTAIN);
	}
	
	private static boolean checkStraight(Set<Rank> ranks) {		
		
		for (Set<Rank> straight : STRAIGHTS) {
			
			if (ranks.containsAll(straight)) {
				return true;
			}
		}			
		
		return false;
	}
	
}











