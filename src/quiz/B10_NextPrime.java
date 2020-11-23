package quiz;

import java.util.Scanner;

public class B10_NextPrime {

	// 사용자로부터 숫자를 입력받으면 
	// 입력받은 수보다 더 크거나 같은 다음 소수를 찾아서 출력해보세요
	
	public static void main(String[] args) {
		System.out.print("숫자 > ");
		int user = new Scanner(System.in).nextInt();
		
		for (int i = user; true; ++i) {			
			int count = 0;
			int sqrt = (int)Math.sqrt(i);
			for (int j = 2; j <= sqrt; ++j) {						
				if (i % j == 0) {
					++count;
				}				
			}
			if (count == 0) {
				System.out.printf("'%d'의 다음 소수는'%d'입니다.\n", 
						user, i);
				break;
			}
		}
		
	}
}
