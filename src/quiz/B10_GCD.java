package quiz;

public class B10_GCD {

	// 두 숫자를 입력받고 두 숫자의 최대공약수를 구해보세요 
	// ※ 최대공약수 : 두 숫자의 공약수 중 가장 큰 공약수	
	public static void main(String[] args) {
//		1. 임의의 두 자연수 a, b가 주어졌을때. 둘중 큰 값이 a라고 가정
		
//		2. a를 b로 나눈 나머지를 n 이라고 하면 (a%b = n)
//		   n이 0일때, b가 최대 공약수(GCD)입니다.

//		3. 만약 n이 0이 아니라면, 
// 		   a에 b값을 다시 넣고 
//		   b에 n을 대입 한 후 다시 2.의 과정을 반복
		int a = 100;
		int b = 50;

		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int n = -1;		
		for (; n != 0;) {
			n = a % b;
			a = b;
			b = n;
		}
		System.out.println("최대 공약수는 " + a + "입니다.");
		

		
//		// num1이 더 크면 값을 바꾼다
//		if (num1 > num2) {
//			int temp = num1;
//			num1 = num2;
//			num2 = temp;
//		}
//		
//		int gcd = 1;
//		for (int i = num1; i > 0; --i) {			
//			if (num1 % i == 0 && num2 % i == 0) {
//				gcd = i;
//				break;
//			}			
//		}
//		System.out.printf("'%d'과 '%d'의 최대공약수는 '%d'입니다.\n", 
//				num1, num2, gcd);
	}
}














