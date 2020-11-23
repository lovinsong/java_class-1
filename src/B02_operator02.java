
public class B02_operator02 {

	public static void main(String[] args) {
		
		// # 비교 연산
		//	- 비교 연산의 결과는 참 또는 거짓이다 (boolean 타입)	
		//	- 산술 연산과 비교 연산이 함께 있으면 산술 연산을 먼저 계산한다
		int a = 5, b = 9;
		
		System.out.println("a > b : " + (a > b));
		System.out.println("a < b : " + (a < b));
		System.out.println("a >= b : " + (a >= b));
		System.out.println("a <= b : " + (a <= b));
		
		System.out.println("a == b : " + (a == b)); // 같으면 true
		System.out.println("a != b : " + (a != b)); // 다르면 true
		
		// # 논리 연산
		//	- boolean 값으로 하는 연산
		//	- && : 두 값이 모두 true일 때 true (AND)
		//	- || : 두 값 중 하나만 true여도 true (OR)
		//	- !  : true면 false, false면 true (NOT)
		System.out.println("#### AND ####");
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println("#### OR ####");
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		System.out.println("#### NOT ####");
		System.out.println(!true);
		System.out.println(!false);
		System.out.println(!(a < 10));
	}
	
}






