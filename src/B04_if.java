
public class B04_if {

	public static void main(String[] args) {
		
		// # if문 
		//	- ()안의 값이 true일 때 {}안의 내용을 실행한다
		//	- ()안의 값이 false일 때 {}안의 내용을 무시한다
		//	- {}안에 들어갈 내용이 한 줄이라면 {}를 생략할 수 있다
		
		// # else if문
		//	- 위의 if문이 실행되지 않았다면 if문처럼 동작한다
		//	- else if는 단독으로 사용할 수 없다
		//	- else if는 여러개 중첩해서 사용할 수 있다
		
		// # else문
		//	- 위의 if, else if가 모두 아니라면 {}안의 내용을 무조건 실행한다
		//	- else문이 있는 조건절은 반드시 한번 실행된다
		
		char lastName = '김';
		
		// 선언을 중괄호 바깥에서 한다
		String result;
		
		if (lastName == '김') { 
			// {}내부에서 선언한 변수는 중괄호를 벗어나면 죽는다 (변수의 생명 주기)
			// String result = "김씨입니다.";

			// {}내부에서는 밖에서 선언한 변수에 대입이 가능하다
			result = "김씨입니다.";
		} else if (lastName == '박') {
			result = "박씨입니다.";
		} else if (lastName == '최') {
			result = "최씨입니다.";
		} else {
			result = "해당하는 성이 없습니다.";
		}
		
		System.out.println(result);
		
		
		int num = 9999;
		
		if (num > 10000)
			System.out.println("num이 10000보다 큽니다.");
		else if (num > 1000)
			System.out.println("num이 1000보다 큽니다.");
		
	}
	
}




