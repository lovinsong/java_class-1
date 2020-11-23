package quiz;

import java.util.Scanner;

public class B09_forQuizBasic {

	// 사용자가 숫자를 입력했을 때
	
	// 1. 10부터 입력한 숫자까지의 총 합을 구해보세요
	
	// 2. 1부터 입력한 숫자 사이의 3의 배수만 모두 출력하고
	//    총 몇 개 인지도 출력해보세요 
	public static void main(String[] args) {
		
		System.out.print("숫자 > ");
		int user = new Scanner(System.in).nextInt();
		
		int start = 10;
		int end = user;
		
		if (start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		
		int sum = 0;
		for (int i = start; i <= end; ++i) {
			System.out.println(i);
			sum += i;
		}
		
		int start2 = 1;
		int end2 = user;
		
		if (start2 > end2) {
			int temp = start2;
			start2 = end2;
			end2 = temp;
		}
		
		int count = 0;
		System.out.print("[");
		for (int i = start2; i <= end2; ++i) {			
			if (i % 3 == 0) {
				System.out.print(i + " ");
				count += 1;
			}
		}
		System.out.print("]\n");
		System.out.println("Q1. 10부터의 총합 - " + sum);
		System.out.println("Q2. 3의 배수의 개수 - " + count + "개");
	}
}











