package quiz;

public class B02_conditionQuiz01 {

	/*
		[ 알맞은 비교연산을 만들어보세요 ]
		    
		1. int형 변수 a가 10보다 크고 20보다 작을 때 true
		2. int형 변수 b가 짝수일 때 true		
		3. int형 변수 c가 7의 배수일 때 true
		4. int형 변수 hour가 0미만 24이상이 아니고, 12이상일 때 true
		5. int형 변수 d와 e의 차이가 30일 때 true		
		6. int형 변수 year가 400으로 나누어 떨어지면 true  
		   또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true
		7. 민수가 철수보다 2살 많으면 true
		8. 민수가 철수보다 생일이 3달 빠르면 true  
 		9. boolean형 변수 powerOn이 false일 때 true
		10. 문자열 참조변수 str이 "yes"일 때 true
		11. 삼각형 A가 직각삼각형이면 true
	*/	
	public static void main(String[] args) {
		int a = 11;
		boolean result01 = a > 10 && a < 20;
		System.out.println(result01);
		
		int b = 4;
		System.out.println(b % 2 == 0);
		
		int c = 21;
		System.out.println(c % 7 == 0);
		
		int hour = -1;
		boolean result04 = !(hour < 0 || hour >= 24) && hour >= 12;
		System.out.println(result04);
		
		int d = 10, e = 40; 
		System.out.println(Math.abs(d - e) == 30);
		
		int year = 2020;
		System.out.println(year % 400 == 0 || 
				(year % 4 == 0 && year % 100 != 0));
		
		int m_age = 6, c_age = 4;
		System.out.println(c_age + 2 == m_age);
		
		int m_birth = 4, c_birth = 7;
		System.out.println(m_birth + 3 == c_birth);
		
		boolean powerOn = false;
		System.out.println(!powerOn);
		
		// 소문자로 시작하는 타입 - 값을 저장한다
		// 대문자로 시작하는 타입 - 주소를 저장한다 (참조형)		
		String str = "yes";
		String str2 = "yes";
		String str3 = new String("yes");
		String str4 = str;
		
		System.out.println(str == str2); // 주소를 통한 비교1
		System.out.println(str == str3); // 주소를 통한 비교2
		
		System.out.println(str.equals(str3)); // 값을 통한 비교
		
		
		int a1 = 50, a2 = 40, a3 = 90;
		
		System.out.println(a1 + a2 + a3 == 180 && 
				(a1 == 90 || a2 == 90 || a3 == 90) &&
				(a1 != 0 && a2 != 0 && a3 != 0));
		
		int b1 = 3, b2 = 4, b3 = 5;
		
		System.out.println(
				b1 * b1 + b2 * b2 == b3 * b3 ||
				b1 * b1 + b3 * b3 == b2 * b2 ||
				b2 * b2 + b3 + b3 == b1 * b1
		);
	}
	
}














