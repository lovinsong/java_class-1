package quiz;

import java.util.Scanner;

public class B10_Prime {

	// 사용자로부터 숫자를 입력받으면 
	// 1부터 입력한 숫자 사이에 존재하는 소수를 모두 출력해보세요 
	
	// ※ 소수 : 약수가 1과 자기 자신밖에 없는 숫자
	public static void main(String[] args) {
		
		System.out.print("숫자 > ");
		int user = new Scanner(System.in).nextInt();
		
		// i : 소수인지 테스트 해볼 숫자 
		for (int i = 2; i <= user; ++i) {
			int count = 0;
			// j : i의 약수인지 테스트 해볼 숫자
			int sqrt = (int)Math.sqrt(i);
			for (int j = 2; j <= sqrt; ++j) {						
				if (i % j == 0) {
					++count;
				}				
			}
			if (count == 0) {
				System.out.printf("'%d'는 소수입니다.\n", i);
			}
		}
	}
}











