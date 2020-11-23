package quiz;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import myobj.boardgame.dice.FiveDice;

public class D02_FiveDice {
	
	// 랜덤으로 5개의 주사위를 굴린 다음에 (주사위의 눈은 1 ~ 6)

	// 	풀하우스 (같은 숫자가 2개 + 3개)
	// 	스몰 스트레이트 (1234/2345/3456)
	// 	라지 스트레이트 (12345/23456)
	// 	4다이스 (같은 숫자 4개)
	// 	5다이스 (같은 숫자 5개)
	
	// 를 구분하는 클래스를 작성하고 테스트 해보세요
	
	// ※ 다른 파일에 작성하고 여기서는 갖다 쓰기만 할 것
	public static void main(String[] args) throws InterruptedException {
		FiveDice dice = new FiveDice();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			dice.roll();
			System.out.print("바꾸기 테스트 > ");
			
			Set<Integer> rerolls = new HashSet<>(); 
			int i = -1;
			while ((i = sc.nextInt()) != -1) {
				rerolls.add(i);
			}
			System.out.println("다시 굴려야하는 인덱스 : " + rerolls);
			dice.reroll(rerolls);
			
			Thread.sleep(2000); 
		}
	}
}










