package quiz;

import java.util.Scanner;

public class B11_count_369_clap {
	
	// 사용자로부터 정수 하나를 입력받고 
	// 해당 숫자까지 369게임이 진행된다면 박수를 총 몇번 쳐야하는지 세어보세요	
	public static void main(String[] args) {
		// # 숫자를 사용하는 방법
		// System.out.print("369 > ");
		
		// # 프로그램 실행시간 측정
//		long start_time = System.currentTimeMillis();
//		
//		int user = 99999999;// new Scanner(System.in).nextInt();
//		int clap = 0;
//		
//		boolean debugMode = false;
//		
//		for (int i = 1; i <= user; ++i) {
//			int check = i;
//			
//			if (debugMode) {
//				System.out.printf("%d : ", i);
//			}
//			
//			while (check != 0) {				
//				int digit = check % 10;
//				
//				if (digit % 3 == 0 && digit != 0) {
//					++clap;
//					if (debugMode) {
//						System.out.print("짝");
//					}
//				}
//				check /= 10;
//			}	
//			if (debugMode) {
//				System.out.println();
//			}
//		}
//		System.out.println(clap + "회");
//		
//		long end_time = System.currentTimeMillis();
//		
//		System.out.println("걸린 시간 : " + (end_time - start_time));
		
		// # 문자열을 사용하는 방법
		int user = 99999999;
		int clap = 0;
		
		long start_time = System.currentTimeMillis();
		
		for (int i = 1; i <= user; ++i) {
			String check = "" + i;			
			int len = check.length();
			
			for (int j = 0; j < len; ++j) {
				if (check.charAt(j) == '3' || 
						check.charAt(j) == '6' || 
						check.charAt(j) == '9') {
					++clap;					
				}				
			}
		}		
		System.out.println(clap);
		long end_time = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end_time - start_time));
	}
}
