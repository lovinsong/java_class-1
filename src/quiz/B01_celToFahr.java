package quiz;

import java.util.Scanner;

public class B01_celToFahr {
	// 사용자로부터 섭씨 온도를 입력받으면 
	// 화씨 온도로 변환하여 출력해주는 프로그램을 만들어보세요 
	// (변환 공식은 알아서 검색, 출력은 소수 첫째 자리까지)
	
	public static void main(String[] args) {		
		
		// sc를 다시 사용하지 않을 예정이기 때문에 따로 저장하지 않는다
		System.out.print("오늘의 온도 > ");
		double cel = new Scanner(System.in).nextDouble();
		double fahr = (cel * 9 / 5) + 32;
		
		System.out.printf("변환된 온도는 %.1f℉입니다.\n", fahr);
		System.out.printf("원래 온도는 %.1f℃였습니다.\n", cel);
	}
	
}








