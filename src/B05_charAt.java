import java.util.Scanner;

public class B05_charAt {

	public static void main(String[] args) {
		
		// # "문자열".charAt(index)
		//	- 문자열에서 원하는 번째의 문자를 꺼내는 함수
		//	- 이 함수의 실행 결과는 char 타입이다 (반환 타입이 char타입이다)	
		//	- 첫 번째 문자가 0번 인덱스이다.
		
		// # "문자열".length()
		//	- 문자열이 몇 글자로 이루어져있는지를 알려준다
		//	- 반환 타입 int

		Scanner sc = new Scanner(System.in);
				
		System.out.print("아무거나 입력해보세요 > ");
		String word = sc.next();
		
		System.out.println(word);
		
		char a = word.charAt(0);
		System.out.println(a);
		
		System.out.println(word.charAt(1));
		System.out.println(word.charAt(2));
		
		if (word.length() >= 5) 
			System.out.println(word.charAt(4));
		else 
			System.out.println("해당 단어의 길이가 5보다 짧습니다.");
	}
	
}




