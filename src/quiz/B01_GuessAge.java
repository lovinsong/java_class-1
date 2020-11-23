package quiz;

import java.util.Scanner;

public class B01_GuessAge {

	// 사용자로부터 올해의 년도와 태어난 년도를 입력받으면
	// 한국 나이를 계산하여 몇 살인지 알려주는 프로그램을 만들어보세요
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("올해의 년도를 입력 > ");
		int thisYear = sc.nextInt();
		System.out.print("태어난 년도를 입력 > ");
		int birthYear = sc.nextInt();
		
		int age = thisYear - birthYear + 1;
		System.out.printf("당신의 나이는 %d살 입니다.\n", age);
		
	}
	
}










