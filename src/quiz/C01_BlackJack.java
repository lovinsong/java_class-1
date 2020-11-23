package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class C01_BlackJack {	
	// # 블랙잭을 만들어 보세요 (https://www.247blackjack.com/)
	
	// * 게임 순서	
	// 1. 딜러(컴퓨터)와 플레이어가 카드를 2장씩 받는다 
	//	  이 때, 딜러의 카드는 한 장 가려놓는다.
	// 2. 사용자는 카드를 보고 더 뽑을지(hit) 멈출지(stand)를 결정한다	
	// 3. 사용자가 멈추면 딜러가 가려져 있던 카드를 뒤집은 뒤 규칙에 따라 카드를 뽑는다	
	//	  (뽑은 카드 합이 16이하일때 무조건 뽑고, 17이상이면 무조건 멈춘다)
	// 4. 딜러보다 합이 높거나 정확하게 21이라면 승리 (베팅 금액만큼 플레이어의 돈이 오른다)
	//    딜러보다 합이 낮거나 21이 넘으면 패배 (베팅 금액만큼 플레이어의 돈이 떨어진다)
	//	  딜러와 카드합이 같다면 무승부
	
	// ※ A는 합이 21이 넘을때는 1로 사용하고 21이하 일때는 11로 사용한다
	// ※ J, Q, K는 10에 해당한다 
	// ※ 각 카드는 문양별로 한장씩 존재한다

	// ※ 다른 함수에서도 변수를 사용할 수 있도록 함수 밖에 변수를 선언할 수 있다
	public static int[] deck;
	public static int[] player;
	public static int[] dealer;
	
	
	public static int[] game_index;	
	public static int DEALER = 0;
	public static int PLAYER = 1;
//	public static int DECK = 2;
	
	// 52 % 13 : 0 - 12 스페이드, 13 - 25 하트, ...
	// "CA", "C2", ... "CK" / "SA", "S2", ..
	public static int[] shuffle() {
		int[] deck = new int[52];
		
		for (int i = 0; i < deck.length; ++i) {
			deck[i] = i;
		}
		
		for (int i = 0; i < 200; ++i) {
			int ran = (int)(Math.random() * 51 + 1);
			
			int temp = deck[0];
			deck[0] = deck[ran];
			deck[ran] = temp;
		}		
		
		return deck;
	}	
	
	public static void draw(int drawer) {
		switch (drawer) {
		case 0:
			dealer[game_index[0]++] = deck[game_index[2]++];
			break;
		case 1:
			player[game_index[1]++] = deck[game_index[2]++];
			break;
		}
	}
	
	public static void prettyCard(int mode, int user) {
		char[] shape = {'♠', '♥', '♣', '◆'};
		
		if (user == DEALER) {
			for (int i = 0; i < game_index[DEALER]; ++i) {
				System.out.print("┌────┐\t");
			}
			System.out.println();
			for (int i = 0; i < game_index[DEALER]; ++i) {
				int s_i = dealer[i] / 13;
				int value = dealer[i] % 13;
				
				System.out.printf("│%2c%-2d│\t", shape[s_i], value);
			}
			System.out.println();
			for (int i = 0; i < game_index[DEALER]; ++i) {
				System.out.print("└────┘\t");
			}
			System.out.println();
		} else {
			
		}
	}
	public static String prettyCard(int card) {
		char[] shape = {'♡', '♠', '♣', '◇'};
		String[] value = {"A", "2", "3", "4", "5", "6", "7", "8", "9", 
				"10", "J", "Q", "K"};
		
		int s_index = card / 13;
		int v_index = card % 13;
		
		return shape[s_index] + value[v_index];
	}
	
	public static void print_game(int mode) {	
				
		System.out.println("DEALER :");
		System.out.print("\t");
		for (int i = 0; i < game_index[0]; ++i) {			
			if (mode == 0 && i == 0) {
				System.out.print("X  ");
			} else {
				System.out.print(prettyCard(dealer[i]) + " ");
			}
		}
		if (mode == 0) {
			System.out.println();
		} else {
			System.out.printf("(%d)\n", check_value(0));
		}
		
		System.out.println("PLAYER : ");
		System.out.print("\t");
		for (int i = 0; i < game_index[1]; ++i) {
			System.out.print(prettyCard(player[i]) + " ");			
		}
		System.out.printf("(%d)\n", check_value(1));
	}
	
	public static int getSum(int[] values) {
		int sum = 0;
		int ace = 0;
		for (int i = 0; i < values.length; ++i) {
			if (values[i] == 0) {
				sum += 11;
				ace += 1;
			} else if (values[i] >= 10) {
				sum += 10;
			} else {
				sum += values[i] + 1; 
			}
		}
		
		// A가 1개 이상 존재하면서 합이 21을 넘을 때 A를 1로 변경한다
		while (sum > 21 && ace > 0) {
			sum -= 10;
			ace -= 1;
		} 
		
		return sum;
	}
	
	
	public static int check_value(int user) {
		int[] values = new int[game_index[user]];
		
		for (int i = 0; i < values.length; ++i) {
			values[i] = user == 0 ? dealer[i] % 13 : player[i] % 13;
		}
		
		return getSum(values);		
	}
	
	public static int game_start() {
		// 무작위 순서의 덱을 하나 생성한다
		deck = shuffle();
		
		// 진행에 필요한 변수들을 초기화 한다
		player = new int[20];
		dealer = new int[20];
		game_index = new int[3];
		
		// 만들어진 덱으로 게임을 진행한다 
		// System.out.println(Arrays.toString(deck));
		
		// # 카드 뽑기 (딜러 두 번, 플레이어 두 번)
		draw(0);
		draw(0);
		draw(1);
		draw(1);
		
		// System.out.println("딜러 : " + Arrays.toString(dealer));
		// System.out.println("플레이어 : " + Arrays.toString(player));
		
		Scanner console = new Scanner(System.in);
		int player_value;
		// # 플레이어의 선택 
		while ((player_value = check_value(1)) < 21) {
			// # 게임 정보 출력
			print_game(0);
			
			System.out.print("1.hit\t2.stand\n>> ");
			int select = console.nextInt();
			
			if (select == 2) {
				break;
			} else if (select == 1) {
				draw(1);
			}							
		}
		
		// 딜러가 마저 뽑고 모든 정보를 출력한 후 결과를 리턴							
		print_game(1);
		
		int dealer_value;
		while ((dealer_value = check_value(0)) <= 16) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
			
			draw(0);
			print_game(1);
			dealer_value = check_value(0);
		} 		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		// 결과를 산출		
		return check_game(dealer_value, player_value);
	}
	
	public static int check_game(int d, int p) {
		if (d > 21 && p > 21) {
			return 0;
		} else if (d == p) {
			return 0;
		} else if (p <= 21 && d > 21) {
			return p == 21 ? 2 : 1;
		} else if (p <= 21 && p > d) {
			return p == 21 ? 2 : 1;
		}  else {
			return -1;
		} 			
	}
	
	public static void main(String[] args) {
		int player_money = 10000;		
		
		while (player_money > 0) {
			int betting = 5000;
			player_money -= betting;
			
			int game_result = game_start();
			
			System.out.println("=======================================");
			StringBuilder msg = new StringBuilder("게임 결과 : ");			
			
			switch (game_result) {
			case 1:
				player_money += betting * 2;
				msg.append("승리\n");
				break;
			case 2:
				player_money += (int)(betting * 2.5);
				msg.append("21로 승리\n");
				break;
			case 0:
				player_money += betting;
				msg.append("무승부\n");
				break;
			default:
				msg.append("패배\n");
				break;
			}
			
			msg.append("현재 잔액 : " + player_money + "원");		
			System.out.println(msg);
			System.out.println("=======================================");
		}
	}
	
}










