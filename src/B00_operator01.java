
public class B00_operator01 {

	public static void main(String[] args) {
		
		// # 연산자 (operator)
		//	- 계산할 때 사용하는 것
		
		// # 산술 연산자
		int a = 10, b = 3;
		double c = 7.0;
		
		System.out.printf("a = %d, b = %d 일 때\n", a, b);
		
		// ※ 연산의 우선 순위는 사칙 연산의 우선순위를 따른다 
		System.out.println("+ : " + (a + b)); // 더하기
		System.out.println("- : " + (a - b)); // 빼기
		System.out.println("x : " + a * b); // 곱하기
		
		// ※ 정수끼리 나누면 몫만 나온다
		System.out.println(a / b); 
		// ※ 정수와 실수를 나누면 정확한 계산을 한다 
		System.out.println(a / c);
		System.out.println(a / (double)b);		
		System.out.println(a % b); // 나머지
		
		System.out.println("제곱 : " 		+ Math.pow(a, b));
		System.out.println("제곱근 : " 		+ Math.sqrt(2));
		System.out.println("절대값 : " 		+ Math.abs(-20));
		System.out.println("반올림 : " 		+ Math.round(1.534));
		System.out.println("올림 : " 		+ Math.ceil(1.001));
		System.out.println("내림 : " 		+ Math.floor(1.999));
		System.out.println("더 큰 숫자 : "  	+ Math.max(a, b));
		System.out.println("더 작은 숫자 : " 	+ Math.min(a, b));
		
		System.out.println(a ^ b); // 제곱이 아니다 (XOR)		
		// 10 : 1010
		// 7  : 0111 ^ (XOR)
		//     ------
		//		1101 (서로 다르면 1)		
	}
	
}








