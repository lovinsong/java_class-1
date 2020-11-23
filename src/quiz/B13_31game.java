package quiz;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class B13_31game {

	// # 31게임을 만들어보세요 

	//	1. 컴퓨터와 사람이 번갈아가면서 숫자를 선택한다 (1, 2, 3)	
	//	2. 컴퓨터는 랜덤으로 숫자를 선택한다 	
	//	3. 마지막에 31 이상의 숫자를 만드는 사람 혹은 컴퓨터가 패배한다

	// 진행 예 :
	
	//	컴퓨터 > 2
	//		현재 숫자 : 2
	//	사람 > 3 
	//		현재 숫자 : 5
	//	...
	//	컴퓨터 > 3
	//		현재 숫자 : 32 
	//		컴퓨터의 패배 입니다.
	public static void main(String[] args) throws IOException {
		// 초기화 부분
		Scanner user = new Scanner(System.in);
		Random ran = new Random();
		
		int game_num = 0;
		
		boolean computer_turn = ran.nextBoolean();
		
		System.out.printf("<%s>의 선공입니다!\n", 
						computer_turn ? "컴퓨터" : "사람");
		
		while (true) {
			// 입력 부분
			int num;			
			if (computer_turn) {				
				// 컴퓨터가 game_num을 본 후 
				// 2, 6, 10, 14, 18, 22, 26, 30을 만들면 무조건 이김
				if (game_num % 4 == 0) {
					num = 2;
				} else if (game_num % 4 == 3) {
					num = 3;
				} else if (game_num % 4 == 1) {
					num = 1;
				} else {
					num = ran.nextInt(3) + 1;
				}				
								
				System.out.println("컴퓨터 > " + num);
			} else {
				System.out.print("유저 > ");
				num = user.nextInt();
				
				if (num > 3 || num < 1) {
					System.out.println("\t1 ~ 3만 입력하셔야 합니다.");
					continue;
				}
			}
		
			// 처리 부분
			game_num += num;			
			
			// 출력 부분 
			if (game_num >= 31) {
				System.out.println("\t패배 : " + game_num);			
				break;
			}
			
			System.out.println("\t현재 상황 : " + game_num);						
			computer_turn = !computer_turn;
		}
		
		System.out.printf("<%s>의 승리!\n", computer_turn ? "유저" : "컴퓨터");
		
	}
}

















